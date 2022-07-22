package com.google.translate.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.translate.Utillity.BrowserUtility;
import com.google.translate.Utillity.Driver;
import com.google.translate.Utillity.ReaderUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTranslate_Page {

    @FindBy(xpath = "(//button[starts-with(@class, VfPpkd-Bz112c-LgbsSe)]/span[@class='zQ0atf'])[1]")
    private WebElement sourceMenu;

    @FindBy(xpath = "(//button[starts-with(@class, VfPpkd-Bz112c-LgbsSe)]/span[@class='zQ0atf'])[2]")
    private WebElement translationMenu;

    @FindBy(xpath = "(//div[@class='vSUSRc']/div[@class='F29iQc'])[2]/div[@class='qSb8Pe']/div[@class='Llmcnf']")
    private List<WebElement> sourceLanguage;

    @FindBy(xpath = "(//div[@class='vSUSRc']/div[@class='F29iQc'])[3]/div[@class='qSb8Pe']/div[@class='Llmcnf']")
    private List<WebElement> tranlationLanguage;

    @FindBy(xpath = "(//div[@class='akczyd'])[1]//button[contains(@class, 'VfPpkd-AznF2e-OWXEXe-auswjd')]")
    private WebElement source;

    @FindBy(xpath = "(//div[@class='akczyd'])[2]//button[contains(@class, 'VfPpkd-AznF2e-OWXEXe-auswjd')]")
    private WebElement translation;

    @FindBy(xpath = "//div[@class='QFw9Te']/textarea[@class='er8xn']")
    private WebElement sourceText;

    @FindBy(xpath = "//span[@class='VIiyi']/span/span[@class='Q4iAWc']")
    private WebElement translationText;

    @FindBy(xpath = "(//button[starts-with(@class, 'VfPpkd-Bz112c-LgbsSe')])[2]/div[@class='VfPpkd-Bz112c-RLmnJb']")
    private WebElement swapLanguage;


    @FindBy(xpath = "(//div[@class='DVHrxd']/div/div/span)[1]/button/i[starts-with(@class, 'material-icons-extended')]")
    private WebElement clearText;

    @FindBy(xpath = "//span[@class='ita-kd-inputtools-div']/div/a[contains(@class, 'ita-kd-dropdown')]/span")
    private WebElement inputTool;

    @FindBy(xpath = "//ul[@class='ita-kd-dropdown-menu']/li[2]/span[3]")
    private WebElement keyboardTool;

    @FindBy(xpath = "(//button[@id='K16'])[1]/span[starts-with(@class, 'vk-cap')]")
    private WebElement shiftKey;

    @FindBy(xpath = "//button[@id='K72']/span[starts-with(@class, 'vk-cap')]")
    private WebElement hKey;

    @FindBy(xpath = "//button[@id='K73']/span[starts-with(@class, 'vk-cap')]")
    private WebElement iKey;


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    public GoogleTranslate_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String url) {
        Driver.getDriver().get(url);
    }

    public void selectSourceLanguage(String language) {

        js.executeScript("arguments[0].click();", sourceMenu);

        for (WebElement each : sourceLanguage) {
            if (each.getText().contains(language)) {
                js.executeScript("arguments[0].click();", each);
            }
        }

    }


    public void selectTranslationLanguage(String language) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", translationMenu);

        for (WebElement each : tranlationLanguage) {
            if (each.getText().contains(ReaderUtility.read("translation language"))) {
                js.executeScript("arguments[0].click();", each);
            }
        }

    }

    public void sourceLanguageSelectedCorrectly(String language) {
        Assert.assertEquals(ReaderUtility.read(language).toLowerCase(), source.getText().toLowerCase());
    }

    public void transationLanguageSelectedCorrectly(String language) {
        Assert.assertEquals(ReaderUtility.read(language).toLowerCase(), translation.getText().toLowerCase());
    }

    public void enterText(String text) {
        BrowserUtility.waitFor(3);
        sourceText.sendKeys(ReaderUtility.read(text));
    }

    public String responseText() {
        BrowserUtility.waitFor(2);
        return translationText.getText();
    }

    public void clickSwapLanguage(){
        js.executeScript("arguments[0].click();", swapLanguage);
    }

    public void clearInputField(){
        BrowserUtility.waitFor(1);
        js.executeScript("arguments[0].click();", clearText);
    }

    public boolean inputFieldIsEmpty(){
        BrowserUtility.waitFor(1);
        return sourceText.getText().isEmpty();
    }

    public void selectInput(){
        BrowserUtility.waitFor(1);
        js.executeScript("arguments[0].click();", inputTool);
        BrowserUtility.waitFor(1);
        js.executeScript("arguments[0].click();", keyboardTool);
    }

    public void typeHi(){
        BrowserUtility.waitFor(1);
        js.executeScript("arguments[0].click();", shiftKey);
        js.executeScript("arguments[0].click();", hKey);
        js.executeScript("arguments[0].click();", iKey);
    }

    public String inputText() {
        BrowserUtility.waitFor(2);
        return sourceText.getAttribute("value");
    }

}
