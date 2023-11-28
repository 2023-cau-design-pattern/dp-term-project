package com.holub.application.setting;

import java.util.ArrayList;
import java.util.List;

import com.holub.database.ComputeOrderBy;
import com.holub.database.Cursor;
import com.holub.database.Selector;
import com.holub.database.Table;
import com.holub.database.TableFactory;

public class SetUp {
	public Table menu;
	public Table order;
	
	public SetUp() { 
		menu = TableFactory.create("menu", new String[] { "name", "price" });
		order = TableFactory.create("order", new String[] { "title", "totalPrice", "date" });
	}
}



// people.insert(new Object[] { "Flintstone", "Wilma", "2" });
// people.insert(new String[] { "addrId", "first", "last" }, new Object[] { "2", "Fred", "Flintstone" });


 // ComputeOrderBy orderBy = new ComputeOrderBy(people, "first");
// orderBy.execute();


//Selector flintstoneSelector = new Selector.Adapter() {
//public boolean approve(Cursor[] tables) {
//	return tables[0].column("last").equals("Flintstone");
//}
//};

//SELECT first, last FROM people WHERE last = "Flintstone"
//The collection version chains to the string version, so the
//following call tests both versions

//List columns = new ArrayList();
//columns.add("first");
//columns.add("last");

//Table result = people.select(flintstoneSelector, columns);

//SELECT * FROM people WHERE last = "Flintstone"
//result = people.select(flintstoneSelector);
