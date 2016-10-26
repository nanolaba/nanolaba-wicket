package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.Action;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;


public class FLink<T> extends Link<T> {

    private final Action action;
    private SerializableBooleanSupplier visibilityFunction;

    public FLink(String id, Action action) {
        super(id);
        this.action = action;
    }

    public FLink(String id, IModel<T> model, Action action) {
        super(id, model);
        this.action = action;
    }

    public FLink<T> setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
        this.visibilityFunction = visibilityFunction;
        return this;
    }

    @Override
    protected void onConfigure() {
        if (visibilityFunction != null) {
            setVisible(visibilityFunction.getAsBoolean());
        }
    }

    @Override
    public void onClick() {
        action.makeAction();
    }
}
