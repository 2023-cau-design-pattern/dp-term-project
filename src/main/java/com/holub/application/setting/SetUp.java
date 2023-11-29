package com.holub.application.setting;

import com.holub.database.Cursor;
import com.holub.database.Selector;
import com.holub.database.Table;
import com.holub.database.TableFactory;
import java.util.List;

public class SetUp {
	// singleton
	private static SetUp instance;
	public static Table menu;
	public static Table order; // 주문 내역 인서트, order select

	public static synchronized SetUp getInstance() {
		if (instance == null) {
			instance = new SetUp();
		}
		return instance;
	}

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
		Selector selector = new Selector.Adapter() {
			public boolean approve(Cursor[] tables) {
				return true;
			}
		};
		Table t = order.select(selector);
		return t.selectAll();
	}
	
	public String selectMenuAll() {
		return menu.selectAll();
	}
	
	public String selectOrderOrderBy(String criteria) {
		order.orderBy(criteria);
		return selectOrderAll();
	}
}