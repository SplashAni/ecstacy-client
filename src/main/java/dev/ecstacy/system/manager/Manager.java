package dev.ecstacy.system.manager;

public abstract class Manager {
    String name;
    public Manager(String name){
        this.name = name;
    }
    public void onInitialize(){

    }

    public String getName() {
        return name;
    }
}
