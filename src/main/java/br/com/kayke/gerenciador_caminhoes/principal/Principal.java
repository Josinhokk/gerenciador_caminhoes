package br.com.kayke.gerenciador_caminhoes.principal;

import br.com.kayke.gerenciador_caminhoes.model.*;
import br.com.kayke.gerenciador_caminhoes.repository.BaseRepository;
import br.com.kayke.gerenciador_caminhoes.repository.CaminhaoRepository;
import br.com.kayke.gerenciador_caminhoes.repository.MotoristaRepository;
import br.com.kayke.gerenciador_caminhoes.repository.OperadorRepository;
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
    @Autowired
    OperadorRepository operadorRepository;
    @Autowired
    BaseRepository baseRepository;

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
                
                ================================
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
        System.out.println("Digite o nome do operador: ");
        String nome = entrada.nextLine();
        if (operadorRepository.findByNome(nome).isPresent()) {
            System.out.println("Operador já cadastrado!");
            return;
        } else {
            Operador operador = new Operador(nome);
            operadorRepository.save(operador);
            System.out.println("Operador cadastrado com sucesso!");

        }

    }

    public void cadastraBases() {
        System.out.println("Oque deseja fazer?");
        System.out.println("""
                ===============================
                1. Operar base
                2. Cadastrar nova base
                ===============================
                """);
        var opc = entrada.nextInt();
        entrada.nextLine();
        switch (opc) {
            case 1:
                System.out.println("Qual base deseja alterar? ");
                List<Base> bases = baseRepository.findAll();
                bases.forEach(base -> {
                    System.out.println("Numero da base: " + base.getNumBase());
                });
                int numBase = entrada.nextInt();
                entrada.nextLine();
                Optional<Base> baseSelecionada = baseRepository.findByNumBase(numBase);
                if (baseSelecionada.isPresent()) {
                    System.out.println("Voce selecionou a base: " + baseSelecionada.get().getNumBase());
                    System.out.println("""
                            ================================
                            1. Atribuir operador à base
                            2. Atribuir caminhão à base
                            
                            0. Voltar
                            ================================
                            """);
                    var opcBase = entrada.nextInt();
                    entrada.nextLine();
                    switch (opcBase) {
                        case 1:
                            System.out.println("Aqui estão os operadores disponíveis: ");
                            List<Operador> operadores = operadorRepository.findAll();
                            operadores.forEach(operador -> {
                                System.out.println("Nome: " + operador.getNome() + ", ID: " + operador.getId());
                            });
                            System.out.println("Digite o ID do operador que deseja atribuir à base: ");
                            Long operadorId = entrada.nextLong();
                            entrada.nextLine();
                            Optional<Operador> operadorSelecionado = operadorRepository.findById(operadorId);
                            if (operadorSelecionado.isPresent()) {
                                baseSelecionada.get().setOperador(operadorSelecionado.get());
                                baseRepository.save(baseSelecionada.get());
                                System.out.println("Operador atribuído à base com sucesso!");
                            } else {
                                System.out.println("Operador não encontrado.");
                            }
                            break;
                        case 2:
                            System.out.println("Ainda não implementado.");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                    }
                }
                break;
            case 2:
                cadastraBase();
                break;
            case 0:
                break;
                default:
                    System.out.println("Opção inválida!");
                    break;
        }
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
        } else {
            System.out.println("Caminhão não encontrado.");
        }
    }

    private void cadastraBase(){
        System.out.println("Digite o numero da nova base: ");
        int numBase = entrada.nextInt();
        entrada.nextLine();
        Optional<Base> base = baseRepository.findByNumBase(numBase);
        if(base.isPresent()){
            System.out.println("Base já cadastrada!");
            return;
        }
        Base novaBase = new Base(numBase);
        baseRepository.save(novaBase);
        System.out.println("Base cadastrada com sucesso!");
    }


}
