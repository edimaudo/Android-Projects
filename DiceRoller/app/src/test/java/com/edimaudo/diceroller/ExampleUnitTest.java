package com.edimaudo.diceroller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
  @Test
  public void generate_number() throws Exception{
    MainActivity mainActivity = new MainActivity();
    int result = mainActivity.getRandomRoll();
    assertTrue(result <= 6 | result >= 1);


  }


}