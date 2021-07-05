package by.javatraining.char_array.task5;

import java.util.Scanner;

/*
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
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

	public void removeAndPrint() {
		int iLastMod = 0;
		for (int i = 0; i < chInput.length; i++) {
			if (i >= chInput.length - iLastMod) {
				chInput[i] = 0;
				continue;
			}

			if (i + iLastMod == 0) {
				while (chInput[i + iLastMod] == ' ') {
					iLastMod++;
				}
			} else {
				if (chInput[i + iLastMod - 1] == ' ') {
					while (chInput[i + iLastMod] == ' ') {
						iLastMod++;
					}
				}
			}

			chInput[i] = chInput[i + iLastMod];
		}

		String strRes = new String(chInput, 0, chInput.length - iLastMod);
		System.out.println("Результат     : " + strRes);
	}

	public static void main(String[] args) {
		Main cTask5 = new Main();

		System.out.println("Удалить в строке все лишние пробелы, включая крайние.");

		cTask5.userInput();

		cTask5.removeAndPrint();
	}
}
