package com.calingaertgrafico.calingaertlegalegrafico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    static Executor executor;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 876, 542);
        stage.setTitle("Calingaert 3000");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

    static void carregarPrograma(String nomeArquivoExecutavel, TextArea txt_outputConsole) throws IOException {
        Memoria memoria = new Memoria(1000, new File(nomeArquivoExecutavel));
        executor = new Executor(memoria);
        txt_outputConsole.appendText("Programa carregado: " + nomeArquivoExecutavel + "\n");
    }
}