package sillytext2;

public class SillyText {

	public static MarkovChain train(String input, int k) {
		MarkovChain result = new MarkovChain();
		int length = input.length();
		for (int i = 0; i < length - (k + 1); i++) {
			String current = input.substring(i, i + k);
			String next = input.substring(i + 1, i + k + 1);
			result.addTransition(current, next);
//			System.out.println(current + " " + next);
		}
//		System.out.println("-----------------------------");
		for (int i = 0; i < k; i++) {
			String current = input.substring(length - (k - i))
					+ input.substring(0, i);
			String next = input.substring(length - (k - i) + 1)
					+ input.substring(0, i + 1);
			result.addTransition(current, next);
//			System.out.println(current + " " + next);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = ReadFile.inFile(args[0]);
		int k = Integer.parseInt(args[1]);
		int chars = Integer.parseInt(args[2]);
		MarkovChain ch = train(input, k);
		String begin = input.substring(0, k);
		System.out.print(begin.substring(0, begin.length() - 1));
		for(int i = 0; i < chars; i++) {
			System.out.print(begin.charAt(begin.length() - 1));
			begin = ch.next(begin);
		}
	}

}
