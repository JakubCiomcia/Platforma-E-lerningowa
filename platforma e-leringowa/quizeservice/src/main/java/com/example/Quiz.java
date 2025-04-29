package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idQuiz;

    @Column(nullable = false, unique = true)
    private String quizzesName;

    @Column()
    private String description;

    @Column(nullable = false)
    private Double quizPassThreshold;

    public Quiz(Long idQuiz, String quizzesName, String description, Double quizPassThreshold) {
        this.idQuiz = idQuiz;
        this.quizzesName = quizzesName;
        this.description = description;
        this.quizPassThreshold = quizPassThreshold;
    }

    public Quiz() {
    }

    public static QuizBuilder builder() {
        return new QuizBuilder();
    }

    public Long getIdQuiz() {
        return this.idQuiz;
    }

    public String getQuizzesName() {
        return this.quizzesName;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getQuizPassThreshold() {
        return this.quizPassThreshold;
    }

    public void setIdQuiz(Long idQuiz) {
        this.idQuiz = idQuiz;
    }

    public void setQuizzesName(String quizzesName) {
        this.quizzesName = quizzesName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuizPassThreshold(Double quizPassThreshold) {
        this.quizPassThreshold = quizPassThreshold;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Quiz)) return false;
        final Quiz other = (Quiz) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idQuiz = this.getIdQuiz();
        final Object other$idQuiz = other.getIdQuiz();
        if (this$idQuiz == null ? other$idQuiz != null : !this$idQuiz.equals(other$idQuiz)) return false;
        final Object this$quizzesName = this.getQuizzesName();
        final Object other$quizzesName = other.getQuizzesName();
        if (this$quizzesName == null ? other$quizzesName != null : !this$quizzesName.equals(other$quizzesName))
            return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$quizPassThreshold = this.getQuizPassThreshold();
        final Object other$quizPassThreshold = other.getQuizPassThreshold();
        if (this$quizPassThreshold == null ? other$quizPassThreshold != null : !this$quizPassThreshold.equals(other$quizPassThreshold))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Quiz;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idQuiz = this.getIdQuiz();
        result = result * PRIME + ($idQuiz == null ? 43 : $idQuiz.hashCode());
        final Object $quizzesName = this.getQuizzesName();
        result = result * PRIME + ($quizzesName == null ? 43 : $quizzesName.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $quizPassThreshold = this.getQuizPassThreshold();
        result = result * PRIME + ($quizPassThreshold == null ? 43 : $quizPassThreshold.hashCode());
        return result;
    }

    public String toString() {
        return "Quiz(idQuiz=" + this.getIdQuiz() + ", quizzesName=" + this.getQuizzesName() + ", description=" + this.getDescription() + ", quizPassThreshold=" + this.getQuizPassThreshold() + ")";
    }

    public static class QuizBuilder {
        private Long idQuiz;
        private String quizzesName;
        private String description;
        private Double quizPassThreshold;

        QuizBuilder() {
        }

        public QuizBuilder idQuiz(Long idQuiz) {
            this.idQuiz = idQuiz;
            return this;
        }

        public QuizBuilder quizzesName(String quizzesName) {
            this.quizzesName = quizzesName;
            return this;
        }

        public QuizBuilder description(String description) {
            this.description = description;
            return this;
        }

        public QuizBuilder quizPassThreshold(Double quizPassThreshold) {
            this.quizPassThreshold = quizPassThreshold;
            return this;
        }

        public Quiz build() {
            return new Quiz(this.idQuiz, this.quizzesName, this.description, this.quizPassThreshold);
        }

        public String toString() {
            return "Quiz.QuizBuilder(idQuiz=" + this.idQuiz + ", quizzesName=" + this.quizzesName + ", description=" + this.description + ", quizPassThreshold=" + this.quizPassThreshold + ")";
        }
    }
}
