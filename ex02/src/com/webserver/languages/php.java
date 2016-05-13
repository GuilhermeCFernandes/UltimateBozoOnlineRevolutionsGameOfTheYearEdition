package com.webserver.languages;

import java.io.*;
import java.util.*;
import com.webserver.core.*;

public class php implements Language {

	public byte[] execute(String page) throws Exception {

		Process process = Runtime.getRuntime().exec("/usr/bin/php -f "+page);
		Scanner input = new Scanner(process.getInputStream());
		//process.getOutputStream();

		String content = "";
		while (input.hasNext()) {
			content += input.nextLine();
		}
		return content.getBytes();
	}
}
