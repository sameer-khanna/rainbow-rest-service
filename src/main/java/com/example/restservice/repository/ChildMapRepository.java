package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildMap;

@Repository
public interface ChildMapRepository extends JpaRepository<ChildMap,Long>{

}
