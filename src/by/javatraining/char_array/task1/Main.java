package by.javatraining.char_array.task1;

import java.util.Arrays;

/*
 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class Main {
	private final String[] myVariables =
		{ "lNumber", "iMagicSquare", "iArrayP", "iMatrixRes", "iSupportMatrix", "getCountOfDigits" };
	private String[] resVariables = new String[myVariables.length];

	public void convertAndPrint() {
		System.out.println("Массив camelCase: " + Arrays.toString(myVariables));

		for (int iMain = 0; iMain < myVariables.length; iMain++) {
			char[] chArr = myVariables[iMain].toCharArray();

			int iUpperCaseCount = 0;
			for (int in = 0; in < chArr.length; in++) {
				if (Character.isUpperCase(chArr[in])) {
					iUpperCaseCount++;
				}
			}

			char[] chArrRes = new char[chArr.length + iUpperCaseCount];

			for (int in = 0, inR = 0; (in < chArr.length) && (inR < chArrRes.length); in++, inR++) {
				if (Character.isUpperCase(chArr[in])) {
					chArrRes[inR] = '_';
					inR++;
					chArrRes[inR] = Character.toLowerCase(chArr[in]);
				} else {
					chArrRes[inR] = chArr[in];
				}
			}

			resVariables[iMain] = new String(chArrRes);
		}

		System.out.println("Массив snake_case: " + Arrays.toString(resVariables));
	}

	public static void main(String[] args) {
		Main cTask1 = new Main();

		System.out.println("Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.");

		cTask1.convertAndPrint();
	}
}
