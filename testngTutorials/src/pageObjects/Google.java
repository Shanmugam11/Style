package pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Google {
	public Properties objProp;  
	protected String Email, Password,uName;
	
	
	@FindBy(xpath="//a[@href='https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://www.google.com/']")
	private WebElement signIn;
	
	
	@FindBy(xpath="//input[@id='identifierId']")
	private WebElement userName;
	
	
	@FindBy(xpath="//div[@id='identifierNext' and @role='button']")
	private WebElement usernameNext;
	
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	
	@FindBy(xpath="//div[@id='passwordNext' and @role='button']")
	private WebElement passwordNext;
	
	
	@FindBy(xpath="//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://www.google.com/']")
	private WebElement clickHoverPicture;
	
	
	@FindBy(xpath="//li[@id='account-shannainar.2004@gmail.com']")
	private WebElement useridIdentifier;
	
	
	//@BeforeClass(alwaysRun=true)
	public void inputData() throws Exception{
		objProp = new Properties();
		objProp.load(new FileInputStream ("dataProp.properties"));
		Email = objProp.getProperty("Email");
		Password = objProp.getProperty("Password");
		uName=objProp.getProperty("Username");
				
		}

	public void googleLogin(){
		System.out.println("The method googleLogin invokes");
		signIn.click();
		userName.sendKeys(Email);
		usernameNext.click();
		password.sendKeys(Password);
		passwordNext.click();
	}
	
	public void validation(){
				
		clickHoverPicture.click();
		String uName=useridIdentifier.getText();
		if (uName.equalsIgnoreCase(uName)){
			System.out.println("Congrats!! Authenticated Login: " + uName);
		}
		else {
			System.out.println("Oops!! UnAuthenticated Login: " + uName);
		}
		
		
		
		
		
	}
	
	
	}

