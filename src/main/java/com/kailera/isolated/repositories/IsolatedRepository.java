package com.kailera.isolated.repositories;

import com.kailera.isolated.entities.Isolated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsolatedRepository extends JpaRepository<Isolated, Long> {
}
