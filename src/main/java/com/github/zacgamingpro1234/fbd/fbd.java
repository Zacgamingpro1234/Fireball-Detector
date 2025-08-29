package com.github.zacgamingpro1234.fbd;

import cc.polyfrost.oneconfig.events.EventManager;
import com.github.zacgamingpro1234.fbd.config.fdbConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = fbd.MODID, name = fbd.NAME, version = fbd.VERSION)
public class fbd {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    public static final Logger LOGGER = LogManager.getLogger("fbd");
    public static final Minecraft mc = Minecraft.getMinecraft();
    public fdbConfig config;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        config = new fdbConfig();
        EventManager.INSTANCE.register(this); //Registers Us To The EventBus
    }
}