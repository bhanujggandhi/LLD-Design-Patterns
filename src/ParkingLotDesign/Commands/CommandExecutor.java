package ParkingLotDesign.Commands;

import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

public abstract class CommandExecutor {

    protected ParkingLotService parkingLotService;
    protected OutputParser outputParser;

    public CommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        this.parkingLotService = parkingLotService;
        this.outputParser = outputParser;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
