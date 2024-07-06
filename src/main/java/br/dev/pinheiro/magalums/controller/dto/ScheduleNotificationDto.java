package br.dev.pinheiro.magalums.controller.dto;

import br.dev.pinheiro.magalums.entity.Notifications;
import br.dev.pinheiro.magalums.entity.enums.ChannelValues;
import br.dev.pinheiro.magalums.entity.enums.StatusValues;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(
        LocalDateTime dateTime,
        String destination,
        String message,
        ChannelValues channel
) {
    public Notifications toNotification() {
        return Notifications.builder()
                .dateTime(dateTime)
                .message(message)
                .destination(destination)
                .channel(channel.toChannel())
                .status(StatusValues.PENDING.toStatus())
                .build();
    }
}
