package by.javatraining.string.task1;

import java.util.Scanner;

/*
 * Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
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

	public void countSpaces() {
		int maxSpaceCount = 0;
		int calcSpaceCount = 0;

		for (int i = 0; i < strInput.length(); i++) {
			while (strInput.charAt(i) == ' ') {
				calcSpaceCount++;
				i++;
			}

			if (calcSpaceCount > maxSpaceCount) {
				maxSpaceCount = calcSpaceCount;
			}

			calcSpaceCount = 0;
		}

		System.out.println("Результат: " + maxSpaceCount);
	}

	public static void main(String[] args) {
		Main cTask1 = new Main();

		System.out.println("Найдите наибольшее количество подряд идущих пробелов в тексте\\строке.");

		cTask1.userInput();

		cTask1.countSpaces();
	}
}
