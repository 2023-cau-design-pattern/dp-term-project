package com.holub.database;

import java.util.LinkedList;

public class UndoInsert implements Undo {
	private final Object[] insertedRow;
	
	public UndoInsert(Object[] insertedRow) {
		this.insertedRow = insertedRow;
	}
	public LinkedList execute(LinkedList rowSet) {
		rowSet.remove(insertedRow);
		return rowSet;
	}

}
