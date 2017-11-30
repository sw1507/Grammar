import java.util.*;

/**
 * CSE143 HW4 Written by: Su Wang, enrolled in quiz session AC, Student ID:
 * 1627344 Grammar reads grammar rules and generates random sentences.
 */
public class Grammar {
	private Map<String, List<String[]>> grammar;

	/**
	 * Initialize a new Grammar.
	 * 
	 * @param rules
	 *            should be a list of strings, throw IllegalArgumentException if
	 *            rules are null or empty, or if there are more than one rule
	 *            for the same non-terminal word in the list.
	 */
	public Grammar(List<String> rules) {
		if (rules == null || rules.size() == 0) {
			throw new IllegalArgumentException();
		}
		grammar = new TreeMap<String, List<String[]>>();
		for (int i = 0; i < rules.size(); i++) {
			List<String[]> allValues = new ArrayList<String[]>();
			// E.g. <adjs>::=<adj>|<adj> <adjs>
			String oneRow = rules.get(i);
			// E.g. ["<adjs>", "<adj>|<adj> <adjs>"]
			String[] pieces = oneRow.split("::=");
			// E.g. //<adjs>
			String key = pieces[0].trim();
			// ["<adj>", "<adj> <adjs>"]
			String[] rule = pieces[1].split("\\|");
			for (int j = 0; j < rule.length; j++) {
				// split by whitespace, cut leading and trailing spaces.
				String ruleList[] = rule[j].trim().split("\\s+");
				allValues.add(ruleList);
			}
			if (grammar.containsKey(key)) {
				throw new IllegalArgumentException();
			} else {
				grammar.put(key, allValues);
			}
		}

	}

	/**
	 * Check if a word is a non-terminal in the grammar.
	 * 
	 * @param symbol
	 *            should be a word. It should not be null or has 0 length, throw
	 *            IllegalArgumentException if violated.
	 * @return true if the given symbol is a non-terminal in the grammar, false
	 *         otherwise.
	 */
	public boolean isNonTerminal(String symbol) {
		if (symbol == null || symbol.length() == 0) {
			throw new IllegalArgumentException();
		}
		return (grammar.containsKey(symbol));

	}

	/**
	 * Print out all non-terminals in the grammar in the alphabetical order.
	 */

	public String toString() {
		List<String> keys = new ArrayList<String>();
		for (String eachKey : grammar.keySet()) {
			keys.add(eachKey);
		}
		String result = "[" + keys.get(0);
		for (int i = 1; i < keys.size(); i++) {
			result += ", " + keys.get(i);
		}
		result += "]";
		return result;

	}

	/**
	 * Generate times (number of) occurrences of random sentences given a rule.
	 * 
	 * @param symbol
	 *            should be a non-terminal word in the grammar and it should not
	 *            be null, throw IllegalArgumentExcpetion if violated.
	 * @param times
	 *            should be a positive integer, throw IllegalArgumentExcpetion
	 *            if times is negative.
	 * @returns the random sentences generated in the format of a list of
	 *          strings
	 */
	public String[] getRandom(String symbol, int times) {
		if (times < 0 || !isNonTerminal(symbol) || symbol == null) {
			throw new IllegalArgumentException();
		} else {
			String[] result = new String[times];
			for (int i = 0; i < times; i++) {
				String sentence = getOneRandom(symbol, "").trim();
				result[i] = sentence;
			}
			return result;
		}

	}

	/**
	 * Generate a random sentence given a symbol. Assumes the symbol passed in
	 * is a valid symbol.
	 * 
	 * @param symbol
	 *            should be a non-terminal word in the grammar and it should not
	 *            be null
	 * @param sentence
	 *            is a string that will appear at the beginning of the random
	 *            sentences in the output, which can be empty.
	 * @return a random sentence as a string.
	 */
	private String getOneRandom(String symbol, String sentence) {
		List<String[]> rule = grammar.get(symbol);
		int size = rule.size();
		// get one random number within the size.
		int index = new Random().nextInt(size);
		// get one random rule.
		String[] temp = rule.get(index);
		// for each symbol in the rule, check if it is a terminal, if it is,
		// add it to the sentence, if not keeping looking.
		for (int j = 0; j < temp.length; j++) {
			String word = temp[j];
			if (!isNonTerminal(word)) {
				sentence += word + " ";
			} else {
				sentence = getOneRandom(word, sentence);
			}
		}

		return sentence;

	}

}
