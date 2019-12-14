package com.aphiwe;

import com.aphiwe.resources.StudentRecordResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class StudentRecordApplication extends Application<StudentRecordConfiguration> {

    public static void main(final String[] args) throws Exception {
        new StudentRecordApplication().run(args);
    }

    @Override
    public String getName() {
        return "StudentRecord";
    }

    @Override
    public void initialize(final Bootstrap<StudentRecordConfiguration> bootstrap) {

    }

    @Override
    public void run(final StudentRecordConfiguration configuration,
                    final Environment environment) {

            final StudentRecordResource resource = new  StudentRecordResource( );
            environment.jersey().register(resource);

    }

}
