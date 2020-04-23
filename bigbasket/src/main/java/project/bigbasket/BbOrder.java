package project.bigbasket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BbOrder {
    
	public static void main( String[] args ) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver1.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");
        
        //DesiredCapabilities capable = new DesiredCapabilities();
        //capable.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        //ChromeOptions option = new ChromeOptions();
        //option.addArguments("--disable-notifications");
        //option.merge(capable);
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        //1) Go to https://www.bigbasket.com/
        driver.get("https://www.bigbasket.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        
        //2) mouse over on  Shop by Category 
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        Actions act = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shop by Category')]")));
        act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Shop by Category')]"))).perform();
        Thread.sleep(3000);
        
        
        //3)Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 
        act.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Foodgrains, Oil & Masala')])[2]"))).perform();
        act.pause(3000);
        act.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Rice & Rice Products')])[2]"))).perform();
        act.pause(3000);
        
        
        //4) Click on Boiled & Steam Rice
        act.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Boiled & Steam Rice')])[2]"))).click().perform();
        Thread.sleep(3000);
        
        //JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,800)");
        
        //5) Choose the Brand as bb Royal
        driver.findElement(By.xpath("(//span[contains(text(),'bb Royal')])[1]")).click();
        Thread.sleep(3000);
        
        
        //6) Go to Ponni Boiled Rice - Super Premium 
        driver.findElement(By.xpath("//a[text()='Ponni Boiled Rice - Super Premium']//parent::div//following-sibling::div/div/span/button")).click();
        Thread.sleep(3000);
        	//select 5kg bag from Dropdown      
        driver.findElement(By.xpath("//a[text()='Ponni Boiled Rice - Super Premium']//parent::div/following-sibling::div/div/span/ul/li[1]//a/span[1]")).click();
        Thread.sleep(3000);
        
        
        //7) print the price of Rice
        String priceOfRice = driver.findElement(By.xpath("//a[text()='Ponni Boiled Rice - Super Premium']//parent::div/following-sibling::div[2]/div/div/h4/span[2]/span")).getText();
        System.out.println("Ponni Boiled Rice Super Premium  price is : "+priceOfRice);
        
        
        //8) Click Add button
        driver.findElement(By.xpath("//a[text()='Ponni Boiled Rice - Super Premium']//parent::div//following-sibling::div[2]/div/div[3]/div[2]/div[2]/button")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("(//a[text()='Continue'])[1]")).click(); //TO HANDLE LOCATION POPUP
        Thread.sleep(3000);
        
        
        //9) Verify the success message displayed 
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-title']"))).getText();
        //driver.findElement(By.xpath("//div[@class='toast-title']")).getText();
        
       
        //10) Type Dal in Search field and enter
        driver.findElement(By.xpath("(//div[@class='input-group'])[1]/input")).sendKeys("Dal",Keys.ENTER);
        Thread.sleep(3000);
        
        
        //12) Go to Toor/Arhar Dal and select 2kg & set Qty 2 
        driver.findElement(By.xpath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div//following-sibling::div/div/span/button")).click();
        Thread.sleep(3000);
        
        //select 2kg & set Qty 2
        driver.findElement(By.xpath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div/following-sibling::div/div/span/ul/li[4]//a/span[1]")).click();
        Thread.sleep(3000);
        WebElement qty = driver.findElement(By.xpath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div//following-sibling::div[2]/div/div[3]/div[2]/div[1]/div/input"));
        qty.click();
        qty.clear();
        qty.sendKeys("2",Keys.ENTER);
        Thread.sleep(3000);
        
      
        
        //13) Print the price of Dal
        String priceOfDal = driver.findElement(By.xpath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div/following-sibling::div[2]/div/div/h4/span[2]/span")).getText();
        System.out.println("Toor/Arhar Dal/Thuvaram Paruppu price is : "+priceOfDal);
        
        
        //14) Click Add button
        driver.findElement(By.xpath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div//following-sibling::div[2]/div/div[3]/div[2]/div[2]/button")).click();
        Thread.sleep(3000);
        
        //15) Mouse hover on My Basket
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Basket']")));
        act.moveToElement(driver.findElement(By.xpath("//span[text()='My Basket']"))).click().build().perform();
        Thread.sleep(3000);
        

        //16) Validate the Sub Total displayed for the selected items
        String totalPrice = driver.findElement(By.xpath("//span[@qa='subTotalMB']")).getText();
        double subTotal= Double.parseDouble(totalPrice);
        System.out.println("Total cart price is : "+ subTotal);
        	
        	//Quantity of the product
        String rQuantity = driver.findElement(By.xpath("(//div[@qa='pcsMB'])[1]")).getText();
        rQuantity = rQuantity.substring(0, 1);
        double riceQuantity = Double.parseDouble(rQuantity);
        System.out.println("Rice quantity added in cart is :"+ riceQuantity);
        
        String dQuantity = driver.findElement(By.xpath("(//div[@qa='pcsMB'])[2]")).getText();
        dQuantity = dQuantity.substring(0, 1);
        double dalQuantity = Double.parseDouble(dQuantity);
        System.out.println("Dal quantity added in cart is :"+ dalQuantity);
        
        	//Price of the product added in the cart
        String riceCart = driver.findElement(By.xpath("(//span[@qa='priceMB'])[1]")).getText();
        double riceKrt = Double.parseDouble(riceCart);
        
        String dalCart = driver.findElement(By.xpath("(//span[@qa='priceMB'])[2]")).getText();
        double dalKrt = Double.parseDouble(dalCart);
        
        double riceTotal = riceQuantity * riceKrt;
        double dalTotal = dalQuantity * dalKrt;
        
        double totalKrt = dalTotal + riceTotal;
         
        if (subTotal == totalKrt) {
			System.out.println("Price is matching with the subTotal and CartTotal");
		} else {
			System.out.println("Price is not matching");
		}
        Thread.sleep(3000);
        
        
        //17) Reduce the Quantity of Dal as 1 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Basket']")));
        act.moveToElement(driver.findElement(By.xpath("//span[text()='My Basket']"))).click().build().perform();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("(//button[@qa='decQtyMB'])[2]")).click();
        Thread.sleep(3000);
        
        //18) Validate the Sub Total for the current items
        
        String totalPrice2 = driver.findElement(By.xpath("//span[@qa='subTotalMB']")).getText();
        double subTotal2 = Double.parseDouble(totalPrice2);
        System.out.println("Total cart price is : "+ subTotal2);
        Thread.sleep(3000);
        
        String reducedQty = driver.findElement(By.xpath("(//div[@qa='pcsMB'])[2]")).getText();
        reducedQty = reducedQty.substring(0, 1);
        double dalQtyReduce = Double.parseDouble(reducedQty);
        System.out.println("Dal quantity added in cart is :"+ dalQtyReduce);
        
        String dalCart2 = driver.findElement(By.xpath("(//span[@qa='priceMB'])[2]")).getText();
        double dalUpdated = Double.parseDouble(dalCart2);
        
        double dalTotalUpd = dalQtyReduce * dalUpdated;	
        double totalKrtUpd = dalTotalUpd + riceTotal;
        
        if (subTotal2 == totalKrtUpd) {
			System.out.println("Price is matching with the subTotal and CartTotal");
		} else {
			System.out.println("Price is not matching");
		}
    
        
        //19) Close the Browser
        driver.close();
    }
}
