package by.javatraining.string.task3;

import java.util.Scanner;

/*
 * Проверить, является ли заданное слово палиндромом.
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

	public void checkAndPrint() {
		StringBuilder inputBuilder = new StringBuilder(strInput);
		while (inputBuilder.indexOf(" ") != (-1)) {
			inputBuilder = inputBuilder.deleteCharAt(inputBuilder.indexOf(" "));
		}

		StringBuilder strLeft;
		StringBuilder strRight;

		if (inputBuilder.length() % 2 == 0) {
			strLeft = new StringBuilder(inputBuilder.substring(0, inputBuilder.length() / 2 - 1));
			strRight = new StringBuilder(inputBuilder.substring(inputBuilder.length() / 2));
		} else {
			strLeft = new StringBuilder(inputBuilder.substring(0, inputBuilder.length() / 2));
			strRight = new StringBuilder(inputBuilder.substring(inputBuilder.length() / 2 + 1));
		}
		strRight = strRight.reverse();

		boolean isIt = strLeft.toString().equalsIgnoreCase(strRight.toString());
		System.out.println("Результат: " + (isIt ? "" : "не ") + "является палиндромом");
	}

	public static void main(String[] args) {
		Main cTask3 = new Main();

		System.out.println("Проверить, является ли заданное слово палиндромом.");

		cTask3.userInput();

		cTask3.checkAndPrint();
	}
}
