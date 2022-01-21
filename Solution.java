package cd;


public class Solution {
	public static void main(String[] args) {
		String gram = "S -> B B \n B -> b B | c";
		Grammar grammar = new Grammar(gram);
		LR0Parser parser = new LR0Parser(grammar);
		parser.parserLR0();
		System.out.println(parser.canonicalCollectionStr());
		System.out.println(parser.actionTableStr());
		System.out.println(parser.goToTableStr());
	}
}
