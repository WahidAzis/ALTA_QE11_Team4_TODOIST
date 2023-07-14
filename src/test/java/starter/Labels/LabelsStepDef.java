package starter.Labels;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;

import java.io.File;

public class LabelsStepDef {
    @Steps
    LabelsAPI labelsAPI;
    @Given("Create a new personal label with valid data")
    public void createANewPersonalLabelWithValidData() {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostCreateValidLabels.json");
        labelsAPI.setPostNewLabels(json);
    }

    @When("Send POST request for a new personal label")
    public void sendPOSTRequestForANewPersonalLabel() {
        SerenityRest.when().post(LabelsAPI.POST_CREATE_LABELS);
    }

    @Given("Create a new personal label with empty body request name")
    public void createANewPersonalLabelWithEmptyBodyRequestName() {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostCreateLabelsWithEmptyBody.json");
        labelsAPI.setPostNewLabels(json);
    }

    @Given("Create a new personal label with invalid parameter special character body request name")
    public void createANewPersonalLabelWithInvalidParameterSpecialCharacterBodyRequestName() {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostCreateLabelsWithEmptyBody.json");
        labelsAPI.setPostNewLabels(json);
    }

    @Given("Create a new personal label with invalid parameter body request name")
    public void createANewPersonalLabelWithInvalidParameterBodyRequestName() {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostCreateLabelsWithEmptyBody.json");
        labelsAPI.setPostNewLabels(json);
    }

    @Given("Create a new personal label without body request")
    public void createANewPersonalLabelWithoutBodyRequest() {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostCreateLabelsWithoutBodyReq.json");
        labelsAPI.setPostNewLabels(json);
    }
/////////////////////////////////////////////////////////////
    @Given("Get a all personal label with valid {string} parameter")
    public void getAPersonalLabelWithValidParameter(String id) {
        labelsAPI.setGetLabels(id);
    }

    @When("Send GET request for get a personal label")
    public void sendGETRequestForGetAPersonalLabel() {
        SerenityRest.when().get(LabelsAPI.GET_LABELS);
    }

    @Given("Get an personal label with valid parameter {string}")
    public void getAnPersonalLabelWithValidParameter(String id) {
        labelsAPI.setGetLabels(id);
    }

    @Given("Get a personal label with invalid {} parameter")
    public void getAPersonalLabelWithInvalidParameter(String id) {
        labelsAPI.setGetLabels(id);
    }


    @Given("Get a personal label with invalid id {}")
    public void getAPersonalLabelWithInvalidId(String id) {
        labelsAPI.setGetLabels(id);
    }

    @Given("Get a personal label with key label name {}")
    public void getAPersonalLabelWithKeyLabelName(String id) {
        labelsAPI.setGetLabels(id);
    }
//////////////////////////////////////////////////
    @Given("Post update a personal with valid id {} and request body")
    public void postUpdateAPersonalWithValidIdAndRequestBody(String id) {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostUpdateLabels.json");
        labelsAPI.setPostUpdateTasks(id, json);

    }

    @When("Send POST request for update a labels")
    public void sendPOSTRequestForUpdateALabels() {
        SerenityRest.when().post(LabelsAPI.GET_LABELS);
    }

    @Given("Post update a personal label with invalid {} and valid request body")
    public void postUpdateAPersonalLabelWithInvalidAndValidRequestBody(String id) {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostUpdateLabels.json");
        labelsAPI.setPostUpdateTasks(id, json);
    }

    @Given("Update a personal label with valid {} and empty body request name")
    public void updateAPersonalLabelWithValidAndEmptyBodyRequestName(String id) {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostUpdateLabelsWithEmptyBody.json");
        labelsAPI.setPostUpdateTasks(id, json);
    }

    @Given("Update a personal label with valid id {} and without body request")
    public void updateAPersonalLabelWithValidIdAndWithoutBodyRequest(String id) {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostUpdateLabelsWithoutBody.json");
        labelsAPI.setPostUpdateTasks(id, json);
    }



    @Given("Update a personal label {} empty")
    public void updateAPersonalLabelEmpty(String id) {
        File json = new File(Constants.REQ_BODY_LABELS + "/PostUpdateLabelsWithoutBody.json");
        labelsAPI.setPostUpdateTasks(id, json);
    }


    @And("Validate Get labels with valid parameter id json schema validator")
    public void validateGetLabelsWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_LABELS + "/GetAllPersonalLabelsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//    @Given("Delete comments with valid id {}")
//    public void deleteCommentsWithValidId(String id) {
//        labelsAPI.setDeleteLabelsWithValidParameterId(id);
//    }
//
////    @When("Send request delete user labels")
////    public void sendRequestDeleteUserComments() {
////        SerenityRest.when().delete(LabelsAPI.DELETE_LABELS);
////    }

//    @Given("Delete a comment with unavailable id {}")
//    public void deleteACommentWithUnavailableId(String id) {
//        labelsAPI.setDeleteLabelsWithValidParameterId(id);
//    }

    @Given("Delete labels with valid id {}")
    public void deleteLabelsWithValidId(String id) {
        labelsAPI.setDeleteLabelsWithValidParameterId(id);
    }

    @When("Send request delete user labels")
    public void sendRequestDeleteUserLabels() {
        SerenityRest.when().delete(LabelsAPI.DELETE_LABELS);
    }

    @And("Validate post create label with valid parameter id json schema validator")
    public void validatePostCreateLabelWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_LABELS + "/PostCreateLabelsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate post update labels with valid parameter id json schema validator")
    public void validatePostUpdateLabelsWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_LABELS + "/PostUpdateLabelsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
