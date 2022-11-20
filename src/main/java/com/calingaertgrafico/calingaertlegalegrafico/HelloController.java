package com.calingaertgrafico.calingaertlegalegrafico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

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
    private TextField textField_arquivoEntrada;

    @FXML
    private TextArea txt_outputConsole;

    @FXML
    private TableView<PalavraDeMemoria> memoria_tabela;

    @FXML
    private TableColumn<PalavraDeMemoria, Integer> tabela_colunaPosicao;

    @FXML
    private TableColumn<?, ?> tabela_colunaValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Memoria memoria = new Memoria(1000);
        HelloApplication.executor = new Executor(memoria);
        atualizarTabelaDeMemoria();
    }

    void atualizarTabelaDeMemoria() {
        tabela_colunaPosicao.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabela_colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        ObservableList<PalavraDeMemoria> obervableListMemoria = FXCollections.observableArrayList(HelloApplication.executor.memoria.memoria);
        memoria_tabela.setItems(obervableListMemoria);
    }

    @FXML
    void onLimparClick(ActionEvent event) throws IOException {
        txt_outputConsole.setText(txt_outputConsole.getText() + "carregando arquivo\n");
        System.out.println("carregando arquivo");
        HelloApplication.carregarPrograma(textField_arquivoEntrada.getText(), txt_outputConsole);
    }

    @FXML
    void onCarregarClick(ActionEvent event) throws IOException {
        HelloApplication.carregarPrograma(textField_arquivoEntrada.getText(), txt_outputConsole);
        atualizarTabelaDeMemoria();
    }

    @FXML
    void selecionarArquivo(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo Montado", "*.HPX"));
        File f = fc.showOpenDialog(null);

        if (f != null){
            textField_arquivoEntrada.setText(f.getAbsolutePath());
        }
    }

    @FXML
    void onExecutarClick(ActionEvent event) {
        while (!HelloApplication.executor.terminou) {
            HelloApplication.executor.step();
        }
        atualizarTabelaDeMemoria();
    }

    }
