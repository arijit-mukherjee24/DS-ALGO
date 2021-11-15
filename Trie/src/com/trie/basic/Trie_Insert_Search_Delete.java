package com.trie.basic;

// https://www.youtube.com/watch?v=ict1UawpXMM&list=PLEJXowNB4kPyi859E6qGUs7jlpQehJndl&index=3 Techdose
// https://www.geeksforgeeks.org/trie-delete/?ref=lbp GFG
public class Trie_Insert_Search_Delete {
	static int ALPHABET_SIZE = 26;

	// trie node
	static class TrieNode {
		TrieNode children[] = new TrieNode[ALPHABET_SIZE];

		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;
	}

	static TrieNode root;

	// If not present, inserts key into trie
	// If the key is prefix of trie node, just
	// marks leaf node
	static void insert(String key) {
		TrieNode pCrawl = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}

		// mark last node as leaf
		pCrawl.isEndOfWord = true;
	}

	// Returns true if key presents in trie, else
	// false
	static boolean search(String key) {
		TrieNode pCrawl = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	// Remove key if key presents in trie, else
	// Trick: Change the isEndOfWord to false for that key, this will indirectly indicate no key exist
	static void remove(String key) {
		if(search(key)) {
			TrieNode pCrawl = root;
			for (int i = 0; i < key.length(); i++) {
				int index = key.charAt(i) - 'a';
				pCrawl = pCrawl.children[index];
			}

			if(pCrawl.isEndOfWord)
				pCrawl.isEndOfWord = false;
		}
	}

	// Driver
	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z'
		// and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "hero", "heroplane" };
		int n = keys.length;

		root = new TrieNode();

		// Construct trie
		for (int i = 0; i < n; i++)
			insert(keys[i]);

		// Search for different keys
		if (search("the"))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (search("these"))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		if (search("hero"))
			System.out.println("Yes");
		else
			System.out.println("No");

		remove("hero");

		if (search("hero"))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		remove("the");
		// Search for different keys after remove of "the"
		if (search("the"))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (search("there"))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
