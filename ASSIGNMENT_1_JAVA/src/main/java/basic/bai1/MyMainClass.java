package basic.bai1;

import java.util.Scanner;

public class MyMainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số thứ nhất x: ");
		double x = Double.parseDouble(scanner.nextLine());

		System.out.print("Nhập số thứ hai y: ");
		double y = Double.parseDouble(scanner.nextLine());

		System.out.println("---------------------------------");
		boolean isContinue = true;
		do {
			System.out.print("\nNhập lệnh ACTION: ");
			String action = scanner.nextLine();
	
			switch (action.toUpperCase()) {
				case "CONG":
					System.out.println("Kết quả: " + x + " + " + y + " = " + CalculateUtils.tinhCong(x, y));
					break;
				case "TRU":
					System.out.println("Kết quả: " + x + " - " + y + " = " + CalculateUtils.tinhTru(x, y));
					break;
				case "NHAN":
					System.out.println("Kết quả: " + x + " x " + y + " = " + CalculateUtils.tinhNhan(x, y));
					break;
				case "CHIA":
					System.out.println("Kết quả: " + x + " : " + y + " = " + CalculateUtils.tinhChia(x, y));
					break;
				default:
					System.out.println("Giá trị ACTION không hợp lệ!");
					isContinue = false;
					break;
			}
		} while (isContinue);
	}

}
