package com.nanolaba.wicket.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;

import java.io.Serializable;

public class FAjaxSubmitLink extends AjaxSubmitLink {

    private final FormAjaxSubmitAction action;

    public FAjaxSubmitLink(String id, FormAjaxSubmitAction action) {
        super(id);
        this.action = action;
    }

    public FAjaxSubmitLink(String id, Form<?> form, FormAjaxSubmitAction action) {
        super(id, form);
        this.action = action;
    }

    @Override
    protected void onAfterSubmit(AjaxRequestTarget target, Form<?> form) {
        action.makeAction(target, form);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FunctionalInterface
    public interface FormAjaxSubmitAction extends Serializable {

        void makeAction(AjaxRequestTarget target, Form<?> form);
    }
}
