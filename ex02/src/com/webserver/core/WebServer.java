package com.webserver.core;

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.reflect.*;

public class WebServer extends Thread {
	private String path = "/tmp";
	private ServerSocket ss;

	// UDP
	// TCP -> garantias
	public WebServer(int port) throws IOException {
		// Registrando uma porta para receber mensagens
		this.ss = new ServerSocket(port);
	}

	// abstract Thread
	// 	public void run()
	public void run() {
		while (true) {
			try {
				// Listener (ouvir mensagens)
				// Esperar por conexões de outros programas
				System.out.println("Waiting for a connection...");
				new Response(path, this.ss.accept()).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) throws IOException {
		WebServer ws = new WebServer(80);
		ws.start(); // chamar o metodo run() para executar em 1 core
	}
}









