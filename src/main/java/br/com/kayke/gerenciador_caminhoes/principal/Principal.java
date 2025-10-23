package br.com.kayke.gerenciador_caminhoes.principal;

import br.com.kayke.gerenciador_caminhoes.model.Caminhao;
import br.com.kayke.gerenciador_caminhoes.model.Modelo;
import br.com.kayke.gerenciador_caminhoes.model.Motorista;
import br.com.kayke.gerenciador_caminhoes.repository.CaminhaoRepository;
import br.com.kayke.gerenciador_caminhoes.repository.MotoristaRepository;
import br.com.kayke.gerenciador_caminhoes.service.Gemini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {
    Scanner entrada = new Scanner(System.in);
    Gemini gemini = new Gemini();

    //repositorios
    @Autowired
    CaminhaoRepository caminhaoRepository;
    @Autowired
    MotoristaRepository motoristaRepository;

    public void exibeMenu() {

        var menu = """
                ================================
                Selecione uma opção:
                
                1. Cadastrar Caminhão
                2. Cadastrar Motorista
                3. Cadastrar Operador
                4. Gerenciar Bases
                
                Outras operações:
                
                5. Definir Motorista para Caminhão
                
                0. Sair
                """;

        var opc = -1;

        while (opc != 0) {
            System.out.println(menu);
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 1:
                    cadastraCaminhao();
                    break;
                case 2:
                    cadastraMotorista();
                    break;
                case 3:
                    cadastraOperador();
                    break;
                case 4:
                    cadastraBases();
                    break;
                case 5:
                    definirMotorista();
                    break;
                default:
                    System.out.println("Opção inválida ou ainda não implementada.");
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

    public void cadastraMotorista() {
        System.out.println("Digite o nome do motorista: ");
        String nome = entrada.nextLine();
        Motorista motorista = new Motorista(nome);
        motoristaRepository.save(motorista);
    }

    public void cadastraOperador() {

    }

    public void cadastraBases() {

    }

    private void definirMotorista() {
        System.out.println("Aqui estão os caminhões sem motorista: ");
        List<Caminhao> caminhoesSemMotorista = caminhaoRepository.findByMotoristaIsNull();
        for (Caminhao caminhao : caminhoesSemMotorista) {
            System.out.println("Caminhão ID: " + caminhao.getId() + ", Placa: " + caminhao.getPlaca());
        }
        System.out.println("Digite o ID do caminhão que deseja atribuir um motorista: ");
        Long caminhaoId = entrada.nextLong();
        entrada.nextLine();
        Optional<Caminhao> caminhaoSelecionado = caminhaoRepository.findById(caminhaoId);
        if (caminhaoSelecionado.isPresent()) {
            List<Motorista> motoristas = motoristaRepository.findAll();
            System.out.println("Aqui estão os motoristas disponíveis: ");
            motoristas.forEach(motorista -> {
                System.out.println("Nome: " + motorista.getNome());
            });
            System.out.println("Seleciona o motorista que deja atribuir ao caminhão: ");
            String nomeMotorista = entrada.nextLine();
            Optional<Motorista> motoristaSelecionado = motoristaRepository.findByNome(nomeMotorista);
            if (motoristaSelecionado.isPresent()) {
                caminhaoSelecionado.get().setMotorista(motoristaSelecionado.get());
                caminhaoRepository.save(caminhaoSelecionado.get());

            }

        }else {
            System.out.println("Caminhão não encontrado.");
        }


    }


}
