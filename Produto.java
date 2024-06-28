import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Produto {
  private int id;
  private String nome;
  private int quantidade;
  private double valor;
  private Date dataCadastro;

  public Produto(int id, String nome, int quantidade, double valor, Date dataCadastro) {
    this.id = id;
    this.nome = nome;
    this.quantidade = quantidade;
    this.valor = valor;
    this.dataCadastro = dataCadastro;
  }

  // Getters e Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Date getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
    String dataFormatada = sdf.format(dataCadastro);
    return "\n\nID do produto: " + id
        + "\nNome: " + nome
        + "\nQuantidade: " + quantidade
        + "\nValor: " + valor
        + "\nData de Cadastramento: " + dataFormatada;
  }
}
