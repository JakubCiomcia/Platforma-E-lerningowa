package com.example.Repository;

import com.example.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
        public interface QuizRepository extends JpaRepository<Quiz, Long> {

    }
