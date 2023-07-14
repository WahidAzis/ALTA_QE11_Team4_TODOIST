package starter.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

import static starter.Utils.Constants.URL;

public class CommentsAPI {
    public static String POST_CREATE_COMMENTS =URL+ "/rest/v2/comments";
    public static String POST_UPDATE_COMMENTS =URL+ "/rest/v2/comments/{id}";
    public static String GET_ALL_COMMENTS = URL+ "/rest/v2/comments?task_id={id}";
    public static String DELETE_COMMENTS =URL+"/rest/v2/comments/{id}";

    @Step("Post create new Comments")
    public void setPostNewComments( File json){
        SerenityRest.given()
                .headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Get new Comments")
    public void setGetComments(Object id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", id);


    }
    @Step("Get new Comments")
    public void setGetCommentsInvalid(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", id);

    }

    @Step("Post Update Comments")
    public void setPostUpdateComments(String id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(json);
    }
    @Step("Delete comments with valid parameter id")
    public void setDeleteCommentsWithValidParameterId(String id) {
        SerenityRest.given().pathParam("id", id);
    }


    }
