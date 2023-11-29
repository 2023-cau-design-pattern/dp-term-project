package com.holub.database;

import java.util.LinkedList;

public class UndoUpdate implements Undo {
	private Object[] row;
	private int cell;
	private Object oldContents;
	
	public UndoUpdate(Object[] row, int cell, Object oldContents) {
		this.row = row;
		this.cell = cell;
		this.oldContents = oldContents;
	}
	
	public LinkedList execute(LinkedList rowSet) {
		row[cell] = oldContents;
		return rowSet;
	}
}
