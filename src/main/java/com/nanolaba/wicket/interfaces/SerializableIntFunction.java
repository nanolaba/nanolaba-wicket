package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.IntFunction;

public interface SerializableIntFunction<R> extends IntFunction<R>, Serializable {
}
