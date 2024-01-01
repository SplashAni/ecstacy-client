package dev.ecstacy.system.manager;

import dev.ecstacy.system.manager.managers.ModuleManager;

import java.util.ArrayList;
import java.util.List;

public class Managers {
    private static final List<Manager> managers = new ArrayList<>();

    public static void initialize() {

        managers.add(new ModuleManager());

        managers.forEach(Manager::onInitialize);

    }
    public Manager getManager(String name) {
        return managers.stream()
                .filter(manager -> manager.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
