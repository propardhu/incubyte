package com.pardhu.test;

import static org.junit.Assert.assertEquals;

import com.pardhu.cal.Calculator;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalTest {

  private static Calculator obj;

  @BeforeClass
  public static void getCal(){
    obj = Calculator.getInstance();
  }

  @Test
  public void Test1() throws Exception {
    assertEquals(obj.add("1,2"),3);
  }

  @Test
  public void Test2() throws Exception {
    assertEquals(obj.add("1,2\n3"),6);
  }

  @Test
  public void Test3() throws Exception {
    assertEquals(obj.add("//[:]\n[4:6:[;]\n[2;3]]"),15);//done based on //[delimiter]\n[numbers…]
  }

  @Test
  public void Test4() throws Exception {
    assertEquals(obj.add("//[:]\n[4:6]"),10);//done based on //[delimiter]\n[numbers…]
  }

  @Test
  public void Test5() throws Exception {
    assertEquals(obj.add("7\n1\n2"),10);
  }


}
