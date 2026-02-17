package generic_utility;

public class JavaUtility {

	static int generateRanNum() {
		int random = (int) (Math.random() * 9999);
		return random;
	}

	static String getTodaysDateAndTime() {

//		17022026_151130
		return null;
	}

	public static void main(String[] args) {
		String orgName = "qspiders_" + generateRanNum();
		System.out.println(orgName);
	}
}
