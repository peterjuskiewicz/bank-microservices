package cz.juskiewi.databasemicroservice.repository;

import cz.juskiewi.databasemicroservice.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
