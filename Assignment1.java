package WU_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment1 {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","\"C:\\Users\\10714379\\Downloads\\chromedriver_win32\\chromedriver.exe\"");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        List<WebElement> link = driver.findElements(By.tagName("a"));
        System.out.println("No of links are:"+link.size());
//
        for(WebElement element :link){
            System.out.println(element.getText());
//
        }
        System.out.println("List of link:"+link.parallelStream().map(ele -> ele.getText()));

//        **********************************************************************************
//        By using Stream
        List<String> collectList =link.stream().filter(ele -> !ele.getText().equals("")).
                map(ele -> ele.getText()).collect(Collectors.toList());
        collectList.forEach(ele -> System.out.println(ele));
//
//        by using lambda expression
        link.forEach(element -> System.out.println(element.getText()));



    }
}
