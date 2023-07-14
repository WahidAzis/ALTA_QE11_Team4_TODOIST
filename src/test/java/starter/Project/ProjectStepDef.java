package starter.Project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;

import java.io.File;

public class ProjectStepDef {
    @Steps
    ProjectsAPI projectsAPI;
    @Given("Post create a new project with valid name")
    public void postCreateANewProjectWithValidName() {
        File json = new File(Constants.REQ_BODY + "/PostCreateNewProject.json");
        projectsAPI.setPostNewProject(json);
    }

    @When("Send request post create new project")
    public void sendRequestPostCreateNewProject() {
        SerenityRest.when().post(ProjectsAPI.POST_CREATE_PROJECT);
    }



///////////////////////////////////SCENARIO 2
    @Given("Post create a new project with empty request body")
    public void postCreateANewProjectWithEmptyRequestBody() {
        File json = new File(Constants.REQ_BODY + "/PostCreateNewProjectEmptyReq.json");
        projectsAPI.setPostNewProject(json);
    }
    ///////////////////////////////////SCENARIO 3
    @Given("Post create a new project with empty name")
    public void postCreateANewProjectWithEmptyName() {
        File json = new File(Constants.REQ_BODY + "/PostCreateNewProjectEmptyName.json");
        projectsAPI.setPostNewProject(json);
    }
////////////////////////////////////// GET SCENARIO 1



    @Given("Get project with valid id {string}")
    public void getProjectWithValidId(String id) {
        projectsAPI.setGetProject(id);
    }

    @When("Send get project request")
    public void sendGetProjectRequest() {
        SerenityRest.when().get(ProjectsAPI.GET_PROJECT);
    }
///////////////////////////////////////////////////////
    @Given("Get a project with unavailable parameter id {}")
    public void getAProjectWithUnavailableParameterId(int id) {
        projectsAPI.setGetAProjectWithUnvailableParameterId(id);
    }
////////////////////////////////////////////////////////////
    @Given("Get a project with invalid id special character {}")
    public void getAProjectWithInvalidIdSpecialCharacter(String character) {
        projectsAPI.setGetAProjectwWithSpecialCharacter(character);
    }

    @When("Send get project request with invalid id special character")
    public void sendGetProjectRequestWithInvalidIdSpecialCharacter() {
        SerenityRest.when().post(ProjectsAPI.GET_PROJECT_CHAR);
    }
////////////////////////////////////////////////////
    @Given("Get all project with valid id parameter {string}")
    public void getAllProjectWithValidIdParameter(String id) {
        projectsAPI.setGetProject(id);
    }
//////////////////////////////////////////////
    @Given("Get all project with valid id parameter")
    public void getAllProjectWithValidIdParameter() {
        projectsAPI.setGetAllProjects();
    }

    @When("send get request for get a project")
    public void sendGetRequestForGetAProject() {
        SerenityRest.when().get(ProjectsAPI.GET_ALL);
    }
//////////////////////////////////////////////////////
//    @Given("Post update a project with valid parameter {} and valid name")
//    public void postUpdateAProjectWithValidParameterAndValidName(int id) {
//    File json = new File(Constants.REQ_BODY +"/PostUpdateProject.json");
//    projectsAPI.setPostUpdateProject(id,json);
//}

    @When("send post request for update a project")
    public void sendPostRequestForUpdateAProject() {
        SerenityRest.when().post(ProjectsAPI.POST_UPDATE_PROJECT);
    }

/////////////////////////////////////////////////////////
    @Given("Post update project with valid {}")
    public void postUpdateProjectWithValid(String id) {
        File json = new File(Constants.REQ_BODY +"/PostUpdateProject.json");
        projectsAPI.setPostUpdateProject(id,json);
    }



    @When("Send request post update project")
    public void sendRequestPostUpdateProject() {
        SerenityRest.when().get(ProjectsAPI.POST_UPDATE_PROJECT);
    }

    @Given("Post update project with invalid id {}")
    public void putUpdateProjectWithInvalidId(String id) {
        File json = new File(Constants.REQ_BODY +"/PostUpdateProjectInvalid.json");
        projectsAPI.setPostUpdateProject(id,json);
    }



    @Given("Post update a project with valid {} parameter and empty request body")
    public void postUpdateAProjectWithValidParameterAndEmptyRequestBody(String id) {
        File json = new File(Constants.REQ_BODY +"/PostUpdateProjectEmptyBody.json");
        projectsAPI.setPostUpdateProject(id,json);
    }

    @Given("Post update a project with valid {} parameter and empty name")
    public void postUpdateAProjectWithValidParameterAndEmptyName(String id) {
        File json = new File(Constants.REQ_BODY +"/PostUpdateProjectEmptyName.json");
        projectsAPI.setPostUpdateProject(id,json);
    }

    @Given("Post update a project with valid {} parameter and invalid name")
    public void postUpdateAProjectWithValidParameterAndInvalidName(String id) {
        File json = new File(Constants.REQ_BODY +"/PostUpdateProjectEmptyName.json");
        projectsAPI.setPostUpdateProject(id,json);
    }


    @Given("Delete a project with valid {} parameter")
    public void deleteAProjectWithValidParameter(String id) {
        projectsAPI.setDeleteProjectWithValidParameterId(id);
    }

    @When("Send request delete user project")
    public void sendRequestDeleteUserProject() {
        SerenityRest.when().delete(ProjectsAPI.DELETE_PROJECT);
    }

    @Given("Delete a project with unavailable {} parameter")
    public void deleteAProjectWithUnavailableParameter(String id) {
        projectsAPI.setDeleteProjectWithValidParameterId(id);
    }

    @Given("Delete project with invalid {} parameter")
    public void deleteProjectWithInvalidParameter(String id) {
        projectsAPI.setDeleteProjectWithValidParameterId(id);
    }

    @Given("Delete a task with unavailable {}")
    public void deleteATaskWithUnavailable(String id) {
        projectsAPI.setDeleteProjectWithValidParameterId(id);
    }

    @And("Validate Post create a new project with valid parameter json schema validator")
    public void validatePostCreateANewProjectWithValidParameterJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_PROJECT + "/PostCreateProjectsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate Get project with valid parameter id json schema validator")
    public void validateGetProjectWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_PROJECT + "/GetProjectSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate post update project with valid parameter id json schema validator")
    public void validatePostUpdateProjectWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_PROJECT + "/PostUpdateProjectSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}