import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.baseTest;

public class ProductSearchTest extends baseTest {

    @Test
    public void testProductSearchOnAmazonAndFlipkart() {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Open Amazon.in
        driver.get("https://www.amazon.in");
        searchAndCaptureProductDetails("Titan watch");

        // Open Flipkart.in
        //driver.get("https://www.flipkart.com");
        //searchAndCaptureProductDetails("Titan watch");
    }

    private void searchAndCaptureProductDetails(String productName) {
        // Locate the search input element and enter product name
    	try
    	{
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(productName);
        searchBox.submit();

        //FluentWait<WebDriver> wait = null;
		// Wait for search results to load
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Titan Crest Premium Smart Watch|1.43\" AMOLED Displ')]"));

        // Capture product details
        String productNameText = firstProduct.getText();
        String productPriceText = driver.findElement(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-price-whole'][normalize-space()='5,994']")).getText();
        WebElement productLinkElement = firstProduct.findElement(By.xpath("./ancestor::a"));
        String productLink = productLinkElement.getAttribute("href");

        // Print or log product details
        System.out.println("Product Name: " + productNameText);
        System.out.println("Product Price: " + productPriceText);
        System.out.println("Product Link: " + productLink);
        
     // Click on the first product to view details
        firstProduct.click();

        // Wait for the "Add to Cart" button and click on it
       // WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        //addToCartButton.click();

        System.out.println("Clicked on Add to Cart button");
        
        WebElement buy = driver.findElement(By.className("a-button-input"));
        buy.click();
        Thread.sleep(3000);
        System.out.println("proceed to checkout clicked");
        
        
     
        
    	} catch (Exception e) {
            e.printStackTrace();

         
    }
}
}
