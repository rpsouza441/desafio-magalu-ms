package br.dev.pinheiro.magalums.controller;

import br.dev.pinheiro.magalums.controller.dto.ScheduleNotificationDto;
import br.dev.pinheiro.magalums.entity.Notifications;
import br.dev.pinheiro.magalums.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<?> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<?> getNotification(@PathVariable("notificationId") Long notificationId){
        Optional<Notifications> notifications = notificationService.findById(notificationId);
        if (notifications.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok((notifications.get()));
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<?> deleteNotification(@PathVariable("notificationId") Long notificationId){
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
