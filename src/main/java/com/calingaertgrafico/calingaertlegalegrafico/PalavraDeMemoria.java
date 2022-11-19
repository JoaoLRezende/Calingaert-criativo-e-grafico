package com.calingaertgrafico.calingaertlegalegrafico;

import javafx.beans.property.SimpleIntegerProperty;

public class PalavraDeMemoria {
    private SimpleIntegerProperty endereco;
    public void setEndereco(int value) { enderecoProperty().set(value); }
    public int getEndereco() { return enderecoProperty().get(); }
    public SimpleIntegerProperty enderecoProperty() {
        if (endereco == null) endereco = new SimpleIntegerProperty(this, "firstName");
        return endereco;
    }

    private SimpleIntegerProperty valor;
    public void setValor(int value) { valorProperty().set(value); }
    public int getValor() { return valorProperty().get(); }
    public SimpleIntegerProperty valorProperty() {
        if (valor == null) valor = new SimpleIntegerProperty(this, "lastName");
        return valor;
    }

    public PalavraDeMemoria(int endereco, int valor) {
        setEndereco(endereco);
        setValor(valor);
    }
}
