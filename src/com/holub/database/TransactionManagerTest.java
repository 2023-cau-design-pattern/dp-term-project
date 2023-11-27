package com.holub.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransactionManagerTest {

	@Test
	void testCommit() {
		Table people = TableFactory.create("people", new String[] { "last", "first", "addrId" });
		people.begin();
		System.out.println("begin/insert into people (Solo, Han, 5) (Lea, Princess, 6)");

		people.insert(new Object[] { "Solo", "Han", "5" });
		people.insert(new Object[] { "Lea", "Princess", "6" });
		
		System.out.println("commit(THIS_LEVEL)\n");
		people.commit(Table.THIS_LEVEL);
		
		String result = people.toString();
		System.out.println(result);
		assertEquals(result, "people\n"
				+ "last	first	addrId	\n"
				+ "----------------------------------------\n"
				+ "Solo	Han	5	\n"
				+ "Lea	Princess	6	\n");
	}

	@Test
	void testRollback() {
		// Now test that nested transactions work correctly.
		Table people = TableFactory.create("people", new String[] { "last", "first", "addrId" });
		people.begin();
		System.out.println("begin/insert into people (Solo, Han, 5) (Lea, Princess, 6)");
		
		people.insert(new Object[] { "Solo", "Han", "5" });
		people.insert(new Object[] { "Lea", "Princess", "6" });
		people.commit(Table.THIS_LEVEL);
		System.out.println("commit(THIS_LEVEL)\n");
		
		System.out.println("begin/insert into people (Vader,Darth, 4)");
		people.begin();
		people.insert(new Object[] { "Vader", "Darth", "4" });
		System.out.println(people.toString());
		System.out.println("begin/update people set last=Skywalker where last=Vader");

		// Now test that rollback(update, delete) transactions work correctly
		people.begin();
		people.update(new Selector() {
			public boolean approve(Cursor[] tables) {
				return tables[0].column("last").equals("Vader");
			}

			public void modify(Cursor current) {
				current.update("last", "Skywalker");
			}
		});
		System.out.println(people.toString());

		System.out.println("delete from people where last=Skywalker");
		people.delete(new Selector.Adapter() {
			public boolean approve(Cursor[] tables) {
				return tables[0].column("last").equals("Skywalker");
			}
		});
		System.out.println(people.toString());

		System.out.println("rollback(Table.THIS_LEVEL) the delete and update");
		people.rollback(Table.THIS_LEVEL);
		String result = people.toString();

		System.out.println(result);
		assertEquals(result, "people\n"
				+ "last	first	addrId	\n"
				+ "----------------------------------------\n"
				+ "Solo	Han	5	\n"
				+ "Lea	Princess	6	\n"
				+ "Vader	Darth	4	\n");

		System.out.println("rollback(Table.THIS_LEVEL) insert");
		people.rollback(Table.THIS_LEVEL);
		result = people.toString();
		System.out.println(result);
		assertEquals(result, "people\n"
				+ "last	first	addrId	\n"
				+ "----------------------------------------\n"
				+ "Solo	Han	5	\n"
				+ "Lea	Princess	6	\n");
	}



}