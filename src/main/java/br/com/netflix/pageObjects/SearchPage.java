package br.com.netflix.pageObjects;

import org.openqa.selenium.WebElement;

import br.com.netflix.metodos.Criar;

public class SearchPage {

	private static WebElement element;

	public static WebElement clicandoFilme() {
		
		 element = Criar.criandoElementXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div[1]/a/div[1]/img" + "");
		
		return element;
	}

	public static WebElement clicandoParaInformacoes() {
		
		element = Criar.criandoElementXpath("/html/body/div[@id='appMountPoint']/div[@class='netflix-sans-font-loaded']/div/div[1]/div[@class='bd dark-background']/div[@class='mainView']/div[@class='search']/div[@class='gallery row-with-x-columns search']/div[@class='galleryContent']/div/div[@class='galleryLockups']/div[@id='row-0']/div[@class='ptrack-container']/div[@class='rowContent slider-hover-trigger-layer']/div[@class='slider']/div[@class='sliderMask showPeek']/div[@class='sliderContent row-with-x-columns']/div[@class='slider-item slider-item-0']/div[@class='title-card-container']/div[@id='title-card-0-0']/div[@class='bob-container']/span/div[@class='bob-card bob-card-adult-video-merch']/div[1]/div[@class='bob-overlay']/a[@class='bob-jaw-hitzone']");
		
		return element;
	}

	public static WebElement iniciandoFilme() {
		
		element = Criar.criandoElementXpath("//*[@id=\"pane-Overview\"]/div/div/div/div[1]/div/div[4]/a/span");
		
		return element;
	}
	
}
