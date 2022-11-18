package com.calingaertgrafico.calingaertlegalegrafico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class HelloController {

    @FXML
    private Button botao_carregar;

    @FXML
    private Button botao_correr;

    @FXML
    private Button botao_executar;

    @FXML
    private Button botao_limpar;

    @FXML
    private Button botao_passo;

    @FXML
    private Button botao_selecionarArquivo;

    @FXML
    private Label lbl_ACC;

    @FXML
    private Label lbl_PC;

    @FXML
    private Label lbl_RE;

    @FXML
    private Label lbl_RI;

    @FXML
    private Label lbl_SP;

    @FXML
    private TableView<?> tabela_memoria;

    @FXML
    private TextField textField_arquivoEntrada;

    @FXML
    private TextArea txt_outputConsole;

    @FXML
    void onLimparClick(ActionEvent event) throws IOException {
        txt_outputConsole.setText(txt_outputConsole.getText() + "carregando arquivo\n");
        System.out.println("carregando arquivo");
        HelloApplication.carregarPrograma(textField_arquivoEntrada.getText(), txt_outputConsole);
    }

    @FXML
    void onCarregarClick(ActionEvent event) throws IOException {
        HelloApplication.carregarPrograma(textField_arquivoEntrada.getText(), txt_outputConsole);
    }

    @FXML
    void carregarArquivo(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo Montado", "*.HPX"));
        File f = fc.showOpenDialog(null);

        if (f != null){
            textField_arquivoEntrada.setText(f.getAbsolutePath());
        }
    }


}
