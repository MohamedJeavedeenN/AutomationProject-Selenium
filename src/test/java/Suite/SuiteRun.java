package Suite;



import java.io.IOException;
import org.testng.annotations.Test;

import New.AutomationProject.HomePage;


public class SuiteRun  extends HomePage{
	
	 @Test(groups="Suite Run")
	    public void browserRun() {
	        invokeBrowsers("firefox");
	        openURL("websiteURLKey");
	        
	    }
	    @Test(groups="SuiteRun",dependsOnMethods="browserRun")
	    public void homepage() throws Exception{
	         clickBox();
	         clickHospital();
	    }
	    @Test(groups="SuiteRun", priority=1)
	    public void hospitalPage() throws InterruptedException {
	        
	         filterCheck();
	         allFilters();
	    }
	   @Test(groups="SuiteRun", priority=2)
	    public void hospitalnames() throws InterruptedException {
	         hospitalLinks();
	    }
	   
	    @Test (groups="SuiteRun", priority=3)
	    public void diagnostics() throws InterruptedException {
	         diagnosticsPage();
	         topCities();
	    }
	    
	    
	    @Test(groups="SuiteRun", priority=4)
	    public void corporate() throws IOException, InterruptedException{
	         corporateWellness();
	         
	    }
	  
	     
	    @Test (groups="SuiteRun", priority=5)
	    public void quit() {
	         quitBrowser();
	    }
}


