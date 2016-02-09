package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

public class FContainer extends WebMarkupContainer {

    private static final long serialVersionUID = 4352939921616009887L;

    private final SerializableBooleanSupplier visibilityFunction;

    public FContainer(String id, SerializableBooleanSupplier visibilityFunction, boolean renderBodyOnly) {
        this(id, null, visibilityFunction, renderBodyOnly);
    }

    public FContainer(String id, SerializableBooleanSupplier visibilityFunction) {
        this(id, visibilityFunction, false);
    }

    public FContainer(String id, IModel<String> model, SerializableBooleanSupplier visibilityFunction) {
        this(id, model, visibilityFunction, false);
    }

    public FContainer(String id, IModel<String> model, SerializableBooleanSupplier visibilityFunction, boolean renderBodyOnly) {
        super(id, model);
        this.visibilityFunction = visibilityFunction;
        setRenderBodyOnly(renderBodyOnly);
    }

    @Override
    protected void onConfigure() {
        setVisible(visibilityFunction.getAsBoolean());
        super.onConfigure();
    }
}
