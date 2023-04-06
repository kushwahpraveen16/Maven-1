import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DiffWaystoCreatePostRequest {

    //CreatePost Methd with Gson
       @Test
       void TestPostusingHashMAP() 
       {
           
           HashMap hm = new HashMap();
           hm.put("name","yash");
           hm.put("location","NewZealand");
           hm.put("phone","8269184559");
           String course[] = {"java","Selenium"};
           hm.put("courses",course);
           
           given()
           .contentType("application/json")
           .body(hm)
           
           .when()
           .post("http://localhost:3000/Super")
           
           .then()
               .statusCode(201)
               .body("name",equalTo("yash"))
               .log().all();
               
       }
       
       
       //CreatePost method with Json Library
       @Test(priority=2)
       void TestCreateusingJsonLib() {
           JSONObject ob = new JSONObject();
           ob.put("name","Vaibhav");
           ob.put("location","Bangladesh");
           ob.put("phone","9074260391");
           String course[] = {".net","sql"};
           ob.put("courses",course);
           
           
           
           given()
           .contentType("application/json")
           .body(ob.toString())
           .when()
           .post("http://localhost:3000/Super")
           
           .then()
           .statusCode(201)
           .body("name",equalTo("Vaibhav"))
           .log().all();
       }
}
