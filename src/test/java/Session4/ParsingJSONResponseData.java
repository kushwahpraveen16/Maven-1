package Session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class ParsingJSONResponseData {

    
    @Test(priority=1)
    void TestJsonResponse() {
       /* given()
            .contentType("ContentType.JSON")
            
        .when()
            .get("http://localhost:3000/stores")
        .then()
            .statusCode(200)
            .header("Content-Type","application/json; charset=utf-8")
            .body("book[2].title", equalTo("Sword of Honour"));*/
        
        //Approach2
        
        Response res = given()
        .contentType(ContentType.JSON)
        .when()
        .get("http://localhost:3000/stores");
        
//            Assert.assertEquals(res.getStatusCode(), 200);
//            String bookres = res.jsonPath().get("book[2].title").toString();
//            Assert.assertEquals(bookres, "Sword of Honour");
            
        //Lets Print all Book title 
        
            JSONObject jo =new JSONObject(res.asString());
            for(int i=0;i<jo.getJSONArray("book").length();i++) {
                String booktitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
                System.out.println("Boook Title: -"+booktitle);
            }
            
    }
}
