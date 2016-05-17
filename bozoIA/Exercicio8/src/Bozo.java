/**
 * Classe inicial do Bozó, é responsavel por cuidar da execuçao do jogo
 * @author Tiago Esper14jdeveRolarança Triques
 * @author Guilherme Correa Fernandes
 */
public class Bozo {
	private RolaDados dados;
	private Placar placar;

	public Bozo() {
		this.dados = new RolaDados(5);
		this.placar = new Placar();
	}

    public String principal(String args) {
		String[] a = args.split(" ");
		
		if(a[0].equals("T")) {
			dados.rolar(a[1]+" "+a[2]+" "+a[3]+" "+a[4]+" "+a[5]);
			return dados.toNumber();	
		}
		else if(a[0].equals("P")) {
            int posicao = Integer.parseInt(a[1]);
			placar.add(posicao-1, dados.valoresAnteriores());
			return ""+placar.getScore();
		}
		else {
			return "";
		}
    }
}
