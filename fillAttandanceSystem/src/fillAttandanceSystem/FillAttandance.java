package fillAttandanceSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class FillAttandance {

	public static void main(String[] args) {
		List<String> errList = new ArrayList<String>();
		Scanner sc=new Scanner(System.in);		
		
		System.out.print("Enter User Name: ");
		String userName=sc.next().trim(); 
		System.out.print("\nEnter Password: ");
		String password =sc.next().trim();
		

		System.setProperty("webdriver.chrome.driver", "/cdacAttandance/fillAttandanceSystem/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://pramani.cdac.in/pramANi/UI/Login?module=LDAP&realm=%2F&goto=https%3A%2F%2Fihrms.cdac.in%3A443%2F&gx_charset=UTF-8");

		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElement(By.id("IDToken1")).sendKeys(userName);
		driver.findElement(By.id("IDToken2")).sendKeys(password);
		driver.findElement(By.name("Login.Submit")).submit();
		WebElement el = driver.findElements(By.xpath("//ul[@class='sf-menu sf-js-enabled']/li/ul/li/a")).get(9);
		String a = "window.open('" + el.getAttribute("href") + "','_blank');"; // replace link with your desired link
		((JavascriptExecutor) driver).executeScript(a);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		File file = new File("/cdacAttandance/fillAttandanceSystem/driver/testOdxls.xls");
		try {
			if (!file.exists()) {
				System.out.println("xls File does't exist");
				return;
			}
			Workbook workbook = new HSSFWorkbook(new FileInputStream(file));
			Sheet sheet = workbook.getSheet("Sheet0");
			Row row;

			WebDriverWait wait = new WebDriverWait(driver, 30);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_entry_date")));
//				System.out.println(i+" "+row.getCell(0).toString());
				driver.findElement(By.name("txt_entry_date")).sendKeys(row.getCell(0).toString());

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmb_entry_hour")));
//				System.out.println(i+" "+row.getCell(1).toString().split(":")[0]);
				driver.findElement(By.name("cmb_entry_hour")).sendKeys(row.getCell(1).toString().split(":")[0]);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmb_entry_min")));
//				System.out.println(i+" "+row.getCell(1).toString().split(":")[1]);
				driver.findElement(By.name("cmb_entry_min")).sendKeys(row.getCell(1).toString().split(":")[1]);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmb_exit_hour")));
//				System.out.println(i+" "+row.getCell(2).toString().split(":")[0]);
				driver.findElement(By.name("cmb_exit_hour")).sendKeys(row.getCell(2).toString().split(":")[0]);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmb_exit_min")));
//				System.out.println(i+" "+row.getCell(2).toString().split(":")[1]);
				driver.findElement(By.name("cmb_exit_min")).sendKeys(row.getCell(2).toString().split(":")[1]);

				if (row.getCell(3).toString().equalsIgnoreCase("ID card not issued")) {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddlEntrySlipReason")));
//					System.out.println(i+" "+"select if");
					Select reason = new Select(driver.findElement(By.id("ddlEntrySlipReason")));
					// reason.selectByIndex(4);
					reason.selectByValue("5");
				} else {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddlEntrySlipReason")));
//					System.out.println(i+" "+"select else");
					Select reason = new Select(driver.findElement(By.id("ddlEntrySlipReason")));
					reason.selectByVisibleText("Other");

					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("entrySlipReason")));
//					System.out.println(i+" "+row.getCell(3).toString());
					driver.findElement(By.name("entrySlipReason")).sendKeys(row.getCell(3).toString());
				}

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Save232")));
//				System.out.println(i+" "+row.getCell(0).toString());
				driver.findElement(By.id("Save232")).click();
				// driver.wait(10);
				try {
					WebDriverWait wait1 = new WebDriverWait(driver, 2);
					wait1.until(ExpectedConditions.alertIsPresent());

					Alert alert = driver.switchTo().alert();
					alert.accept();
					String str = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
					System.out.println("Row: " + i + " Completed");

				} catch (Exception e) {
					String str = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
					errList.add(row.getCell(0).toString());
					driver.findElement(By.id("Reset")).click();
					System.out.println("Row: " + i + " Failed");
				}
			}
			System.out.println();
			errList.stream().forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
