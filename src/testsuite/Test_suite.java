package testsuite;

import basetest.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Test_suite extends BaseTest
{
    String baseurl = "https://www.amazon.co.uk/";

    String expectedText,actualText;
    @Before
    public void setUp()
    {
        openBrowser(baseurl);
    }

    @Test
    public void amazon_test()
    {
        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        //3. Click on the checkbox brand Dell on the left side.
        driver.findElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']")).click();

        //4. Verify that the  30(May be different) products are displayed on the page.
        List<WebElement> elements = driver.findElements(By.xpath("//h2"));
        int elementsCount = elements.size();
        System.out.println("Total Number of Elements : " + elementsCount);


        //5. Print all product names in the console.
        List<WebElement> resultList = driver.findElements(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));
        List<String> list = new ArrayList<>();
        System.out.println(resultList.size());
        for (WebElement web:resultList)
        {
            list.add(web.getText());
            System.out.println(web.getText());
        }



        //6. Click on the product name 'Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14" Ful HD Windows 10 Pro Laptop - CT22R
        //Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14" Ful HD Windows 10 Pro Laptop - CT22R'
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB ')]")).click();


    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
