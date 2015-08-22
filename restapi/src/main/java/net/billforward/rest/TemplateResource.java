package net.billforward.rest;

import restx.*;
import restx.factory.Component;
import restx.factory.Factory;

import javax.inject.Inject;
import java.io.IOException;

import net.billforward.*;

/**
 * Created by birch on 22/08/2015.
 */
@Component
public class TemplateResource extends StdRoute {
//    private final Factory factory;

    @Inject
    public TemplateResource(Factory factory) {
//        super("FactoryRoute", new StdRestxRequestMatcher("GET", "/@/factory"));
        super("TemplateRoute", new StdRestxRequestMatcher("GET", "/template"));
//        this.factory = factory;
    }

    @Override
    public void handle(RestxRequestMatch match, RestxRequest req, RestxResponse resp, RestxContext ctx) throws IOException {
        resp.setContentType("text/html");

        String content = Whatever.hello();

//        resp.getWriter().println(factory.dump());
        resp.getWriter().println(content);
    }
}
