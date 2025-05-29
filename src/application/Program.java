package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;
import entities.func.Funcao;
import entities.func.MenuFuncao;
import entities.model.App;
import entities.model.Menu;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		App app  = new Funcao();
		Menu  menu = new MenuFuncao();
		
		List<Cliente> cliente = new ArrayList<>();
		List<Produto> estoque = new ArrayList<>();
		
		menu.mostrarMenuPrincipal(sc, app, estoque, cliente);
		

		sc.close();
	}

}
