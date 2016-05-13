import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


	public static void main(String[] args) throws Exception {
		ServerSocket servidor = new ServerSocket(9669);
	     System.out.println("Porta 9669 aberta!");
	     Socket cliente = servidor.accept();
	     System.out.println("Nova conexão com o cliente " +   
	       cliente.getInetAddress().getHostAddress()
	     );
			
	     PrintStream saida = new PrintStream(cliente.getOutputStream());

	     Scanner s = new Scanner(cliente.getInputStream());
	     while (s.hasNextLine()) {
	       String r = s.nextLine();
	       System.out.println(r);
	       saida.println("Recebido: " + r);
	     }
		System.out.println("Fim do servidor");

	     s.close();
	     servidor.close();
	     saida.close();
	     cliente.close();

	}

}
