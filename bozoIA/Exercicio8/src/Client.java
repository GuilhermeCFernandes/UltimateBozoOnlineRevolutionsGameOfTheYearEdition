import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		//Entrada, saida e controle
		Socket cliente = new Socket("172.26.209.96", 9669);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		Scanner server = new Scanner(cliente.getInputStream());
		String serverResponse = null;
		String[] dados = null;
		int contador = 1;

		saida.println("I 9037713");
		serverResponse = server.nextLine();

		for(int rodadas = 1; rodadas <= 10; rodadas++) {
			saida.println("R"+rodadas);
			serverResponse = server.nextLine();
			dados = serverResponse.split(" ");

			//Decidir quais dados lançar novamente
			saida.println("T 0 0 0 0 0");
			serverResponse = server.nextLine();
			dados = serverResponse.split(" ");

			//Decidir quais dados lançar novamente
			saida.println("T 1 0 1 0 1");
			serverResponse = server.nextLine();
			dados = serverResponse.split(" ");

			//Escolher posicao no placar para ocupar
			saida.println("P"+rodadas+" "+contador);
			serverResponse = server.nextLine();
			contador++;
		}
		saida.println("F");
		serverResponse = server.nextLine();

		saida.close();
		server.close();
		cliente.close();
	}
}
