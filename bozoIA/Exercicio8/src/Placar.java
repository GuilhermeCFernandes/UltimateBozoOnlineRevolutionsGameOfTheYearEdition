/**
 * Representa o placar do jogo, cuida da pontuaçao
 * @author Tiago Esperança Triques
 * @author Guilherme Correa Fernandes
 */
import java.util.Arrays;

public class Placar {
    
    int score;
    int [][] configDados = new int [10][5];
    int [] pontos = new int [10];
    int [] pontosDasPosicoes = new int[]{1, 2, 3, 4, 5, 6, 15, 20, 30 ,40};
    
    public Placar(){
        Arrays.fill(pontos, -1);
    }

    private int sumAux (int [] dados, int h){
        int resultado = 0;
        for (int v: dados)
            if(v == h)
                resultado += v;
        return resultado;
    }
    
    private int counter (int [] dados, int h){
        return sumAux(dados, h) / h;
    }
    
    private int [] countAll (int [] dados){
        int [] result = new int [6];
        for(int i = 0; i < 5; i ++){
            result[i] = counter(dados, i + 1);
        }
        return result;
    }
   
    private boolean isValid(int posicao, int [] dados){
        if(posicao >= 0 && posicao < 10 && pontos[posicao] != -1) {
            return false;
        }

        int [] aux = new int [5];
        aux = countAll(dados);
        
        if(posicao >= 0 && posicao <= 5 && sumAux(dados, posicao + 1) != 0){
            score += sumAux(dados, posicao + 1);
            pontos[posicao] = sumAux(dados, posicao + 1);
            return true;
        }
       
        if(posicao == 6){
            boolean dupla = false, trio = false;
            for(int v: aux){
                if(v == 2)
                    dupla = true;
                if(v == 3)
                    trio = true;
            }
            if(dupla && trio){
                score += 15;
                pontos[posicao] = 15;
                return true;
            }
        }

        if(posicao == 7){
            if(Arrays.equals(aux, new int[]{1,1,1,1,1,0}) || Arrays.equals(aux, new int[]{0,1,1,1,1,1})){
                score += 20;
                pontos[posicao] = 20;
                return true;
            }
        }
        if(posicao == 8){
            for(int v: aux)
                if(v == 4){
                    score += 30;
                    pontos[posicao] = 30;
                    return true;
                }
        }

        if(posicao == 9){
            for(int v: aux)
                if(v == 5){
                    score += 40;
                    pontos[posicao] = 40;
                    return true;
                }
        }
        
        return false;
    }
	/**
	 * Adiciona uma combinacao de dados, se for valida, para uma posicao do placar.
	 * Cada posicao so pode ser usada uma vez
	 * @param posicao Posicao do placar para armazenar os dados
	 * @param dados Sequencia de dados
	 */
    public void add (int posicao, int [] dados){
        if(isValid(posicao, dados)) {
            configDados[posicao] = dados;
        }
    }
    /**
     * Retorna a pontuaçao atual
     * @return Pontuacao
     */
    public int getScore(){
        return score;
    }
    
    private String posicaoPlacar(int n){
    	String s = new String();
    	if(pontos[n] == -1){
    		s += '(';
    		s += pontosDasPosicoes[n];
    		s += ')';
    	}
    	else
    		s += pontos[n];
    	return s;
    }
    
    /**
     * Representa o placar na forma de uma string, mostrando as posicoes livre(com os valores delas), e as ja ocupadas(com os pontos obtidos em cada uma)
     */
    @Override
        public String toString(){
        return String.format("%s\t|%s\t|%s\n--------------------------\n%s\t|%s\t|%s\n--------------------------\n%s\t|%s\t|%s\n--------------------------\n\t|%s\t|\n        +-------+\n",posicaoPlacar(0), posicaoPlacar(6), posicaoPlacar(3), posicaoPlacar(1),posicaoPlacar(7), posicaoPlacar(4), posicaoPlacar(2), posicaoPlacar(8), posicaoPlacar(5), posicaoPlacar(9));
    }
}
