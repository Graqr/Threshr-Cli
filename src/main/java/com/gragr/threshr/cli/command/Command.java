package com.gragr.threshr.cli.command;

import com.graqr.threshr.ThreshrException;
import com.graqr.threshr.model.Tcin;
import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine;
import picocli.CommandLine.ITypeConverter;
import picocli.CommandLine.Option;

@CommandLine.Command(
        name = "threshr-cli",
        description = "Threshr cli tool for querying target corporation's api",
        mixinStandardHelpOptions = true)
public class Command implements Runnable {

    @Option(names = {"-t", "--tcin"}, description = "target catalog id number", converter = TcinConverter.class)
    Tcin tcin;

    @Option(names = {"-s", "--store"}, description = "store id number")
    int storeID;

    public static void main(String[] args) {
        PicocliRunner.run(Command.class, args);
    }

    public void run() {
        //fail fast
        if (null == tcin || tcin.getTcins().isEmpty()) {
            throw new CommandLine.PicocliException("tcin arg cannot be empty");
        }
    }

    /**
     * Converts a commandline argument from a string to a tcin argument. Allows for multiple tcins to be passed with a
     * comma delimiter.
     */
    static class TcinConverter implements ITypeConverter<Tcin> {
        @Override
        public Tcin convert(String argument) throws ThreshrException {
            return new Tcin(argument.split(","));
        }
    }


}
