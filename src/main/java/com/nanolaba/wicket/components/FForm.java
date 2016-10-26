package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.Action;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public class FForm extends Form {

    private final Action action;
    private SerializableBooleanSupplier visibilityFunction;

    public FForm(String id, Action action) {
        super(id);
        this.action = action;
    }

    public FForm(String id, IModel model, Action action) {
        super(id, model);
        this.action = action;
    }

    public FForm setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
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
    protected void onSubmit() {
        action.makeAction();
        super.onSubmit();
    }
}
