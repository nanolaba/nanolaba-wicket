package com.nanolaba.wicket.components.form;

import com.nanolaba.wicket.components.IComponentWithVisibilityFunction;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class FTextField extends TextField implements IComponentWithVisibilityFunction {

    private SerializableBooleanSupplier visibilityFunction;

    public FTextField(String id) {
        super(id);
    }

    public FTextField(String id, Class type) {
        super(id, type);
    }

    public FTextField(String id, IModel model) {
        super(id, model);
    }

    public FTextField(String id, IModel model, Class type) {
        super(id, model, type);
    }

    @Override
    public FTextField setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
        this.visibilityFunction = visibilityFunction;
        return this;
    }

    @Override
    protected void onConfigure() {
        if (visibilityFunction != null) {
            setVisible(visibilityFunction.getAsBoolean());
        }
    }
}
