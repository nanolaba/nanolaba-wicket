package com.nanolaba.wicket.components;

import com.nanolaba.wicket.interfaces.SerializableBooleanSupplier;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;


public class FTab<T extends WebMarkupContainer> extends AbstractTab {

    private final PanelSupplier<T> panelSupplier;
    private final SerializableBooleanSupplier visibilityFunction;

    public FTab(String title, PanelSupplier<T> panelSupplier) {
        this(Model.of(title), panelSupplier);
    }

    public FTab(String title, PanelSupplier<T> panelSupplier, SerializableBooleanSupplier visibilityFunction) {
        this(Model.of(title), panelSupplier, visibilityFunction);
    }

    public FTab(IModel<String> title, PanelSupplier<T> panelSupplier) {
        this(title, panelSupplier, null);
    }

    public FTab(IModel<String> title, PanelSupplier<T> panelSupplier, SerializableBooleanSupplier visibilityFunction) {
        super(title);
        this.panelSupplier = panelSupplier;
        this.visibilityFunction = visibilityFunction;
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
