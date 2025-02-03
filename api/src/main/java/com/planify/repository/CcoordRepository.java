package com.planify.repository;

import com.planify.dto.CcoordUpdateDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.planify.model.Ccoord;



@Repository
public interface CcoordRepository extends JpaRepository<Ccoord, Long> {

	 Optional<Ccoord> findById(Long id) ;
	 
	 
	 @Query("SELECT new com.planify.dto.CcoordUpdateDto"
				+ "(c.id,u.firstName,u.lastName,u.mobilenumber,"
				+ "u.email,c.dob ,c.specialization,c.course)"
				+ " FROM Ccoord c JOIN c.user u")
	 
		List<CcoordUpdateDto> findSelectedFieldsFromCcoordAndUser();
	 
	 

	 
	 @Query("SELECT new com.planify.dto.CcoordUpdateDto"
				+ "(c.id,u.firstName,u.lastName,u.mobilenumber,"
				+ "u.email,c.dob ,c.specialization,c.course)"
				+ " FROM Ccoord c JOIN c.user u where c.id=:id")
	 
		


	Optional<CcoordUpdateDto> findSelectedFieldsFromCcoordAndUserById(@Param("id") Long id);
	 	

	
	 
	 
	 
	
	
	
	
	
	
}
