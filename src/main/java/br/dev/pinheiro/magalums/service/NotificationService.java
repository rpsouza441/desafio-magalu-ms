package br.dev.pinheiro.magalums.service;

import br.dev.pinheiro.magalums.controller.dto.ScheduleNotificationDto;
import br.dev.pinheiro.magalums.entity.Notifications;
import br.dev.pinheiro.magalums.entity.enums.StatusValues;
import br.dev.pinheiro.magalums.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private  final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        repository.save(dto.toNotification());
    }

    public Optional<Notifications> findById(Long id) {
        return repository.findById(id);
    }

    public void cancelNotification(Long notificationId) {
        Optional<Notifications> notifications = findById(notificationId);

        if (notifications.isPresent()) {
            notifications.get().setStatus(StatusValues.CANCELED.toStatus());
            repository.save(notifications.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        List<Notifications> notifications = repository.findByStatusInAndDateTimeBefore(List.of(
                StatusValues.PENDING.toStatus(),
                StatusValues.ERROR.toStatus()
        ), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notifications> sendNotification() {
        return n -> {

            //TODO REALIZAR O ENVIO DA NOTIFICACAO

            n.setStatus(StatusValues.SUCCESS.toStatus());
            repository.save(n);

        };
    }

}
