import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class HTTPRequests {

    int id;
    //Get User from the API
   @Test(priority=1)
    void getUser() 
    {
      
        given()
       
        .when()
        .get("https://reqres.in/api/users?page=2")
      
        .then()
            .statusCode(200)
            .log().all();
    }
    
    //Create User 
    
    @Test(priority=2)
    void createuser() 
    {
       HashMap hm = new HashMap();
       hm.put("name","Kazak");
       hm.put("job","Banker");
        
        
        id = given()
            .contentType("application/json")
            .body(hm)  
        
        .when()
            .post("https://reqres.in/api/users")
            .jsonPath().getInt("id");
        
//        .then()
//            .statusCode(201)
//            .log().all();
        
    }
    
    @Test(priority=3,dependsOnMethods= {"createuser"})
    void updateuser() {
        String user = "{\"name\":\"Elias S\",\"job\":\"Quality Engineer\"}";
        
        given()
            .contentType("application/json")
            .body(user)  
         .when()
             .put("https://reqres.in/api/users/"+id)
         .then()
             .statusCode(200)
             .log().all();
        
    }
  
    @Test(priority=4)
    void deleteuser() {
        
        given()

        .when()
        .delete("https://reqres.in/api/users/"+id)
        
        .then()
        .statusCode(204)
        .log().all();
    }
    
}
