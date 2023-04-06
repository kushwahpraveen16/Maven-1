package Rest_Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Get_Data {

    @Test
    public void testResponsecode() {
        Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
        int code = resp.getStatusCode();
        System.out.println(" Status code is "+code);
        Assert.assertEquals(code,200);
        
        
    }
    @Test
    public void GetWeatherDetailsCondensed()
    {
            // Specify the base URL to the RESTful web service
            RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

            // Get the RequestSpecification of the request that is to be sent
            // to the server.
            RequestSpecification httpRequest = RestAssured.given();

            // Call RequestSpecification.get() method to get the response.
            // Make sure you specify the resource name.
            Response response = httpRequest.get("");

            // Response.asString method will directly return the content of the body
            // as String.
            System.out.println("Response Body is =>  " + response.asString());
    }
}
