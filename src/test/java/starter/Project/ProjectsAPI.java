package starter.Project;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

import static starter.Utils.Constants.URL;

public class ProjectsAPI {


    ///////////////////SECTIONS
    public static String POST_CREATE_PROJECT =URL+ "/rest/v2/projects";
    public static String GET_PROJECT =URL+ "/rest/v2/projects/{id}";
    public static String GET_ALL =URL+ "/rest/v2/projects";
    public static String GET_PROJECT_CHAR =URL+ "/rest/v2/projects/{character}";
    public static String POST_UPDATE_PROJECT =URL+ "/rest/v2/projects/{id}";
    public static String DELETE_PROJECT =URL+"/rest/v2/project/{id}";

    @Step("Post create new project")
    public void setPostNewProject( File json){
        SerenityRest.given()
                .headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Get Project")
    public void setGetProject(String id){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Get a project with unavailable parameter id")
    public void setGetAProjectWithUnvailableParameterId(int id){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Get a project with special character")
    public void  setGetAProjectwWithSpecialCharacter(String character){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("character",character);
    }
    @Step("Get all projects")
    public void setGetAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ Constants.BEARER_TOKEN);
    }
    @Step("Post update Project")
    public void setPostUpdateProject(String id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Delete project with valid parameter id")
    public void setDeleteProjectWithValidParameterId(String id) {
        SerenityRest.given().pathParam("id", id);
    }


}
