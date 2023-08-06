package ParkingLotDesign.Commands.CommandLists;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Model.Slot;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

import java.util.List;
import java.util.Optional;

public class SlotForRegNumberCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "slot_number_for_registration_number";

    public SlotForRegNumberCommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        super(parkingLotService, outputParser);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
        final String regNum = command.getParams().get(0);

        final Optional<Slot> foundSlot = occupiedSlots.stream()
                .filter(slot -> slot.getParkedCar().getRegistrationNumber().equals(regNum))
                .findFirst();
        if(foundSlot.isPresent())
            outputParser.printLine(foundSlot.get().getSlotNumber().toString());
        else
            outputParser.notFound();
    }
}
