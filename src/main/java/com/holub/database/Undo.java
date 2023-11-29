package com.holub.database;

import java.util.LinkedList;

public interface Undo {
	LinkedList execute(LinkedList rowSet);
}
