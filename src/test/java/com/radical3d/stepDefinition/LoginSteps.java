package com.radical3d.stepDefinition;

import com.radical3d.factory.BaseClass;
import com.radical3d.pageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {
    LoginPage loginPage;
    @Given("user enters the login page")
    public void user_enters_the_login_page(){
        BaseClass.getWebDriver().get(BaseClass.getProperties().getProperty("url"));
        loginPage = new LoginPage();
    }
    @When("user enter the username {string}")
    public  void user_enter_the_username(String username){
        loginPage.sendKeysUserNameInput(username);
    }
    @When("user enter the password {string}")
    public  void user_enter_the_password(String pass){
        loginPage.sendkeysPassInput(pass);
    }
    @When("user click the Login Button")
    public  void user_click_the_login_button(){
        loginPage.clickLoginbutton();
    }
    @Then("user login succesfully")
    public void user_login_succesfully(){
        String loginPageURL = BaseClass.getProperties().getProperty("url");
        Assertions.assertNotEquals(loginPageURL, BaseClass.getWebDriver().getCurrentUrl());
    }
    @Then("user sees an error message for locked user")
    public void user_sees_an_error_message_for_locked_user(){
        //Given
        String expected_message = "Epic sadface: Sorry, this user has been locked out.";
        //When
        String error_message = loginPage.getErrorMessageDiv().getText();
        //Then
        Assertions.assertEquals(expected_message, error_message);

    }

}
