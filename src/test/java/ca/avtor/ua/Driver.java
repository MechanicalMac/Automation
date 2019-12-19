package ca.avtor.ua;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private ChromeDriver driver;
    Driver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public ChromeDriver getDriverInstance(){
        return driver;
    }
}
