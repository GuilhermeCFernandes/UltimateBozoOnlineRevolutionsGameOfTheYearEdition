import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server extends Thread{
	Vector<String> buffer = new Vector<String>();
	
	public String bufferNext(){
		String tmp;
		if(buffer.isEmpty())
			return null;
		tmp = buffer.get(0);
		buffer.remove(0);
		return tmp;
		
	}
	
	public void run(String[] args) throws Exception {
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
		       String [] splittedString = r.split(" ");
		       buffer.add(splittedString[1]);
		       //saida.println("Recebido: " + r);




		}
	     servidor.close();
		System.out.println("Fim do servidor");

	     servidor.close();
	     saida.close();
	     cliente.close();
	     s.close();

	}

}
