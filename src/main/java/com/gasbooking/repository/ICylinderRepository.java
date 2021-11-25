package com.gasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Cylinder;
@Repository
public interface ICylinderRepository extends JpaRepository<Cylinder, Integer> {

}
