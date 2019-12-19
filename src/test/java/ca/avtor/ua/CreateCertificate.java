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

public class CreateCertificate {
    @Test
    @FileParameters(value = "/Users/mechanical_mac/Desktop/Automation/src/test/resources/resources.csv", mapper = CsvWithHeaderMapper.class)
    public void generateCertificate(String surname, String name, String city) throws InterruptedException {
        ChromeDriver chromeDriver = new Driver().getDriverInstance();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 50);
        String url = "http://ca.avtor.ua";
        String pinCode = "12345678";
        String keyAlgorithm = "PKCS#1 RSA";
        String keyLength = "2048 bit";
        chromeDriver.get(url);
        WebElement deviceList = chromeDriver.findElementByXPath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/nav/a[2]");
        deviceList.click();
        WebElement device = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div/div/div[1]")));
        device.click();
        Thread.sleep(1000);
        WebElement generateCertificateButton = chromeDriver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[5]/div/div/nav/a[2]");
        generateCertificateButton.click();
        WebElement inputName = chromeDriver.findElementByName("SN");
        inputName.sendKeys(surname);
        WebElement inputLastName = chromeDriver.findElementByName("G");
        inputLastName.sendKeys(name);
        WebElement inputCity = chromeDriver.findElementByName("ST");
        inputCity.sendKeys(city);
        WebElement keyAlgorithmSelect = chromeDriver.findElementByName("AlgOid");
        keyAlgorithmSelect.sendKeys(keyAlgorithm);
        WebElement keyLengthSelect = chromeDriver.findElementByName("KeyLen");
        keyLengthSelect.sendKeys(keyLength);
        WebElement pinCodeInput = chromeDriver.findElementByName("certPin");
        pinCodeInput.sendKeys(pinCode);
        WebElement generateButton = chromeDriver.findElementByClassName("spinnerWrapper");
        generateButton.click();
        WebElement generateSuccessfulModalWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
        WebElement closeButton = chromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[2]/button");
        closeButton.click();
        chromeDriver.quit();
    }
}
