package ParkingLotDesign.Mode;

import ParkingLotDesign.Commands.CommandExecutorFactory;
import ParkingLotDesign.Commands.CommandLists.ExitCommandExecutor;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Utils.OutputParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode {
    public InteractiveMode(CommandExecutorFactory commandExecutorFactory, OutputParser outputParser) {
        super(commandExecutorFactory, outputParser);
    }

    @Override
    public void process() throws IOException {
        outputParser.welcome();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            processCommand(command);
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}
