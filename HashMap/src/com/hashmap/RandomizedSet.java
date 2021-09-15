package com.hashmap;
// Leetcode 380. Insert Delete GetRandom O(1)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//HashMap + ArrayList Solution
//HashMap to store <val, index> pair. 
//remove(): Move the last element in ArrayList to the deleted element position to remove the element. Update the <val, index> pair in HashMap.
//Time complexity: O(1) for initialization, insert, remove and getRandom
//Space complexity: O(N)

//Ref: https://www.youtube.com/watch?v=WtkwD7ikxfg  Techdose
public class RandomizedSet {

	List<Integer> list;
	Map<Integer, Integer> map;
	Random random;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<Integer, Integer>();
		random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		int idx = map.getOrDefault(val, -1);
		if (idx < 0) {
			return false;
		}
		// move the last element in the list to the idx position, and update the map
		int lastIdx = list.size() - 1;
		if (idx == lastIdx) {
			list.remove(idx);
			map.remove(val);
		} else {
			Integer last = list.get(lastIdx);
			list.set(idx, last);
			list.remove(lastIdx);
			map.remove(val); // remove val in HashMap
			map.put(last, idx); // update last and its index in HashMap
		}
		return true;
	}

	public int getRandom() {
		int randIdx = random.nextInt(list.size());
		return list.get(randIdx);
	}

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		boolean param_1 = obj.insert(1);
		System.out.println(param_1);
		boolean param_2 = obj.remove(2);
		System.out.println(param_2);
		boolean param_3 = obj.insert(2);
		System.out.println(param_3);
		int param_4 = obj.getRandom();
		System.out.println(param_4);
	}
}
