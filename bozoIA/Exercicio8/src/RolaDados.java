import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Guilherme Correa Fernandes
 * @author Tiago Esperança Triques
 */
public class RolaDados {
    int n;
    int[] valores;
    Dado[] dados;
    StringTokenizer[] tokenizer;

    /**
     * Construtor que cria e armazena diversos objetos do tipo dado
     * Os "dados" são criados utilizando o construtor padrão da classe Dado, ou seja, serão criados dados de 6 lados.
     *
     * @param n Quantidade de dados
     */
    public RolaDados (int n) {
        this.n = n;
        dados = new Dado[n];
        tokenizer = new StringTokenizer[n];

        for(int i = 0; i < n; i ++) {
            dados[i] = new Dado();
        }

        valores = new int[n];
    }

    public int[] valoresAnteriores() {
        for(int i = 0; i < 5; i++) {
            valores[i] = dados[i].getLado();
        }
        return valores;
    }

    /**
     * Método para rolar todos os dados
     * @return Vetor de inteiros representando quais faces foram sorteadas no lançamento dos dados.
     */
    public int[] rolar() {
        for(int i = 0; i < n; i ++) {
            valores[i] = dados[i].rolar();
        }
        return valores;
    }

    /**
     * Rola algum dos dados
     * @param quais Vetor de boolean indicando qual/quais dados dever ser rolados. As
     * @return Vetor de inteiros representando quais faces foram sorteadas no lançamento dos dados.
     */
    public int [] rolar(boolean [] quais) {
        for(int i = 0; i < n; i ++) {
            if(quais[i]){
                dados[i].rolar();
            }
            valores[i] = dados[i].getLado();
        }
        return valores;
    }

    /**
     *  Método para rolar algum dos dados
     *
     * @param s String que contém o número de quais dados devem ser rolados, ie: "1 2" representa que apenas os dados 1 e 2 devem ser rolados.
     * @return Valores sorteados no lançamento dos dados. Caso um dado não tenha sido lançado, o valor mostrado é o resultado do último lançamento.
     */
    public int [] rolar(String s) {
        boolean [] quais = new boolean[n];
        Arrays.fill(quais, false);
        for(int i = 0; i < s.length(); i ++) {
            int aux = Character.getNumericValue(s.charAt(i));
            aux--;
            if (aux < n && aux >= 0)
            	quais[aux] = true;
        }
        return rolar(quais);
    }

    /**
     * Método para imprimir uma representação dos n dados e suas respectivas faces sorteadas.
     * @return String contendo o desenho que representa os dados
     */
    @Override
    public String toString() {
        String s = "";
        
        for(int i = 0; i < n; i ++) {
                tokenizer[i] = new StringTokenizer(dados[i].toString(), "\n");
        }
        
        for(int i = 0; i < n; i++) {
            s += "   " +(i+1);
            s += (i == n-1) ? "\n" : "\t";
        }

        while(tokenizer[0].hasMoreTokens()) {
            for(int i = 0; i < n; i++) {
                s += tokenizer[i].nextToken();
                s += (i == n-1) ? "\n" : "\t";
            }
        }

        return s;
    }
}
