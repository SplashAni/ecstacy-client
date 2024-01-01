package dev.ecstacy.system.manager.managers;

import dev.ecstacy.event.events.KeyEvent;
import dev.ecstacy.event.events.TickEvent;
import dev.ecstacy.system.impl.module.Module;
import dev.ecstacy.system.manager.Manager;
import meteordevelopment.orbit.EventHandler;

import static dev.ecstacy.Main.mc;

public class EventManager extends Manager {
    public EventManager() {
        super("Events");
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
        ModuleManager.get().getActiveModules()
                .stream()
                .filter(module -> module.getKey() == event.getKey())
                .forEach(Module::toggle);
    }
}
