package dev.ecstacy.utils;

import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class Renderer {
    DrawContext context;

    public Renderer(DrawContext context) {
        this.context = context;
    }

    public DrawContext getContext() {
        return context;
    }

    public void drawRectangle(int x, int y, int width, int height, Color color) {
        context.fill(x, y, width, height, color.getRGB());
    }

}
