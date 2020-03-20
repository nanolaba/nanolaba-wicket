package com.nanolaba.wicket.util;

import org.apache.wicket.model.IDetachable;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.cycle.RequestCycle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.Map;

public interface IWicketUtils {

    default HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse) RequestCycle.get().getResponse().getContainerResponse();
    }

    default HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) RequestCycle.get().getRequest().getContainerRequest();
    }

    default HttpSession getHttpSession() {
        return ((HttpServletRequest) RequestCycle.get().getRequest().getContainerRequest()).getSession(true);
    }

    default void sendPermanentRedirect(String url) {
        HttpServletResponse response = getHttpServletResponse();
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", url);
    }


    default void detachFields(Object... objects) {
        try {
            for (Object oo : objects) {
                for (Field field : oo.getClass().getDeclaredFields()) {
                    field.setAccessible(true);

                    Object o = field.get(oo);
                    if (o instanceof IDetachable) {
                        ((IDetachable) o).detach();
                    } else if (o instanceof Iterable) {
                        for (Object value : (Iterable) o) {
                            if (value instanceof IDetachable) {
                                ((IDetachable) value).detach();
                            }
                        }
                    } else if (o instanceof Map) {
                        for (Object value : ((Map) o).values()) {
                            if (value instanceof IDetachable) {
                                ((IDetachable) value).detach();
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    default void detach(IDetachable... models) {
        if (models != null) {
            for (IDetachable model : models) {
                if (model != null) {
                    model.detach();
                }
            }
        }
    }

    default void detach(Iterable<? extends IDetachable> models) {
        if (models != null) {
            for (IDetachable model : models) {
                if (model != null) {
                    model.detach();
                }
            }
        }
    }

    default <T> T get(IModel<T> model) {
        return get(model, null);
    }

    default <T> T get(IModel<T> model, T defaultValue) {
        if (model == null) {
            return defaultValue;
        }
        T object = model.getObject();
        return object == null ? defaultValue : object;
    }
}
