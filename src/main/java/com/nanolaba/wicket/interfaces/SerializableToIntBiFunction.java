package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.ToIntBiFunction;

public interface SerializableToIntBiFunction<T, U> extends ToIntBiFunction<T, U>, Serializable {
}
