package com.webserver.core;

import java.io.*; // PrintStream
import java.net.*; // Socket e ServerSocket
import java.util.*; // Scanner
import java.lang.reflect.*; // ???

public class Response extends Thread {
	private Socket socket;
	private String path;

	public Response(String path, Socket socket) {
		this.path = path;
		this.socket = socket;
	}

	public void run() {
		try {
			//System.out.println("Connected.");

			// Preparar canais de entrada e saida de dados
			Scanner input = new Scanner(socket.getInputStream()); // InputStream
			PrintStream output = new PrintStream(socket.getOutputStream()); // OutputStream

			String line = null;
			String page = null;
			do {
				line = input.nextLine();
				if (page == null) {
					String args[] = line.split(" ");
					page = args[1];
				}
			} while(line.trim().length() != 0);

			System.out.println("Requested page: "+path+page);

			String args[] = page.split("\\.");
			String fileType = args[args.length-1];
			System.out.println(fileType);

			// Java Reflection API
			Class c = Class.forName("com.webserver.languages."+fileType);
			Language language = (Language) c.newInstance();
			byte[] content = language.execute(path+page);

			//output.println(content);
			output.write(content, 0, content.length);

			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

