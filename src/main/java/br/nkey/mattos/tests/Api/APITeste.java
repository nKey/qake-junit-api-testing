package br.nkey.mattos.tests.Api;

import br.nkey.mattos.core.BaseApiTeste;
import org.apache.http.client.ClientProtocolException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static br.nkey.mattos.endPoint.EndPoint.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APITeste extends BaseApiTeste {


    @Test
    public void validarGet() throws ClientProtocolException, IOException {
        final String body = "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati";
        given()
              //  .log().all()
                .when()
                .get(ENDPOINT_COMMENTS)
                .then()
               // .log().all()
                .statusCode(200)
                .body("$", hasSize(1))
                .body("postId[0]", is(1))
                .body("id[0]", is(4))
                .body("name[0]", is("alias odio sit"))
                .body("email[0]", is("Lew@alysha.tv"))
                .body("body[0]", is(body));
    }

    @Test
    public void post() {
            given()
                .log().all()
                .body("{\"name\": \"Douglas Adriano Queiroz\", \"username\":\"dougaq\",\"email\": \"dougaq@gmail.com\"," +
                        "\"address\":{\"street\": \"Rod. João Paulo 692\",\"suite\": \"d\",\"city\": \"Florianópolis\",\"zipcode\": \"88030-300\", \"geo\":{\"lat\": \"-27.593500\",\"lng\": \"-48.558540\"}}," +
                        "\"phone\": \"(48) 999886724\",\"website\": \"https://www.linkedin.com/in/douglas-queiroz-680b1978/\",\"company\": {\"name\": \"nkey\",\"catchPhrase\": \"Coocriando Soluções Digitais\",\"bs\": \"nkey\"}}")
                .when()
                .post(ENDPOINT_POST_USERS)
                .then()
                .log().all()
                .statusCode(201)
                .body("id", is(11))
                .body("name", is("Douglas Adriano Queiroz"))
                .body("email", is("dougaq@gmail.com"));
    }

    @Test
    public void put() {
        given()
                .log().all()
                .body("{\"name\": \"Douglas Adriano Queirozz\", \"username\":\"dougaq\",\"email\": \"dougaq@gmail.com\"," +
                        "\"address\":{\"street\": \"Rod. João Paulo 692\",\"suite\": \"d\",\"city\": \"Florianópolis\",\"zipcode\": \"88030-300\", \"geo\":{\"lat\": \"-27.593500\",\"lng\": \"-48.558540\"}}," +
                        "\"phone\": \"(48) 999886724\",\"website\": \"https://www.linkedin.com/in/douglas-queiroz-680b1978/\",\"company\": {\"name\": \"nkey\",\"catchPhrase\": \"Coocriando Soluções Digitais\",\"bs\": \"nkey\"}}")
                .when()
                .put(ENDPOINT_PUT_USERS)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", is(5))
                .body("name", is("Douglas Adriano Queirozz"))
                .body("email", is("dougaq@gmail.com"));
    }
}




