package com.holub.database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TransactionManager {
	
	private static TransactionManager transactionManager = new TransactionManager();
	
	
	public static TransactionManager getInstance() {
		return transactionManager;
	}
	
}
