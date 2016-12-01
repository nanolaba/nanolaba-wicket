package com.nanolaba.wicket.components.panel;

import com.nanolaba.wicket.components.IComponentWithVisibilityFunction;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class FPanel<T> extends GenericPanel implements IComponentWithVisibilityFunction<FPanel> {

    private SerializableBooleanSupplier visibilityFunction;

    public FPanel(String id) {
        super(id);
    }

    public FPanel(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    public FPanel setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
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
