package com.gasbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Cylinder;
@Repository
public interface ICylinderRepository extends JpaRepository<Cylinder, Integer> {
	 public Optional<List<Cylinder>> findByType(String type);
}
