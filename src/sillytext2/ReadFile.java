package sillytext2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {
	public static String inFile(String file) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		while(sc.hasNextLine()) {
			sb.append(sc.nextLine() + "\n");
		}
		sc.close();
		return sb.toString();
	}
}
