import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    private final ProgressRepository progressRepository;

    @Autowired
    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public Progress getProgress(Long userId) {
        return progressRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Progress not found"));
    }
}
