package by.javatraining.string.task8;

import java.util.Scanner;

/*
 * Вводиться строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.
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
	}

	public void findAndPrint() {
		strBuilder = new StringBuilder(strInput);
		int indMax = 0;
		int iMaxLength = 0;
		int index = 0;

		while (index < strBuilder.length()) {
			int indSpace = strBuilder.indexOf(" ", index);

			if (indSpace == (-1)) {
				break;
			} else {
				if ((index == 0) && (indSpace != index)) {
					iMaxLength = indSpace;
					index = indSpace;
					continue;
				}

				if (strBuilder.charAt(indSpace + 1) == ' ') {
					index = indSpace + 1;
				} else {
					int indNext = strBuilder.indexOf(" ", indSpace + 1);

					if (indNext == (-1)) {
						index = strBuilder.length();
						int iLen = index - (indSpace + 1);

						if (iLen > iMaxLength) {
							indMax = indSpace + 1;
							iMaxLength = iLen;
						}
					} else {
						index = indNext;
						int iLen = index - (indSpace + 1);

						if (iLen > iMaxLength) {
							indMax = indSpace + 1;
							iMaxLength = iLen;
						}
					}
				}
			}
		}

		System.out.println("Результат: " + strBuilder.substring(indMax, indMax + iMaxLength));
	}

	public static void main(String[] args) {
		Main cTask8 = new Main();

		System.out.println("Найти самое длинное слово и вывести его на экран.");

		cTask8.userInput();

		cTask8.findAndPrint();
	}
}
