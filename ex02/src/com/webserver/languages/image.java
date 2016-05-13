package com.webserver.languages;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import com.webserver.core.*;

public class image implements Language {

	public byte[] execute(String image) throws Exception {
		File img = new File(image);
		return Files.readAllBytes(img.toPath());
	}
}
