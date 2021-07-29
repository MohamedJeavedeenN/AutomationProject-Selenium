package New.AutomationProject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * Applying Page Object Model 
 */
public class PomClass {

    //Home Page
    @FindBy(xpath="//input[@placeholder='Search location']")
    public static WebElement searchBox;
    @FindBy(xpath="//*[@class='icon-ic_cross_solid']")
    public static WebElement crossIcon;
    @FindBy(xpath="//div[normalize-space()='Bangalore']")
    public static WebElement city;
    @FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
    public static WebElement hospitalSearch;
    @FindBy(xpath="//div[normalize-space()='Hospital']")
    public static WebElement hospital;
    
    //Hospital Page
    @FindBy(xpath="//span[contains(text(),'Open 24X7')]")
    public static WebElement check;
   
    @FindBy(xpath="//label[@for='Accredited0']")
    public static WebElement check2;
   
    @FindBy(xpath="//i[@class='u-transition--transform u-d-inlineblock icon-ic_dropdown']")
    public static WebElement filter;
   
    @FindBy(xpath="//span[contains(text(),'Has Parking')]")
    public static WebElement filter1;
   
    @FindBy(xpath="//span[contains(text(),'Cafeteria')]")
    public static WebElement filter2;
   
    @FindBy(xpath="//h2[@class='u-title-font u-c-pointer u-bold']]")
    public static WebElement clist ;
    
    @FindBy(xpath="/h2[@class='u-title-font u-c-pointer u-bold']")
    public static WebElement hospitalList;
    
    //Diagnostics Page
    @FindBy(xpath="//div[@class='product-tab__title' and contains(text(),'Diagnostics')]")
    public static WebElement diagnostics;
   @FindBy(xpath="//div[@class='u-margint--standard o-f-color--primary']")
    public static WebElement diagnostics2;
    
    

}
 
