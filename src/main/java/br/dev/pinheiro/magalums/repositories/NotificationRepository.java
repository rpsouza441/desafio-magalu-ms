package br.dev.pinheiro.magalums.repositories;

import br.dev.pinheiro.magalums.entity.Notifications;
import br.dev.pinheiro.magalums.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface NotificationRepository extends JpaRepository<Notifications, Long> {


    List<Notifications> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
