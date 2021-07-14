package RAProject;


import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GitHub_RA_Project {
	
	// Declare request specification
    RequestSpecification requestSpec;
   
    int SSHKey;
    int id;

 
    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // set Token
                .addHeader("Authorization", "token givetoken")
                // Set base URL
                .setBaseUri("https://api.github.com")
                // Build request specification
                .build();
        
    }
	
  @Test(priority=1)
  public void PostSSH () {
	// Create JSON request
      String reqBody = "{\"title\": \"TestAPIKey\", \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCZ8OSc9RAjQd6WqewRhAK0BVKZCY7UqWqxvOcnnY2JJ3OPwwASSPqJ282thiRffHUCRAq+HY1IIHalLAFGJiRWNwvFfxRR6dljHlIPzE3Exx1yy1DJhljUXM1PAdFdYse9wsumjvjPVl3+EXGEL/P1SMf8lxR+lN0w7fPcl+f+dsm+giCdxQ2MQWI3ILDu9Pg7i4J/nPwlJsfE6i5iCLHAS17xdFqiVPe4kmbsnFBxaZszyvAmkz/YIC4yDlLPybcKdmZ1LGd17f3TdmLowXIvN8hAIaOctqdOXgKyKupnXGBIEbm3Ze1z4iXIHvplA9nya8V4i0nqgqG7uqwe\"}";
  
      
      Response response = 
    		  given().spec(requestSpec) // Set headers
              .body(reqBody) // Add request body
              .when().post("/user/keys"); // Send POST request
              
         // Print response
              System.out.println(response.getBody().asPrettyString());
              
            SSHKey = response.then().extract().path("id");
              
      // Assertion
      response.then().statusCode(201);

  }
  
  @Test(priority=2)
  public void getSSH () {
	// Create JSON request
      String reqBody = "{\"title\": \"TestAPIKey\", \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCZ8OSc9RAjQd6WqewRhAK0BVKZCY7UqWqxvOcnnY2JJ3OPwwASSPqJ282thiRffHUCRAq+HY1IIHalLAFGJiRWNwvFfxRR6dljHlIPzE3Exx1yy1DJhljUXM1PAdFdYse9wsumjvjPVl3+EXGEL/P1SMf8lxR+lN0w7fPcl+f+dsm+giCdxQ2MQWI3ILDu9Pg7i4J/nPwlJsfE6i5iCLHAS17xdFqiVPe4kmbsnFBxaZszyvAmkz/YIC4yDlLPybcKdmZ1LGd17f3TdmLowXIvN8hAIaOctqdOXgKyKupnXGBIEbm3Ze1z4iXIHvplA9nya8V4i0nqgqG7u1Lutiyu\"}";
  
      
      Response response = 
    		  given().spec(requestSpec) // Set headers
              .body(reqBody) // Add request body
              .when().get("/user/keys"); // Send get request
              
         // Print response
              System.out.println(response.getBody().asPrettyString());
              response.then().log().body();       
      // Assertion
      response.then().statusCode(200);

  }
  
  @Test(priority=3)
  public void DeleteSSH () {
	// Create JSON request
      String reqBody = "{\"title\": \"TestAPIKey\", \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCZ8OSc9RAjQd6WqewRhAK0BVKZCY7UqWqxvOcnnY2JJ3OPwwASSPqJ282thiRffHUCRAq+HY1IIHalLAFGJiRWNwvFfxRR6dljHlIPzE3Exx1yy1DJhljUXM1PAdFdYse9wsumjvjPVl3+EXGEL/P1SMf8lxR+lN0w7fPcl+f+dsm+giCdxQ2MQWI3ILDu9Pg7i4J/nPwlJsfE6i5iCLHAS17xdFqiVPe4kmbsnFBxaZszyvAmkz/YIC4yDlLPybcKdmZ1LGd17f3TdmLowXIvN8hAIaOctqdOXgKyKupnXGBIEbm3Ze1z4iXIHvplA9nya8V4i0nqgqG7u1Ljhsa\"}";
  
      
      Response response = 
    		  given().spec(requestSpec) // Set headers
    		  .body(reqBody) // Add request body
              .pathParam("id", SSHKey) // Add path parameter
              .when().delete("/user/keys/{id}");; // Send delete request
              
         // Print response
              System.out.println(response.getBody().asPrettyString());
   
      // Assertion
      response.then().statusCode(204);

  }
  
}
