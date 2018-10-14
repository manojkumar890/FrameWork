package com.abc.uti;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		FileInputStream fis = new FileInputStream("src\\com\\abc\\utilities\\hybriddriven.properties");
		Properties p= new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String un=p.getProperty("un");
		String pwd1=p.getProperty("pwd1");
		String myacc=p.getProperty("myacc");
		String email=p.getProperty("email");
		String pwd2=p.getProperty("pwd2");
		String login=p.getProperty("login");
		String logout=p.getProperty("logout");
		driver.get(url);
		
		System.out.println(myacc);
		System.out.println(email);
		System.out.println(pwd1);
		System.out.println(login);
		System.out.println(logout);
		
		
		driver.findElement(By.xpath(myacc)).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(email)).sendKeys(un);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(pwd2)).sendKeys(pwd1);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(login)).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(logout)).click();
		Thread.sleep(5000);
		
		FileOutputStream fos = new FileOutputStream("src\\\\com\\\\abc\\\\utilities\\\\hybriddriven.properties");
		p.setProperty("TestResult", "pass");
		p.save(fos,"TestCasePassed");
		driver.quit();
	}

}
