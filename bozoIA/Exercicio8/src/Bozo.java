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
        Server server = new Server();
        server.run();

        for(int nRodadas = 0; nRodadas < 10; nRodadas++) {
            //Rolar dados pela primeira vez
            String tmp;
        	dados.rolar();
            try {
                System.out.printf(dados.toString());
            } catch(Exception e) {
            }

            //Perguntar ao jogador quais dados devem ser lançados novamente
            //Imprimir dados após o lançamento
            System.out.println("Lançar novamente quais dados?");
            deveRolar = null;
            while(deveRolar == null)
            	deveRolar = server.bufferNext();
            dados.rolar(deveRolar);
            System.out.printf(dados.toString());

            //Perguntar ao jogador quais dados devem ser lançados novamente
            //Imprimir dados após o lançamento
            System.out.println("Lançar novamente quais dados?");
            deveRolar = null;
            while(deveRolar == null)
            	deveRolar = server.bufferNext();
            dados.rolar(deveRolar);            
            System.out.printf(dados.toString());

            System.out.println("Armazenar em qual \"slot\"");
            tmp = null;
            while(tmp == null)
            	tmp = server.bufferNext();
            posicao = Integer.parseInt(server.bufferNext());
            placar.add(posicao-1, dados.valoresAnteriores());

            System.out.printf(placar.toString());
        }

    }
}
