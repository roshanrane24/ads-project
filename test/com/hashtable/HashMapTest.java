package com.hashtable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapTest {
	static HashMap<String, Integer> hm;
	
	@BeforeEach
	void setUp() {
		hm = new HashMap<>();
		
		hm.put("One", 1);
		hm.put("Two", 2);
		hm.put("Three", 3);
		hm.put("Four", 4);
		hm.put("Five", 5);
		hm.put("Six", 6);
	}

	@Test
	void test1() {
		assertEquals(4, hm.get("Four"));
	}

	@Test
	void test2() {
		hm.put("Ten", 10);
		
		assertEquals(10, hm.get("Ten"));
	}

	@Test
	void test3() {
		
		assertEquals(4, hm.remove("Four"));
		assertEquals(null, hm.remove("Four"));
	}

	@Test
	void test4() {
		Integer[] v = hm.values();
		Arrays.sort(v);
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6}, v);
	}

	@Test
	void test5() {
		hm.remove("Four");
		Integer[] v = hm.values();
		Arrays.sort(v);
		assertArrayEquals(new Integer[] {1, 2, 3, 5, 6}, v);
	}
}
