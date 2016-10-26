package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.AjaxAction;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;


public class FAjaxLink<T> extends AjaxLink<T> {

    private final AjaxAction action;
    private SerializableBooleanSupplier visibilityFunction;

    public FAjaxLink(String id, AjaxAction action) {
        super(id);
        this.action = action;
    }

    public FAjaxLink(String id, IModel<T> model, AjaxAction action) {
        super(id, model);
        this.action = action;
    }

    public FAjaxLink<T> setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
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
    public void onClick(AjaxRequestTarget target) {
        action.makeAction(target);
    }
}
