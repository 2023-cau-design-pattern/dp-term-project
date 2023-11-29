package com.holub.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderByTest {
	private Table people;
	private Table address;
	
	private String result;
	
	@BeforeEach
	public void createTable() {
		people = TableFactory.create("people", new String[] { "last", "first", "addrId" });

		people.insert(new Object[] { "Holub", "Allen", "5" });
		people.insert(new Object[] { "Flintstone", "Wilma", "2" });
		people.insert(new String[] { "addrId", "first", "last" }, new Object[] { "4", "Fred", "Flintstone" });

		address = TableFactory.create("address", new String[] { "addrId", "street"});
		
		address.insert(new Object[] { 152, "Sangdo"});
		address.insert(new Object[] { 324, "Gangnam"});
		address.insert(new Object[] { 23, "Jongno"});
		address.insert(new Object[] { 1, "Daejeon"});
		address.insert(new Object[] { 4, "Busan"});
	}

	@Test
	public void testOrderByCase1() {
		System.out.println(people.toString());
		
		System.out.println("begin/orderBy people by 'first'");
		people.begin();
		ComputeOrderBy orderBy = new ComputeOrderBy(people, "first");
		orderBy.execute();
		
		result = people.toString();
		
		assertEquals(result, "people\n"
				+ "last	first	addrId	\n"
				+ "----------------------------------------\n"
				+ "Holub	Allen	5	\n"
				+ "Flintstone	Fred	4	\n"
				+ "Flintstone	Wilma	2	\n");
	}
	
	@Test
	public void testOrderByString() {
		System.out.println(address.toString());
		
		System.out.println("begin/orderBy address by 'addrId'");
		
		address.begin();
		ComputeOrderBy orderBy = new ComputeOrderBy(address, "addrId");
		orderBy.execute();
		
		result = address.toString();
		
		assertEquals(result, "address\n"
				+ "addrId	street	\n"
				+ "----------------------------------------\n"
				+ "1	Daejeon	\n"
				+ "4	Busan	\n"
				+ "23	Jongno	\n"
				+ "152	Sangdo	\n"
				+ "324	Gangnam	\n");
	}
	
	@Test
	public void testOrderByInt() {
		System.out.println(address.toString());
		
		System.out.println("begin/orderBy address by 'street'");
		
		address.begin();
		ComputeOrderBy orderBy = new ComputeOrderBy(address, "street");
		orderBy.execute();
		
		result = address.toString();
		
		assertEquals(result, "address\n"
				+ "addrId	street	\n"
				+ "----------------------------------------\n"
				+ "4	Busan	\n"
				+ "1	Daejeon	\n"
				+ "324	Gangnam	\n"
				+ "23	Jongno	\n"
				+ "152	Sangdo	\n");
	}
	
	@AfterEach
	public void printResultTable() {
		System.out.println(result);
	}
}
