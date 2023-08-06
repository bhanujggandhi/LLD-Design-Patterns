package ParkingLotDesign.Commands.CommandLists;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Model.Parking.NaturalOrdering;
import ParkingLotDesign.Model.ParkingLot;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.IntegerValidator;
import ParkingLotDesign.Utils.OutputParser;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        super(parkingLotService, outputParser);
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if(params.size() != 1) {
            return false;
        }

        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrdering());
        outputParser.printLine("Created a parking lot with " + parkingLot.getCapacity() + " slots!");
    }
}
