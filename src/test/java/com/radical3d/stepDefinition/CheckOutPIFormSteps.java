package com.radical3d.stepDefinition;

import com.radical3d.pageObject.CheckOutPIFormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.Map;

public class CheckOutPIFormSteps {

    CheckOutPIFormPage piForm = new CheckOutPIFormPage();

    @Then("user fill in the personal information form data")
    public void user_fill_in_personal_information_form_data(DataTable data){
        Map<String,String> datamap =data.asMap();

        System.out.println(datamap);

        piForm.fillInPIForm(
                datamap.get("first_name"),
                datamap.get("last_name"),
                datamap.get("zip_code")
        );
    }

    @Then("click continue chekcout button")
    public void click_continue_checkout_button(){
        this.piForm.clickContinueCheckout();
    }
}
