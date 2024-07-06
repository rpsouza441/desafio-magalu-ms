package br.dev.pinheiro.magalums.repositories;

import br.dev.pinheiro.magalums.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
