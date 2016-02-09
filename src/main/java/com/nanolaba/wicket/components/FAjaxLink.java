package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.AjaxAction;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;


public class FAjaxLink<T> extends AjaxLink<T> {

    private static final long serialVersionUID = 166504194001783109L;

    private final AjaxAction action;

    public FAjaxLink(String id, AjaxAction action) {
        super(id);
        this.action = action;
    }

    public FAjaxLink(String id, IModel<T> model, AjaxAction action) {
        super(id, model);
        this.action = action;
    }

    @Override
    public void onClick(AjaxRequestTarget target) {
        action.makeAction(target);
    }
}
