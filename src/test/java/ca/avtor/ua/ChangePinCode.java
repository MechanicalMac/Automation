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
public class ChangePinCode {
    @Test
    @FileParameters(value = "src/test/resources/resourcesPinCode.csv", mapper = CsvWithHeaderMapper.class)
    public void changePinCode(String currentPin, String newPin, String confirmNewPin) throws InterruptedException {
        String url = "http://ca.avtor.ua";
        ChromeDriver chromeDriver = new Driver().getDriverInstance();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        chromeDriver.get(url);
        WebElement deviceList = chromeDriver.findElementByXPath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/nav/a[2]");
        deviceList.click();
        WebElement device = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div/div/div[1]")));
        device.click();
        Thread.sleep(1000);
        WebElement changePinCodeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div/div[5]/div/div/nav/a[3]")));
        changePinCodeButton.click();
        WebElement currentPinInput = chromeDriver.findElementById("currentPin");
        currentPinInput.sendKeys(currentPin);
        WebElement newPinInput = chromeDriver.findElementById("newPin");
        newPinInput.sendKeys(newPin);
        WebElement confirmNewPinInput = chromeDriver.findElementById("newPin2");
        confirmNewPinInput.sendKeys(confirmNewPin);
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[5]/div/div/div/div[3]/div/div/button")));
        confirmButton.click();
        WebElement modalWindowChangePinCodeSuccessful = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[1]")));
        chromeDriver.quit();
    }
}