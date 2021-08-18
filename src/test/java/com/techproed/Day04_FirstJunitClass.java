package com.techproed;

import org.junit.*;

public class Day04_FirstJunitClass {
    //ANNOTATIONS: @TEST ,@BEFORE,@AFTER,@IGNORE
    //we dont need main method
    //creste a test case
    //@ignore skip tast case
    //set up ->teardown 1 test2 (SKIPPED)-> TEST 3
    @Before
    public void setup(){
        System.out.println("@Before runs before each @Test method ");
    }
    @Test
    public void setUp(){
        System.out.println("this will be reusable set up method ");

    }

    @Test
    public  void test1(){
        System.out.println("TEST CASE 1");
    }

    @Test
    public  void test2(){
        System.out.println("TEST CASE 2");
    }
    @Test
    public  void test3(){
        System.out.println("TEST CASE 3");
    }
    @After
    @Test
    public void tearDown(){
        System.out.println("this will run after all test classes are done ");

    }
    //Assertions: if expected =actual
    //assertion()
    @Test
    public void assertion(){
        //1) Assert.assertTrue();if statement =true then pass otherwise fail
        //2) Assert.assertFalse();if stattement false it is false otherwise fail
        Assert.assertTrue(3==4);
        Assert.assertFalse(3==4);
        String expected ="junit";
        Assert.assertTrue("junit".contains("j"));

        //3)Assert.assertEquals("expected","actual")) if expected=actual,then pass,otherwise FAIL
        Assert.assertEquals("junit","junit");


    }


}
