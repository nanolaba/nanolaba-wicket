package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;

public interface IComponentWithVisibilityFunction<T> {

    T setVisibilityFunction(SerializableBooleanSupplier visibilityFunction);
}
