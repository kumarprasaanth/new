package decode2.decode2.decode3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class code {
	WebDriver driver;
	@Given("sign up")
	public void sign_up() {
		System.setProperty("webdriver.chrome.driver", "C:\\kprasaanth\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("pras123");
		driver.findElement(By.id("firstName")).sendKeys("pras");
		driver.findElement(By.id("lastName")).sendKeys("pass");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("pass_confirmation")).sendKeys("password123");
		driver.findElement(By.xpath("//input[@value='Male']"));
		driver.findElement(By.id("emailAddress")).sendKeys("pras123@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567891");
		driver.findElement(By.id("dob")).sendKeys("23/12/2001");
		driver.findElement(By.id("address")).sendKeys("21,nagar");
		driver.findElement(By.id("userName")).sendKeys("pras123");
		Select a=new Select(driver.findElement(By.id("securityQuestion")));
		a.selectByVisibleText("What is your Birth Place?");
	    driver.findElement(By.id("answer")).sendKeys("chennai");		
	    driver.findElement(By.name("Submit")).click();
	}

	@When("login")
	public void login() {
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.partialLinkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	}

	@And("select product")
	public void select_product() throws InterruptedException {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("All Categories"))).build().perform();
		a.moveToElement(driver.findElement(By.linkText("Electronics"))).click().build().perform();
		Thread.sleep(3000);
		a.moveToElement(driver.findElement(By.linkText("Head Phone"))).click().build().perform();
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Add to cart")).click();
		driver.findElement(By.partialLinkText("Cart")).click();

		
	}

	@And("checkout")
	public void checkout() throws InterruptedException {
		driver.findElement(By.partialLinkText("Checkout")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Andhra Bank']"));
		driver.findElement(By.id("btn")).click();
	    
	}

	@Then("payment")
	public void payment() {
		driver.findElement(By.name("username")).sendKeys("123456");
		driver.findElement(By.name("password")).sendKeys("pass@123");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}

}
