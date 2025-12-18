package com.example.demo.newrepository;
import org.springframework.data.jpa.newrepository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.newentity.StudentValidation;

@Repository
public interface  NewStudentRepo extends JpaRepository<StudentValidation,Long>{

}