package br.com.kayke.gerenciador_caminhoes.service;


import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class Gemini {
    Client client = new Client();
public String gerarPlaca(){
    GenerateContentResponse response =
            client.models.generateContent(
                    "gemini-2.5-flash",
                    "Gere uma placa de caminhão brasileira aleatória no formato XXX0000," +
                            " onde X é uma letra maiúscula e 0 é um número, quero que me de so a placa.",
                    null);
    return response.text();
}

}
