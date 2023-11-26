package com.holub.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderByTest {

	@Test
	public void testOrderByCase1() {
		Table people = TableFactory.create("people", new String[] { "last", "first", "addrId" });

		people.insert(new Object[] { "Holub", "Allen", "5" });
		people.insert(new Object[] { "Flintstone", "Wilma", "2" });
		people.insert(new String[] { "addrId", "first", "last" }, new Object[] { "4", "Fred", "Flintstone" });


		System.out.println(people.toString());

		System.out.println("begin/orderBy people by 'first'");
		people.begin();
		people.orderBy("first");
		
		String result = people.toString();
		System.out.println(result);
		assertEquals(result, "people\n"
				+ "last	first	addrId	\n"
				+ "----------------------------------------\n"
				+ "Holub	Allen	5	\n"
				+ "Flintstone	Fred	4	\n"
				+ "Flintstone	Wilma	2	\n");
	}
}
