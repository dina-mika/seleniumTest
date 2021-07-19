package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) {
		
		String[][] emailPassword = {
				{"123@gmail.com", "123"},
				{"1234@gmail.com", "12345"}, 
				{"12345@gmail.com", "12345"}};
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dina\\Downloads\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://bootsnipp.com/login");
		//First test: Check the site
		String at = driver.getTitle();
		String et = "Login to free code playground for Bootstrap";
		if(at.equalsIgnoreCase(et)) {
			System.out.println("First test: Done");
		
		}
		else {
			System.out.println("First test: Failed");
			driver.close();
		}
			
		for(int i = 0; i<=emailPassword.length; i++) {
			String email = emailPassword[i][0];
			String pass = emailPassword[i][1];
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("password")).sendKeys(pass);
			if(!driver.findElement(By.name("remember")).isSelected()){
				driver.findElement(By.name("remember")).click();
			}
			driver.findElement(By.xpath("//input[@class='btn btn-lg btn-success btn-block']")).click();
			
		
			String at1 = driver.getCurrentUrl();
			//Second test: To do authorization
			String et1 = "https://bootsnipp.com/user";
			if(at1.equalsIgnoreCase(et1)) {
				System.out.println("Second test: Done for " + email);
			driver.quit();
			}
			else {
				System.out.println("Second test: Failed for " + email);
				driver.findElement(By.name("email")).clear();
			}
		}
		driver.quit();
	}

		
	}
