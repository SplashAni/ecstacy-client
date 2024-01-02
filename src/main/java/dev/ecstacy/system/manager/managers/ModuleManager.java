package dev.ecstacy.system.manager.managers;

import dev.ecstacy.system.impl.module.Category;
import dev.ecstacy.system.impl.module.Module;
import dev.ecstacy.system.impl.module.modules.Fly;
import dev.ecstacy.system.manager.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager extends Manager {
    public static ModuleManager get() {
        return new ModuleManager();
    }
    public ModuleManager() {
        super("Modules");
    }

    public List<Module> modules = new ArrayList<>();

    @Override
    public void onInitialize() {

        modules.add(new Fly());

        super.onInitialize();
    }

    public List<Module> getActiveModules() {
        return modules.stream()
                .filter(Module::isActive)
                .collect(Collectors.toList());
    }
    public List<Module> getCategory(Category category) {
        return modules.stream()
                .filter(module -> module.getCategory().equals(category))
                .collect(Collectors.toList());
    }


}
