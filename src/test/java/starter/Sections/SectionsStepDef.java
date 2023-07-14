package starter.Sections;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.Utils.TodoistResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class SectionsStepDef {

    @Steps
    SectionAPI sectionAPI;

    @Given("Post create new section with valid parameter")
    public void postCreateNewSectionWithValidParameter() {
        File json = new File(Constants.REQ_BODY_SECTIONS + "/PostCreateNewSections.json");
        sectionAPI.setPostNewSections(json);
    }

    @When("Send request post create new section")
      public void sendRequestPostCreateNewSection() {
//       Response response =
               SerenityRest.when().post(SectionAPI.POST_NEW_SECTIONS);



//        JsonPath jsonPathEvaluator = response.jsonPath();
//        String id_project = jsonPathEvaluator.get("id");
//        System.out.println(id_project);
//        Constants.ID_Sections=id_project;
    }

    @And("Response body page should contain project_id {int} and name {string}")
    public void responseBodyPageShouldContainProject_idAndName(int project_id, String name) {
        SerenityRest.then()
                .body(TodoistResponses.PROJECT_ID, equalTo(project_id))
                .body(TodoistResponses.NAME, equalTo(name));
    }
//
//    @And("Validate Get all section with valid parameter json schema validator")
//    public void validateGetAllSectionWithValidParameterJsonSchemaValidator() {
//        File json = new File(Constants.JSON_SCHEMA + "/CreateNewSectionSchema.json");
//        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
//    }

    ///////////////SCENARIO 2
    @Given("Post create new invalid section with empty project")
    public void postCreateNewInvalidSectionWithEmptyProject() {
        File json = new File(Constants.REQ_BODY_SECTIONS + "/PostCreateNewSectionsWithEmptyProject.json");
        sectionAPI.setPostNewSections(json);
    }

    ///////////////SCENARIO 2
    @Given("Post create new invalid section with empty name")
    public void postCreateNewInvalidSectionWithEmptyName() {
        File json = new File(Constants.REQ_BODY_SECTIONS + "/PostCreateNewSectionsWithEmptyName.json");
        sectionAPI.setPostNewSections(json);
    }

    @And("Validate Get all section with valid parameter json schema validator\"")
    public void validateGetAllSectionWithValidParameterJsonSchemaValidator() throws Throwable {
        File json = new File(Constants.JSON_SCHEMA_SECTIONS + "/CreateNewSectionSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create new invalid section with special char")
    public void postCreateNewInvalidSectionWithSpecalChar() {
        File json = new File(Constants.REQ_BODY_SECTIONS + "/PostCreateNewSectionsWithSpecialChar.json");
        sectionAPI.setPostNewSections(json);
    }

    //////////////////////////////////////////////
    @Given("Get single section with valid id {int}")
    public void getSingleSectionWithValidParameter(int id) {
        sectionAPI.setGetSingleSections(id);
    }


    @When("Send get single section request")
    public void sendGetSingleSectionRequest() {
        SerenityRest.when().post(SectionAPI.GET_SINGLE_SECTIONS);
    }


    @And("Validate Get single section with valid parameter id json schema validator\"")
    public void validateGetSingleSectionWithValidParameterIdJsonSchemaValidator() throws Throwable {
        File json = new File(Constants.JSON_SCHEMA_SECTIONS + "/GetSingleSectionsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
////////////////////////////////////////////
    @Given("Get single section with invalid id {}")
    public void getSingleSectionWithInvalidId(String id) {
        sectionAPI.setGetSingleSectionsWithInvalidParameter(id);
    }
    @When("Send get single section invalid id request")
    public void sendGetSingleSectionInvalidIdRequest() {
        SerenityRest.when().post(SectionAPI.GET_SINGLE_SECTIONS);
    }

/////////////////////////////////
    @Given("Get single section with character {}")
    public void getSingleSectionWithCharacter(String character) {
        sectionAPI.setGetSingleSectionsWithSpecialCharacter(character);
    }

    @When("Send get single section with special character request")
    public void sendGetSingleSectionWithSpecialCharacterRequest() {
        SerenityRest.when().post(SectionAPI.GET_SINGLE_SECTIONS_CHAR);
    }


///////////////////////////
    @Given("Get all section with valid parameter {int}")
    public void getAllSectionWithValidParameter(int id) {
        sectionAPI.setGetSingleSections(id);
}

    @When("Send get all section request")
    public void sendGetAllSectionRequest() {
        SerenityRest.when().post(SectionAPI.GET_SINGLE_SECTIONS);
    }

    @And("Validate Get all section with valid parameter id json schema validator")
    public void validateGetAllSectionWithValidParameterIdJsonSchemaValidator() {
    }

//////////////////////////////////////////
    @Given("Get all section with invalid parameter {}")
    public void getAllSectionWithInvalidParameter(String id) {
        sectionAPI.setGetSingleSectionsWithInvalidParameter(id);
    }
////////////////////////////////////////
    @Given("Post update section with valid id {}")
    public void postUpdateSectionWithValidId(int id) {
        File json = new File(Constants.REQ_BODY_SECTIONS +"/PostUpdateSection.json");
        sectionAPI.setPostUpdateSection(id,json);
    }

    @When("Send request post update section")
    public void sendRequestPostUpdateSection() {
        SerenityRest.when().post(SectionAPI.POST_NEW_UPDATE_SECTION);
    }

    @And("Validate Put update section with valid parameter json schema validator")
    public void validatePutUpdateSectionWithValidParameterJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_SECTIONS + "/PostUpdateSectionsValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//////////////////////////////////////

    @Given("Post create a new project valid id {} with empty request body")
    public void postCreateANewProjectInvalidIdWithEmptyRequestBody(int id) {
        File json = new File(Constants.REQ_BODY_SECTIONS +"/PostUpdateSectionWithEmptyBody.json");
        sectionAPI.setPostUpdateSection(id,json);
    }
    /////////////////////////////////////////////
    @Given("Put update section with invalid id {}")
    public void putUpdateSectionWithInvalidId(int id) {
        File json = new File(Constants.REQ_BODY_SECTIONS +"/PostUpdateSection.json");
        sectionAPI.setPostUpdateSectionsWithInvalidData(id,json);
    }
///////////////////////////////////////////////////
    @Given("Delete section with valid id {}")
    public void deleteSectionWithValidId(int id) {
    sectionAPI.setDeleteSectionsWithValidParameterId(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(sectionAPI.DELETE_SECTION);
    }


    /////////////////////////////////////////////
}