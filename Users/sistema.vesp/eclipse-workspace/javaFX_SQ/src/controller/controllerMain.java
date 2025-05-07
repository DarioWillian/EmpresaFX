package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.FuncionarioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Funcionario;

public class controllerMain implements Initializable{
	 @FXML
	 private Button btApagar;

     @FXML
	private Button btEditar;

	@FXML
    private Button btSalvar;

	@FXML
    private TextField txtCPF;

	@FXML
    private TextField txtCargo;

    @FXML
    private TextField txtNome;
	  
	@FXML
    private TextField txtNivel;
	  
	@FXML
	private TextField txtSenha;
	
    @FXML
    private TableColumn<Funcionario, String> Cargo;

    @FXML
    private TableColumn<Funcionario, String> Cpf;

    @FXML
    private TableColumn<Funcionario, String> Nivel;

    @FXML
    private TableColumn<Funcionario, String> Nome;

    @FXML
    private TableColumn<Funcionario, String> Senha;

    @FXML
    private TableColumn<Funcionario, String> id;

    @FXML
    private TableView<Funcionario> tabelaFuncionarios;
    
    
    
    
    @FXML
    void Apagar(ActionEvent event) {
    	int i = tabelaFuncionarios.getSelectionModel().getSelectedIndex();
    	if(i == -1) {
    		Alert msg = new Alert(AlertType.ERROR);
        	msg.setHeaderText("ERRO ");
	    	msg.setContentText("Falha, Selecione o funcionario antes de excluir");
	    	msg.show();
    	}else {
    		Funcionario func = new Funcionario();
    		FuncionarioDao funcDao = new FuncionarioDao();
    		
    		func = tabelaFuncionarios.getItems().get(i);
    		Alert msg = new Alert(AlertType.CONFIRMATION);
        	msg.setHeaderText("Voçe deseja realmente excluir o funcionario: "+func.getNome()+"?");
	    
	    	
	    	Optional<ButtonType> resultado = msg.showAndWait();
	    	
	    	if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
	    		funcDao.delete(func.getId());
	    		carregarTable();
	    		
	    	}
	    	
    	}
    }

    @FXML
    void Editar(ActionEvent event) {

    	
    	
    	
    	
    	
    	
    	
    }

    @FXML
    void Salvar(ActionEvent event) {
    	//se o espaço for vazio e pra sair uma mensagem de erro na tela 
    	//por isso usamos o equals("")
        if(txtNome.getText().equals("") || txtCargo.getText().equals("") || txtCPF.getText().equals("") || txtNivel.getText().equals("") || txtSenha.getText().equals("") ) {
        	Alert msg = new Alert(AlertType.ERROR);
        	msg.setHeaderText("ERRO Iformações incompletas");
	    	msg.setContentText("Falha na tentativa de fazer o cadastro!!");
	    	msg.show();
        	
        }else {
        	//criaçao da nova tebela com o novo funcionario 
        	Funcionario funcionario = new Funcionario(); 
        	FuncionarioDao funcDao = new FuncionarioDao();
        	funcionario.setNome(txtNome.getText());
        	funcionario.setCargo(txtCargo.getText());
        	funcionario.setCpf(Cpf.getText());
        	funcionario.setNivel(txtNivel.getText());
        	funcionario.setSenha(txtSenha.getText());
            
        	//Criaçao da tabela que eu acabei de declarar
        	funcDao.create(funcionario);
        	carregarTable();
            
            txtNome.setText("");        	
            txtCargo.setText("");        	
            txtCargo.setText("");        	
            txtNivel.setText("");        	
            txtSenha.setText(""); 	
        	
        }
    	
    	
    	
    }

    
    private ObservableList<Funcionario> funcionarios;
    private FuncionarioDao funcDao = new FuncionarioDao();
    void carregarTable() {
    	funcionarios = FXCollections.observableArrayList(funcDao.read());
    	
    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	Cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
    	Cpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
    	Senha.setCellValueFactory(new PropertyValueFactory<>("Senha"));
    	Nivel.setCellValueFactory(new PropertyValueFactory<>("Nivel"));
    	
    	tabelaFuncionarios.setItems(funcionarios);
    	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarTable();
	}
    
    
    
    
    
    
    
    
    
    
}
