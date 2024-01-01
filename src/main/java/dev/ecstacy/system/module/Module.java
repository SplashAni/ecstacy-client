package dev.ecstacy.system.module;

import dev.ecstacy.Main;
import net.minecraft.client.MinecraftClient;

public class Module {

    String name;
    Category category;
    public MinecraftClient mc = Main.mc;

    public Module(String name, Category category) {

    }

    public void onTick() {

    }

    public void onDeactivate() {
        Main.BUS.unsubscribe(this);
    }

    public void onActivate() {
        Main.BUS.subscribe(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
