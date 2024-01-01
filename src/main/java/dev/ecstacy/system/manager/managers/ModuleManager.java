package dev.ecstacy.system.manager.managers;

import dev.ecstacy.system.impl.module.Module;
import dev.ecstacy.system.impl.module.modules.Fly;
import dev.ecstacy.system.manager.Manager;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager extends Manager {
    public ModuleManager() {
        super("Modules");
    }

    public List<Module> modules = new ArrayList<>();

    @Override
    public void onInitialize() {

        modules.add(new Fly());

        super.onInitialize();
    }

    public List<Module> getModules() {
        return modules;
    }

}
