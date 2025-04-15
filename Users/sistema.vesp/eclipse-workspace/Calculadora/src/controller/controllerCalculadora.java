package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class controllerCalculadora {
    @FXML
    private Button btResultado;
    @FXML
    private TextField txtTela;
    private int primeiroNumero;
    private int SegundoNumero;
    private String operacao = "";
    String numero = "";
    private int resultado;
    @FXML
    void apagar(ActionEvent event) {
    	txtTela.setText(""); //vai limpar o meu visor
    	primeiroNumero = 0;
    	SegundoNumero = 0;
    	numero = ""; //limpa o numero
    	operacao = ""; //limpa a operacao
    //funciona meio que um limpa tela geral
    }
    @FXML
    void digitarNumero(ActionEvent event) {
     Button botao = (Button) event.getSource();//pega o botão que foi clicado
     numero =  numero + botao.getText();//pega o numero
     txtTela.setText(numero);//atualiza a tela com o numero do botao
     if(operacao.equals("")) {
    	 primeiroNumero = Integer.parseInt(numero); //so vai para o segundo numero quando a operacao ja for clicada 
     }else {
    	 SegundoNumero = Integer.parseInt(numero);//so vai para o segundo numero quando a operacao ja for clicada 
     }
     System.out.println("primeiro: " + primeiroNumero);//imprime o primeiro numero no console
     System.out.println("segundo: " + SegundoNumero);//imprime o segundo numero no console
    }
    @FXML
    void escolherOperacao(ActionEvent event) {
    Button botao = (Button) event.getSource();//pega o botao da opecacao
    operacao = botao.getText();//vai salvar a operacao
    numero = "";//limpa o numero da tela e começa do segundo numero
    txtTela.setText(txtTela.getText() + operacao);//mostra na tela a operaçao
    }
    @FXML
    void verResultado(ActionEvent event) {
    	if(SegundoNumero == 0)  { //se o numero for igual a zero, exibe a mensagem de erro
    		txtTela.setText("ERRO");//sai a mensagem de erro na tela	
    	}
    	switch(operacao) { //escolhe a opecacao
    	case "/"://caso for / 
    		resultado =  primeiroNumero / SegundoNumero; // divide ele 
    		txtTela.setText(""+resultado); //e mostra o resultado
    		break;//encerra o caso
    	case "+": //caso for + 
    		resultado = primeiroNumero + SegundoNumero;//soma eles
    		txtTela.setText(""+resultado);//e mostra o resultado
    		break;//encerra o caso
    	case "*": //caso for *
    		resultado =  primeiroNumero * SegundoNumero; //multiplica ele
    		txtTela.setText(""+resultado);//e mostra o resultado
    		break;
    	case "-"://caso for -
    		resultado =  primeiroNumero - SegundoNumero; //subtrai eles
    		txtTela.setText(""+resultado);//e mostra o resultado
    	    break;//encerra o caso
    	
    	default://se for outra operacao
    		txtTela.setText("ERRO");//sai a mensagem de erro
    		break;//encerra o caso
    	}
    }
}
