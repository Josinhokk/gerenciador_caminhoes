package br.com.kayke.gerenciador_caminhoes.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
