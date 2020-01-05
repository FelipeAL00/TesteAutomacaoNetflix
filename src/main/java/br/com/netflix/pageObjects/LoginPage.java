package br.com.netflix.pageObjects;

import org.openqa.selenium.WebElement;

import br.com.netflix.metodos.Criar;

public class LoginPage {

	private static WebElement element;
	
	public static WebElement enviarDados(String id) {
		element = Criar.criandoElementId(id);
		
		return element;
	}
	
	public static WebElement confirmarEnvioBtn(String xpath){
		element = Criar.criandoElementXpath(xpath);
		
		return element;
	}
		
}
