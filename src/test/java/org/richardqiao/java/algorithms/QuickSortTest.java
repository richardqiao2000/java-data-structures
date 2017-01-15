package org.richardqiao.java.algorithms;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testQuickSort() {
    QuickSort qs = new QuickSort();
    Assert.assertArrayEquals(qs.quickSort(new int[]{3,2,1,5,6,4}), new int[]{1,2,3,4,5,6});
    Assert.assertArrayEquals(qs.quickSort(new int[]{3,5,6,43,20,3,2,1,3}), new int[]{1, 2, 3, 3, 3, 5, 6, 20, 43});
    Assert.assertArrayEquals(qs.quickSort(new int[]{2,1}), new int[]{1, 2});
  }

}
