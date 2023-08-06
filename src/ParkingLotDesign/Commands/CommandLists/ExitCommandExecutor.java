package ParkingLotDesign.Commands.CommandLists;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

public class ExitCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        super(parkingLotService, outputParser);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        outputParser.endOut();
    }
}
