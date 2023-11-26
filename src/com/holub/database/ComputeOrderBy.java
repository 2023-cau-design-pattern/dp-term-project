package com.holub.database;

public class ComputeOrderBy implements Compute {
	ConcreteTable concreteTable;
	String criteria;
	
	public ComputeOrderBy(ConcreteTable concreteTable, String criteria) {
		this.concreteTable = concreteTable;
		this.criteria = criteria;
	}

	@Override
	public void execute() {
		concreteTable.orderBy(criteria);
	}
}
