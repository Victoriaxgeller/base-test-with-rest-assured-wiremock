package fakestore;

import com.google.gson.Gson;
import fakestore.data.GenerateTestData;
import mock.WireMockServerSetup;
import mock.WireMockClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class FakeStoreBaseTest {
    static WireMockServerSetup mockServer = new WireMockServerSetup();
    GenerateTestData generateCart = new GenerateTestData();
    Gson gson = new Gson();
    WireMockClient wireMockClient = new WireMockClient();

    @BeforeAll
    public static void beforeAll() {
        mockServer.start();
    }

    @AfterAll
    public static void afterAll() {
        mockServer.stop();
    }
}
