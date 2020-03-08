package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildEducation;
import com.example.restservice.crud.ChildFamily;

public interface ChildFamilyRepository extends JpaRepository<ChildFamily, Integer> {

	Optional<List<ChildFamily>> findChildFamilyByChildNo(Integer childNo);
	Optional<ChildFamily> findChildFamilyByFamilyNo(Integer childNo);

}