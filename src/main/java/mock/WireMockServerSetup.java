package mock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockServerSetup {
   static WireMockServer wireMockServer;

    public void start() {
        wireMockServer = new WireMockServer(8088);
        configureFor("localhost", 8088);
        wireMockServer.start();
    }



    public void stop() {
        wireMockServer.stop();
    }

}
