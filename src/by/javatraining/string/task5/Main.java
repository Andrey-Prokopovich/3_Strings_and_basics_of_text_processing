package by.javatraining.string.task5;

import java.util.Scanner;

/*
 * Подсчитать, сколько раз среди символов заданной строки встречается буква 'a'.
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

	public void countAndPrint() {
		int aCount = 0;
		int index = 0;

		while (strInput.indexOf('a', index) != (-1)) {
			aCount++;
			index = strInput.indexOf('a', index) + 1;
		}

		System.out.println("Результат: " + aCount);
	}

	public static void main(String[] args) {
		Main cTask5 = new Main();

		System.out.println("Подсчитать, сколько раз среди символов заданной строки встречается буква 'a'.");

		cTask5.userInput();

		cTask5.countAndPrint();
	}
}
