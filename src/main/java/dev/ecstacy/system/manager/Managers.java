package dev.ecstacy.system.manager;

import dev.ecstacy.Main;
import dev.ecstacy.system.manager.managers.EventManager;
import dev.ecstacy.system.manager.managers.ModuleManager;

import java.util.ArrayList;
import java.util.List;

import static dev.ecstacy.Main.BUS;

public class Managers {
    public static Managers get() {
        return new Managers();
    }
    private static final List<Manager> managers = new ArrayList<>();

    public static void initialize() {

        managers.add(new ModuleManager());
        managers.add(new EventManager());

        managers.forEach(Manager::onInitialize);

        BUS.subscribe(getManager("Events"));
    }
    public static Manager getManager(String name) {
        return managers.stream()
                .filter(manager -> manager.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
