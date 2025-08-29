package com.github.zacgamingpro1234.fbd.hud;

import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.annotations.Number;
//import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.hud.BasicHud;
import cc.polyfrost.oneconfig.libs.universal.UMatrixStack;
//import cc.polyfrost.oneconfig.renderer.NanoVGHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;

import java.util.List;

import static com.github.zacgamingpro1234.fbd.fbd.*;

public class fdbHud extends BasicHud {
    transient public static final TextureManager texmanager = mc.getTextureManager();
    transient private static volatile float size;
    transient public static boolean fbnear = false;

    @Dropdown(
            name = "Viewing Option",        // name of the component
    //        options = {"Simple Icon", "Minimap"},
            options = {"Simple Icon"},
            size = 2
    )
    public static int vopt = 0;        // default option (here "Another Option")

    @Number(
            name = "The X Bounding Box",
            min = 0, max = 64,
            step = 5
    )
    public static int xbox = 30; // default value

    @Number(
            name = "The Y Bounding Box",
            min = 0, max = 64,
            step = 5
    )
    public static int ybox = 30; // default value

    @Number(
            name = "The Z Bounding Box",
            min = 0, max = 64,
            step = 5
    )
    public static int zbox = 30; // default value

    @Override
    protected void draw(UMatrixStack matrices, float x, float y, float scale, boolean example) {
        size = 16 * scale;
        if (vopt == 0) {
            if (chkfb()) {
                drawSI(x, y);
            }
        } else {
//            drawmp(x, y);
        }
    }

    private static boolean chkfb() {
        AxisAlignedBB area = mc.thePlayer.getEntityBoundingBox().expand(xbox,ybox,zbox);
        List<EntityFireball> fireballs = mc.theWorld.getEntitiesWithinAABB(EntityLargeFireball.class, area);
        return !fireballs.isEmpty();
    }

    private static void drawSI(float x, float y) {
        texmanager.bindTexture(new ResourceLocation("minecraft",
                "textures/items/fireball.png"));
        int sizernd = Math.round(size);
        GuiScreen.drawScaledCustomSizeModalRect(
                Math.round(x), Math.round(y), 0, 0,
                sizernd, sizernd,
                sizernd, sizernd,
                size, size);
    }

//    private static void drawmp(float x, float y) {
//        NanoVGHelper.INSTANCE.setupAndDraw(true, vg -> NanoVGHelper.INSTANCE.drawCircle(
//                vg, x, y, size,
//                OneColor.HSBAtoARGB(0, 0, 0, 128)
//        ));
//    }

    @Override
    protected float getWidth(float scale, boolean example) {
        return 16 * scale;
    }

    @Override
    protected float getHeight(float scale, boolean example) {
        return 16 * scale;
    }
}
