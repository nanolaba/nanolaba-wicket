package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.FormAjaxAction;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;

public class FAjaxSubmitLink extends AjaxSubmitLink implements IComponentWithVisibilityFunction<FAjaxSubmitLink> {

    private FormAjaxAction submitAction;
    private FormAjaxAction afterSubmitAction;
    private FormAjaxAction errorAction;
    private SerializableBooleanSupplier visibilityFunction;

    public FAjaxSubmitLink(String id) {
        super(id);
    }

    public FAjaxSubmitLink(String id, Form<?> form) {
        super(id, form);
    }

    public FAjaxSubmitLink setSubmitAction(FormAjaxAction submitAction) {
        this.submitAction = submitAction;
        return this;
    }

    public FAjaxSubmitLink setAfterSubmitAction(FormAjaxAction afterSubmitAction) {
        this.afterSubmitAction = afterSubmitAction;
        return this;
    }

    public FAjaxSubmitLink setErrorAction(FormAjaxAction errorAction) {
        this.errorAction = errorAction;
        return this;
    }

    @Override
    public FAjaxSubmitLink setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
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
