package Session3;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HeadersDemo {
    
    //@Test
    void testHeaders() {
        
        given()
        
        .when()
           .get("https://www.google.com/")
        .then()
        .header("Content-Type", "text/html; charset=ISO-8859-1")
        .and()
        .header("Content-Encoding","gzip")
        .and()
        .header("Server","gws");
    }   
    
    @Test(priority=2)
 void getHeaders() {
        
       Response rtes =  given()
        
        .when()
           .get("https://www.google.com/");
    
    
//    String HeaderValue = rtes.getHeader("Content-Type");
//    System.out.println("The Value of Content-Type header is "+HeaderValue);
       
      Headers headers =  rtes.getHeaders();
      System.out.println(headers);
    
    }   

}
