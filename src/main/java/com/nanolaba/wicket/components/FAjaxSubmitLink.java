package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.FormAjaxAction;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;

public class FAjaxSubmitLink extends AjaxSubmitLink {

    private final FormAjaxAction submitAction;
    private final FormAjaxAction afterSubmitAction;
    private final FormAjaxAction errorAction;

    public static FAjaxSubmitLink onSubmit(String id, FormAjaxAction submitAction) {
        return new FAjaxSubmitLink(id, submitAction, null, null);
    }

    public static FAjaxSubmitLink onAfterSubmit(String id, FormAjaxAction afterSubmitAction) {
        return new FAjaxSubmitLink(id, null, afterSubmitAction, null);
    }

    public static FAjaxSubmitLink onError(String id, FormAjaxAction errorAction) {
        return new FAjaxSubmitLink(id, null, null, errorAction);
    }

    public FAjaxSubmitLink(String id, FormAjaxAction submitAction, FormAjaxAction afterSubmitAction, FormAjaxAction errorAction) {
        this(id, null, submitAction, afterSubmitAction, errorAction);
    }

    public FAjaxSubmitLink(String id, Form<?> form, FormAjaxAction submitAction, FormAjaxAction afterSubmitAction, FormAjaxAction errorAction) {
        super(id, form);
        this.submitAction = submitAction;
        this.afterSubmitAction = afterSubmitAction;
        this.errorAction = errorAction;
    }

    @Override
    protected void onAfterSubmit(AjaxRequestTarget target, Form<?> form) {
        if (afterSubmitAction != null) {
            afterSubmitAction.makeAction(target, form);
        }
    }

    @Override
    protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
        if (submitAction != null) {
            submitAction.makeAction(target, form);
        }
    }

    @Override
    protected void onError(AjaxRequestTarget target, Form<?> form) {
        if (errorAction != null) {
            errorAction.makeAction(target, form);
        }
    }

}
