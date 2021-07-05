package by.javatraining.string.task2;

import java.util.Scanner;

/*
 * В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Main {
	private Scanner scanner;
	private String strInput;
	private StringBuilder strBuilder;

	public Main() {
		scanner = new Scanner(System.in);
	}

	public void userInput() {
		System.out.print("Введите строку: ");
		strInput = scanner.nextLine();

		strBuilder = new StringBuilder(strInput);
	}

	public void insertBThenPrint() {
		for (int i = 0; i < strBuilder.length(); i++) {
			if (strBuilder.charAt(i) == 'a') {
				strBuilder.insert(i + 1, 'b');
			}
		}

		System.out.println("Результат: " + strBuilder.toString());
	}

	public static void main(String[] args) {
		Main cTask2 = new Main();

		System.out.println("В строке вставить после каждого символа 'a' символ 'b'.");

		cTask2.userInput();

		cTask2.insertBThenPrint();
	}
}
