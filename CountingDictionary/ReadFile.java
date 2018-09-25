import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ReadFile {
	private String fileName;

	public ReadFile(String s) {
		fileName = s;
	}

	public Vector<String> process() {

		File f = new File(fileName);
		Scanner sc = null;

		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Is it possible that file "+fileName+" does not exist?");
			System.exit(-1);
		}

		Vector<String> toR = new Vector<String>();

		while (sc.hasNext()) {
			toR.add(sc.next());
		}

		return toR;
	}

	public void addFileToDict(CountingDictionary dict) {
		Vector<String> words = process();
		for (String s : words) {
			 dict.insert(s);
		}
	}

	public void addFileToDict(CountingDictionary dict, CountingDictionary commonWords) {
		Vector<String> wordsToAdd = process();
		for (String s : wordsToAdd) {
			if (commonWords.find(s) == -1) {
				dict.insert(s);
			}
		}
	}
}
