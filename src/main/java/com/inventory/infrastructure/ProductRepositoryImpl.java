package com.inventory.infrastructure;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
            product.setCreatedAt(LocalDate.now());
            product.setVersion(0);
            entityManager.persist(product);
        } else {
            product.preUpdate();
            product.setVersion(product.getVersion() + 1);
            product = entityManager.merge(product);
        }
        return product;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        Product product = entityManager.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Product p ORDER BY p.name", Product.class);
        return query.getResultList();
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
    }

    @Override
    public Optional<Product> findByCode(String code) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.code = :code", Product.class);
        query.setParameter("code", code);
        List<Product> results = query.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY p.name",
            Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Product> findByCategory(String category) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.category = :category ORDER BY p.name",
            Product.class);
        query.setParameter("category", category);
        return query.getResultList();
    }

    @Override
    public List<Product> findByStockLessThan(Integer stock) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.stock < :stock ORDER BY p.stock ASC",
            Product.class);
        query.setParameter("stock", stock);
        return query.getResultList();
    }

    @Override
    public List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price DESC",
            Product.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        return query.getResultList();
    }

    @Override
    public List<Product> findProductsCreatedAfter(LocalDate date) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.createdAt > :date ORDER BY p.createdAt DESC",
            Product.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public int decreaseStock(UUID id, Integer quantity) {
        Query query = entityManager.createQuery(
            "UPDATE Product p SET p.stock = p.stock - :quantity, p.version = p.version + 1 " +
            "WHERE p.id = :id AND p.stock >= :quantity");
        query.setParameter("id", id);
        query.setParameter("quantity", quantity);
        return query.executeUpdate();
    }

    @Override
    public int increaseStock(UUID id, Integer quantity) {
        Query query = entityManager.createQuery(
            "UPDATE Product p SET p.stock = p.stock + :quantity, p.version = p.version + 1 " +
            "WHERE p.id = :id");
        query.setParameter("id", id);
        query.setParameter("quantity", quantity);
        return query.executeUpdate();
    }

    @Override
    public List<Object[]> getStockByCategory() {
        Query query = entityManager.createQuery(
            "SELECT p.category, SUM(p.stock) FROM Product p GROUP BY p.category ORDER BY SUM(p.stock) DESC");
        return query.getResultList();
    }

    @Override
    public List<Object[]> countProductsByCategory() {
        Query query = entityManager.createQuery(
            "SELECT p.category, COUNT(p) FROM Product p GROUP BY p.category ORDER BY COUNT(p) DESC");
        return query.getResultList();
    }
}