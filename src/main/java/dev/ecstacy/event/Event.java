package dev.ecstacy.event;

import meteordevelopment.orbit.ICancellable;

public class Event implements ICancellable {
    @Override
    public void setCancelled(boolean cancelled) {

    }

    @Override
    public void cancel() {
        ICancellable.super.cancel();
    }

    @Override
    public boolean isCancelled() {
        return false;
    }
}
