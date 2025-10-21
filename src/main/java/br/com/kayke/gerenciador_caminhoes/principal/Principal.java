package br.com.kayke.gerenciador_caminhoes.principal;

import br.com.kayke.gerenciador_caminhoes.model.Caminhao;
import br.com.kayke.gerenciador_caminhoes.model.Modelo;
import br.com.kayke.gerenciador_caminhoes.repository.CaminhaoRepository;
import br.com.kayke.gerenciador_caminhoes.service.Gemini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {
    Scanner entrada = new Scanner(System.in);
    Gemini gemini = new Gemini();


    @Autowired
    CaminhaoRepository caminhaoRepository;

    public void exibeMenu(){

        var menu = """
                ================================
                Selecione uma opção:
                
                1. Cadastrar Caminhão
                2. Cadastrar Motorista
                3. Cadastrar Operador
                4. Gerenciar Bases
                
                0. Sair
                """;

        var opc =  -1;

        while (opc != 0) {
            System.out.println(menu);
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 1:
                    cadastraCaminhao();
                    break;
            }
            
        }


    }

    private void cadastraCaminhao() {
        System.out.println("Digite a placa do caminhão:");
        String placa = gemini.gerarPlaca();
        System.out.println("Placa gerada: " + placa);
        System.out.println("Qual o modelo do caminhão? (SIDER, TRUCK, CARRETA)");
        String modelo = entrada.nextLine().toLowerCase();
        Modelo modeloProcurado = Modelo.caminhao(modelo);
        System.out.println("Modelo selecionado: " + modeloProcurado);
        Caminhao caminhao = new Caminhao(placa, modeloProcurado);
        caminhaoRepository.save(caminhao);

    }

}
