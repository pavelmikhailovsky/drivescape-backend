package by.drivescape.preson;

import by.drivescape.configs.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

@SpringJUnitWebConfig(AppConfig.class)
public class PersonControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private WebTestClient webTestClient;

    @BeforeEach
    public void setUp() throws Exception {
        webTestClient = MockMvcWebTestClient.bindToApplicationContext(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080/api/v1").build();
        webTestClient.get().uri("/person")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
    }

}
