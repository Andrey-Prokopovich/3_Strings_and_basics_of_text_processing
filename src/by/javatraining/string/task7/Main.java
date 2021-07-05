package by.javatraining.string.task7;

import java.util.Scanner;

/*
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 * Например, если было введено "abc cde def", то должно быть выведено "abcdef".
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

	public void modifyAndPrint() {
		strBuilder = new StringBuilder();

		strInput.chars().distinct().forEach(c -> strBuilder.append((char) c));
		strBuilder.deleteCharAt(strInput.indexOf(' '));

		System.out.println("Результат: " + strBuilder.toString());
	}

	public static void main(String[] args) {
		Main cTask7 = new Main();

		System.out.println("Удалить из строки повторяющиеся символы и все пробелы.");

		cTask7.userInput();

		cTask7.modifyAndPrint();
	}
}
