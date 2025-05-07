package application;
	
import java.sql.Connection;
import java.util.ArrayList;

import connectionFactory.connectionDatabase;
import dao.FuncionarioDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Funcionario;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage stage;
	private static Scene main;
	private static Scene login;
	@Override
	
	
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/viewLogin.fxml"));
			login = new Scene(fxmlLogin);
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/view/viewMain.fxml"));
            main = new Scene(fxmlMain);
			
			primaryStage.setScene(login);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScreen(String tela) {
		
		if(tela.equals("login")){
			stage.setScene(login);
			stage.centerOnScreen();
			
		}else if(tela.equals("main")) {
			stage.setScene(main);
			stage.centerOnScreen();
		}
	}
	
	public static void main(String[] args) {
		Connection con = connectionDatabase.getConnection();
		connectionDatabase.closeConnection(con);
		
		Funcionario funcionario = new Funcionario();
		 
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		funcionarios = funcionarioDao.read();
		
		for(int i = 0; i < funcionarios.size(); i++) {
			
              funcionario = funcionarios.get(i);
              System.out.print("||");
              System.out.print(funcionario.getId());
              System.out.print("||");
              System.out.print(funcionario.getNome());
              System.out.print("||");
              System.out.print(funcionario.getCargo());
              System.out.print("||");
              System.out.print(funcionario.getCpf());
              System.out.print("||");
              System.out.print(funcionario.getSenha());
              System.out.print("||");
              System.out.print(funcionario.getNivel());
              System.out.print("");
		}
		
		
		launch(args);
	}
}
 