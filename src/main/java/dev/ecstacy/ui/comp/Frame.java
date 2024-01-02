package dev.ecstacy.ui.comp;

import dev.ecstacy.system.impl.module.Category;
import dev.ecstacy.utils.Renderer;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;
import java.util.List;

public class Frame {
    int x, y;
    String name;
    boolean extended;
    int width, height;
    Category category;

    public Frame(String name, Category category, int x, int y) {

        this.category = category;
        this.name = name;
        this.x = x;
        this.y = y;
        extended = true;

        this.width = 100;
        this.height = 15;

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {

        Renderer renderer = new Renderer(context);


        renderer.drawText(name, Renderer.Spacing.Center, x, y, width, Color.WHITE);

        context.fill(x, y, x + width, y + height, Color.BLACK.getRGB());

        int offset = height;
        for (String module : bruh()) {

            context.fill(this.x, this.y + offset, this.x + this.getWidth(), this.y + this.getHeight() + offset,
                    new Color(51, 49, 49, 255).getRGB());

            renderer.drawText(module, Renderer.Spacing.Center, this.x, this.y + offset, this.getWidth(), Color.WHITE);
            offset += height;
        }


    }

    public List<String> bruh() {
        return List.of("wtf", "hi", "xd", "Ok");
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

        if (isHovered((int) mouseX, (int) mouseY) && button == 1) {
            extended = !extended;
        }

    }

    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}
