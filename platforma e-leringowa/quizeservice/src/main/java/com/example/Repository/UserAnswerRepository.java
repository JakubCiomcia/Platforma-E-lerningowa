package com.example.Repository;

import com.example.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

}
