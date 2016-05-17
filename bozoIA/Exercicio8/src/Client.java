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
		IA ia = new IA();

		int contador = 1;

		saida.println("I 9037713");
		serverResponse = server.nextLine();
		System.out.println(serverResponse);

		for(int rodadas = 1; rodadas <= 10; rodadas++) {
			saida.println("R"+rodadas);
			serverResponse = server.nextLine();
			System.out.println(serverResponse);
			dados = serverResponse.split(" ");

			//Decidir quais dados lançar novamente
			saida.println("T 0 0 0 0 0");
			serverResponse = server.nextLine();
			System.out.println(serverResponse);
			dados = serverResponse.split(" ");

			//Decidir quais dados lançar novamente
			saida.println("T 0 0 0 0 0");
			serverResponse = server.nextLine();
			System.out.println(serverResponse);
			dados = serverResponse.split(" ");

			//Escolher posicao no placar para ocupar
			saida.println("P"+rodadas+" "+ia.best(dados));
			serverResponse = server.nextLine();
			System.out.println(serverResponse);
			contador++;
		}
		saida.println("F");
		serverResponse = server.nextLine();
		System.out.println(serverResponse);

		saida.close();
		server.close();
		cliente.close();
	}
}
