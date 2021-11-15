package com.trie.leetcode;

// 208. Implement Trie (Prefix Tree)
public class ImplementTrie {
	private TrieNode root;

	public ImplementTrie() {
        root = new TrieNode();
    }

	public void insert(String word) {
		TrieNode pCrawl = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}

		// mark last node as leaf
		pCrawl.isEndOfWord = true;
	}

	public boolean search(String word) {
		TrieNode pCrawl = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	public boolean startsWith(String prefix) {
		TrieNode pCrawl = root;

		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null);
	}
}

class TrieNode {
	TrieNode children[] = new TrieNode[26];
	boolean isEndOfWord;
}
