package com.calingaertgrafico.calingaertlegalegrafico;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Memoria {
    
    private int memTamanho = 10000;
    ArrayList<PalavraDeMemoria> memoria;
    static final int STACK_LIMIT = 100;

    Memoria(int numPalavras) {
        memTamanho = numPalavras;
        memoria = new ArrayList<>();

        for (int i = 0; i < memTamanho; i++) {
            memoria.add(new PalavraDeMemoria(i, 0));
        }

        set((short)2, (short) STACK_LIMIT);
    }

    Memoria(int numPalavras, File arquivoObjeto) throws IOException {
        this(numPalavras);

        FileInputStream arquivoObjetoStream = new FileInputStream(arquivoObjeto);
        for (short i = STACK_LIMIT; arquivoObjetoStream.available() > 0; i++) {
            set(i, lerShort(arquivoObjetoStream));
        }
    }

    public ArrayList<PalavraDeMemoria> printMemoria() {
        return memoria;
    }

    public void set(short endereco, short conteudo) { 
            memoria.get(endereco).setValor(conteudo);
    }

    public short get(short endereco){
            return (short) memoria.get(endereco).getValor();
    }

    private short lerShort(FileInputStream stream) throws IOException {
        short num;
        num = (byte) stream.read();
        num <<= 8;
        num += stream.read();
        return num;
    }

}

