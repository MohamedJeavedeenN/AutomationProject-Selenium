package New.AutomationProject;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



   /*
   * Author:Mohamed
   * Description:Finding Hospitals
   */

public class HomePage {
    public static WebDriver driver = null;
    public static Properties prop = null;
    public WebDriverWait wait;
	
	/*
	 * Description:Invoke MultiBrowsers Execution
    */
    public void invokeBrowsers(String browserName) {
    	
    	//Invoking MultiBrowser
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + "\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

 
        //Property File
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream file = new FileInputStream(System.getProperty("user.dir")
                        + "\\resources\\PropertyFile\\config.Properties");
                prop.load(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
     /*
      * Description:Open the URL
      */
     public void openURL(String websiteURLKey)  {
    	 
    	//Open the Url
        driver.get(prop.getProperty(websiteURLKey));
    }
    
     /*
      * Description:Enter the preffered City.
      */
    public void clickBox() {
    	try {
    	//Search the hospital based on city Bangalore
        PageFactory.initElements(driver, PomClass.class);
        PomClass.searchBox.click();
        PomClass.crossIcon.click();
        PomClass.searchBox.sendKeys("Bangalore");
        PomClass.city.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	}
        catch(Exception e) {
        	PomClass.crossIcon.click();
            PomClass.searchBox.sendKeys("Bangalore");
            System.out.println(e.getMessage());
        }
    	
        	
        }
    
    /*
     * Description: Select The type 'Hospital in Dropdown'.
     */
    public void clickHospital() throws InterruptedException {
    	
    	// Hover to next search box and type hospital
        PageFactory.initElements(driver, PomClass.class);
        PomClass.hospitalSearch.click();
        PomClass.hospitalSearch.sendKeys("Hospital");
        PomClass.hospital.click();
        Thread.sleep(3000);
    }
    
    /*
     * Description:Check The filters patient wants
     */
    public void filterCheck() throws InterruptedException {
    	
    	//Check the Filters box
        PageFactory.initElements(driver, PomClass.class);
        PomClass.check.click();
        Thread.sleep(3000);
        PageFactory.initElements(driver, PomClass.class);
        PomClass.check2.click();
        Thread.sleep(3000);
    }
    /*
     * Description:Check MOre filters in All filters button
     */
 
    public void allFilters() throws InterruptedException {
    	 
    	//Check the more Filters
        PageFactory.initElements(driver, PomClass.class);
        PomClass.filter.click();
        Thread.sleep(3000);
    
        PageFactory.initElements(driver, PomClass.class);
        PomClass.filter1.click();
        Thread.sleep(3000);

 

        PageFactory.initElements(driver, PomClass.class);
        PomClass.filter.click();
        Thread.sleep(3000);
        
        PageFactory.initElements(driver, PomClass.class);
        PomClass.filter2.click();
        Thread.sleep(3000);
    }
    
    /*
     * Description:Get the Hospitals List and print in console
     */
    public void hospitalLinks() throws InterruptedException {
    	
    	//After applying all Filters get the list of hospital name
        List<WebElement> clist = driver.findElements(By.xpath("//h2[@class='u-title-font u-c-pointer u-bold']"));
        System.out.println("The Hospital Names:");
        
        
        for (int list = 0; list <=7; list++) {
            System.out.println(" " + clist.get(list).getText());
            Thread.sleep(3000);
        }
    }

    
    /*
     * Description:Get The Top City list in Diagnostics page
     */
    public void diagnosticsPage() throws InterruptedException {
        
    	//Navigate to Diagnostic Page
        PageFactory.initElements(driver, PomClass.class);
        PomClass.diagnostics.click();
        Thread.sleep(3000);
        
    }
    
    public void topCities() {
    	
        List<WebElement> clist = driver
                .findElements(By.xpath("//div[@class='u-margint--standard o-f-color--primary']"));
        System.out.println("The Top cities:");
        for (int list = 0; list <= 4; list++) {
            System.out.println(" " + clist.get(list).getText());


        }
    }

 
    /*
     * Description:Filling invalid details using Apache POI
     */
    public void corporateWellness() throws IOException, InterruptedException {
    	
    	//Corporate Wellness page form filling
    	driver.navigate().back();
		driver.findElement(By.xpath("//span[@class='u-d-item up-triangle' and contains(text(),'For Providers')]"))
				.click();
		driver.findElement(By.linkText("Corporate wellness")).click();
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)){
				//naviagate to childWindow
				driver.switchTo().window(childWindow);
				
				 //Applying POI to read the Excel data
				  File src=new File("C:\\eclipse\\Final\\Excel\\Book 3.xlsx");
	              FileInputStream stream =new FileInputStream(src);
	              XSSFWorkbook book=new XSSFWorkbook(stream);
	              XSSFSheet sheet=book.getSheet("Sheet1");
	               
	           
	              String Your_name=sheet.getRow(0).getCell(0).getStringCellValue();
	              String org_name=sheet.getRow(0).getCell(1).getStringCellValue();
	              String Your_mail=sheet.getRow(0).getCell(2).getStringCellValue();
	              long Your_phone=(int) sheet.getRow(0).getCell(3).getNumericCellValue();
	              Thread.sleep(5000);
	              String phone=String.valueOf(Your_phone);
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				  driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Your_name);
				  driver.findElement(By.id("organization_name")).sendKeys(org_name);
				  driver.findElement(By.id("official_email_id")).sendKeys(Your_mail);
				  driver.findElement(By.id("official_phone_no")).sendKeys(phone);
				  driver.findElement(By.id("button-style")).click();
				  Thread.sleep(5000);

	               
				  	 
			}
		
		}
    }
	
   
    /*
     * Description: Close the Browser
     */
    public void quitBrowser(){
        // quit browser
        driver.quit();
    }
    
}
