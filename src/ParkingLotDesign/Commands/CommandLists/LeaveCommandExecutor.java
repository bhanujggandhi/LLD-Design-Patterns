package ParkingLotDesign.Commands.CommandLists;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.IntegerValidator;
import ParkingLotDesign.Utils.OutputParser;

public class LeaveCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        super(parkingLotService, outputParser);
    }

    @Override
    public boolean validate(Command command) {
//        System.out.println(command.getParams().size());
        if(command.getParams().size() != 1)
            return false;

        return IntegerValidator.isInteger(command.getParams().get(0));
    }

    @Override
    public void execute(Command command) {
        final int slotNo = Integer.parseInt(command.getParams().get(0));
        System.out.println(command.getParams().get(0));
        parkingLotService.makeSlotFree(slotNo);
        outputParser.printLine("Slot number: " + slotNo + " is free now!");
    }
}
