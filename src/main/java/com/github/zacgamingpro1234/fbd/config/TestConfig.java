package com.github.zacgamingpro1234.fbd.config;

import com.github.zacgamingpro1234.fbd.fbd;
import com.github.zacgamingpro1234.fbd.hud.TestHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.HUD;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class TestConfig extends Config {
    @HUD(
            name = "Example HUD"
    )
    public TestHud hud = new TestHud();

    public TestConfig() {
        super(new Mod(fbd.NAME, ModType.UTIL_QOL), fbd.MODID + ".json");
        initialize();
    }
}

