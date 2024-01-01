package dev.ecstacy.ui.parts;

import dev.ecstacy.utils.Renderer;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class Frame {
    String name;
    int x;
    int y;
    int width, height;

    public Frame(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;

        width = 100;
        height = 15;
    }


    public void render(DrawContext context, int mouseX, int mouseY) {

        Renderer renderer = new Renderer(context);


        renderer.drawText(name, Renderer.Spacing.Center, x, y, width, Color.WHITE);
        context.fill(x, y, x + width, y + height, Color.BLACK.getRGB());

    }


    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered((int) mouseX, (int) mouseY) && button == 1) {

        }
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}
