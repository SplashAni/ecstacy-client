package splash.ecstacy;

import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Main implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("ecstacy");
    public static final IEventBus bus = new EventBus();
    public static final MinecraftClient mc = MinecraftClient.getInstance();


    @Override
    public void onInitialize() {

        bus.registerLambdaFactory("splash.ecstasy", (lookupInMethod, klass)
                -> (MethodHandles.Lookup) lookupInMethod.invoke(null,
                klass, MethodHandles.lookup())
        );



		LOGGER.info("Loading ghost cheets..");
    }
}