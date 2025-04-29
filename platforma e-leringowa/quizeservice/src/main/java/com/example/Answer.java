package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAnswer;
    @JoinColumn(name = "id_questions", nullable = false)
    private Quiz idQuestion;
    @Column()
    private String answerA;
    @Column()
    private String answerB;
    @Column()
    private String answerC;
    @Column()
    private String answerD;
    @Column()
    private String answerE;
    @Column()
    private String answerF;
    @Column()
    private String answerG;


    private String answerText;

    private boolean correct; // czy odpowiedź jest poprawna

    public Answer(Long idAnswer, Quiz idQuestion, String answerA, String answerB, String answerC, String answerD, String answerE, String answerF, String answerG, String answerText, boolean correct) {
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerE = answerE;
        this.answerF = answerF;
        this.answerG = answerG;
        this.answerText = answerText;
        this.correct = correct;
    }

    public Answer() {
    }

    public static AnswerBuilder builder() {
        return new AnswerBuilder();
    }

    public Long getIdAnswer() {
        return this.idAnswer;
    }

    public Quiz getIdQuestion() {
        return this.idQuestion;
    }

    public String getAnswerA() {
        return this.answerA;
    }

    public String getAnswerB() {
        return this.answerB;
    }

    public String getAnswerC() {
        return this.answerC;
    }

    public String getAnswerD() {
        return this.answerD;
    }

    public String getAnswerE() {
        return this.answerE;
    }

    public String getAnswerF() {
        return this.answerF;
    }

    public String getAnswerG() {
        return this.answerG;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public boolean isCorrect() {
        return this.correct;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public void setIdQuestion(Quiz idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public void setAnswerE(String answerE) {
        this.answerE = answerE;
    }

    public void setAnswerF(String answerF) {
        this.answerF = answerF;
    }

    public void setAnswerG(String answerG) {
        this.answerG = answerG;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Answer)) return false;
        final Answer other = (Answer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idAnswer = this.getIdAnswer();
        final Object other$idAnswer = other.getIdAnswer();
        if (this$idAnswer == null ? other$idAnswer != null : !this$idAnswer.equals(other$idAnswer)) return false;
        final Object this$idQuestion = this.getIdQuestion();
        final Object other$idQuestion = other.getIdQuestion();
        if (this$idQuestion == null ? other$idQuestion != null : !this$idQuestion.equals(other$idQuestion))
            return false;
        final Object this$answerA = this.getAnswerA();
        final Object other$answerA = other.getAnswerA();
        if (this$answerA == null ? other$answerA != null : !this$answerA.equals(other$answerA)) return false;
        final Object this$answerB = this.getAnswerB();
        final Object other$answerB = other.getAnswerB();
        if (this$answerB == null ? other$answerB != null : !this$answerB.equals(other$answerB)) return false;
        final Object this$answerC = this.getAnswerC();
        final Object other$answerC = other.getAnswerC();
        if (this$answerC == null ? other$answerC != null : !this$answerC.equals(other$answerC)) return false;
        final Object this$answerD = this.getAnswerD();
        final Object other$answerD = other.getAnswerD();
        if (this$answerD == null ? other$answerD != null : !this$answerD.equals(other$answerD)) return false;
        final Object this$answerE = this.getAnswerE();
        final Object other$answerE = other.getAnswerE();
        if (this$answerE == null ? other$answerE != null : !this$answerE.equals(other$answerE)) return false;
        final Object this$answerF = this.getAnswerF();
        final Object other$answerF = other.getAnswerF();
        if (this$answerF == null ? other$answerF != null : !this$answerF.equals(other$answerF)) return false;
        final Object this$answerG = this.getAnswerG();
        final Object other$answerG = other.getAnswerG();
        if (this$answerG == null ? other$answerG != null : !this$answerG.equals(other$answerG)) return false;
        final Object this$answerText = this.getAnswerText();
        final Object other$answerText = other.getAnswerText();
        if (this$answerText == null ? other$answerText != null : !this$answerText.equals(other$answerText))
            return false;
        if (this.isCorrect() != other.isCorrect()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Answer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idAnswer = this.getIdAnswer();
        result = result * PRIME + ($idAnswer == null ? 43 : $idAnswer.hashCode());
        final Object $idQuestion = this.getIdQuestion();
        result = result * PRIME + ($idQuestion == null ? 43 : $idQuestion.hashCode());
        final Object $answerA = this.getAnswerA();
        result = result * PRIME + ($answerA == null ? 43 : $answerA.hashCode());
        final Object $answerB = this.getAnswerB();
        result = result * PRIME + ($answerB == null ? 43 : $answerB.hashCode());
        final Object $answerC = this.getAnswerC();
        result = result * PRIME + ($answerC == null ? 43 : $answerC.hashCode());
        final Object $answerD = this.getAnswerD();
        result = result * PRIME + ($answerD == null ? 43 : $answerD.hashCode());
        final Object $answerE = this.getAnswerE();
        result = result * PRIME + ($answerE == null ? 43 : $answerE.hashCode());
        final Object $answerF = this.getAnswerF();
        result = result * PRIME + ($answerF == null ? 43 : $answerF.hashCode());
        final Object $answerG = this.getAnswerG();
        result = result * PRIME + ($answerG == null ? 43 : $answerG.hashCode());
        final Object $answerText = this.getAnswerText();
        result = result * PRIME + ($answerText == null ? 43 : $answerText.hashCode());
        result = result * PRIME + (this.isCorrect() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Answer(idAnswer=" + this.getIdAnswer() + ", idQuestion=" + this.getIdQuestion() + ", answerA=" + this.getAnswerA() + ", answerB=" + this.getAnswerB() + ", answerC=" + this.getAnswerC() + ", answerD=" + this.getAnswerD() + ", answerE=" + this.getAnswerE() + ", answerF=" + this.getAnswerF() + ", answerG=" + this.getAnswerG() + ", answerText=" + this.getAnswerText() + ", correct=" + this.isCorrect() + ")";
    }

    public static class AnswerBuilder {
        private Long idAnswer;
        private Quiz idQuestion;
        private String answerA;
        private String answerB;
        private String answerC;
        private String answerD;
        private String answerE;
        private String answerF;
        private String answerG;
        private String answerText;
        private boolean correct;

        AnswerBuilder() {
        }

        public AnswerBuilder idAnswer(Long idAnswer) {
            this.idAnswer = idAnswer;
            return this;
        }

        public AnswerBuilder idQuestion(Quiz idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public AnswerBuilder answerA(String answerA) {
            this.answerA = answerA;
            return this;
        }

        public AnswerBuilder answerB(String answerB) {
            this.answerB = answerB;
            return this;
        }

        public AnswerBuilder answerC(String answerC) {
            this.answerC = answerC;
            return this;
        }

        public AnswerBuilder answerD(String answerD) {
            this.answerD = answerD;
            return this;
        }

        public AnswerBuilder answerE(String answerE) {
            this.answerE = answerE;
            return this;
        }

        public AnswerBuilder answerF(String answerF) {
            this.answerF = answerF;
            return this;
        }

        public AnswerBuilder answerG(String answerG) {
            this.answerG = answerG;
            return this;
        }

        public AnswerBuilder answerText(String answerText) {
            this.answerText = answerText;
            return this;
        }

        public AnswerBuilder correct(boolean correct) {
            this.correct = correct;
            return this;
        }

        public Answer build() {
            return new Answer(this.idAnswer, this.idQuestion, this.answerA, this.answerB, this.answerC, this.answerD, this.answerE, this.answerF, this.answerG, this.answerText, this.correct);
        }

        public String toString() {
            return "Answer.AnswerBuilder(idAnswer=" + this.idAnswer + ", idQuestion=" + this.idQuestion + ", answerA=" + this.answerA + ", answerB=" + this.answerB + ", answerC=" + this.answerC + ", answerD=" + this.answerD + ", answerE=" + this.answerE + ", answerF=" + this.answerF + ", answerG=" + this.answerG + ", answerText=" + this.answerText + ", correct=" + this.correct + ")";
        }
    }
}
