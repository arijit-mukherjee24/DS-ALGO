package com.trie.basic;


public class CountNoOfStringsWithGivenPrefix {
	static int ALPHABET_SIZE = 26;

	// trie node
	static class TrieNode {
		TrieNode children[] = new TrieNode[ALPHABET_SIZE];

		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;

		// prefix count/ word count
		int wc;
	}

	static TrieNode root;

	// If not present, inserts key into trie
	// If the key is prefix of trie node, just
	// marks leaf node
	static void insert(String key) {
		TrieNode pCrawl = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl.wc += 1;

			pCrawl = pCrawl.children[index];
		}

		// mark last node as leaf
		pCrawl.isEndOfWord = true;
	}
	
	// prefix count (Ref: Techdose)
	static int countPrefix(String key) {
		TrieNode pCrawl = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null || pCrawl.children[index].wc==0)
				return 0;

			pCrawl = pCrawl.children[index];
		}

		return pCrawl.wc;
	}

	// Driver
	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "ababc", "abaxy", "abcd", "adb" };

		root = new TrieNode();

		// Construct trie
		for (int i = 0; i < keys.length; i++)
			insert(keys[i]);
		
		System.out.println("Prefix count aba "+countPrefix("aba"));
		System.out.println("Prefix count ab "+countPrefix("ab"));
		System.out.println("Prefix count a "+countPrefix("a"));
		System.out.println("Prefix count aba "+countPrefix("abad"));
		System.out.println("Prefix count aba "+countPrefix("ad"));

	}
}
