package basic.bai2;

import java.util.Scanner;

public class MainScreen {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			int n = 0;
			do {
				try {
					System.out.print("Nhập N (N > 0): ");
					n = Integer.parseInt(scanner.nextLine());
				} catch (Exception ex) {
					System.out.println(" => Sai định dạng!");
				}
			} while (n <= 0);

			int sumOdd = 0;
			int sumEven = 0;
			int countDivide3 = 0;
			String numberD3s = "";
			String numberOdds = "";
			String numberEvens = "";

			for (int i = 0; i <= n; i++) {
				if (i % 2 == 0) {
					sumOdd = sumOdd + i;
					numberOdds = numberOdds.isEmpty() ? "" + i : (numberOdds + ", " + i);
				} else if (i % 3 == 0) {
					countDivide3 = countDivide3 + 1;
					numberD3s = numberD3s.isEmpty() ? "" + i : (numberD3s + ", " + i);

					sumEven = sumEven + i;
					numberEvens = numberEvens.isEmpty() ? "" + i : (numberEvens + ", " + i);
				} else {
					sumEven = sumEven + i;
					numberEvens = numberEvens.isEmpty() ? "" + i : (numberEvens + ", " + i);
				}
			}

			System.out.println(" + Tổng chẵn: " + sumOdd + " - gồm: " + numberOdds);
			System.out.println(" + Tổng lẻ: " + sumEven + " - gồm: " + numberEvens);
			System.out.println(" + Số con số chia hết cho 3 nhưng không chia hết cho 2: " + countDivide3 + " số - gồm: "
					+ numberD3s);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
