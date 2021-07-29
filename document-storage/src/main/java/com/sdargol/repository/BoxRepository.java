package com.sdargol.repository;

import com.sdargol.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<Box, Integer> {
}
