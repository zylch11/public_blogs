package io.waqasahmed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int accessCount;
  private boolean exceedesLimit;

  public boolean isExceedesLimit()
  {
    return exceedesLimit;
  }

  public void setExceedesLimit(boolean exceedesLimit)
  {
    this.exceedesLimit = exceedesLimit;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAccessCount()
  {
    return accessCount;
  }

  public void setAccessCount(int accessCount)
  {
    this.accessCount = accessCount;
  }
}


