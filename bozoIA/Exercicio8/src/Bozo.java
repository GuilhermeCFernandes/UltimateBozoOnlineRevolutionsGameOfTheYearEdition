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
			String rola = new String();
			for(int i = 1; i < 6; i ++)
				rola += a[i];
			dados.rolar(rola);
			return dados.toNumbers();	
		}
		else if(a[0].charAt(0) == 'P') {
            int posicao = Integer.parseInt(a[1]);
			placar.add(posicao-1, dados.valoresAnteriores());
			return ""+placar.getScore();
		}
		else if(a[0].charAt(0) == 'R') {
			dados.rolar("11111");
			return dados.toNumbers();
		}
		else if(a[0].charAt(0) == 'F') {
			return placar.getScore() + "";
		}
		else {
			return "Deu bosta";
		}
    }
}
