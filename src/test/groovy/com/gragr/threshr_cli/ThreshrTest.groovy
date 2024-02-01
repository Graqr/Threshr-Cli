package com.gragr.threshr_cli

import com.graqr.threshr.model.TargetStore
import com.graqr.threshr.model.Tcin
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ThreshrTest extends Specification {


    @Shared
    ApplicationContext ctx

    @Shared
    TargetStore targetStore = new TargetStore(
            "1750",
            "UT",
            "84014-1752",
            40.91825,
            -111.887)

    @Shared
    Tcin tcin = new Tcin(
            new String[]{"82691535", "12953464"} //corn & coke https://bit.ly/45V8dui https://bit.ly/40j4A0e
    )

    void setupSpec() {
        ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
    }

    void cleanupSpec() {
        ctx.stop()
    }

}