package dev.ecstacy.system.impl.module;

import dev.ecstacy.Main;
import net.minecraft.client.MinecraftClient;

public abstract class Module {

    int key;
    String name;
    boolean active;
    Category category;
    public MinecraftClient mc = Main.mc;

    public Module(String name, Category category) {

    }

    public void onTick() {

    }
    public void toggle() {
        active = !active;

        if (isActive()) {
            onActivate();
        } else {
            onDeactivate();
        }
    }

    public boolean isActive() {
        return active;
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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
