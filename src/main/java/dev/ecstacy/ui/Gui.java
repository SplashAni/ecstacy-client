package dev.ecstacy.ui;

import dev.ecstacy.utils.Renderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.awt.*;

public class Gui extends Screen {
    public Gui() {
        super(Text.of("Gui"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        Renderer renderer = new Renderer(context);


        renderer.drawRectangle(69,69,60,20, Color.GREEN);


        super.render(context, mouseX, mouseY, delta);
    }
}
