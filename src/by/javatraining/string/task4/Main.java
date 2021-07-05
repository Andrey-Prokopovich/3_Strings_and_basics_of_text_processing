package by.javatraining.string.task4;

/*
 * С помощью функции копирования и операции конкатенации составить из частей слова "информатика" слово "торт".
 */

public class Main {
	private final String strOriginal = "информатика";

	public void Form_n_Print() {
		char tChar = strOriginal.charAt(strOriginal.indexOf('т'));
		char oChar = strOriginal.charAt(strOriginal.indexOf('о'));
		char rChar = strOriginal.charAt(strOriginal.indexOf('р'));

		StringBuilder strCake = new StringBuilder(4);
		strCake.append(tChar).append(oChar).append(rChar).append(tChar);

		System.out.println("Результат: " + strCake.toString());
	}

	public static void main(String[] args) {
		Main cTask4 = new Main();

		System.out.println("Составить из частей слова \"информатика\" слово \"торт\".'");

		cTask4.Form_n_Print();
	}
}
