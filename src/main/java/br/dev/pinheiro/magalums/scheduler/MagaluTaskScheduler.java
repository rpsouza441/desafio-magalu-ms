package br.dev.pinheiro.magalums.scheduler;

import br.dev.pinheiro.magalums.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluTaskScheduler {
    private final NotificationService service;

    public MagaluTaskScheduler(NotificationService service) {

        this.service = service;
    }

    private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checktasks() {
        LocalDateTime dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
        service.checkAndSend(dateTime);

    }
}
