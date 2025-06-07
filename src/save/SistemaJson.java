package save;

import java.util.List;

import entities.Cliente;
import entities.Produto;
import sistemas.Compra;
import sistemas.Pedido;

public class SistemaJson {

    public void salvarTudo(
            List<Produto> estoque,
            List<Cliente> clientes,
            List<Compra> compras,
            List<Pedido> pedidos,
            List<Pedido> cancelado
    ) {
        try {
            Json.salvarLista(estoque, "produtos.json");
            Json.salvarLista(clientes, "clientes.json");
            Json.salvarLista(compras, "compras.json");
            Json.salvarLista(pedidos, "pedidos.json");
            Json.salvarLista(cancelado, "cancelado.json");
            System.out.println("Dados salvos com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public void carregarTudo(
            List<Produto> estoque,
            List<Cliente> clientes,
            List<Compra> compras,
            List<Pedido> pedidos,
            List<Pedido> cancelado
            
           
    ) {
        try {
            estoque.clear();
            estoque.addAll(Json.carregarLista("produtos.json", Produto.class));

            clientes.clear();
            clientes.addAll(Json.carregarLista("clientes.json", Cliente.class));

            compras.clear();
            compras.addAll(Json.carregarLista("compras.json", Compra.class));

            pedidos.clear();
            pedidos.addAll(Json.carregarLista("pedidos.json", Pedido.class));
            
            cancelado.clear();
            cancelado.addAll(Json.carregarLista("cancelado.json", Pedido.class));

            System.out.println("Dados carregados com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}