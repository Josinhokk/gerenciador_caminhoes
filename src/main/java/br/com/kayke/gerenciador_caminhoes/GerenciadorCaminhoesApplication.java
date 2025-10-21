package br.com.kayke.gerenciador_caminhoes;

import br.com.kayke.gerenciador_caminhoes.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorCaminhoesApplication implements CommandLineRunner {

    @Autowired
    Principal principal;

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorCaminhoesApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        principal.exibeMenu();
    }
}
