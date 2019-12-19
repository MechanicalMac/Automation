/*package Certificate;

import Login.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnitParamsRunner.class)
public class CreateCertificate {
    @Test
    @FileParameters(value = "src\\test\\resources\\resources.csv", mapper = CsvWithHeaderMapper.class)
    public void generateCertificate(String name, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        String url = "http://ca.avtor.ua/";
        chromeDriver.get(url);
        WebElement inputName = chromeDriver.findElementByName("adLogin");
        inputName.sendKeys(name);
        WebElement inputPassword = chromeDriver.findElementByName("adPassword");
        inputPassword.sendKeys(password);
        WebElement confirmButton = chromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/button");
        confirmButton.click();
        WebElement deviceButton = chromeDriver.findElementByXPath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/nav/a[2]");
        deviceButton.click();
        Thread.sleep(5000);
    }
} */
