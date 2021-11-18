package by.drivescape.preson;

import by.drivescape.TestAppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringJUnitWebConfig(TestAppConfig.class)
public class PersonControllerTests {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext wac) {
        this.mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/person")).andExpect(status().isOk()).andReturn();
        var response = mvcResult.getResponse();
        System.out.println(response.getContentAsString());
    }

}
