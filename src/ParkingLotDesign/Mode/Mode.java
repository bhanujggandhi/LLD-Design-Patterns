package ParkingLotDesign.Mode;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Commands.CommandExecutorFactory;
import ParkingLotDesign.Exceptions.InvalidCommandException;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Utils.OutputParser;

import java.io.IOException;


public abstract class Mode {
    protected OutputParser outputParser;
    private CommandExecutorFactory commandExecutorFactory;

    public Mode(final CommandExecutorFactory commandExecutorFactory, final OutputParser outputParser) {
        this.outputParser = outputParser;
        this.commandExecutorFactory = commandExecutorFactory;
    }

    protected void processCommand(final Command command) {
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if(commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException();
        }
    }

    public abstract void process() throws IOException;

}
