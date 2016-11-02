package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.ObjIntConsumer;

public interface SerializableObjIntConsumer<T> extends ObjIntConsumer<T>, Serializable {
}
