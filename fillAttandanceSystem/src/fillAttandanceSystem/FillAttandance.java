package fillAttandanceSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillAttandance {

	public static void main(String[] args) {
	/*	System.setProperty("webdriver.chrome.driver", "/cdacAttandance/fillAttandanceSystem/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://pramani.cdac.in/pramANi/UI/Login?module=LDAP&realm=%2F&goto=https%3A%2F%2Fihrms.cdac.in%3A443%2F&gx_charset=UTF-8");
		//
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String title = driver.getTitle();
		driver.findElement(By.id("IDToken1")).sendKeys("arunendra");
		driver.findElement(By.id("IDToken2")).sendKeys("Welcome@123");
		driver.findElement(By.name("Login.Submit")).submit();
		WebElement el =driver.findElements(By.xpath("//ul[@class='sf-menu sf-js-enabled']/li/ul/li/a")).get(9);
		String a = "window.open('"+el.getAttribute("href")+"','_blank');";  // replace link with your desired link
		((JavascriptExecutor)driver).executeScript(a);
	    
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		driver.findElement(By.name("txt_entry_date")).sendKeys("14/11/2019");
		driver.findElement(By.name("cmb_entry_hour")).sendKeys("09");
		driver.findElement(By.name("cmb_entry_min")).sendKeys("30");
		driver.findElement(By.name("cmb_exit_hour")).sendKeys("17");
		driver.findElement(By.name("cmb_exit_min")).sendKeys("30");		
		Select reason=new Select(driver.findElement(By.name("ddlEntrySlipReason")));
		reason.selectByVisibleText("Other");
		driver.findElement(By.name("entrySlipReason")).sendKeys("BSID Client Location");
		*/
		File file=new File("/cdacAttandance/fillAttandanceSystem/driver/testOdxls.xls");
		try {
			if(!file.exists()) {
				System.out.println("xls File does't exist");
				return;
			}
			Workbook workbook=new HSSFWorkbook(new FileInputStream(file));
			Sheet sheet =workbook.getSheet("Sheet0");
			Row row = sheet.getRow(0);
			row.getCell(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//System.out.println(el.getAttribute("href"));
		
		//driver.close();
	}

}
