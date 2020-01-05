package br.com.netflix.metodos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Criar {
//	 criação de webdriver, webelement, select e actions para que fique cada vez mais generico e simples de criar, sem precisar instanciar toda hora um novo webelement
	
	private static WebDriver driver = new ChromeDriver();
	private static WebElement element;
	private static Select select;
	private static Actions actions;
	
	public static void passandoCaminhoHttp(String caminho) {
			driver.get(caminho);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	public static WebElement criandoElementId(String id){
		element = driver.findElement(By.id(id));
		return element;
	}
	
	public static WebElement criandoElementName(String name){
		element = driver.findElement(By.name(name));
		return element;
	}
	
	public static WebElement criandoElementXpath(String xpath){
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public static Select criandoSelect(WebElement element){
		select = new Select(element);
		return select;
	}
	
	public static Actions criandoactions(){
		actions =  new Actions(driver);
		return actions;
	}
	
	public static void close() {
		driver.close();
	}

//	pegando a url do webdriver para conferir se estamos presos na login
	public static String getlink() {
		return driver.getCurrentUrl().toString();
	}

	
}
