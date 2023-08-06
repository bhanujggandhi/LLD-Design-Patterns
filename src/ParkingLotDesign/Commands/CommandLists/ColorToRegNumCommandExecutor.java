package ParkingLotDesign.Commands.CommandLists;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Model.Slot;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

import java.util.List;
import java.util.stream.Collectors;

public class ColorToRegNumCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "registration_numbers_for_cars_with_color";

    public ColorToRegNumCommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        super(parkingLotService, outputParser);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> slotForColors = parkingLotService.getSlotsForColor(command.getParams().get(0));

        if(slotForColors.isEmpty()) {
            outputParser.notFound();
        } else {
            final String result = slotForColors.stream()
                    .map(slot -> slot.getParkedCar().getRegistrationNumber())
                    .collect(Collectors.joining(", "));
            outputParser.printLine(result);
        }

    }
}
