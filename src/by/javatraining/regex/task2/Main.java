package by.javatraining.regex.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Дана строка содержащая следующий текст (xml-документ):
 * 
 * <notes>
 *  <note id = "1">
 *   <to>Вася</to>
 *   <from>Света</from>
 *   <heading>Напоминание</heading>
 *   <body>Позвони мне завтра!</body>
 *  </note>
 *  <note id = "2">
 *   <to>Петя</to>
 *   <from>Маша</from>
 *   <heading>Важное напоминание</heading>
 *   <body/>
 *  </note>
 * </notes>
 
Напишите анализатор, позволяющий  последоваетльно возвращать содержимое узлов xml-докмента
и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */

public class Main {
	private final String xml = "<notes>\n" + "  <note id = \"1\">\n" + "    <to>Вася</to>\n"
			+ "    <from>Света</from>\n" + "    <heading>Напоминание</heading>\n"
			+ "    <body>Позвони мне завтра!</body>\n" + "  </note>\n" + "  <note id = \"2\">\n" + "    <to>Петя</to>\n"
			+ "    <from>Маша</from>\n" + "    <heading>Важное напоминание</heading>\n" + "    <body/>\n"
			+ "  </note>\n" + "</notes>";

	public void doIt() {
		System.out.println(xml + "\n");

		Pattern tegPattern = Pattern.compile("</?.+?>");
		Matcher matcher = tegPattern.matcher(xml);

		boolean flagOpen = true;
		int tegEnd = 0, tegStart = 0;

		while (matcher.find()) {
			String tmp = xml.substring(matcher.start() + 1, matcher.start() + 2); // Проверка: какой символ идет после
																					// '<'?
			String tmpEmpty = xml.substring(matcher.end() - 2, matcher.end() - 1); // Проверка: какой символ идет перед
																					// '>'?
			String tegName = xml.substring(matcher.start(), matcher.end()); // Название тега.

			if (!tmp.equals("/") && !tmpEmpty.equals("/")) { // Проверка: тег - открывающий, пустой или закрывающий?
				System.out.println(tegName + " - Открывающий тег.");
				flagOpen = false;
				tegStart = matcher.end();
			} else if (tmpEmpty.equals("/")) { // Проверка пустой тег или нет.
				System.out.println(tegName + " - Тег без тела.");
			} else {
				tegEnd = matcher.start();

				if (!flagOpen) {
					if (tegStart < tegEnd) {
						String tegContent = xml.substring(tegStart, tegEnd);
						flagOpen = true;
						System.out.println(tegContent + " - Содержимое тега.");
					}
				}

				System.out.println(tegName + " - Закрывающий тег.");
			}
		}
	}

	public static void main(String[] args) {
		Main cTask2 = new Main();

		cTask2.doIt();
	}
}
