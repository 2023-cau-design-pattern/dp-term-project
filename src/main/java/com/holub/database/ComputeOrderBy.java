package com.holub.database;

public class ComputeOrderBy implements Compute {
	Table table;
	String criteria;
	
	public ComputeOrderBy(Table table, String criteria) {
		this.table = table;
		this.criteria = criteria;
	}

	@Override
	public void execute() {
		table.orderBy(criteria);
	}
}