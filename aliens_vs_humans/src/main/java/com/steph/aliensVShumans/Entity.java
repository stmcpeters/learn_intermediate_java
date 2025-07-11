package com.steph.aliensVShumans;

public class Entity {
  private String name;
  private int health;  // all entities should start with 100?
  
  /**
   * Creates a new entity with the specified name and health.
   * 
   * @param name the name of the entity
   * @param health the initial health points of the entity
   */
  public Entity(String name, int health){
    this.name = name;
    this.health = health;
  }

  /**
   * Gets the name of this entity.
   * 
   * @return the name of the entity
   */
  public String getName(){
    return this.name;
  }

  /**
   * Gets the current health level of this entity.
   * 
   * @return the current health points of the entity
   */
  public int getHealth(){
    return this.health;
  }

  /**
   * Returns the entity's new health points after taking damage
   * 
   * @return the current health points of the entity
   */
  public int takeDamage(int damage){
    return this.health -= damage;
  }

  // TODO:
  // attack()
  // isAlive()
  // isDead()
  // heal() restore health
  // toString()
}
