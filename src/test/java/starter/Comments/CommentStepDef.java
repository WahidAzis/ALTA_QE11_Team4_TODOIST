package starter.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;

import java.io.File;

public class CommentStepDef {
    @Steps
    CommentsAPI commentsAPI;
    @Given("Post create a new comment with valid content and task id")
    public void postCreateANewCommentWithValidContentAndTaskId() {
        File json = new File(Constants.REQ_BODY_COMMENTS + "/PostCreateComments.json");
        commentsAPI.setPostNewComments(json);
    }

    @When("Send request post create new comments")
    public void sendRequestPostCreateNewComments() {
        SerenityRest.when().post(CommentsAPI.POST_CREATE_COMMENTS);
    }

    @Given("Post create a new comment with empty request body")
    public void postCreateANewCommentWithEmptyRequestBody() {
        File json = new File(Constants.REQ_BODY_COMMENTS + "/PostCreateCommentsEmptyBody.json");
        commentsAPI.setPostNewComments(json);
    }
/////////////////////////////////////////////////////////////////////
    @Given("Get comments with valid id {string}")
    public void getCommentsWithValidId(String id) {
        commentsAPI.setGetComments(id);
    }

    @When("send GET request for get a comment")
    public void sendGETRequestForGetAComment() {
        SerenityRest.when().post(CommentsAPI.GET_ALL_COMMENTS);
    }
///////////////////////////////
    @Given("Get a comment with unavailable parameter {}")
    public void getACommentWithUnavailableParameter(String id) {
        commentsAPI.setGetCommentsInvalid(id);
    }

    @Given("Get a comment with invalid {}")
    public void getACommentWithInvalid(String id) {
        commentsAPI.setGetCommentsInvalid(id);
    }
/////////////////////////////////////////////////////////////////
    @Given("Post update a comment with valid {} and content")
    public void postUpdateACommentWithValidAndContent(String id) {
        File json = new File(Constants.REQ_BODY_COMMENTS+"/PostUpdateComments.json");
        commentsAPI.setPostUpdateComments(id,json);
    }

    @When("Send request post update comments")
    public void sendRequestPostUpdateComments() {
        SerenityRest.when().post(CommentsAPI.POST_UPDATE_COMMENTS);
    }

    @Given("Post update a comment with invalid {} and valid content")
    public void postUpdateACommentWithInvalidAndValidContent(String id) {
        File json = new File(Constants.REQ_BODY_COMMENTS+"/PostUpdateCommentsInvalid.json");
        commentsAPI.setPostUpdateComments(id,json);
    }
///////////////////////////////////////////////////////////////
//    @Given("Post update a project with valid {} and empty name")
//    public void postUpdateAProjectWithValidAndEmptyName(String id) {
//        File json = new File(Constants.REQ_BODY_COMMENTS+"/PostUpdateCommentsEmptyName.json");
//        commentsAPI.setPostUpdateComments(id,json);
//
//    }

    @Given("Post update a comments with valid {} and number data type of name")
    public void postUpdateAProjectWithValidAndNumberDataTypeOfName(String id) {
        File json = new File(Constants.REQ_BODY_COMMENTS+"/PostUpdateCommentsValidIdAndInvalidBody.json");
        commentsAPI.setPostUpdateComments(id,json);
    }

//    @And("Validate get new comments with valid parameter page json schema validator")
//    public void validateGetNewCommentsWithValidParameterPageJsonSchemaValidator() {
//        File json = new File(Constants.JSON_SCHEMA_COMMENTS + "/GetCommentsValidSchema.json");
//        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
//    }

    @And("Validate post update comments with valid parameter page json schema validator")
    public void validatePostUpdateCommentsWithValidParameterPageJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_COMMENTS + "/PostUpdateCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    @Given("Post update a comments with valid {} and empty name")
    public void postUpdateACommentsWithValidAndEmptyName(String id) {
        File json = new File(Constants.REQ_BODY_COMMENTS+"/PostUpdateCommentsEmptyName.json");
        commentsAPI.setPostUpdateComments(id,json);
    }


    @Given("Delete a comment with valid {}")
    public void deleteACommentWithValid(String id) {
        commentsAPI.setDeleteCommentsWithValidParameterId(id);
    }

    @When("Send request delete user comments")
    public void sendRequestDeleteUserComments() {
        SerenityRest.when().delete(CommentsAPI.DELETE_COMMENTS);
    }

    @Given("Delete comment with invalid id {}")
    public void deleteCommentWithInvalidId(String id) {
        commentsAPI.setDeleteCommentsWithValidParameterId(id);
    }

    @Given("Delete a comment with unavailable id {}")
    public void deleteACommentWithUnavailableId(String id) {
        commentsAPI.setDeleteCommentsWithValidParameterId(id);
    }

    @And("Validate get new comments with valid parameter page json schema validator")
    public void validateGetNewCommentsWithValidParameterPageJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA + "/GetCommentsValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate post create comments with valid parameter id json schema validator")
    public void validatePostCreateCommentsWithValidParameterIdJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_COMMENTS + "/PostCreateCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
