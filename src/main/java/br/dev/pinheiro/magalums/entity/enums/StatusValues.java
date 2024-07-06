package br.dev.pinheiro.magalums.entity.enums;

import br.dev.pinheiro.magalums.entity.Channel;
import br.dev.pinheiro.magalums.entity.Status;

public enum StatusValues {
    PENDING(1L, "pending"),
    SUCCESS(2L,"success"),
    ERROR(3L, "error"),
    CANCELED(4L, "canceled");

    private final Long id;
    private final String description;

    StatusValues(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Status toStatus (){
        return new Status(id, description);
    }
}
