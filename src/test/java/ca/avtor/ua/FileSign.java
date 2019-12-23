package ca.avtor.ua;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(JUnitParamsRunner.class)
public class FileSign {
    @Test
    @FileParameters(value = "src/test/resources/PathToSignFiles.csv", mapper = CsvWithHeaderMapper.class)
    public void CheckFileSign(String path, String pinCode) throws InterruptedException {
        ChromeDriver chromeDriver = new Driver().getDriverInstance();
        String url = "http://ca.avtor.ua/";
        chromeDriver.get(url);
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        WebElement signAndCheck = chromeDriver.findElementByXPath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/nav/a[3]");
        signAndCheck.click();
        WebElement refreshButton = chromeDriver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div[1]/div/div/div[1]/button");
        refreshButton.click();
        WebElement inputFileSource = chromeDriver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div[1]/div/div/div[2]/label/span/input");
        inputFileSource.sendKeys(path);
        Thread.sleep(1000);
        WebElement inputPinCode = chromeDriver.findElementById("signPin");
        inputPinCode.sendKeys(pinCode);
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("spinnerWrapper")));
        confirmButton.click();
        WebElement modalWindowSignSuccessful = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[1]")));
        chromeDriver.quit();
    }
}
