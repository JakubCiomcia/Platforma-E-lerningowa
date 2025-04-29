package com.example;

import com.example.Repository.QuestionRepository;
import com.example.Repository.QuizGradeRepository;
import com.example.Repository.QuizRepository;
import com.example.Repository.UserAnswerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
public class QuizService {


    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final UserAnswerRepository userAnswerRepository;
    private final QuizGradeRepository quizGradeRepository;

    public QuizService(QuestionRepository questionRepository, QuizRepository quizRepository, UserAnswerRepository userAnswerRepository, QuizGradeRepository quizGradeRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.userAnswerRepository = userAnswerRepository;
        this.quizGradeRepository = quizGradeRepository;
    }


    // Utworzenie nowego quizu
    @Cacheable(value = "quizzes", key = "#idQuiz")
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Pobranie wszystkich quizów
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Pobranie quizu po id
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz o id " + id + " nie został znaleziony"));
    }

    /**
     * Metoda przetwarza odpowiedzi użytkownika, oblicza wynik quizu
     * oraz zapisuje ocenę w tabeli quiz_grades.
     *
     * @param quizId      Identyfikator quizu
     * @param userId      Identyfikator użytkownika (typ UUID, zgodny z encją User)
     * @param userAnswers Lista odpowiedzi użytkownika
     * @return Zapisana ocena quizu (QuizGrade)
     */
    @Transactional
    public QuizGrade submitQuizAnswers(Long quizId, UUID userId, List<UserAnswer> userAnswers) {
        // Zapisujemy odpowiedzi użytkownika

        userAnswers.forEach(userAnswerRepository::save);

        int totalQuestions = userAnswers.size();
        int correctAnswers = 0;

        // Obliczamy liczbę poprawnych odpowiedzi
        for (UserAnswer ua : userAnswers) {
            if (ua.getSelectedAnswer() != null && ua.getSelectedAnswer().isCorrect()) {
                correctAnswers++;
            }
        }

        double percentage = (correctAnswers * 100.0) / totalQuestions;
        Quiz quiz = getQuizById(quizId);
        boolean isPass = percentage >= quiz.getQuizPassThreshold();

        // Tworzymy obiekt oceny quizu
        QuizGrade quizGrade = QuizGrade.builder()
                // Jeśli encja QuizGrade miała referencję do encji User zamiast Long,
                // można by przekazać obiekt User. W obecnej definicji używamy Long.
                .idUser(convertUserIdToLong(userId))
                .quiz(quiz)
                .numberOfQuestion(String.valueOf(totalQuestions))
                .correctQuestion(correctAnswers)
                .percentageOfCorrectQuestions(percentage)
                .isPass(isPass)
                .build();

        return quizGradeRepository.save(quizGrade);
    }

    /**
     * Pomocnicza metoda konwertująca UUID na Long.
     * W praktyce warto zmienić typ idUser w encji QuizGrade na UUID lub referencję do encji User.
     */
    private Long convertUserIdToLong(UUID userId) {
        // Ta metoda jest przykładowa. W realnej aplikacji warto używać spójnych typów identyfikatorów.
        return userId.getMostSignificantBits() & Long.MAX_VALUE;
    }

    public QuestionRepository getQuestionRepository() {
        return this.questionRepository;
    }

    public QuizRepository getQuizRepository() {
        return this.quizRepository;
    }

    public UserAnswerRepository getUserAnswerRepository() {
        return this.userAnswerRepository;
    }

    public QuizGradeRepository getQuizGradeRepository() {
        return this.quizGradeRepository;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuizService)) return false;
        final QuizService other = (QuizService) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$questionRepository = this.getQuestionRepository();
        final Object other$questionRepository = other.getQuestionRepository();
        if (this$questionRepository == null ? other$questionRepository != null : !this$questionRepository.equals(other$questionRepository))
            return false;
        final Object this$quizRepository = this.getQuizRepository();
        final Object other$quizRepository = other.getQuizRepository();
        if (this$quizRepository == null ? other$quizRepository != null : !this$quizRepository.equals(other$quizRepository))
            return false;
        final Object this$userAnswerRepository = this.getUserAnswerRepository();
        final Object other$userAnswerRepository = other.getUserAnswerRepository();
        if (this$userAnswerRepository == null ? other$userAnswerRepository != null : !this$userAnswerRepository.equals(other$userAnswerRepository))
            return false;
        final Object this$quizGradeRepository = this.getQuizGradeRepository();
        final Object other$quizGradeRepository = other.getQuizGradeRepository();
        if (this$quizGradeRepository == null ? other$quizGradeRepository != null : !this$quizGradeRepository.equals(other$quizGradeRepository))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuizService;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $questionRepository = this.getQuestionRepository();
        result = result * PRIME + ($questionRepository == null ? 43 : $questionRepository.hashCode());
        final Object $quizRepository = this.getQuizRepository();
        result = result * PRIME + ($quizRepository == null ? 43 : $quizRepository.hashCode());
        final Object $userAnswerRepository = this.getUserAnswerRepository();
        result = result * PRIME + ($userAnswerRepository == null ? 43 : $userAnswerRepository.hashCode());
        final Object $quizGradeRepository = this.getQuizGradeRepository();
        result = result * PRIME + ($quizGradeRepository == null ? 43 : $quizGradeRepository.hashCode());
        return result;
    }

    public String toString() {
        return "QuizService(questionRepository=" + this.getQuestionRepository() + ", quizRepository=" + this.getQuizRepository() + ", userAnswerRepository=" + this.getUserAnswerRepository() + ", quizGradeRepository=" + this.getQuizGradeRepository() + ")";
    }
}

