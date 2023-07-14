package starter.Sections;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

import static starter.Utils.Constants.URL;

public class SectionAPI {


    ///////////////////SECTIONS
    public static String GET_SINGLE_SECTIONS = URL+ "/rest/v2/sections/{id}";
    public static String GET_SINGLE_SECTIONS_CHAR =URL+ "/rest/v2/sections/{character}";
    public static String  POST_NEW_SECTIONS = URL +"/rest/v2/sections";
    public static String POST_NEW_UPDATE_SECTION = URL+ "/rest/v2/sections/{id}";
    public static String DELETE_SECTION =URL+"/rest/v2/sections/{id}";
    //    public static String GET_ALL_SECTIONS = URL+"/rest/v2/sections?project_id={id}";
    @Step("Post create new sections")
    public void setPostNewSections( File json){
        SerenityRest.given()
                .headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Get single section")
    public void setGetSingleSections(int id){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Get single section with invalid parameter")
    public void setGetSingleSectionsWithInvalidParameter(String id){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Get single section with special character")
    public void  setGetSingleSectionsWithSpecialCharacter(String character){
       SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("character",character);
    }

    @Step("Post update section")
    public void setPostUpdateSection(int id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Post update section with invalid data")
    public void setPostUpdateSectionsWithInvalidData(int id,File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.BEARER_TOKEN)
                .pathParam("id",id)
          .contentType(ContentType.JSON).body(json);
    }
    @Step("Delete sections with valid parameter id")
    public void setDeleteSectionsWithValidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }


}
