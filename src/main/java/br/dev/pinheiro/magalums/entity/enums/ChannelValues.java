package br.dev.pinheiro.magalums.entity.enums;

import br.dev.pinheiro.magalums.entity.Channel;

public enum ChannelValues {
    EMAIL(1L, "email"),
    SMS(2L,"sms"),
    PUSH(3L, "push"),
    WHATSAPP(4L, "whatsapp");

    private Long id;
    private String description;

    ChannelValues(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public  Channel toChannel(){
        return new Channel(id, description);
    }
}
