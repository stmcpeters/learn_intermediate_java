package com.steph.aliensVShumans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EntityTest {
  // declares a test entity instance to be used across test methods
  public static Entity human;

  @BeforeAll
  public static void beforeAll(){
    human = new Entity("John", 100);
  }

  @Test
  public void EntityConstructor(){
    assertNotNull(human);
  }

  @Test
  public void testGetName(){
    assertEquals("John", human.getName());
  }

  @Test
  public void testGetHealth(){
    assertEquals(100, human.getHealth());
  }

  @Test
  public void testTakeDamage(){
    assertEquals(90, human.takeDamage(10));
  }
}
