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
	     cliente.getInetAddress().getHostAddress());
	     String[] tmp;
	     int counter = 0;
		

	     Bozo bozo = new Bozo();
			
	     PrintStream saida = new PrintStream(cliente.getOutputStream());
        Scanner s = new Scanner(cliente.getInputStream());
        while (s.hasNextLine()) {
			String r = s.nextLine();
			
			if(counter  == 0){
				tmp = r.split(" ");
				saida.println("Ola jogador de id:" + tmp[1]);
			}else{
				saida.println(bozo.principal(r));
			}
			counter ++;
				
	     }
	     servidor.close();
		System.out.println("Fim do servidor");

	     servidor.close();
	     saida.close();
	     cliente.close();
	     s.close();

	}

}
