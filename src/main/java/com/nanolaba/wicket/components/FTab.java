package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;


public class FTab<T extends WebMarkupContainer> extends AbstractTab {

    private final PanelSupplier<T> panelSupplier;
    private SerializableBooleanSupplier visibilityFunction;

    public FTab(String title, PanelSupplier<T> panelSupplier) {
        this(Model.of(title), panelSupplier);
    }

    public FTab(IModel<String> title, PanelSupplier<T> panelSupplier) {
        super(title);
        this.panelSupplier = panelSupplier;
    }

    public FTab<T> setVisibilityFunction(SerializableBooleanSupplier visibilityFunction) {
        this.visibilityFunction = visibilityFunction;
        return this;
    }

    @Override
    public WebMarkupContainer getPanel(String id) {
        return panelSupplier.get(id);
    }

    @Override
    public boolean isVisible() {
        return visibilityFunction == null ? super.isVisible() : visibilityFunction.getAsBoolean();
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public interface PanelSupplier<T extends WebMarkupContainer> extends Serializable {
        T get(String panelId);
    }

}
