package com.calingaertgrafico.calingaertlegalegrafico;

public class UndefinedSymbolException extends Exception {
    String simboloIndefinido;
    public UndefinedSymbolException(String simboloIndefinido) {
        this.simboloIndefinido = simboloIndefinido;
    }

    @Override
    public String toString() {
        return "Símbolo indefinido: " + simboloIndefinido;
    }
}
