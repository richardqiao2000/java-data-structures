package org.richardqiao.java.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DecodeStringTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testDecode() {
    DecodeString ds = new DecodeString();
    System.out.println(ds.decode("3[a]2[bc]"));
    assertEquals(new DecodeString().decode("3[a]2[bc]"), "aaabcbc");
  }

}
