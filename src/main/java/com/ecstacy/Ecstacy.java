package com.ecstacy;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ecstacy implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("ecstacy");
    public static final MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
		LOGGER.info("Loading ghost cheets..");
    }
}