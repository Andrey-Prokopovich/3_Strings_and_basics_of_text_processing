package by.javatraining.char_array.task4;

import java.util.Scanner;

/*
 * В строке найти количество чисел.
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

	private boolean checkIfNumber(char cCheck) {
		switch (cCheck) {
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
			return true;
		default:
			return false;
		}

	}

	public void findAndPrint() {
		int iNumCount = 0;
		for (int i = 0; i < chInput.length; i++) {
			if (checkIfNumber(chInput[i])) {
				iNumCount++;

				for (int in = i + 1; in <= chInput.length; in++) {
					if (in == chInput.length) {
						i = in;
						break;
					}

					switch (chInput[in]) {
					case ',':
						/* falls through */
					case '.':
						if (checkIfNumber(chInput[in + 1]))
							break;
						/* falls through */
					case ' ':
						/* falls through */
					case '+':
						/* falls through */
					case '-':
						/* falls through */
					case '*':
						/* falls through */
					case '/':
						/* falls through */
					case '=':
						/* falls through */
					case '(':
						/* falls through */
					case ')':
						i = in;
						break;
					}

					if (i == in) {
						break;
					}
				}
			}
		}

		System.out.println("Результат: " + iNumCount);
	}

	public static void main(String[] args) {
		Main cTask4 = new Main();

		System.out.println("В строке найти количество чисел.");

		cTask4.userInput();

		cTask4.findAndPrint();
	}
}
