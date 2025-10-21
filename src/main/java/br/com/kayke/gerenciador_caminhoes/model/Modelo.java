package br.com.kayke.gerenciador_caminhoes.model;

public enum Modelo {
    CARRETA("carreta"),
    TRUCK("truck"),
    SIDER("sider");

    private String modelo;

    Modelo(String modelo) {
        this.modelo = modelo;
    }

    public static Modelo caminhao(String text){
        for(Modelo modeloRetornado : Modelo.values()){
            if(modeloRetornado.modelo.equalsIgnoreCase(text)){
                return modeloRetornado;
            }
        }
        throw new IllegalArgumentException("Nenhuma ccategoria encontrada");
    }
}