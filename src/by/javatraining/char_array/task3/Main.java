package by.javatraining.char_array.task3;

import java.util.Scanner;

/*
 * В строке найти количество цифр.
 */

public class Main {
	private Scanner scanner;
	private String strInput;
	private char[] chInput;

	public Main() {
		scanner = new Scanner(System.in);
	}

	public void userInput() {
		System.out.println("Введите строку:");
		System.out.print(">> ");
		strInput = scanner.nextLine();
		chInput = strInput.toCharArray();
	}

	public void findAndPrint() {
		int iNumCount = 0;
		for (int i = 0; i < chInput.length; i++) {
			switch (chInput[i]) {
			case '0':
				/* falls through */
			case '1':
				/* falls through */
			case '2':
				/* falls through */
			case '3':
				/* falls through */
			case '4':
				/* falls through */
			case '5':
				/* falls through */
			case '6':
				/* falls through */
			case '7':
				/* falls through */
			case '8':
				/* falls through */
			case '9':
				iNumCount++;
				break;
			}
		}

		System.out.println("Результат: " + iNumCount);
	}

	public static void main(String[] args) {
		Main cTask3 = new Main();

		System.out.println("В строке найти количество цифр.");

		cTask3.userInput();

		cTask3.findAndPrint();
	}
}
