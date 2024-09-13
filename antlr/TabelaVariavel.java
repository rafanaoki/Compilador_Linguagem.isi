import java.util.HashMap;
import java.util.Map;

public class TabelaVariavel {
    // Mapa que associa o nome da variável ao objeto Variavel
    private Map<String, Variavel> tabela;

    public TabelaVariavel() {
        tabela = new HashMap<>();
    }

    public void addVariavel(Variavel variavel) {
        tabela.put(variavel.getNome(), variavel);
    }

    public Variavel getVariavel(String nome) {
        return tabela.get(nome);
    }

    public boolean contem(String nome) {
        return tabela.containsKey(nome);
    }

    public void listarVariaveis() {
        for (Variavel v : tabela.values()) {
            System.out.println(v);
        }
    }

    public void atualizarValor(String nome, String valor) {
        Variavel v = tabela.get(nome);
        if (v != null) {
            v.setValor(valor);
        } else {
            System.out.println("ERRO: Variável " + nome + " não existe.");
        }
    }
}
