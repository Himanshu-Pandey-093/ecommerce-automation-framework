package Backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APITests {

    private final String baseUrl = "https://fakestoreapi.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUrl;
    }

    @Test
    public void testSearchProduct() {
        // Search for a product
        Response response = RestAssured.given()
                .basePath("/products")
                .queryParam("search", "titan")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Validate response structure and content
        String productName = response.jsonPath().getString("[0].title");
        String productPrice = response.jsonPath().getString("[0].price");

        Assert.assertNotNull(productName, "Product name should not be null");
        Assert.assertNotNull(productPrice, "Product price should not be null");

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);
    }

    @Test
    public void testGetProductDetails() {
        int productId = 1; // Example product ID

        
        Response response = RestAssured.given()
                .basePath("/products/" + productId)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Validate response structure and content
        String productName = response.jsonPath().getString("title");
        String productPrice = response.jsonPath().getString("price");

        Assert.assertNotNull(productName, "Product name should not be null");
        Assert.assertNotNull(productPrice, "Product price should not be null");

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);
    }
}
