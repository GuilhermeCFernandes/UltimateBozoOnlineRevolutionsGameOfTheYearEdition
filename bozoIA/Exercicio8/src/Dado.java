import java.util.Random;

/**
 * Classe que simula um dado com número de faces variádos
 * O lançamento do dado é feito através de um gerador de números aleatórios
 * É possível também ver qual foi a ultima face sorteada.
 *
 * @author Tiago Esperança Triques
 * @author Guilherme Correa Fernandes
 */
public class Dado {
    int lado, faces;
    String desenho = "";
    Random rd = new Random();

    /**
    * Instancia um objeto "dado" com 6 lados
    */
    public Dado() {
        faces = 6;
        //rolar();
    }

    /**
    * Cria um dado de n lados
    * @param n Número de lados do dado a ser criado
    */
    public Dado(int n) {
        faces = n;
        lado = rd.nextInt(faces) + 1;
    }

    /**
    * Método para retornar o último lado sorteado do dado
    * @return int Último número sorteado
    */
    public int getLado() {
        return lado;
    }

    /**
    *  Simula um lancamento de dado, gerando um número aleatório entre 1 e "número de faces"
    *  @return Valor sorteado
    */
    public int rolar() {
        lado = rd.nextInt(faces) + 1;
        return getLado();
    }

    /**
     * Método que imprime uma representação da ultima face sorteada pelo dado
     * Apenas funciona com um dado de 6 faces
     * @return Uma string com o desenho representando a face sorteada do dado caso o dado seja de 6 lados ou uma string vazia caso o dado tenha um número diferente de 6 lados
     */
    

    
    @Override
    public String toString() {
        if(faces != 6)
            return "";
        switch(lado) {
        case 1:
            desenho = ("+-----+\n");
            desenho +=("|     |\n");
            desenho +=("|  *  |\n");
            desenho +=("|     |\n");
            desenho +=("+-----+\n");
            break;
        case 2:
            desenho = ("+-----+\n");
            desenho +=("|*    |\n");
            desenho +=("|     |\n");
            desenho +=("|    *|\n");
            desenho +=("+-----+\n");
            break;
        case 3:
            desenho = ("+-----+\n");
            desenho +=("|*    |\n");
            desenho +=("|  *  |\n");
            desenho +=("|    *|\n");
            desenho +=("+-----+\n");
            break;
        case 4:
            desenho = ("+-----+\n");
            desenho +=("|*   *|\n");
            desenho +=("|     |\n");
            desenho +=("|*   *|\n");
            desenho +=("+-----+\n");
            break;
        case 5:
            desenho = ("+-----+\n");
            desenho +=("|*   *|\n");
            desenho +=("|  *  |\n");
            desenho +=("|*   *|\n");
            desenho +=("+-----+\n");
            break;
        case 6:
            desenho = ("+-----+\n");
            desenho +=("|*   *|\n");
            desenho +=("|*   *|\n");
            desenho +=("|*   *|\n");
            desenho +=("+-----+\n");
            break;
        }
        return desenho;
    }
}
