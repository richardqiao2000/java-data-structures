package org.richardqiao.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RangeAdditionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testgetModifiedArray() {
		RangeAddition ra = new RangeAddition();
		for(int num: ra.getModifiedArray(5, new int[][]{{0,1,4}, {1,3,2}, {3,3,2}})){
		  System.out.print(num + ", ");
		}
	}

}
