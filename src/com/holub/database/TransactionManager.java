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
	
	// ----------------------------------------------------------------------
	// @Transaction
	// begin, commit, rollback
	//
	public void begin(String model) {
		LinkedList transactionStack = getTransactionStack(model);
		transactionStack.addLast(new LinkedList());
	}
	
	public void commit(String model, boolean all) throws IllegalStateException {
		LinkedList transactionStack = getTransactionStack(model);
		if (transactionStack.isEmpty())
			throw new IllegalStateException("No BEGIN for COMMIT");
		do {
			LinkedList currentLevel = (LinkedList) transactionStack.removeLast();

			if (!transactionStack.isEmpty())
				((LinkedList) transactionStack.getLast()).addAll(currentLevel);

		} while (all && !transactionStack.isEmpty());
	}
	
	public LinkedList rollback(String model, boolean all, LinkedList rowSet) throws IllegalStateException {
		LinkedList transactionStack = getTransactionStack(model);

		if (transactionStack.isEmpty())
			throw new IllegalStateException("No BEGIN for ROLLBACK");
		do {
			LinkedList currentLevel = (LinkedList) transactionStack.removeLast();

			while (!currentLevel.isEmpty())
				rowSet = ((Undo) currentLevel.removeLast()).execute(rowSet);
			
		} while (all && !transactionStack.isEmpty());
		
		return rowSet;
	}
	
	
	private LinkedList getTransactionStack(String model) {
		LinkedList transactionStack = transactionStacks.get(model);
		if (transactionStack == null) {
			transactionStack = new LinkedList();
			transactionStacks.put(model, transactionStack);
		}
		
		return transactionStack;
	}
	
	// ----------------------------------------------------------------------
	// @Register
	// register in transaction stack
	// 
	private void register(String model, Undo op) {
		LinkedList transactionStack = getTransactionStack(model);
		((LinkedList) transactionStack.getLast()).addLast(op);
	}
	
	public void registerUpdate(String model, Object[] row, int cell, Object oldContents) {
		LinkedList transactionStack = getTransactionStack(model);
		if (!transactionStack.isEmpty())
			register(model, new UndoUpdate(row, cell, oldContents));
	}

	public void registerDelete(String model, Object[] oldRow) {
		LinkedList transactionStack = getTransactionStack(model);
		if (!transactionStack.isEmpty())
			register(model, new UndoDelete(oldRow));
	}

	public void registerInsert(String model, Object[] newRow) {
		LinkedList transactionStack = getTransactionStack(model);
		if (!transactionStack.isEmpty())
			register(model, new UndoInsert(newRow));
	}
	// ----------------------------------------------------------------------
	
}
