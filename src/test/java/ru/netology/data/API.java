package ru.netology.data;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import static io.restassured.RestAssured.given;


public class API {


     public static ReuestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


     public static String PaymentPageForm(DataHelper.UserInfo userInfo) {
          return given()
                  .spec(requestSpec)
                  .body(userInfo)
                  .when()
                  .post("/api/v1/pay")
                  .then()
                  .statusCode(200)
                  .extract().response().asString();
     }

}
