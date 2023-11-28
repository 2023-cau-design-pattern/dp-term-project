package com.holub.application.setting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.holub.database.ComputeOrderBy;
import com.holub.database.Cursor;
import com.holub.database.Selector;
import com.holub.database.Table;
import com.holub.database.TableFactory;
//import com.holub.database.ConcreteTable.Test;

public class SetUp {
	public static Table menu;
	public static Table order; // 주문 내역 인서트, order select
	
	public SetUp() { 
		menu = TableFactory.create("menu", new String[] { "name", "price" });
		order = TableFactory.create("order", new String[] { "title", "totalPrice", "date" });
        
		menu.insert(new Object[] {"wheat", 5.50});
		menu.insert(new Object[] {"white", 5.00});
		menu.insert(new Object[] {"honey_oat", 6.00});
		menu.insert(new Object[] {"oat", 5.75});
		menu.insert(new Object[] {"flatbread", 6.50});
		menu.insert(new Object[] {"mustard", 0.30});
		menu.insert(new Object[] {"chili", 0.45});
		menu.insert(new Object[] {"ranch", 0.50});
		menu.insert(new Object[] {"tomato", 0.25});
		menu.insert(new Object[] {"cheese", 0.75});
		menu.insert(new Object[] {"ham", 1.00});
		menu.insert(new Object[] {"coffee", 1.5});
		menu.insert(new Object[] {"tea", 1.0});
		menu.insert(new Object[] {"coke", 1.25});
		
	}
	
	public String selectMenu(List columns) {
		Selector flintstoneSelector = new Selector.Adapter() {
			public boolean approve(Cursor[] tables) {
				return true; 
			}
		};
		
		Table result = menu.select(flintstoneSelector, columns);
		
		return result.selectAll();
		
	}
	
	public String selectOrder(List columns) {
		Selector flintstoneSelector = new Selector.Adapter() {
			public boolean approve(Cursor[] tables) {
				return true;
			}
		};
		
		Table result = order.select(flintstoneSelector, columns);
		
		return result.selectAll();
	}
	
	public String selectOrderAll() {
		return order.selectAll();
	}
	
	public String selectMenuAll() {
		return menu.selectAll();
	}
	
	public String selectOrderOrderBy(String criteria) {
		order.orderBy(criteria);
		
		return selectOrderAll();
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
