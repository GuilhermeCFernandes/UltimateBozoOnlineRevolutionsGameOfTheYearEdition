package com.webserver.languages;

import java.io.*;
import java.util.*;
import com.webserver.core.*;

public class html implements Language {

	public byte[] execute(String page) throws Exception {

		Scanner file = new Scanner(new FileInputStream(page));
		String content = "";
		while (file.hasNext()) {
			content += file.nextLine();
		}
		return content.getBytes();
	}
}
