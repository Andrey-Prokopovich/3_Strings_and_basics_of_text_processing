package by.javatraining.string.task6;

import java.util.Scanner;

/*
 * Из заданной строки получить новую, повторив каждый символ дважды.
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

	public void repeatAndPrint() {
		strBuilder = new StringBuilder(strInput);
		strBuilder.ensureCapacity(strBuilder.length() * 2);

		for (int i = strBuilder.length() - 1; i >= 0; i--) {
			strBuilder.insert(i + 1, strBuilder.charAt(i));
		}

		System.out.println("Результат: " + strBuilder.toString());
	}

	public static void main(String[] args) {
		Main cTask6 = new Main();

		System.out.println("Из заданной строки получить новую, повторив каждый символ дважды.");

		cTask6.userInput();

		cTask6.repeatAndPrint();
	}
}
