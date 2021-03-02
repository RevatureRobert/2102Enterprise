package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {
	public static void main(String[] args) {
		String filename = "charFile.txt";
		writeCharStream(filename);
		readCharStream(filename);
	}

	
	static void writeCharStream(String filename) {
	try(FileWriter fos = new FileWriter(filename)){
			for(int i = 62; i< 74; i++) {
				fos.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void readCharStream(String filename) {
		try(FileReader is = new FileReader(filename)){ //try with resources block. This will automatically close any resource within it.
			int i;
			while((i = is.read()) != -1) {
				System.out.println((char)i);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
