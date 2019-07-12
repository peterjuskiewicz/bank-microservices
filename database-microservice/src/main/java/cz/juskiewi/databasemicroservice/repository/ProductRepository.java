package cz.juskiewi.databasemicroservice.repository;

import cz.juskiewi.databasemicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
