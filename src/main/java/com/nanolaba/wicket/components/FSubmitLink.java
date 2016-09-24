package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.Action;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;


public class FSubmitLink extends SubmitLink {

    private final Action action;

    public FSubmitLink(String id, Action action) {
        super(id);
        this.action = action;
    }

    public FSubmitLink(String id, Form<?> form, Action action) {
        super(id, form);
        this.action = action;
    }

    public FSubmitLink(String id, IModel<?> model, Action action) {
        super(id, model);
        this.action = action;
    }

    public FSubmitLink(String id, IModel<?> model, Form<?> form, Action action) {
        super(id, model, form);
        this.action = action;
    }

    @Override
    public void onSubmit() {
        action.makeAction();
    }
}
