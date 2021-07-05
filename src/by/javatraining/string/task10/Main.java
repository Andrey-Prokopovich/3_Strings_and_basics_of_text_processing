package by.javatraining.string.task10;

import java.util.Scanner;

/*
 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или 
 * вопросительным знаком. Определить количество предложений в строке x.
 */

public class Main {
	private Scanner scanner;
	private String strInput;

	public Main() {
		scanner = new Scanner(System.in);
	}

	public void userInput() {
		System.out.print("Введите строку: ");
		strInput = scanner.nextLine();
	}

	public void findAndPrint() {
		int iSentences = 0;

		int index = 0;

		while (strInput.indexOf(".", index) != (-1)) {
			iSentences++;
			index = strInput.indexOf(".", index) + 1;
		}

		index = 0;
		while (strInput.indexOf("!", index) != (-1)) {
			iSentences++;
			index = strInput.indexOf("!", index) + 1;
		}

		index = 0;
		while (strInput.indexOf("?", index) != (-1)) {
			iSentences++;
			index = strInput.indexOf("?", index) + 1;
		}

		System.out.println("Результат: " + iSentences);
	}

	public static void main(String[] args) {
		Main cTask10 = new Main();

		System.out.println(
				"Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или \r\n"
						+ "вопросительным знаком. Определить количество предложений в строке x.");

		cTask10.userInput();

		cTask10.findAndPrint();
	}
}
