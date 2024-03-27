package config;

import org.aeonbits.owner.Config;

public interface Configuration extends Config {

    @DefaultValue("https://petstore.swagger.io/v2/")
    @Key("baseURL")
    String baseURL();

    @DefaultValue("https://fakestoreapi.com")
    @Key("fakestoreApiURL")
    String fakestoreApiURL();

    @DefaultValue("localhost")
    @Key("wireMockHost")
    String wireMockHost();

    @DefaultValue("8088")
    @Key("wireMockPort")
    Integer wireMockPort();

}
