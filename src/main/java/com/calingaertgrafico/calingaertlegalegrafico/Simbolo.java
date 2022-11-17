package com.calingaertgrafico.calingaertlegalegrafico;

class Simbolo {
    enum ModoDeRelocabilidade { ABSOLUTO, RELATIVO };

    short endereco;
    ModoDeRelocabilidade modoDeRelocabilidade;

    public Simbolo(short endereco, ModoDeRelocabilidade modoDeRelocabilidade) {
        this.endereco = endereco;
        this.modoDeRelocabilidade = modoDeRelocabilidade;
    }

    public String toString() {
        return "" + endereco + " " + modoDeRelocabilidade;
    }
}