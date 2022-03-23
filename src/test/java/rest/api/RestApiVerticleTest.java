package rest.api;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class RestApiVerticleTest {

    @BeforeAll
    static void setup(Vertx vertx,
                      VertxTestContext testContext) {
        vertx.deployVerticle(new RestApiVerticle(), testContext.succeeding(restApiVerticleId -> testContext.completeNow()));
    }

    @Test
    public void testRestApi(Vertx vertx, VertxTestContext testContext) {
        final WebClient webClient = WebClient.create(vertx);

        webClient.get(8080, "localhost", "")
                .as(BodyCodec.buffer())
                .send(testContext.succeeding(response -> {
                            testContext.verify(() ->
                                    Assertions.assertAll(
                                            () -> Assertions.assertEquals(200, response.statusCode())
                                    )
                            );
                            testContext.completeNow();
                        })
                );
    }
}
