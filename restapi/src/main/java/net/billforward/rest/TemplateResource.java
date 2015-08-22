package net.billforward.rest;

import restx.*;
import restx.factory.Component;
import restx.factory.Factory;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by birch on 22/08/2015.
 */
@Component
public class TemplateResource extends StdRoute {
    private final Factory factory;

    @Inject
    public TemplateResource(Factory factory) {
        super("FactoryRoute", new StdRestxRequestMatcher("GET", "/@/factory"));
        this.factory = factory;
    }

    @Override
    public void handle(RestxRequestMatch match, RestxRequest req, RestxResponse resp, RestxContext ctx) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println(factory.dump());
    }
}
