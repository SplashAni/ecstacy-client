package dev.ecstacy.mixins;

import dev.ecstacy.Main;
import dev.ecstacy.event.events.KeyEvent;
import dev.ecstacy.ui.Gui;
import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static dev.ecstacy.Main.mc;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {

        if(key == GLFW.GLFW_KEY_UNKNOWN) return;

        if (Main.BUS.post(new KeyEvent(key, scancode,action)).isCancelled()) ci.cancel();

    }
}
