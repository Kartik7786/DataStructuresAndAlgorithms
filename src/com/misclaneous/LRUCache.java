package com.misclaneous;

import java.util.LinkedHashMap;

public class LRUCache {

	LinkedHashMap<Integer, Integer> map;
	int capacity = -1;

	public LRUCache(int capacity) {
		map = new LinkedHashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {

			int val = map.get(key);
			map.remove(key);
			map.put(key, val);
			return val;
		} else
			return -1;
	}

	public void put(int key, int value) {
		int remove = -1;
		if (map.containsKey(key)) {
			map.remove(key);
			map.put(key, value);
		} else if (map.size() == this.capacity) {
			int counter = 0;
			for (Integer element : map.keySet()) {
				if (counter == 0)
					remove = element;
				else
					break;
				counter++;
			}
			map.remove(remove);
			map.put(key, value);
		} else {
			map.put(key, value);
		}
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
