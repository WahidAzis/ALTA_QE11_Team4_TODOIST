package starter.Task;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;

import java.io.File;

public class TasksStepDef {
    @Steps
    TasksAPI tasksAPI;

    @Given("Post Create a new task with valid request body")
    public void postCreateANewTaskWithValidRequestBody() {
        File json = new File(Constants.REQ_BODY_TASK + "/PostCreateNewTasks.json");
        tasksAPI.setPostNewTasks(json);
    }

    @When("Send POST request for create a new task")
    public void sendPOSTRequestForCreateANewTask() {
        SerenityRest.when().post(TasksAPI.POST_CREATE_TASK);
    }

    /////////////////////////////////////////////////////////
    @Given("Post Create a new task empty request body")
    public void postCreateANewTaskEmptyRequestBody() {
        File json = new File(Constants.REQ_BODY_TASK + "/PostCreateEmptyBody.json");
        tasksAPI.setPostNewTasks(json);
    }

    @Given("Post Create a new task with invalid content request body")
    public void postCreateANewTaskWithInvalidContentRequestBody() {
        File json = new File(Constants.REQ_BODY_TASK + "/PostCreateTaskInvalidContent.json");
        tasksAPI.setPostNewTasks(json);
    }

    @Given("Post Create a new task with empty content request body")
    public void postCreateANewTaskWithEmptyContentRequestBody() {
        File json = new File(Constants.REQ_BODY_TASK + "/PostCreateEmptyContent.json");
        tasksAPI.setPostNewTasks(json);
    }

    @Given("Post Create a new task with invalid due_string request body")
    public void postCreateANewTaskWithInvalidDue_stringRequestBody() {
        File json = new File(Constants.REQ_BODY_TASK + "/PostCreateInvalidBody.json");
        tasksAPI.setPostNewTasks(json);
    }

    @Given("Post Create a new task with empty due_string request body")
    public void postCreateANewTaskWithEmptyDue_stringRequestBody() {
        File json = new File(Constants.REQ_BODY_TASK + "/PostCreateEmptyBody.json");
        tasksAPI.setPostNewTasks(json);
    }
////////////////////////////////////////////////////////////////////////////

    @When("Send GET request for get an active task")
    public void sendGETRequestForGetAnActiveTask() {
        SerenityRest.when().get(TasksAPI.GET_TASK);

    }

    @Given("Get an active task with valid {string} parameter")
    public void getAnActiveTaskWithValidParameter(String id) {
        tasksAPI.setGetActiveTask(id);
    }

    /////////////////////////////////////////////////////////////////////////////////
    @Given("Get an active task with invalid id parameter type special {}")
    public void getAnActiveTaskWithInvalidIdParameterTypeSpecial(String character) {
        tasksAPI.getActiveTasksWithSpecialCharacter(character);

    }

    @When("Send GET request for get an active task with special character")
    public void sendGETRequestForGetAnActiveTaskWithSpecialCharacter() {
        SerenityRest.when().post(TasksAPI.GET_TASK_CHAR);
    }

//    @Given("Get an active task with invalid id parameter {}")
//    public void getAnActiveTaskWithInvalidIdParameter(int id) {
//        tasksAPI.setGetActiveTaskWithInvalidId(id);
//    }

    @When("Send GET request for get an active task with invalid id")
    public void sendGETRequestForGetAnActiveTaskWithInvalidId() {
        SerenityRest.when().get(TasksAPI.GET_TASK);
    }

    @Given("Get all active task with available id")
    public void getAllActiveTaskWithAvailableId(int id) {
        tasksAPI.setGetActiveTaskWithInvalidId(id);
    }

    @When("Send GET request for get an active task available id")
    public void sendGETRequestForGetAnActiveTaskAvailableId() {
        SerenityRest.when().get(TasksAPI.GET_ALL_TASK);
    }

    @Given("Get an active task with invalid parameter {}")
    public void getAnActiveTaskWithInvalidParameter(int id) {
        tasksAPI.setGetActiveTaskWithInvalidId(id);
    }

    ///////////////////////////////////////////////////////////////
    @Given("Post update a task with valid {} and request body")
    public void postUpdateATaskWithValidAndRequestBody(String id) {
        File json = new File(Constants.REQ_BODY_TASK + "/PostUpdateValid.json");
        tasksAPI.setPostUpdateTasks(id, json);
    }

    @When("Send POST request for update a task")
    public void sendPOSTRequestForUpdateATask() {
        SerenityRest.when().post(TasksAPI.GET_TASK);
    }

    //////////////////////////////////////
    @Given("Post update a task with invalid {} and valid request body")
    public void postUpdateATaskWithInvalidAndValidRequestBody(String id) {
        File json = new File(Constants.REQ_BODY_TASK + "/PostUpdateInvalidIdAndValidBody.json");
        tasksAPI.setPostUpdateTasks(id, json);
    }

    @Given("Post Update a task with valid id {} and empty body content")
    public void postUpdateATaskWithValidIdAndEmptyBodyContent(String id) {
        File json = new File(Constants.REQ_BODY_TASK + "/PostUpdateInvalidIdAndValidBody.json");
        tasksAPI.setPostUpdateTasks(id, json);
    }

    @Given("Post Update a task with valid id {} and without request body")
    public void postUpdateATaskWithValidIdAndWithoutRequestBody(String id) {
        File json = new File(Constants.REQ_BODY_TASK + "/PostUpdateValidIdAndReqBody.json");
        tasksAPI.setPostUpdateTasks(id, json);
    }

    @Given("Delete a task with valid {} parameter")
    public void deleteATaskWithValidParameter(String id) {
        tasksAPI.setDeleteTasksWithValidParameterId(id);
    }

    @When("Send request delete task")
    public void sendRequestDeleteTask() {
        SerenityRest.when().delete(TasksAPI.DELETE_TASKS);
    }


    @Given("Delete a task with invalid id {} parameter special char")
    public void deleteATaskWithInvalidIdParameterSpecialChar(String character) {
        tasksAPI.setDeleteTasksWithValidParameterIdSpecialChar(character);
    }


    @And("Validate Get tasks with valid parameter id json schema validator")
    public void validateGetTasksWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_TASKS + "/TasksGetValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate post tasks with valid parameter id json schema validator")
    public void validatePostTasksWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_TASKS + "/TasksPostCreateValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate post Update tasks with valid parameter id json schema validator")
    public void validatePostUpdateTasksWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_TASKS + "/PostUpdateTaskValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete a task with unavailable {}")
    public void deleteATaskWithUnavailable(String id) {
        tasksAPI.setDeleteTasksWithUnavailable(id);
    }

}
//    @Given("Post update a project with valid {} and empty name")
//    public void postUpdateAProjectWithValidAndEmptyName(String id) {
//        File json = new File(Constants.REQ_BODY_TASK +"/PostCommentsEmptyName.json");
//        tasksAPI.setPostUpdateTasks(id,json);
//    }
//}

