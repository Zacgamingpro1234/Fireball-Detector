package com.github.zacgamingpro1234.fbd.config;

import com.github.zacgamingpro1234.fbd.fbd;
import com.github.zacgamingpro1234.fbd.hud.fdbHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.HUD;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class fdbConfig extends Config {
    @HUD(
            name = "Fireball Detector HUD"
    )
    public fdbHud hud = new fdbHud();

    public fdbConfig() {
        super(new Mod(fbd.NAME, ModType.UTIL_QOL), fbd.MODID + ".json");
        initialize();
    }
}

