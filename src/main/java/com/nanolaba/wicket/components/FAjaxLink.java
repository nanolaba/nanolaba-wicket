package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.AjaxAction;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;


public class FAjaxLink<T> extends AjaxLink<T> {

    private AjaxAction clickAction;
    private SerializableBooleanSupplier visibilityFunction;

    public FAjaxLink(String id) {
        super(id);
    }

    public FAjaxLink(String id, IModel<T> model) {
        super(id, model);
    }

    public FAjaxLink(String id, AjaxAction clickAction) {
        super(id);
        this.clickAction = clickAction;
    }

    public FAjaxLink(String id, IModel<T> model, AjaxAction clickAction) {
        super(id, model);
        this.clickAction = clickAction;
    }

    public FAjaxLink<T> setClickAction(AjaxAction clickAction) {
        this.clickAction = clickAction;
        return this;
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
        if (clickAction != null) {
            clickAction.makeAction(target);
        }
    }
}
