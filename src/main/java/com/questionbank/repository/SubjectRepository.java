package com.questionbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.questionbank.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

	 @Query("select s from Subject s  where s.yearID = :yearID")
	 List<Subject> getSubjectsByYearId(@Param("yearID") Long yearID);
}
