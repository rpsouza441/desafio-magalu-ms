package br.dev.pinheiro.magalums.repositories;

import br.dev.pinheiro.magalums.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
