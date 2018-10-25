package testCases;

import pageObjects.WebDrivers;

import org.testng.annotations.Test;

import pageObjects.Google;

public class googleLogin extends WebDrivers{

	Google objGoogle;

	
	
@Test(priority=0)
public void login(){
	objGoogle.googleLogin();
	objGoogle.validation();
	
}






}
