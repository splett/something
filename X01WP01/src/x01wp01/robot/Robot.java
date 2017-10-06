package x01wp01.robot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import x01wp01.entity.user.User;

public class Robot {

	private WebDriver driver;
	private OperaOptions options;
	private User user;
	
	public Robot(User user) {
		setProperty();
		setOptions();
		setDriver(new OperaDriver(options));
		this.user = user;
	}

	private void setOptions() {
		options = new OperaOptions();
		options.setBinary(new File("C:\\Program Files\\Opera\\launcher.exe"));
	}

	private void setProperty() {
		System.setProperty("webdriver.opera.driver", new File("drivers/OperaDriver.exe").getAbsolutePath());
	}
	
	public void executeTask() {
		initBlackboard();
		loginUser();
		findElements();
	}

	private void initBlackboard() {
		driver.get("https://up.blackboard.com/webapps/login/");
		driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);
	}

	private void loginUser() {
		driver.findElement(By.id("user_id")).sendKeys(user.getUserId());
		driver.findElement(By.id("password")).sendKeys(user.getPassword());
		driver.findElement(By.id("entry-login")).click();
	}
	
	private void findElements() {
		driver.findElement(By.id("_22_1termCourses_noterm")).findElements(By.tagName("a")).get(0).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public OperaOptions getOptions() {
		return options;
	}

	public void setOptions(OperaOptions options) {
		this.options = options;
	}
	
}
