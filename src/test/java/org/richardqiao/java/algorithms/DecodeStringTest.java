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
    assertEquals(new DecodeString().decode("3[a]2[bc]"), "aaabcbc");
    assertEquals(new DecodeString().decode("3[a2[c]]"), "accaccacc");
    assertEquals(new DecodeString().decode("2[abc]3[cd]ef"), "abcabccdcdcdef");
  }

}
