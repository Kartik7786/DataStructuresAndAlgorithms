package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {

			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String s = new String(c);
			if (map.containsKey(s))
				map.get(s).add(strs[i]);
			else {
				ArrayList<String> arr = new ArrayList<>();
				arr.add(strs[i]);
				map.put(s, arr);
			}
		}
		List<List<String>> arr = new ArrayList<List<String>>();

		for (String s : map.keySet())
			arr.add(map.get(s));

		return arr;

	}

	public static void main(String[] args) {
		GroupAnagrams g = new GroupAnagrams();
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		//g.groupAnagrams(strs);
		System.out.println("Test");
		
		int x = 6;
		System.out.println(x << 1);
	}
}
