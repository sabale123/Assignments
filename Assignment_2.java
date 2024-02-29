package WU_Assignments;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment_2 {
    public static void main(String[] args) throws IOException {


WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://money.rediff.com/losers/bse/daily/groupall");
List<WebElement> elements =driver.findElements(By.xpath("//table[@class=\"dataTable\"]//tr//td[1]"));

List<WebElement> element2 =driver.findElements(By.xpath("//table[@class=\"dataTable\"]//tr//td[4]"));
        HashMap<String ,String> hash = new HashMap<String, String>();
        int companySize =elements.size();
        for(int i=0;i<companySize;i++){
            hash.put(elements.get(i).getText(),element2.get(i).getText());

        }
        System.out.println(hash);
String companyName="";
String price="";

HashMap<String,String> map = new HashMap<>();
        FileInputStream file = new FileInputStream("C:\\Users\\10714379\\IdeaProjects\\maven\\src\\test\\java\\WU_Assignments\\company Doc.xlsx");
        Workbook book = WorkbookFactory.create(file);
        Sheet sheet = book.getSheetAt(0);
        int LastRowCount = sheet.getLastRowNum();
        Row raw = sheet.getRow(0);
        int lastcolumn = raw.getLastCellNum();
        for(int i=0;i<=LastRowCount;i++){
            raw = sheet.getRow(i);
            for(int j=0;j<lastcolumn;j++){
                Cell call = raw.getCell(j);
                if(j==0){
                    companyName = call.toString();
                }else {
                    price= call.toString();
                }
            }
            map.put(companyName,price);
        }
        for(Map.Entry<String,String> temp:map.entrySet()){
            String cmpName = temp.getKey();
            String xlsPrice = temp.getValue();
            String webPrice = hash.get(cmpName);
            if(xlsPrice != webPrice){
                System.out.println("value on web incorrect");
            }
        }






}
}
