package com.demoblaze.factory;

import org.aeonbits.owner.ConfigCache;

public class ConfigFactory {
    public static FrameworkConfig getConfig() {
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }
}

