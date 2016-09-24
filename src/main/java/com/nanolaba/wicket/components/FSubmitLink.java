package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.Action;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;

public class FSubmitLink extends SubmitLink {

    private final Action submitAction;
    private final Action afterSubmitAction;
    private final Action errorAction;

    public static FSubmitLink onSubmit(String id, Action submitAction) {
        return new FSubmitLink(id, submitAction, null, null);
    }

    public static FSubmitLink onAfterSubmit(String id, Action afterSubmitAction) {
        return new FSubmitLink(id, null, afterSubmitAction, null);
    }

    public static FSubmitLink onError(String id, Action errorAction) {
        return new FSubmitLink(id, null, null, errorAction);
    }

    public FSubmitLink(String id, Action submitAction, Action afterSubmitAction, Action errorAction) {
        super(id);
        this.submitAction = submitAction;
        this.afterSubmitAction = afterSubmitAction;
        this.errorAction = errorAction;
    }

    public FSubmitLink(String id, Form<?> form, Action submitAction, Action afterSubmitAction, Action errorAction) {
        super(id, form);
        this.submitAction = submitAction;
        this.afterSubmitAction = afterSubmitAction;
        this.errorAction = errorAction;
    }

    public FSubmitLink(String id, IModel<?> model, Action submitAction, Action afterSubmitAction, Action errorAction) {
        super(id, model);
        this.submitAction = submitAction;
        this.afterSubmitAction = afterSubmitAction;
        this.errorAction = errorAction;
    }

    public FSubmitLink(String id, IModel<?> model, Form<?> form, Action submitAction, Action afterSubmitAction, Action errorAction) {
        super(id, model, form);
        this.submitAction = submitAction;
        this.afterSubmitAction = afterSubmitAction;
        this.errorAction = errorAction;
    }

    @Override
    public void onSubmit() {
        if (submitAction != null) {
            submitAction.makeAction();
        }
    }

    @Override
    public void onError() {
        if (errorAction != null) {
            errorAction.makeAction();
        }
    }

    @Override
    public void onAfterSubmit() {
        if (afterSubmitAction != null) {
            afterSubmitAction.makeAction();
        }
    }
}
