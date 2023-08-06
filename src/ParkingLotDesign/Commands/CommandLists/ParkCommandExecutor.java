package ParkingLotDesign.Commands.CommandLists;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Exceptions.NoFreeSlotAvailableException;
import ParkingLotDesign.Exceptions.ParkingLotException;
import ParkingLotDesign.Model.Car;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

public class ParkCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "park";

    public ParkCommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        super(parkingLotService, outputParser);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(Command command) {
        final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            final Integer slot = parkingLotService.park(car);
            outputParser.printLine("Car is parked at " + slot);
        } catch (NoFreeSlotAvailableException e) {
            outputParser.lotFull();
        }
    }
}
