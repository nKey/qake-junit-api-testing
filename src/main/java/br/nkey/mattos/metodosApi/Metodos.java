package br.nkey.mattos.metodosApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Metodos {

    public void metodoGet(String EndPoint) {

        System.out.println("ESTOU DETRO DO METODO ");
        given()

                .log().all()
                .when()
                .get(EndPoint)
                .then()
                .log().all().statusCode(200);

    }

public void validarCorpoRequisicao(String postId, int id, String name){
    given()

          .then()
            .log().all()
            .body("postId", is(postId))
            .body("id", is(id))
            .body("name", is(name));
}
}
