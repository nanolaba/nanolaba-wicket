package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.Action;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;


public class FLink<T> extends Link<T> {

    private final Action action;

    public FLink(String id, Action action) {
        super(id);
        this.action = action;
    }

    public FLink(String id, IModel<T> model, Action action) {
        super(id, model);
        this.action = action;
    }

    @Override
    public void onClick() {
        action.makeAction();
    }
}
