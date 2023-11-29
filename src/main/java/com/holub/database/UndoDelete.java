package com.holub.database;

import java.util.LinkedList;

public class UndoDelete implements Undo {
	private final Object[] deletedRow;
	
	public UndoDelete(Object[] deletedRow) {
		this.deletedRow = deletedRow;
	}
	
	public LinkedList execute(LinkedList rowSet) {
		rowSet.add(deletedRow);
		return rowSet;
	}
}
