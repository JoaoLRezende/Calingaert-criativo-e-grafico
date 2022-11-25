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
    private Label lbl_RI;

    @FXML
    private Label lbl_SP;

    @FXML
    private TextField textField_arquivoEntrada;

    @FXML
    private TextField textField_entrada;

    @FXML
    private TextArea txt_outputConsole;

    @FXML
    private TableView<PalavraDeMemoria> memoria_tabela;

    @FXML
    private TableColumn<PalavraDeMemoria, Integer> tabela_colunaPosicao;

    @FXML
    private TableColumn<?, ?> tabela_colunaValor;

    private URL url;
    private ResourceBundle rb;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url = url;
        this.rb = rb;
        Memoria memoria = new Memoria(1000);
        HelloApplication.executor = new Executor(memoria);
        txt_outputConsole.appendText("Inicializando Calingaert 3000. beep boop.\n");
        atualizarInterface();
    }

    @FXML
    void onLimparClick(ActionEvent event) throws IOException {
        initialize(url, rb);
        txt_outputConsole.setText("Limpo.\n");
    }

    void atualizarInterface() {
        tabela_colunaPosicao.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabela_colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        ObservableList<PalavraDeMemoria> obervableListMemoria = FXCollections.observableArrayList(HelloApplication.executor.memoria.memoria);
        memoria_tabela.setItems(obervableListMemoria);

        // atualizar registradores
        lbl_ACC.setText(String.valueOf(HelloApplication.executor.acumulador));
        lbl_PC.setText(String.valueOf(HelloApplication.executor.contadorDePrograma));
        lbl_RI.setText(String.valueOf(HelloApplication.executor.registradorDeInstrucao));
        lbl_SP.setText(String.valueOf(HelloApplication.executor.ponteiroDaPilha));
    }

    @FXML
    void onCarregarClick(ActionEvent event) throws IOException {
        HelloApplication.carregarPrograma(textField_arquivoEntrada.getText(), txt_outputConsole);
        atualizarInterface();
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
        while (true) {
            if (HelloApplication.executor.aguardandoEntrada) {
                txt_outputConsole.appendText("Aguardando entrada.\n");
                atualizarInterface();
                return;
            }
            if (HelloApplication.executor.terminou) {
                txt_outputConsole.appendText("\nExecução terminada com sucesso.\n");
                atualizarInterface();
                return;
            }
            darPasso();
        }
    }

    @FXML
    void onPassoClick(ActionEvent event) {
        darPasso();
    }

    void darPasso() {
        if (HelloApplication.executor.aguardandoEntrada) {
            txt_outputConsole.appendText("Aguardando entrada.\n");
            return;
        }

        if(!HelloApplication.executor.terminou) {
            Short retorno = HelloApplication.executor.step();
            if (retorno != null) {
                txt_outputConsole.appendText("\nSaída: " + retorno + "\n");
            }
        } else {
            txt_outputConsole.appendText("\nExecução terminada com sucesso.\n");
        }
        atualizarInterface();
    }

    @FXML
    void onReadClick(ActionEvent event) {
        if (!HelloApplication.executor.aguardandoEntrada) {
            txt_outputConsole.appendText("Não perguntei.\n");
            return;
        }

        HelloApplication.executor.passarEntrada(Short.parseShort(textField_entrada.getText()));
        txt_outputConsole.appendText("Entrou: " + Short.parseShort(textField_entrada.getText()) + "\n");

    }

}
