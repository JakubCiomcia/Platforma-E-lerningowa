package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_grades")
public class QuizGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idQuizGrade;

    private Long idUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quizzes", nullable = false)
    private Quiz quiz;

    @Column(nullable = false)
    private String numberOfQuestion;

    @Column(nullable = false)
    private Integer correctQuestion;

    @Column(nullable = false)
    private Double percentageOfCorrectQuestions;

    @Column(nullable = false)
    private Boolean isPass;

    public QuizGrade(Long idQuizGrade, Long idUser, Quiz quiz, String numberOfQuestion, Integer correctQuestion, Double percentageOfCorrectQuestions, Boolean isPass) {
        this.idQuizGrade = idQuizGrade;
        this.idUser = idUser;
        this.quiz = quiz;
        this.numberOfQuestion = numberOfQuestion;
        this.correctQuestion = correctQuestion;
        this.percentageOfCorrectQuestions = percentageOfCorrectQuestions;
        this.isPass = isPass;
    }

    public QuizGrade() {
    }

    public static QuizGradeBuilder builder() {
        return new QuizGradeBuilder();
    }

    public Long getIdQuizGrade() {
        return this.idQuizGrade;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public Quiz getQuiz() {
        return this.quiz;
    }

    public String getNumberOfQuestion() {
        return this.numberOfQuestion;
    }

    public Integer getCorrectQuestion() {
        return this.correctQuestion;
    }

    public Double getPercentageOfCorrectQuestions() {
        return this.percentageOfCorrectQuestions;
    }

    public Boolean getIsPass() {
        return this.isPass;
    }

    public void setIdQuizGrade(Long idQuizGrade) {
        this.idQuizGrade = idQuizGrade;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setNumberOfQuestion(String numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public void setCorrectQuestion(Integer correctQuestion) {
        this.correctQuestion = correctQuestion;
    }

    public void setPercentageOfCorrectQuestions(Double percentageOfCorrectQuestions) {
        this.percentageOfCorrectQuestions = percentageOfCorrectQuestions;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuizGrade)) return false;
        final QuizGrade other = (QuizGrade) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idQuizGrade = this.getIdQuizGrade();
        final Object other$idQuizGrade = other.getIdQuizGrade();
        if (this$idQuizGrade == null ? other$idQuizGrade != null : !this$idQuizGrade.equals(other$idQuizGrade))
            return false;
        final Object this$idUser = this.getIdUser();
        final Object other$idUser = other.getIdUser();
        if (this$idUser == null ? other$idUser != null : !this$idUser.equals(other$idUser)) return false;
        final Object this$quiz = this.getQuiz();
        final Object other$quiz = other.getQuiz();
        if (this$quiz == null ? other$quiz != null : !this$quiz.equals(other$quiz)) return false;
        final Object this$numberOfQuestion = this.getNumberOfQuestion();
        final Object other$numberOfQuestion = other.getNumberOfQuestion();
        if (this$numberOfQuestion == null ? other$numberOfQuestion != null : !this$numberOfQuestion.equals(other$numberOfQuestion))
            return false;
        final Object this$correctQuestion = this.getCorrectQuestion();
        final Object other$correctQuestion = other.getCorrectQuestion();
        if (this$correctQuestion == null ? other$correctQuestion != null : !this$correctQuestion.equals(other$correctQuestion))
            return false;
        final Object this$percentageOfCorrectQuestions = this.getPercentageOfCorrectQuestions();
        final Object other$percentageOfCorrectQuestions = other.getPercentageOfCorrectQuestions();
        if (this$percentageOfCorrectQuestions == null ? other$percentageOfCorrectQuestions != null : !this$percentageOfCorrectQuestions.equals(other$percentageOfCorrectQuestions))
            return false;
        final Object this$isPass = this.getIsPass();
        final Object other$isPass = other.getIsPass();
        if (this$isPass == null ? other$isPass != null : !this$isPass.equals(other$isPass)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuizGrade;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idQuizGrade = this.getIdQuizGrade();
        result = result * PRIME + ($idQuizGrade == null ? 43 : $idQuizGrade.hashCode());
        final Object $idUser = this.getIdUser();
        result = result * PRIME + ($idUser == null ? 43 : $idUser.hashCode());
        final Object $quiz = this.getQuiz();
        result = result * PRIME + ($quiz == null ? 43 : $quiz.hashCode());
        final Object $numberOfQuestion = this.getNumberOfQuestion();
        result = result * PRIME + ($numberOfQuestion == null ? 43 : $numberOfQuestion.hashCode());
        final Object $correctQuestion = this.getCorrectQuestion();
        result = result * PRIME + ($correctQuestion == null ? 43 : $correctQuestion.hashCode());
        final Object $percentageOfCorrectQuestions = this.getPercentageOfCorrectQuestions();
        result = result * PRIME + ($percentageOfCorrectQuestions == null ? 43 : $percentageOfCorrectQuestions.hashCode());
        final Object $isPass = this.getIsPass();
        result = result * PRIME + ($isPass == null ? 43 : $isPass.hashCode());
        return result;
    }

    public String toString() {
        return "QuizGrade(idQuizGrade=" + this.getIdQuizGrade() + ", idUser=" + this.getIdUser() + ", quiz=" + this.getQuiz() + ", numberOfQuestion=" + this.getNumberOfQuestion() + ", correctQuestion=" + this.getCorrectQuestion() + ", percentageOfCorrectQuestions=" + this.getPercentageOfCorrectQuestions() + ", isPass=" + this.getIsPass() + ")";
    }

    public static class QuizGradeBuilder {
        private Long idQuizGrade;
        private Long idUser;
        private Quiz quiz;
        private String numberOfQuestion;
        private Integer correctQuestion;
        private Double percentageOfCorrectQuestions;
        private Boolean isPass;

        QuizGradeBuilder() {
        }

        public QuizGradeBuilder idQuizGrade(Long idQuizGrade) {
            this.idQuizGrade = idQuizGrade;
            return this;
        }

        public QuizGradeBuilder idUser(Long idUser) {
            this.idUser = idUser;
            return this;
        }

        public QuizGradeBuilder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }

        public QuizGradeBuilder numberOfQuestion(String numberOfQuestion) {
            this.numberOfQuestion = numberOfQuestion;
            return this;
        }

        public QuizGradeBuilder correctQuestion(Integer correctQuestion) {
            this.correctQuestion = correctQuestion;
            return this;
        }

        public QuizGradeBuilder percentageOfCorrectQuestions(Double percentageOfCorrectQuestions) {
            this.percentageOfCorrectQuestions = percentageOfCorrectQuestions;
            return this;
        }

        public QuizGradeBuilder isPass(Boolean isPass) {
            this.isPass = isPass;
            return this;
        }

        public QuizGrade build() {
            return new QuizGrade(this.idQuizGrade, this.idUser, this.quiz, this.numberOfQuestion, this.correctQuestion, this.percentageOfCorrectQuestions, this.isPass);
        }

        public String toString() {
            return "QuizGrade.QuizGradeBuilder(idQuizGrade=" + this.idQuizGrade + ", idUser=" + this.idUser + ", quiz=" + this.quiz + ", numberOfQuestion=" + this.numberOfQuestion + ", correctQuestion=" + this.correctQuestion + ", percentageOfCorrectQuestions=" + this.percentageOfCorrectQuestions + ", isPass=" + this.isPass + ")";
        }
    }
}
