package dev.ecstacy;

import dev.ecstacy.system.manager.Manager;
import dev.ecstacy.system.manager.Managers;
import dev.ecstacy.system.manager.managers.ModuleManager;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class Main implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("ecstacy");
    public static final IEventBus BUS = new EventBus();
    public static final MinecraftClient mc = MinecraftClient.getInstance();


    @Override
    public void onInitialize() {

        BUS.registerLambdaFactory("dev.ecstasy", (lookupInMethod, klass)
                -> (MethodHandles.Lookup) lookupInMethod.invoke(null,
                klass, MethodHandles.lookup())
        );


        Managers.initialize();


        LOGGER.info("Loading ghost cheets..");
    }
}