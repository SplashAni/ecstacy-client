package dev.ecstacy.system.impl.module.modules;

import dev.ecstacy.system.impl.module.Category;
import dev.ecstacy.system.impl.module.Module;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.entity.EntityPose;
import org.lwjgl.glfw.GLFW;

public class Fly extends Module {
    public Fly() {
        super("Fly",Category.World);
        setKey(GLFW.GLFW_KEY_Z);
    }

    @Override
    public void onTick() {
        System.out.println("hi");
        mc.player.setPose(EntityPose.CROAKING);
        super.onTick();
    }

    @Override
    public void onDeactivate() {
        super.onDeactivate();
    }

    @Override
    public void onActivate() {
        super.onActivate();
    }
}
