import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	

	public static void main(String[] args) throws Exception {
		Socket cliente = new Socket("127.0.0.1",9669);
		System.out.println("O cliente se conectou ao servidor!");
		
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		Scanner teclado = new Scanner(System.in);
		Scanner server = new Scanner(cliente.getInputStream());
		
		while (teclado.hasNextLine()) {
		  saida.println(teclado.nextLine());
		  System.out.println(server.nextLine());
		}
		System.out.println("Fim do cliente");
		saida.close();
		teclado.close();
		server.close();
		cliente.close();

	}

}
