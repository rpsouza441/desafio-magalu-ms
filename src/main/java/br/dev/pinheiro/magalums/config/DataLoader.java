package br.dev.pinheiro.magalums.config;

import br.dev.pinheiro.magalums.entity.enums.ChannelValues;
import br.dev.pinheiro.magalums.entity.enums.StatusValues;
import br.dev.pinheiro.magalums.repositories.ChannelRepository;
import br.dev.pinheiro.magalums.repositories.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;

    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository,
                      StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(ChannelValues.values())
                .map(ChannelValues::toChannel)
                .forEach(channelRepository::save);


        Arrays.stream(StatusValues.values())
                .map(StatusValues::toStatus)
                .forEach(statusRepository::save);
    }
}
