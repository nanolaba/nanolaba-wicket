package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.ToDoubleBiFunction;

public interface SerializableToDoubleBiFunction<T, U> extends ToDoubleBiFunction<T, U>, Serializable {
}
