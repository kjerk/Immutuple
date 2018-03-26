package io.github.kjerk.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public interface TestUtils {
	
	interface Defaults {
		int chunkSize = 4096;
	}
	
	static String readResourceAsString(String filePath) {
		return new String(readResource(filePath), Charset.defaultCharset());
	}
	
	static byte[] readResource(String filePath) {
		InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(filePath);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		writeAll(inputStream, baos);
		return baos.toByteArray();
	}
	
	static void writeAll(InputStream inputStream, OutputStream outputStream) {
		writeAll(inputStream, outputStream, Defaults.chunkSize);
	}
	
	static void writeAll(InputStream inputStream, OutputStream outputStream, int chunkSize) {
		try {
			byte[] buffer = new byte[chunkSize];
			int readBytes;
			while((readBytes = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, readBytes);
			}
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
