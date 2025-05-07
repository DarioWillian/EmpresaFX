package controller;

import java.util.ArrayList;

import application.Main;
import dao.FuncionarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Funcionario;

public class controllerLogin {

    @FXML
    private TextField TxtUsuario;

    @FXML
    private Button btLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void login(ActionEvent event) {

    	if(TxtUsuario.getText().equals("") || txtSenha.getText().equals("") ) {
    	Alert msg = new Alert(AlertType.ERROR);
    	msg.setHeaderText("Falha ao fazer o login");
    	msg.setContentText("Usuario ou senha incorretos! Verifique novamente!");
    	msg.show();
    	}else {
    		FuncionarioDao funciDao = new FuncionarioDao();
    		Funcionario func = new Funcionario();
    		ArrayList<Funcionario> funcionarios = new ArrayList<>();
    		funcionarios = funciDao.autenticarUsuario(TxtUsuario.getText(),   txtSenha.getText() );
    		
    		if(funcionarios.size() != 0) {	
    		func = funcionarios.get(0);
    		
    		if(TxtUsuario.getText().equals(func.getCpf()) && txtSenha.getText().equals(func.getSenha()) ) {
    			Alert msg = new Alert(AlertType.INFORMATION);
    			msg.setHeaderText("Seja bem vindo");
    	    	msg.setContentText("É um prazer telo(a) de volta!");
    	    	msg.show();
    	    	Main.changeScreen("main");
    		}
    		}else {
    			Alert msg = new Alert(AlertType.ERROR);
    			msg.setHeaderText("Falha ao tentar fazer o login");
    	    	msg.setContentText("Usuario ou senha incorretos! Verifique novamente!");
    	    	msg.show();
    		
    		}
    		
    		
    	}
    	
    	
    	
    }

}
