package nl.trio.foosball.model;

import java.io.Serializable;

//@Entity
public class Player implements Serializable{

//  private BigInteger id;
  private Long id;
  private String name;
  private String alias;
  private String pw;
  private int age;
  private String gender;

  public Player() {
  }

  //  @Id
//  @GeneratedValue( strategy = GenerationType.IDENTITY )
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
