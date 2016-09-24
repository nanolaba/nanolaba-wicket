package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.AjaxAction;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.model.IModel;

public class FAjaxCheckBox extends AjaxCheckBox {

    private final AjaxAction action;

    public FAjaxCheckBox(String id, AjaxAction action) {
        super(id);
        this.action = action;
    }

    public FAjaxCheckBox(String id, IModel<Boolean> model, AjaxAction action) {
        super(id, model);
        this.action = action;
    }

    @Override
    protected void onUpdate(AjaxRequestTarget target) {
        action.makeAction(target);
    }
}
