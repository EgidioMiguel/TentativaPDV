package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;
import entities.func.Funcao;
import entities.func.FuncaoSistema;
import entities.func.MenuFuncao;
import entities.model.App;
import entities.model.AppSistema;
import entities.model.Menu;
import sistemas.Compra;
import sistemas.Pedido;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		App app  = new Funcao();
		AppSistema aps = new FuncaoSistema();
		Menu  menu = new MenuFuncao();
		
		List<Cliente> cliente = new ArrayList<>();
		List<Produto> estoque = new ArrayList<>();
		List<Compra> compra = new ArrayList<>();
		List<Pedido>  venda = new ArrayList<>();		
		
		menu.mostrarMenuPrincipal(sc, aps, app, estoque, cliente, compra, venda);		

		sc.close();
	}

}
