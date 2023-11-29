package com.holub.database;

import com.holub.application.setting.SetUp;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SetUpTest {

	@Test
	void test() {
		SetUp setUp = new SetUp();
		setUp.order.insert(new Object[] {"dd", 456, "a"});
		setUp.order.insert(new Object[] {"gg", 123, "b"});
		
		String result = setUp.selectOrderAll();
		
		
		result = setUp.selectOrderOrderBy("totalPrice");
		
		List columns = new ArrayList();
		columns.add("title");
		
		result = setUp.selectOrder(columns);
		
		System.out.println(result);
		
	}

}
