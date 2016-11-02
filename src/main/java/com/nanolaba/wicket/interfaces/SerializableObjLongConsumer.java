package com.nanolaba.wicket.interfaces;

import java.io.Serializable;
import java.util.function.ObjLongConsumer;

public interface SerializableObjLongConsumer<T> extends ObjLongConsumer<T>, Serializable {
}
