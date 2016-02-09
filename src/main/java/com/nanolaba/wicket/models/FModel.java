package com.nanolaba.wicket.models;

import com.nanolaba.wicket.interfaces.SerializableSupplier;
import org.apache.wicket.model.LoadableDetachableModel;

public class FModel<P> extends LoadableDetachableModel<P> {

    private static final long serialVersionUID = 1118033010998850740L;

    private final SerializableSupplier<P> getter;

    public FModel(SerializableSupplier<P> getter) {
        this.getter = getter;
    }

    public static <P> FModel<P> of(SerializableSupplier<P> getter) {
        return new FModel<>(getter);
    }

    @Override
    protected P load() {
        return getter.get();
    }
}