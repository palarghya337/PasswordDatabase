package com.arghya.passworddatabase.bean;

import java.io.Serializable;

public class DataBasePojo
  implements Serializable
{
  private static final long serialVersionUID = 1210558406628130173L;
  private String website;
  private String userName;
  private String password;
  
  public String getWebsite()
  {
    return this.website;
  }
  
  public void setWebsite(String website)
  {
    this.website = website;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
}
