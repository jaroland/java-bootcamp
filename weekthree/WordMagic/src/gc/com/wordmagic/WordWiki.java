package gc.com.wordmagic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class WordWiki {

	static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	static int i = 0;
	// static PrintStream out;

	public static void putHtml() {
		String[] htmlList = new String[5];
		try {
			BufferedReader in = new BufferedReader(
					new FileReader("C:\\Users\\thero\\Documents\\bootcamp\\htmlinput.txt"));
			String line = "";
			int i = 0;
			while ((line = in.readLine()) != null) {
				htmlList[i] = line;
				i++;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (i = 0; i < htmlList.length; i++) {
			getHtml(htmlList[i]);
		}
		outputMapFile(map);

	}

	public static void getHtml(String html) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			URL url = new URL(html);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
			String htmlString = stringBuilder.toString();
			readWordList(htmlString, html);
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readWordList(String htmlString, String html) {
		String[] wordList = new String[301];
		try {
			BufferedReader in = new BufferedReader(
					new FileReader("C:\\Users\\thero\\Documents\\bootcamp\\wordlist.txt"));
			String line = "";
			int i = 0;
			while ((line = in.readLine()) != null) {
				wordList[i] = line;
				i++;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		compareWordListAndSite(wordList, htmlString, html);

	}

	public static void compareWordListAndSite(String[] specialWords, String wikiSite, String html)

	{

		String[] words = wikiSite.split(" ");
		StringBuilder stringBuilder = new StringBuilder();

		for (String specialWord : specialWords) {

			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (specialWord.equals(word)) {

					ArrayList<String> temp = new ArrayList<String>();
					word = "<mark>" + word + "</mark>";
					if (map.containsKey(specialWord)) {
						if (!temp.contains(html))
							temp.add(html);
						map.put(specialWord, temp);
					} else {
						map.put(specialWord, temp);
					}
				}

				stringBuilder.append(word + " ");
			}

		}

		String output = stringBuilder.toString();
		// System.out.println(specialWords[3] + " " + map.get(specialWords[3]));
		outputGenerator(output);
	}

	public static void outputGenerator(String output) {
		String fileNumber = "output" + i;
		try {
			PrintStream out = new PrintStream(
					new FileOutputStream("C:\\Users\\thero\\Documents\\bootcamp\\" + fileNumber + ".html"));
			out.print(output);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void outputMapFile(HashMap<String, ArrayList<String>> map) {

		try {

			PrintStream out2 = new PrintStream(new FileOutputStream("C:\\Users\\thero\\Documents\\bootcamp\\map.txt"));
			for (String specialWord : map.keySet()) {
				ArrayList<String> value = map.get(specialWord);
				out2.println(specialWord + "=" + value);
			}

			out2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
