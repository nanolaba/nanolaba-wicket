package com.nanolaba.wicket.interfaces;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;

import java.io.Serializable;

@FunctionalInterface
public interface FormAjaxAction extends Serializable {

    void makeAction(AjaxRequestTarget target, Form<?> form);
}
