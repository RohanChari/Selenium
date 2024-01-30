package TestNgPackage;

import org.testng.annotations.Test;

public class Broswer {
  
 @Test(priority=3)
 
  public void test1() {
	  
	  System.out.println("this is test1");
  }
  
  @Test(priority=2)
  public void test2() {
	  
	  System.out.println("this is test2");
  }
  
  @Test (groups= {"sanity"}, priority=1)
  public void test3() {
	  
	  System.out.println("this is test3");
	  System.out.println("this is sanity group priority 1");
  }
  
  
  @Test (groups= {"sanity"}, priority=4)
  public void test4() {
	  
	  System.out.println("this is test4");
  }
  
  
  
  
  
  
  
  
  
}
