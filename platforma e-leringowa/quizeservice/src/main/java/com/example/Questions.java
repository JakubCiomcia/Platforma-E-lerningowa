package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quizzes", nullable = false)
    private Quiz idQuizzes;

    @Column()
    private String description;


    public Questions(Long idQuestion, Quiz idQuizzes, String description) {
        this.idQuestion = idQuestion;
        this.idQuizzes = idQuizzes;
        this.description = description;
    }

    public Questions() {
    }

    public static QuestionsBuilder builder() {
        return new QuestionsBuilder();
    }

    public Long getIdQuestion() {
        return this.idQuestion;
    }

    public Quiz getIdQuizzes() {
        return this.idQuizzes;
    }

    public String getDescription() {
        return this.description;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setIdQuizzes(Quiz idQuizzes) {
        this.idQuizzes = idQuizzes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Questions)) return false;
        final Questions other = (Questions) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idQuestion = this.getIdQuestion();
        final Object other$idQuestion = other.getIdQuestion();
        if (this$idQuestion == null ? other$idQuestion != null : !this$idQuestion.equals(other$idQuestion))
            return false;
        final Object this$idQuizzes = this.getIdQuizzes();
        final Object other$idQuizzes = other.getIdQuizzes();
        if (this$idQuizzes == null ? other$idQuizzes != null : !this$idQuizzes.equals(other$idQuizzes)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Questions;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idQuestion = this.getIdQuestion();
        result = result * PRIME + ($idQuestion == null ? 43 : $idQuestion.hashCode());
        final Object $idQuizzes = this.getIdQuizzes();
        result = result * PRIME + ($idQuizzes == null ? 43 : $idQuizzes.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "Questions(idQuestion=" + this.getIdQuestion() + ", idQuizzes=" + this.getIdQuizzes() + ", description=" + this.getDescription() + ")";
    }

    public static class QuestionsBuilder {
        private Long idQuestion;
        private Quiz idQuizzes;
        private String description;

        QuestionsBuilder() {
        }

        public QuestionsBuilder idQuestion(Long idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public QuestionsBuilder idQuizzes(Quiz idQuizzes) {
            this.idQuizzes = idQuizzes;
            return this;
        }

        public QuestionsBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Questions build() {
            return new Questions(this.idQuestion, this.idQuizzes, this.description);
        }

        public String toString() {
            return "Questions.QuestionsBuilder(idQuestion=" + this.idQuestion + ", idQuizzes=" + this.idQuizzes + ", description=" + this.description + ")";
        }
    }
}
