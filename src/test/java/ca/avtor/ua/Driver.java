package ca.avtor.ua;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class Driver {
    private ChromeDriver driver;
    Driver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    ChromeDriver getDriverInstance(){
        return driver;
    }
}
