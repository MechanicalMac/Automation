//package Login;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import junitparams.FileParameters;
//import junitparams.JUnitParamsRunner;
//import junitparams.mappers.CsvWithHeaderMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//@RunWith(JUnitParamsRunner.class)
//public class Login {
//    @Test
//    @FileParameters(value = "src\\test\\resources\\resources.csv", mapper = CsvWithHeaderMapper.class)
//    public void loginUser(String name, String password) {
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver chromeDriver = new ChromeDriver();
//        String url = "http://av-avtor-srv:8082/";
//        chromeDriver.get(url);
//        WebElement nameInput = chromeDriver.findElementByName("adLogin");
//        nameInput.sendKeys(name);
//        WebElement passwordInput = chromeDriver.findElementByName("adPassword");
//        passwordInput.sendKeys(password);
//        WebElement confirmButton = chromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/button");
//        confirmButton.click();
//    }
//}
//
