package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.Action;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public class FForm extends Form {

    private static final long serialVersionUID = 4078344864715682597L;

    private final Action action;

    public FForm(String id, Action action) {
        super(id);
        this.action = action;
    }

    public FForm(String id, IModel model, Action action) {
        super(id, model);
        this.action = action;
    }

    @Override
    protected void onSubmit() {
        action.makeAction();
        super.onSubmit();
    }
}
