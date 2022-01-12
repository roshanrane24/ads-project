package com.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.social_network.Gender;
import com.social_network.User;

class GraphTest {
	static Graph<Integer, User> graph;
	static User u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13, u14, u15, u16, u17, u18, u19, u20, u21, u22,
			u23, u24, u25, u26;

	@BeforeAll
	static void setUpBeforeAll() {
		u1 = new User("1", Gender.MALE);
		u2 = new User("2", Gender.MALE);
		u3 = new User("3", Gender.MALE);
		u4 = new User("4", Gender.MALE);
		u5 = new User("5", Gender.MALE);
		u6 = new User("6", Gender.MALE);
		u7 = new User("7", Gender.MALE);
		u8 = new User("8", Gender.MALE);
		u9 = new User("9", Gender.MALE);
		u10 = new User("10", Gender.MALE);
		u11 = new User("11", Gender.MALE);
		u12 = new User("12", Gender.MALE);
		u13 = new User("13", Gender.MALE);
		u14 = new User("14", Gender.MALE);
		u15 = new User("15", Gender.MALE);
		u16 = new User("16", Gender.MALE);
		u17 = new User("17", Gender.MALE);
		u18 = new User("18", Gender.MALE);
		u19 = new User("19", Gender.MALE);
		u20 = new User("20", Gender.MALE);
		u21 = new User("21", Gender.MALE);
		u22 = new User("22", Gender.MALE);
		u23 = new User("23", Gender.MALE);
		u24 = new User("24", Gender.MALE);
		u25 = new User("25", Gender.MALE);
		u26 = new User("26", Gender.MALE);
	}

	@BeforeEach
	void setUp() {
		graph = new Graph<>();

		graph.addNode(u1);
		graph.addNode(u2);
		graph.addNode(u3);
		graph.addNode(u4);
		graph.addNode(u5);
		graph.addNode(u6);
		graph.addNode(u7);
		graph.addNode(u8);
		graph.addNode(u9);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 9);
		graph.addEdge(3, 2);
		graph.addEdge(3, 6);
		graph.addEdge(9, 2);
		graph.addEdge(9, 4);
		graph.addEdge(9, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		graph.addEdge(5, 8);
		graph.addEdge(6, 7);
		graph.addEdge(7, 2);
	}

	@Test
	void test1() {
		assertArrayEquals(new User[] { u1, u3, u4, u9, u2, u6, u5, u7, u8 }, graph.BFS(u1));
	}

	@Test
	void test2() {
		assertArrayEquals(new User[] { u8, u5, u4, u6, u9, u1, u3, u7, u2 }, graph.BFS(u8));
	}

	@Test
	void test3() {
		assertArrayEquals(new User[] { u1, u3, u4, u9 }, graph.BFS(u1, 2));
	}

	@Test
	void test4() {
		assertArrayEquals(new User[] { u1 }, graph.BFS(u1, 1));
	}

	@Test
	void test5() {
		assertArrayEquals(new User[] {}, graph.BFS(u11, 0));
	}

	@Test
	void test6() {
		graph.removeNode(u2);
		assertArrayEquals(new User[] { u1, u3, u4, u9, u6, u5, u7, u8 }, graph.BFS(u1));
	}

	@Test
	void test7() {
		assertEquals(u5, graph.getNode(5));
	}

	@Test
	void test8() {
		assertEquals(null, graph.getNode(15));
	}

	@Test
	void test9() {
		graph.removeEdge(1, 9);
		assertArrayEquals(new User[] { u1, u3, u4, u2, u6, u5, u9, u7, u8 }, graph.BFS(u1));
	}

	@Test
	void test10() {
		graph.addEdge(1, 8);
		assertArrayEquals(new User[] { u1, u3, u4, u8, u9, u2, u6, u5, u7 }, graph.BFS(u1));
	}
}
