package com.nanolaba.wicket.util;

import org.apache.wicket.request.cycle.RequestCycle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

}
