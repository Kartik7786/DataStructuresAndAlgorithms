package com.tries;

class Trie {

	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!node.containsKey(c)) {
				node.put(c, new TrieNode());
			}
			node = node.get(c);
		}
		node.setEnd();
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = searchHelper(word);

		return node != null && node.isEnd();

	}

	public TrieNode searchHelper(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.get(word.charAt(i)) == null)
				return null;
			else
				node = node.get(word.charAt(i));
		}
		return node;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {

		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (node.get(prefix.charAt(i)) == null)
				return false;
			else
				node = node.get(prefix.charAt(i));
		}
		return true;

	}

	class TrieNode {
		static final int size = 26;
		private TrieNode[] node;
		private boolean isEnd;

		TrieNode() {
			node = new TrieNode[size];
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd() {
			isEnd = true;
		}

		public boolean containsKey(char c) {
			return node[c - 'a'] != null;
		}

		public TrieNode get(char c) {
			return node[c - 'a'];
		}

		public void put(char c, TrieNode node) {
			this.node[c - 'a'] = node;
		}
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */