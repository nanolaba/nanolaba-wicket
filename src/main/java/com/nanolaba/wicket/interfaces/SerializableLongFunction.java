package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.LongFunction;

public interface SerializableLongFunction<R> extends LongFunction<R>, Serializable {
}
