package com.google.translate.StepDef;

import com.google.translate.pages.GoogleTranslate_Page;
import com.google.translate.Utillity.Driver;
import com.google.translate.Utillity.ReaderUtility;

import io.cucumber.java.en.*;
import org.junit.Assert;


public class Google_Translate {
    GoogleTranslate_Page gT = new GoogleTranslate_Page();

    @Given("User login into Google Translate Application {string}")
    public void User_login_into_google_translate_application(String url) {
        gT.login(url);
    }

    @Then("User should be successfully logged into the application")
    public void User_should_be_successfully_logged_into_the_application() {
        Assert.assertEquals("Google Translate", Driver.getDriver().getTitle());
    }

    @Then("User select {string} from the drop-down menu on the left")
    public void User_select_from_the_drop_down_menu_on_the_left(String string) {
        gT.selectSourceLanguage(ReaderUtility.read(string));
    }

    @Then("User verify the {string} displayed on the left side")
    public void User_verify_the_displayed_on_the_left_side(String string) {
       gT.sourceLanguageSelectedCorrectly(string);
    }

    @Then("User select {string} from the drop-down menu on the right")
    public void User_select_from_the_drop_down_menu_on_the_right(String string) {
       gT.selectTranslationLanguage(ReaderUtility.read(string));
    }

    @Then("User verify the {string} displayed on the right side")
    public void User_verify_the_displayed_on_the_right_side(String string) {
       gT.transationLanguageSelectedCorrectly(string);
    }

    @When("User enter the {string} in the input field on the left")
    public void User_enter_the_in_the_input_field_on_the_left(String string) {
        gT.enterText(string);
    }

    @Then("The {string} should display as expected")
    public void the_should_display_as_expected(String string) {
        Assert.assertEquals(ReaderUtility.read(string), gT.responseText());
    }

    @Then("User click swap languages button")
    public void User_click_swap_languages_button() {
        gT.clickSwapLanguage();
    }

    @Then("User verify the result")
    public void User_verify_the_result() {
        System.out.println(gT.responseText());
    }

    @Then("User cleared the input field")
    public void User_cleared_the_input_field() {
       gT.clearInputField();
    }

    @Then("User verify that input is empty")
    public void User_verify_that_input_is_empty() {
        Assert.assertTrue(gT.inputFieldIsEmpty());
    }

    @Then("User click <select input tool> button and select <screen keyboard>")
    public void User_click_button_and_select() {
       gT.selectInput();
    }

    @Then("User enter <Hi> to input field")
    public void User_enter_to_input_field() {
      gT.typeHi();
    }

    @Then("User verify that {string} is displayed in the input field")
    public void User_verify_that_is_displayed_in_the_input_field(String string) {
        Assert.assertEquals(string, gT.inputText());
    }

}
