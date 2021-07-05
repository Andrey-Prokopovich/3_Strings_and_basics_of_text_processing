package by.javatraining.regex.task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Создать приложение, разбирающее текст (текст храниться в строке) и позволяющее выполнить с текстом
 * три различных операции: отсортировать абзацы по количеству предложений; в каждом предложении
 * отсортировать слова по длине; отсортировать лексемы в предложении по убыванию количества вхождений
 * заданного символа, а в случае равенства - по алфавиту.
 */

public class Main {
	private Scanner scanner;
	private final String rn = "\r\n";
	private final String text = "  " + "Lyrics of song \"She Is Love\" by \"3 Doors Down\"." + rn + rn
			+ "She walks through the city." + rn + "No one recognizes her face." + rn + "They don't want her pity." + rn
			+ "No one ever mentions her name." + rn + "She's carried the broken." + rn
			+ "Their scars have no name in her heart." + rn + "She walks in forgiveness." + rn
			+ "She'll shine like a light in the dark." + rn + rn + "She is love." + rn + "She is love." + rn
			+ "She is love." + rn + "She is love." + rn + rn + "And she'll always remember" + rn
			+ "The days when they welcomed her here." + rn + "And they know if they need her" + rn
			+ "She made a promise to always be here." + rn + rn + "She is love." + rn + "She is love." + rn
			+ "She is love." + rn + "She is love." + rn + rn + "When they are weak she will always be strong," + rn
			+ "And though they don't know it they're never alone!" + rn + "No matter how many times they may leave" + rn
			+ "It's never hopeless 'cause she still believes!" + rn + rn + "She is love." + rn + "She is love." + rn
			+ "She is love." + rn + "She is love." + rn + "She is love." + rn + "She is love.";
	private StringBuilder sortedText;

	public Main() {
		scanner = new Scanner(System.in);
	}

	private int binarySearch(int[][] sArray, int value, int low, int high) {
		int index = -1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (sArray[mid][0] < value) {
				low = mid + 1;
			} else if (sArray[mid][0] > value) {
				index = mid;
				high = mid - 1;
			} else if (sArray[mid][0] == value) {
				index = mid;
				break;
			}
		}

		return index;
	}

	private void sortParagraphs() {
		System.out.println("Абзацы отсортированы по количеству предложений:");

		String[] paragraphs = text.split("\r\n\r\n");

		int ArrSize = paragraphs.length;
		int[][] sentenceCount = new int[ArrSize][2];
		Pattern sentenceEnd = Pattern.compile("[.!](\r\n)?");
		Matcher matcher;

		for (int i = 0; i < ArrSize; i++) {
			matcher = sentenceEnd.matcher(paragraphs[i]);

			int iCount = 0;
			while (matcher.find()) {
				iCount++;
			}

			if (i == 0) {
				sentenceCount[i][0] = iCount;
				sentenceCount[i][1] = i;
			} else {
				int vPos = binarySearch(sentenceCount, iCount, 0, i - 1);

				int j = i;
				if ((vPos >= 0) && (vPos != i)) {
					for (; j >= vPos; j--) {
						if (j != vPos) {
							sentenceCount[j][0] = sentenceCount[j - 1][0];
							sentenceCount[j][1] = sentenceCount[j - 1][1];
						} else {
							break;
						}
					}
				}

				sentenceCount[j][0] = iCount;
				sentenceCount[j][1] = i;
			}
		}

		sortedText = new StringBuilder(text.length());
		for (int i = 0; i < ArrSize; i++) {
			sortedText.append(paragraphs[sentenceCount[i][1]] + rn);
		}

		System.out.println(sortedText);
		sortedText = null;
	}

	private void sortWords() {
		System.out.println("Слова в предложениях отсортированы по длинне:");

		sortedText = new StringBuilder(text.length());
		Pattern sentenceEnd = Pattern.compile("\"?[.!](\r\n)?");
		Matcher matcher = sentenceEnd.matcher(text);

		int iStart = 0;
		int iEnd = 0;
		while (matcher.find()) {
			iEnd = matcher.start();

			String[] words = text.substring(iStart, iEnd).trim().split("[,\"]?\\s+\"?");
			int arrSize = words.length;
			int[][] wordCount = new int[arrSize][2];

			for (int i = 0; i < arrSize; i++) {
				int iCount = words[i].length();

				if (i == 0) {
					wordCount[i][0] = iCount;
					wordCount[i][1] = i;
				} else {
					int vPos = binarySearch(wordCount, iCount, 0, i - 1);

					int j = i;
					if ((vPos >= 0) && (vPos != i)) {
						for (; j >= vPos; j--) {
							if (j != vPos) {
								wordCount[j][0] = wordCount[j - 1][0];
								wordCount[j][1] = wordCount[j - 1][1];
							} else {
								break;
							}
						}
					}

					wordCount[j][0] = iCount;
					wordCount[j][1] = i;
				}
			}

			for (int i = 0; i < arrSize; i++) {
				sortedText.append((i == 0 ? "" : " ") + words[wordCount[i][1]]);
			}
			sortedText.append("." + rn);

			iStart = matcher.end();
		}

		System.out.println(sortedText);
		sortedText = null;
	}

	private int countLiteral(String str, String lex) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (lex.equalsIgnoreCase(str.substring(i, i + 1))) {
				count++;
			}
		}
		return count;
	}

	private void sortLexemes(char lex) {
		if (text.indexOf(lex) == (-1)) {
			System.out.println("Символ " + lex + " отсутствует в тексте.");
		} else {
			System.out.println("Лексемы в предложениях отсортированы по количеству вхождений заданного символа:");

			sortedText = new StringBuilder(text.length());
			Pattern sentenceEnd = Pattern.compile("\"?[.!](\r\n)?");
			Matcher matcher = sentenceEnd.matcher(text);
			String lexeme = Character.toString(lex);

			int iStart = 0;
			int iEnd = 0;
			while (matcher.find()) {
				iEnd = matcher.start();

				String[] words = text.substring(iStart, iEnd).trim().split("[,\"]?\\s+\"?");
				int arrSize = words.length;
				int[][] lexCount = new int[arrSize][2];

				for (int i = 0; i < arrSize; i++) {
					int iCount = countLiteral(words[i], lexeme);

					if (i == 0) {
						lexCount[i][0] = iCount;
						lexCount[i][1] = i;
					} else {
						int vPos = binarySearch(lexCount, iCount, 0, i - 1);

						int j = i;
						if ((vPos >= 0) && (vPos != i)) {
							for (; j >= vPos; j--) {
								if (j != vPos) {
									lexCount[j][0] = lexCount[j - 1][0];
									lexCount[j][1] = lexCount[j - 1][1];
								} else {
									break;
								}
							}
						}

						lexCount[j][0] = iCount;
						lexCount[j][1] = i;
					}
				}

				for (int k = 0; k < words.length; k++) {
					for (int j = 0; j < words.length - 1; j++) {
						if ((lexCount[j][0] == lexCount[j + 1][0]) && (words[lexCount[j][1]].toLowerCase()
								.compareTo(words[lexCount[j + 1][1]].toLowerCase()) < 0)) {
							int storeInt = lexCount[j][1];
							lexCount[j][1] = lexCount[j + 1][1];
							lexCount[j + 1][1] = storeInt;
						}
					}
				}

				boolean pointIn = false;
				for (int i = arrSize - 1; i >= 0; i--) {
					if (lexCount[i][0] == 0) {
						break;
					}

					sortedText.append((i != arrSize - 1 ? " " : "") + words[lexCount[i][1]]);
					pointIn = true;
				}
				if (pointIn) {
					sortedText.append("." + rn);
				}

				iStart = matcher.end();
			}

			System.out.println(sortedText);
			sortedText = null;
		}
	}

	public void doIt() {
		System.out.println(text + rn);

		final String strChoice = "Что вы желаете сделать с текстом"
				+ "\n1). Отсортировать абзацы по количеству предложений;"
				+ "\n2). В каждом предложении отсортировать слова по длине;"
				+ "\n3). Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства - по алфавиту."
				+ " Cимвол указать через пробел(например: \"3 a\")." + "\n0). Выход из программы.\n";
		System.out.print(strChoice);
		System.out.print(">> ");

		boolean boContinue = false;
		do {
			if (!scanner.hasNextInt()) {
				System.out.println("Некорректный ввод! Введите число!");
				System.out.print(">> ");
				scanner.next();
			} else {
				switch (scanner.nextInt()) {
				case 0:
					boContinue = true;
					break;
				case 1:
					sortParagraphs();
					break;
				case 2:
					sortWords();
					break;
				case 3:
					char lex = scanner.nextLine().charAt(1);
					sortLexemes(lex);
					break;
				}

				if (!boContinue) {
					System.out.print(strChoice);
				}
			}
		} while (!boContinue);
	}

	public static void main(String[] args) {
		Main cTask1 = new Main();

		cTask1.doIt();
	}
}
