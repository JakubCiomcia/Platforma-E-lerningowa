package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "user_answers")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserAnswer;


    @Column(name = "user_id", nullable = false)
    private Long user;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer selectedAnswer;

    public UserAnswer(Long idUserAnswer, Long user, Questions question, Answer selectedAnswer) {
        this.idUserAnswer = idUserAnswer;
        this.user = user;
        this.question = question;
        this.selectedAnswer = selectedAnswer;
    }

    public UserAnswer() {
    }

    public static UserAnswerBuilder builder() {
        return new UserAnswerBuilder();
    }

    public Long getIdUserAnswer() {
        return this.idUserAnswer;
    }

    public Long getUser() {
        return this.user;
    }

    public Questions getQuestion() {
        return question;
    }

    public Answer getSelectedAnswer() {
        return this.selectedAnswer;
    }

    public void setIdUserAnswer(Long idUserAnswer) {
        this.idUserAnswer = idUserAnswer;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public void setSelectedAnswer(Answer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public static class UserAnswerBuilder {
        private Long idUserAnswer;
        private Long user;
        private Questions question;
        private Answer selectedAnswer;

        UserAnswerBuilder() {
        }

        public UserAnswerBuilder idUserAnswer(Long idUserAnswer) {
            this.idUserAnswer = idUserAnswer;
            return this;
        }

        public UserAnswerBuilder user(Long user) {
            this.user = user;
            return this;
        }

        public UserAnswerBuilder question(Questions question) {
            this.question = question;
            return this;
        }

        public UserAnswerBuilder selectedAnswer(Answer selectedAnswer) {
            this.selectedAnswer = selectedAnswer;
            return this;
        }
        public UserAnswer build() {
            return new UserAnswer(idUserAnswer, user, question, selectedAnswer);
        }

        public String toString() {
            return "UserAnswer.UserAnswerBuilder(idUserAnswer=" + this.idUserAnswer + ", user=" + this.user + ", question=" + this.question + ", selectedAnswer=" + this.selectedAnswer + ")";
        }
    }
}