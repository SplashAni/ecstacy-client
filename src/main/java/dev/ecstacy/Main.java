package dev.ecstacy;

import dev.ecstacy.event.events.KeyEvent;
import dev.ecstacy.event.events.TickEvent;
import dev.ecstacy.system.impl.module.Module;
import dev.ecstacy.system.manager.Managers;
import dev.ecstacy.system.manager.managers.ModuleManager;
import dev.ecstacy.ui.GuiScreen;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.EventHandler;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Main implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("ecstacy");
    public static final IEventBus BUS = new EventBus();
    public static final MinecraftClient mc = MinecraftClient.getInstance();


    @Override
    public void onInitialize() {

        BUS.registerLambdaFactory("dev.ecstacy", (lookupInMethod, klass)
                -> (MethodHandles.Lookup) lookupInMethod.invoke(null,
                klass, MethodHandles.lookup())
        );

        BUS.subscribe(this);


        Managers.initialize();

        LOGGER.info("Loading ghost cheets..");
    }
    @EventHandler
    public void onTick(TickEvent event) {

        if (mc.world == null) return;

        for (Module module : ModuleManager.get().getActiveModules()) {
            module.onTick();
        }
    }

    @EventHandler
    public void onKey(KeyEvent event) {

        if(event.getKey() == GLFW.GLFW_KEY_RIGHT_SHIFT){
            mc.setScreen(new GuiScreen());
        }

        ModuleManager.get().getActiveModules()
                .stream()
                .filter(module -> module.getKey() == event.getKey())
                .forEach(Module::toggle);

    }
}