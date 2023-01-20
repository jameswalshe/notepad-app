package com.kainos.ea;

import com.kainos.ea.resources.NotepadWebService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class NotepadWebServiceApplication extends Application<NotepadWebServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NotepadWebServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "NotepadWebService";
    }

    @Override
    public void initialize(final Bootstrap<NotepadWebServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final NotepadWebServiceConfiguration configuration,
                    final Environment environment) {
        FilterRegistration.Dynamic corsFilter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        corsFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        corsFilter.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());
        corsFilter.setInitParameter("allowedHeaders",
                "*");

        environment.jersey().register(new NotepadWebService());

    }

}
