public class NumToWordConverter {

	public static void main(String[] args) {

		String num = args[0];
		convertNumToWord(num.toCharArray());
	}

	public static void convertNumToWord(char[] num) {

		String[] oneDigit = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
				"nine" };

		String[] twoDigit = new String[] { "", "ten", "eleven", "twelve", "thriteen", "fourteen", "fifteen", "sixteen",
				"seventeen", "eighteen", "ninteen" };

		String[] tensMultiple = new String[] { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
				"eighty", "ninty" };

		String[] tensPower = new String[] { "hundred", "thousand", "lakh", "milion", "core" };

		int length = num.length;
		if (length == 0) {
			System.out.println("empty String");
		}

		// till 1 - 10
		if (length == 1) {
			System.out.println(num[0] + " -> " + oneDigit[num[0] - '0']);
		}

		int x = 0;
		while (x < num.length) {
			if (length >= 3) {

				if (num[x] - '0' != 0) {
					System.out.println(oneDigit[num[x] - '0'] + " ");
					System.out.println(tensPower[length - 3] + " ");
				}
				--length;

			} else {
				// two digits
				if (num[x] - '0' == 1) {
					int sum = num[x] - '0' + num[x + 1] - '0';
					System.out.println(twoDigit[sum]);
					return;

				} else if (num[x] - '0' == 2 && num[x + 1] - '0' == 0) {
					System.out.println("twenty");
					return;

				} else {
					int i = num[x] - '0';
					if (i > 0)
						System.out.println(tensMultiple[i] + " ");
					else
						System.out.println("");
					++x;

					if (num[x] - '0' != 0)
						System.out.println(oneDigit[num[x] - '0']);

				}

			}
			++x;
		}
	}

}
