package Session3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
    
    //@Test
    void testCookies() {
        
        given()
        
        .when()
           .get("https://www.google.com/")
        .then()
        .cookie("AEC","ARSKqsKzpuwgUo3GD2ss74Hz4VGtq39kFx-gY4UBOu2vM2H8iLTqJmn4QO4")
        .log().all();
    }           
    
    
    @Test
    void GetCookiesinfo() 
    {
        Response res = given()
        .when()
        .get("https://www.google.com/");
       
       //Get Single Cookie Info 
        String cookie_value = res.getCookie("AEC");
        System.out.println(cookie_value);
        
        //Get All Cookies info
        Map<String,String> map = res.getCookies();
        System.out.println(map);
    }

}
