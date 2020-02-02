package com.misclaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

	HashMap<Integer, Integer> map;
	ArrayList<Integer> arr;
	Random rand;

	public RandomizedSet() {

		map = new HashMap<>();
		arr = new ArrayList<Integer>();
		rand = new Random();

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		else {
			arr.add(val);
			map.put(val, arr.size());
		}
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {

		if (!map.containsKey(val))
			return false;
		else {
			int index = map.get(val);
			arr.set(index, arr.get(arr.size() - 1));
			map.put(arr.get(arr.size() - 1), index);
			arr.remove(arr.size() - 1);
			map.remove(val);

		}
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return arr.get(rand.nextInt(arr.size()));
	}

}