package starter.Task;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

import static starter.Utils.Constants.URL;

public class TasksAPI {
    public static String POST_CREATE_TASK =URL+ "/rest/v2/tasks";
    public static String GET_ALL_TASK =URL+ "/rest/v2/tasks";
    public static String GET_TASK =URL+ "/rest/v2/tasks/{id}";
    public static String GET_TASK_CHAR =URL+ "/rest/v2/tasks{character}";
    public static String DELETE_TASKS =URL+ "/rest/v2/tasks/{id}";
    @Step("Post create new tasks")
    public void setPostNewTasks( File json){
        SerenityRest.given()
                .headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Get active task")
    public void  setGetActiveTask(String id) {
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN)
         .pathParam("id",id);
    }

    @Step("Get active task with special character")
    public void getActiveTasksWithSpecialCharacter(String character) {
        SerenityRest.given().pathParam("character", character);
    }
    @Step("Get active task with invalid id")
    public void setGetActiveTaskWithInvalidId(int id){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Post update tasks")
    public void setPostUpdateTasks(String id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Delete tasks with valid parameter id")
    public void setDeleteTasksWithValidParameterId(String id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete tasks with valid parameter id special char")
    public void setDeleteTasksWithValidParameterIdSpecialChar(String character) {
        SerenityRest.given().pathParam("id", character);
    }
    @Step("Delete a task with unavailable id")
    public void setDeleteTasksWithUnavailable(String character) {
        SerenityRest.given().pathParam("id", character);
    }
}
