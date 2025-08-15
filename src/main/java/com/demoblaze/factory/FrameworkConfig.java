package com.demoblaze.factory;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/config.properties")
public interface FrameworkConfig extends Config {
    @Key("browser")
    String browser();

    @Key("baseUrl")
    String baseUrl();
}

