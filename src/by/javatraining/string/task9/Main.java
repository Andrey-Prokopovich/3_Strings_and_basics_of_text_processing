package by.javatraining.string.task9;

import java.util.Scanner;

/*
 * Посчитать количество строчных (маленьких) и прописных (больших) букв в веденной стоке.
 * Учитывать только английские буквы.
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
		int iLower = 0;
		int iHigher = 0;

		for (int i = 0; i < strInput.length(); i++) {
			char cSymbol = strInput.charAt(i);

			if ((cSymbol >= 'a') && (cSymbol <= 'z')) {
				iLower++;
			}

			if ((cSymbol >= 'A') && (cSymbol <= 'Z')) {
				iHigher++;
			}
		}

		System.out.println("Результат: строчных - " + iLower + ", прописных - " + iHigher + ".");
	}

	public static void main(String[] args) {
		Main cTask9 = new Main();

		System.out.println(
				"Посчитать количество строчных и прописных букв в веденной стоке. Учитывать только английские буквы.");

		cTask9.userInput();

		cTask9.findAndPrint();
	}
}
