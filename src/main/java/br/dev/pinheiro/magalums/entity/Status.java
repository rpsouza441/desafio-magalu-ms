package br.dev.pinheiro.magalums.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="tb_status")
public class Status {

    @Id
    private Long id;

    private String description;
}
