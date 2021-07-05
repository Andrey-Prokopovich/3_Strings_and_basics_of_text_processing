package by.javatraining.char_array.task2;

import java.util.Scanner;

/*
 * Замените в строке все вхождения 'word' на 'letter'.
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

	public void replaceAndPrint() {
		int iWordCount = 0;
		for (int i = 0; i < chInput.length; i++) {
			if ((i <= chInput.length - 4) && (Character.toLowerCase(chInput[i]) == 'w')
					&& (Character.toLowerCase(chInput[i + 1]) == 'o') && (Character.toLowerCase(chInput[i + 2]) == 'r')
					&& (Character.toLowerCase(chInput[i + 3]) == 'd')) {
				iWordCount++;
			}
		}

		char[] chRes = new char[chInput.length + (iWordCount * 2)];
		for (int i = 0, iRes = 0; (i < chInput.length) && (iRes < chRes.length); i++, iRes++) {
			if ((i <= chInput.length - 4) && (Character.toLowerCase(chInput[i]) == 'w')
					&& (Character.toLowerCase(chInput[i + 1]) == 'o') && (Character.toLowerCase(chInput[i + 2]) == 'r')
					&& (Character.toLowerCase(chInput[i + 3]) == 'd')) {
				chRes[iRes] = 'l';
				chRes[iRes + 1] = 'e';
				chRes[iRes + 2] = 't';
				chRes[iRes + 3] = 't';
				chRes[iRes + 4] = 'e';
				chRes[iRes + 5] = 'r';

				i = i + 3;
				iRes = iRes + 5;
			} else {
				chRes[iRes] = chInput[i];
			}
		}

		String strRes = new String(chRes);
		System.out.println("Результат: " + strRes);
	}

	public static void main(String[] args) {
		Main cTask2 = new Main();

		System.out.println("Замените в строке все вхождения 'word' на 'letter'.");

		cTask2.userInput();

		cTask2.replaceAndPrint();
	}
}
