package starter.Labels;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

import static starter.Utils.Constants.URL;

public class LabelsAPI {

    public static String POST_CREATE_LABELS =URL+ "/rest/v2/labels";
    public static String GET_LABELS =URL+ "/rest/v2/labels/{id}";
    public static String GET_LABELS_ALL =URL+ "/rest/v2/labels";
    public static String DELETE_LABELS =URL+"/rest/v2/labels/{id}";

    @Step("Post create new Labels")
    public void setPostNewLabels( File json){
        SerenityRest.given()
                .headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Get Labels")
    public void  setGetLabels(String  id) {
        SerenityRest.given().headers("Authorization","Bearer "+Constants.BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Post update Labels")
    public void setPostUpdateTasks(String id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Delete labels with valid parameter id")
    public void setDeleteLabelsWithValidParameterId(String id) {
        SerenityRest.given().pathParam("id", id);
    }


}
