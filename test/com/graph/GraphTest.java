package com.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.social_network.Gender;
import com.social_network.User;

class GraphTest {
	static Graph<Integer, User> graph;
	static User u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13, u14, u15, u16, u17, u18, u19, u20, u21, u22,
			u23, u24, u25, u26;

	@BeforeEach
	void setUp() {
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

		graph.removeNode(u1);
		graph.removeNode(u2);
		graph.removeNode(u3);
		graph.removeNode(u4);
		graph.removeNode(u5);
		graph.removeNode(u6);
		graph.removeNode(u7);
		graph.removeNode(u8);
		graph.removeNode(u9);
		graph.removeNode(u10);
		graph.removeNode(u11);
		graph.removeNode(u12);
		graph.removeNode(u13);
		graph.removeNode(u14);
		graph.removeNode(u15);
		graph.removeNode(u16);
		graph.removeNode(u17);
		graph.removeNode(u18);
		graph.removeNode(u19);
		graph.removeNode(u20);
		graph.removeNode(u21);
		graph.removeNode(u22);
		graph.removeNode(u23);
		graph.removeNode(u24);
		graph.removeNode(u25);
		graph.removeNode(u26);

		graph.addEdge(8, 2);
		graph.addEdge(4, 14);
		graph.addEdge(25, 20);
		graph.addEdge(4, 22);
		graph.addEdge(13, 24);
		graph.addEdge(2, 12);
		graph.addEdge(6, 16);
		graph.addEdge(17, 18);
		graph.addEdge(1, 6);
		graph.addEdge(18, 20);
		graph.addEdge(18, 3);
		graph.addEdge(23, 24);
		graph.addEdge(6, 15);
		graph.addEdge(10, 13);
		graph.addEdge(6, 21);
		graph.addEdge(12, 13);
		graph.addEdge(10, 14);
		graph.addEdge(10, 22);
		graph.addEdge(13, 23);
		graph.addEdge(13, 14);
		graph.addEdge(1, 8);
		graph.addEdge(1, 2);
		graph.addEdge(9, 14);
		graph.addEdge(17, 16);
		graph.addEdge(11, 2);
		graph.addEdge(9, 2);
		graph.addEdge(5, 3);
		graph.addEdge(22, 23);
		graph.addEdge(19, 2);
		graph.addEdge(5, 4);
		graph.addEdge(6, 4);
		graph.addEdge(2, 3);
		graph.addEdge(25, 4);
		graph.addEdge(20, 5);
		graph.addEdge(17, 11);
		graph.addEdge(10, 12);
		graph.addEdge(8, 9);
		graph.addEdge(8, 12);
		graph.addEdge(26, 8);
		graph.addEdge(16, 18);
		graph.addEdge(5, 19);
		graph.addEdge(18, 19);
		graph.addEdge(2, 5);
		graph.addEdge(10, 4);
		graph.addEdge(14, 24);
		graph.addEdge(1, 7);
		graph.addEdge(12, 14);
		graph.addEdge(14, 22);
		graph.addEdge(8, 7);
		graph.addEdge(4, 9);
		graph.addEdge(5, 25);
		graph.addEdge(8, 10);
		graph.addEdge(25, 19);
		graph.addEdge(6, 3);
		graph.addEdge(25, 9);
		graph.addEdge(25, 22);
		graph.addEdge(9, 5);
		graph.addEdge(18, 11);
		graph.addEdge(16, 3);
		graph.addEdge(9, 10);
		graph.addEdge(2, 4);
	}

	@Test
	void test1() {
		assertArrayEquals(new User[] { u17, u16, u18, u11, u6, u3, u20, u19, u2, u15, u21, u1, u4, u5, u25, u9, u8, u12,
				u7, u22, u10, u14, u26, u13, u23, u24 }, graph.BFS(u17));
	}

	@Test
	void test2() {
		assertArrayEquals(new User[] { u15, u6, u16, u21, u1, u4, u3, u17, u18, u8, u7, u2, u9, u22, u25, u10, u5, u14,
				u11, u20, u19, u12, u26, u23, u13, u24 }, graph.BFS(u15));
	}

	@Test
	void test3() {
		assertArrayEquals(new User[] { u17, u16, u18, u11 }, graph.BFS(u17, 1));
	}

	@Test
	void test4() {
		assertArrayEquals(new User[] { u11 }, graph.BFS(u11, 0));
	}

	@Test
	void test5() {
		graph.removeNode(u2);
		assertArrayEquals(new User[] { u1, u8, u7, u6, u9, u10, u12, u26, u16, u15, u21, u4, u3, u25, u5, u14, u22, u13,
				u17, u18, u20, u19, u24, u23, u11 }, graph.BFS(u1));
	}

	@Test
	void test6() {
		graph.removeNode(u14);
		assertArrayEquals(new User[] { u1, u8, u7, u2, u6, u9, u10, u12, u26, u11, u5, u19, u4, u3, u16, u15, u21, u25,
				u22, u13, u17, u18, u20, u23, u24 }, graph.BFS(u1));
	}

	@Test
	void test7() {
		assertEquals(graph.getNode(20), u20);
	}

	@Test
	void test8() {
		graph.removeEdge(6, 15);
		assertArrayEquals(new User[] { u17, u16, u18, u11, u6, u3, u20, u19, u2, u21, u1, u4, u5, u25, u9, u8, u12, u7,
				u22, u10, u14, u26, u13, u23, u24 }, graph.BFS(u17));
	}

	@Test
	void test9() {
		graph.removeEdge(4, 10);
		assertArrayEquals(new User[] { u17, u16, u18, u11, u6, u3, u20, u19, u2, u15, u21, u1, u4, u5, u25, u9, u8, u12,
				u7, u22, u14, u10, u26, u13, u23, u24 }, graph.BFS(u17));
	}

	@Test
	void test10() {
		graph.addEdge(3, 19);
		assertArrayEquals(new User[] { u17, u16, u18, u11, u6, u3, u20, u19, u2, u15, u21, u1, u4, u5, u25, u9, u8, u12,
				u7, u22, u10, u14, u26, u13, u23, u24 }, graph.BFS(u17));
	}
}
