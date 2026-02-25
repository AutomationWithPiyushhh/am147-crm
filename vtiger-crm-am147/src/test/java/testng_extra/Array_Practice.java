package testng_extra;

public class Array_Practice {
	public static void main(String[] args) {
		int[] digits = new int[4];

		digits[0] = 0;
		digits[1] = 3;
		digits[2] = 6;
		digits[3] = 9;
		digits[2] = 12;

	}

	public String[][] getData() {
		String[][] cred = new String[5][2];

		cred[0][0] = "Kashif";
		cred[0][1] = "KuchBhi";

		cred[1][0] = "Kanishka";
		cred[1][1] = "Honesty";

		cred[2][0] = "Harsh";
		cred[2][1] = "Harsh@123";

		cred[3][0] = "PraveshBhai";
		cred[3][1] = "12345678";

		cred[4][0] = "Swati";
		cred[4][1] = "aurlikhdo@123";
		
		return cred;
	}
}
