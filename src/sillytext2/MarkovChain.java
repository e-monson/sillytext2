package sillytext2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovChain {
	private HashMap<String, ArrayList<String>> chain;

	Random rand = new Random();

	public MarkovChain() {
		chain = new HashMap<String, ArrayList<String>>();
	}

	public void addTransition(String v, String w) {
		if (chain.containsKey(v)) {
			chain.get(v).add(w);
		} else {
			chain.put(v, new ArrayList<String>());
			chain.get(v).add(w);
		}
	}

	public String next(String v) {
		ArrayList<String> choices = chain.get(v);
		if ((choices.size() - 1) < 1) {
			return choices.get(0);
		} else {
			// System.out.println(choices.size() - 1);
			int index = rand.nextInt(choices.size() - 1);
			String result = choices.get(index);
			return result;
		}
	}

	public static void main(String[] args) {
		MarkovChain mc = new MarkovChain();
		mc.addTransition("a g", " ga");
		mc.addTransition("a g", " gw");
		for (int i = 0; i < 10; i++) {
			System.out.print(mc.next("a g"));
		}
	}
}
