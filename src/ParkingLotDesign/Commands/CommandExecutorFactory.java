package ParkingLotDesign.Commands;

import ParkingLotDesign.Commands.CommandLists.*;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        final OutputParser outputParser = new OutputParser();

        commands.put(CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService, outputParser));

        commands.put(ParkCommandExecutor.COMMAND_NAME,
                new ParkCommandExecutor(parkingLotService, outputParser));

        commands.put(LeaveCommandExecutor.COMMAND_NAME,
                new LeaveCommandExecutor(parkingLotService, outputParser));

        commands.put(StatusCommandExecutor.COMMAND_NAME,
                new StatusCommandExecutor(parkingLotService, outputParser));

        commands.put(ColorToRegNumCommandExecutor.COMMAND_NAME,
                new ColorToRegNumCommandExecutor(parkingLotService, outputParser));

        commands.put(ColorToSlotNumCommandExecutor.COMMAND_NAME,
                new ColorToSlotNumCommandExecutor(parkingLotService, outputParser));

        commands.put(ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(parkingLotService, outputParser));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if(commandExecutor == null) {
            System.out.printf("o");
        }

        return commandExecutor;
    }
}
