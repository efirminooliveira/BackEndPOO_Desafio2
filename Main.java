import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static List<Produto> produtos = new ArrayList<>();
  private static int contadorId = 1;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      limparConsole();
      exibirMenu();
      opcao = scanner.nextInt();
      scanner.nextLine(); // Consumir a nova linha

      switch (opcao) {
        case 0:
          System.out.println("Saindo do sistema...");
          break;
        case 1:
          cadastrarProduto(scanner);
          break;
        case 2:
          editarProduto(scanner);
          break;
        case 3:
          deletarProduto(scanner);
          break;
        case 4:
          visualizarProdutos();
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }

      if (opcao != 0) {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
      }

    } while (opcao != 0);

    scanner.close();
  }

  private static void exibirMenu() {
    System.out.println("Menu:");
    System.out.println("0 - Sair do sistema");
    System.out.println("1 - Cadastrar produto");
    System.out.println("2 - Editar produto");
    System.out.println("3 - Deletar produto");
    System.out.println("4 - Visualizar lista de produtos");
    System.out.print("Escolha uma opção: ");
  }

  private static void limparConsole() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void cadastrarProduto(Scanner scanner) {
    limparConsole();
    System.out.print("Nome do produto: ");
    String nome = scanner.nextLine();
    System.out.print("Quantidade: ");
    int quantidade = scanner.nextInt();
    System.out.print("Valor: ");
    double valor = scanner.nextDouble();
    scanner.nextLine(); // Consumir a nova linha

    Produto produto = new Produto(contadorId++, nome, quantidade, valor, new Date());
    produtos.add(produto);
    System.out.println("Produto cadastrado com sucesso!");
  }

  private static void editarProduto(Scanner scanner) {
    limparConsole();
    System.out.print("ID do produto a ser editado: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    Produto produto = buscarProdutoPorId(id);
    if (produto != null) {
      System.out.print("Novo nome (atual: " + produto.getNome() + "): ");
      String nome = scanner.nextLine();
      if (!nome.trim().isEmpty()) {
        produto.setNome(nome);
      }

      System.out.print("Nova quantidade (atual: " + produto.getQuantidade() + "): ");
      String quantidadeStr = scanner.nextLine();
      if (!quantidadeStr.trim().isEmpty()) {
        int quantidade = Integer.parseInt(quantidadeStr);
        produto.setQuantidade(quantidade);
      }

      System.out.print("Novo valor (atual: " + produto.getValor() + "): ");
      String valorStr = scanner.nextLine();
      if (!valorStr.trim().isEmpty()) {
        double valor = Double.parseDouble(valorStr);
        produto.setValor(valor);
      }

      System.out.println("Produto editado com sucesso!");
    } else {
      System.out.println("Produto não encontrado.");
    }
  }

  private static void deletarProduto(Scanner scanner) {
    limparConsole();
    System.out.print("ID do produto a ser deletado: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    Produto produto = buscarProdutoPorId(id);
    if (produto != null) {
      produtos.remove(produto);
      System.out.println("Produto deletado com sucesso!");
    } else {
      System.out.println("Produto não encontrado.");
    }
  }

  private static void visualizarProdutos() {
    limparConsole();
    if (produtos.isEmpty()) {
      System.out.println("Nenhum produto cadastrado.");
    } else {
      System.out.println("Lista de produtos:");
      for (Produto produto : produtos) {
        System.out.println(produto);
      }
    }
  }

  private static Produto buscarProdutoPorId(int id) {
    for (Produto produto : produtos) {
      if (produto.getId() == id) {
        return produto;
      }
    }
    return null;
  }
}
