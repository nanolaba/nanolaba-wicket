package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.ToLongFunction;

public interface SerializableToLongFunction<T> extends ToLongFunction<T>, Serializable {
}
