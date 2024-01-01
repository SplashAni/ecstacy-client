package dev.ecstacy.system.manager.managers;

import dev.ecstacy.event.events.KeyEvent;
import dev.ecstacy.event.events.TickEvent;
import dev.ecstacy.system.impl.module.Module;
import dev.ecstacy.system.manager.Manager;
import dev.ecstacy.ui.Gui;
import meteordevelopment.orbit.EventHandler;
import org.lwjgl.glfw.GLFW;

import java.util.logging.Logger;

import static dev.ecstacy.Main.LOGGER;
import static dev.ecstacy.Main.mc;

public class EventManager extends Manager {
    public EventManager() {
        super("Events");
    }


}
