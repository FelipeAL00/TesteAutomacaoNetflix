package br.com.netflix.metodos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.netflix.pageObjects.HomePage;
import br.com.netflix.pageObjects.LoginPage;
import br.com.netflix.pageObjects.SearchPage;

public class Controller{

	private static WebElement element;
	private static Actions actions;
	
	public static void passandoCaminhoHttp(String caminho) {
//		metodo que passa o caminho http para o driver do selenium ser criado
		Criar.passandoCaminhoHttp(caminho);
	}	
	
	public static boolean login(int row,int colLogin, int colSenha) throws Exception {
//		excelutil classe que busca as senhas e logins dos usuarios para saber se é válido ou não
		ExcelUtil.setExcelFile("C:\\Users\\felipe.almeida\\Documents\\java-workspace\\Netflix\\" + "TestData.xlsx","Planilha1");
		
//		usuario buscado no excel através da linha e coluna que o programa passa
		String login = ExcelUtil.getCellData(row, colLogin); 
		String senha = ExcelUtil.getCellData(row, colSenha);
		
//		element está recebendo de uma classe estatica que cria o element através do ID
		element = LoginPage.enviarDados("id_userLoginId");
//		acoesRepetidas é a classe que faz funções que são repetidas mais de uma vez, exemplo: sendKeys, click...
		AcoesRepetidas.escrever(login,element);
		
		element = LoginPage.enviarDados("id_password");
		AcoesRepetidas.escrever(senha,element);
				
		element = LoginPage.confirmarEnvioBtn("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button");
		AcoesRepetidas.clicar(element);
		
//		Se após setarmos o usuario e senha e mesmo assim não ser redirecionado para a 
//		próxima página, quer dizer que o usuário não passou e devemos continuar tentando, então retornamos uma bool
//		sinalizando que o programa não deve ser parado e reprova o usuario no caso de testes do excel
		if(Criar.getlink().equals("https://www.netflix.com/br/login")) {
			ExcelUtil.setCellData("Reprovou", row, 4);
			return false;
		}
//		se passar ele nos retorna um verdadeiro, sinalizando que o usuario logou e aprova no caso de teste
		ExcelUtil.setCellData("Passou", row, 4);
		return true;
	}

	public static void usuario() {
//		escolhendo que o usuario devemos usar.
		element = HomePage.usuario("//*[@id=\"appMountPoint\"]/div/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/div/a/div/div");
		AcoesRepetidas.clicar(element);
	}
	
	public static void clicandoEmPesquisar(int row) throws Exception {
//		pesquisando o filme de acordo caso de teste
		String filme = ExcelUtil.getCellData(row, 3);
		
//		clicando no btn pesquisar
		element = HomePage.btnPesquisar();
		AcoesRepetidas.clicar(element);
// 		escrevendo no campo que aparece em sequencia
		element = HomePage.textoPesquisar();		
		AcoesRepetidas.escrever(filme ,element);
		
	}
	
	public static void escolhendoFilme(){
//		escolhendo o filme que  e parando em cima do elemento
		element = SearchPage.clicandoFilme();
		actions = Criar.criandoactions();
		AcoesRepetidas.pararEmCimaDoElemento(actions,element);
//		clicando para abrir informações do filme
		element = SearchPage.clicandoParaInformacoes();
		AcoesRepetidas.clicar(element);		
//		iniciando um filme
		element = SearchPage.iniciandoFilme();
		AcoesRepetidas.clicar(element);
		
	}

	public static void limpar() {
//		limpando a entrada de dados no login, quando nao passado um login
		element = LoginPage.enviarDados("id_userLoginId");
		AcoesRepetidas.limpar(element);
		
		element = LoginPage.enviarDados("id_password");
		AcoesRepetidas.limpar(element);
		
	}

	public static void close() {
//		fechando o webdriver
		AcoesRepetidas.close();
	}


	
	
}
