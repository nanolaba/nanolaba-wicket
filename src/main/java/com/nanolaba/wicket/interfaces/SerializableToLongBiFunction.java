package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.ToLongBiFunction;

public interface SerializableToLongBiFunction<T, U> extends ToLongBiFunction<T, U>, Serializable {
}
