package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.Action;
import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public class FForm extends Form {

    private Action submitAction;
    private Action errorAction;
    private SerializableBooleanSupplier visibilityFunction;

    public FForm(String id) {
        super(id);
    }

    public FForm(String id, IModel model) {
        super(id, model);
    }

    public FForm(String id, Action submitAction) {
        super(id);
        this.submitAction = submitAction;
    }

    public FForm setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
        this.visibilityFunction = visibilityFunction;
        return this;
    }

    public FForm setSubmitAction(Action submitAction) {
        this.submitAction = submitAction;
        return this;
    }

    public FForm setErrorAction(Action errorAction) {
        this.errorAction = errorAction;
        return this;
    }

    @Override
    protected void onError() {
        if (errorAction != null) {
            errorAction.makeAction();
        }
    }

    @Override
    protected void onConfigure() {
        if (visibilityFunction != null) {
            setVisible(visibilityFunction.getAsBoolean());
        }
    }

    @Override
    protected void onSubmit() {
        if (submitAction != null) {
            submitAction.makeAction();
        }
    }
}
