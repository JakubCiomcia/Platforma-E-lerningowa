package com.example.Repository;

import com.example.QuizGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface QuizGradeRepository extends JpaRepository<QuizGrade, Long> {

}
