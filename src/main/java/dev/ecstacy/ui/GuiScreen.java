package dev.ecstacy.ui;

import dev.ecstacy.system.impl.module.Category;
import dev.ecstacy.ui.parts.Frame;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GuiScreen extends Screen {

    /*
     * Gui will consist of 3 parts,
     * Frame (Main Heading part of the gui)
     * Button (Module buttons, where module names will)
     * Settings (Under the Button when clicked will display the module settings,
     * this will contain its components)
     */


    List<Frame> frames;

    public GuiScreen() {

        super(Text.literal("Gui"));

        AtomicInteger offset = new AtomicInteger(5);

        frames = Arrays.stream(Category.values())
                .map(category -> new Frame(category.name(), offset.get(), 15))
                .peek(frame -> offset.addAndGet(105))
                .collect(Collectors.toList());

    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        frames.forEach(frame -> frame.render(context, mouseX, mouseY));

        super.render(context, mouseX, mouseY, delta);
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        frames.forEach(frame -> frame.mouseClicked(mouseX, mouseY, button));

        return super.mouseClicked(mouseX, mouseY, button);
    }


}
