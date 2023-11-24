package com.holub.database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TransactionManager {
	
	private static TransactionManager transactionManager = new TransactionManager();
	Map<String, LinkedList> transactionStacks = new HashMap<>(); // key: Model명, Value: transactionStack
	
	public static TransactionManager getInstance() {
		return transactionManager;
	}
	
	public void begin(String model) {
		LinkedList transactionStack = getTransactionStack(model);
		transactionStack.addLast(new LinkedList());
	}
	
	private LinkedList getTransactionStack(String model) {
		LinkedList transactionStack = transactionStacks.get(model);
		if (transactionStack == null) {
			transactionStack = new LinkedList();
			transactionStacks.put(model, transactionStack);
		}
		
		return transactionStack;
	}
	
}