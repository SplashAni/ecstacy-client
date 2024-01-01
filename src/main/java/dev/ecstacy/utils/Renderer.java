package dev.ecstacy.utils;

import net.minecraft.client.gui.DrawContext;

import java.awt.*;

import static dev.ecstacy.Main.mc;

public class Renderer {
    DrawContext context;
    ColorUtils colors;

    public Renderer(DrawContext context) {
        this.context = context;
        this.colors = ColorUtils.get();
    }

    public ColorUtils getColors() {
        return colors;
    }

    public DrawContext getContext() {
        return context;
    }

    public void drawText(String text, Spacing spacing, int x, int y, int width, Color color) {

        int textX = switch (spacing) {
            case Center -> x + (width - mc.textRenderer.getWidth(text)) / 2;
            case Left -> x;
            case Right -> x + width - mc.textRenderer.getWidth(text);
        };


        context.drawTextWithShadow(mc.textRenderer, text, textX, y + mc.textRenderer.fontHeight / 2, color.getRGB());
    }
    

    public enum Spacing {
        Center,
        Left,
        Right
    }

}
