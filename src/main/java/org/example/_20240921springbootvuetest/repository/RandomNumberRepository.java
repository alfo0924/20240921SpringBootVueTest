package org.example._20240921springbootvuetest.repository;

import org.example._20240921springbootvuetest.model.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {
}
