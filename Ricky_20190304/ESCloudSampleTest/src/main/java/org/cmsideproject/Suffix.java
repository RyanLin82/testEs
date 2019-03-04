package org.cmsideproject;

public class Suffix {
	
	
//@Value("${IndexNameConfig.somePropertyValue}")
  private String value;

//  public IndexNameConfig(String somePropertyValue) {
//	  this.somePropertyValue = somePropertyValue;
//  }

  public String getValue() {
	  return value;
  }

  public void setValue(String somePropertyValue) {
	  this.value = somePropertyValue;
  }
}
