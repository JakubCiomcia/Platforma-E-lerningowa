import org.springframework.stereotype.Service;

import javax.management.Notification;

@Service
public class NotificationService {

    public void sendNotification(Notification notification) {
        // Implementacja wysyłania powiadomienia (np. poprzez e-mail, SMS)
    }
}
