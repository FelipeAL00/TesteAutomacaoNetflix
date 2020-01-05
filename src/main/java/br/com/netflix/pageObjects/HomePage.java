package br.com.netflix.pageObjects;

import org.openqa.selenium.WebElement;

import br.com.netflix.metodos.Criar;

public class HomePage {
	private static WebElement element;
	public static WebElement btnPesquisar() {
		element = Criar.criandoElementXpath("//*[@id=\"appMountPoint\"]/div/div/div[1]/div[1]/div[1]/div/div/div/div[1]/div/button");
	
		return element;
	}
	
	public static WebElement textoPesquisar() {
		element = Criar.criandoElementXpath("/html/body/div[@id='appMountPoint']/div[@class='netflix-sans-font-loaded']/div/div[1]/div[@class='bd dark-background']/div[@class='pinning-header']/div[@class='pinning-header-container']/div[@class='main-header has-billboard search-focused menu-navigation']/div[@class='secondary-navigation search-focused']/div[@class='nav-element'][1]/div[@class='searchBox']/div[@class='searchInput']/input");
	
		return element;
	}
	
	public static WebElement usuario(String xpath) {
		element = Criar.criandoElementXpath(xpath);
		
		return element;
	}

}
