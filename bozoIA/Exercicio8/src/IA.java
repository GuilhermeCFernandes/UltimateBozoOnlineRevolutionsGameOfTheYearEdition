import java.util.Arrays;

public class IA {
	private int[] score;
	private boolean[] taken;
	private int[] valorDados;

	public IA() {
		this.score = new int[10];
		this.taken = new boolean[10];
		this.valorDados = new int[10];

		for(boolean b : taken) {
			b = false;
		}
	}

	public int best(String[] dados) {
		for(int i = 0; i < 5; i++) {
			valorDados[i] = Integer.parseInt(dados[i]);
		}
		
		for(int i = 0; i < 10; i++) {
			if(taken[i] = true) {
				score[i] = 0;
			} else {
				
				int[] contagem = new int[6];
				
				for(int c = 0; c < 6; c++) {
					contagem[c] = 0;
				}

				for(int j = 0; j < 6; j++) {
					contagem[valorDados[j] - 1]++;
				}

				switch(i) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
						score[i] = (i * counter(valorDados, 1));
						break;
					case 7://FULL HAND 15
						score[i] = isFullHand(contagem) ? 15 : 0;						
						break;
					case 8://SEQUENCIA 20
						score[i] = isStraight(contagem) ? 20 : 0;
						break;
					case 9://QUADRA 30
						score[i] = isFourOfAKind(contagem) ? 30 : 0;
						break;
					case 10://QUINA 40
						score[i] = isFiveOfAKind(contagem) ? 40 : 0;
						break;
				}
			}
		}

		int max = score[0], index = 0;
		for(int n = 0; n < 10; n++) {
			if(max < score[n]) {
				max = score[n];
				index = n;
			}
		}

		return index;
	}

	private int counter(int[] dados, int v) {
		int counter = 0;
		
		for(int i : dados) {
			if(dados[i] == v) {
				counter++;
			}
		}

		return counter;
	}

	private boolean isFullHand(int[] contagem) {
		return ( achou(contagem, 2) && achou(contagem, 3) );
	}

	private boolean isStraight(int[] contagem) {
		return ( Arrays.equals(contagem, new int[]{1, 1, 1, 1, 1, 0}) || Arrays.equals(contagem, new int[]{0, 1, 1, 1, 1, 1}) );
	}

	private boolean isFourOfAKind(int [] contagem) {
		return ( achou(contagem, 4) );
	}

	private boolean isFiveOfAKind(int[] contagem) {
		return ( achou(contagem, 5) );
	}

	private boolean achou(int[] contagem, int valor) {
		for(int c : contagem) {
			if(c == valor) {
				return true;
			} else {
				return false;
			}
		}
	
		return false;
	}
}
