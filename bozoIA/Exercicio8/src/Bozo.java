/**
 * Classe inicial do Bozó, é responsavel por cuidar da execuçao do jogo
 * @author Tiago Esperança Triques
 * @author Guilherme Correa Fernandes
 */
public class Bozo {
    public static void main(String[] args) {
        //Instancia objeto RolaDados e Placar 
        RolaDados dados = new RolaDados(5);
        Placar placar =  new Placar();
        String deveRolar = "";
        int posicao = 0;

        for(int nRodadas = 0; nRodadas < 10; nRodadas++) {
            //Rolar dados pela primeira vez
            dados.rolar();
            try {
                System.out.printf(dados.toString());
            } catch(Exception e) {
            }

            //Perguntar ao jogador quais dados devem ser lançados novamente
            //Imprimir dados após o lançamento
            System.out.println("Lançar novamente quais dados?");
            try {
                deveRolar = EntradaTeclado.leString();
            } catch(Exception e) {
            }
            dados.rolar(deveRolar);
            System.out.printf(dados.toString());

            //Perguntar ao jogador quais dados devem ser lançados novamente
            //Imprimir dados após o lançamento
            System.out.println("Lançar novamente quais dados?");
            try {
                deveRolar = EntradaTeclado.leString();
            } catch(Exception e) {
            }
            dados.rolar(deveRolar);
            System.out.printf(dados.toString());

            System.out.println("Armazenar em qual \"slot\"");
            try {
                posicao = EntradaTeclado.leInt();
            } catch(Exception e) {
            }
            placar.add(posicao-1, dados.valoresAnteriores());

            System.out.printf(placar.toString());
        }

    }
}
