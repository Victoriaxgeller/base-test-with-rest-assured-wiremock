package config;

import org.aeonbits.owner.Config;

public interface Configuration extends Config {

    @DefaultValue("https://petstore.swagger.io/v2/")
    @Key("baseURL")
    String baseURL();

}
