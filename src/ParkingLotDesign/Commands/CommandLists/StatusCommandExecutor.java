package ParkingLotDesign.Commands.CommandLists;

import ParkingLotDesign.Commands.CommandExecutor;
import ParkingLotDesign.Model.Car;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Model.Slot;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

import java.util.List;

public class StatusCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "status";

    public StatusCommandExecutor(ParkingLotService parkingLotService, OutputParser outputParser) {
        super(parkingLotService, outputParser);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();

        if (occupiedSlots.isEmpty()) {
            outputParser.lotEmpty();
            return;
        }

        outputParser.statusHeader();
        for (Slot slot : occupiedSlots) {
            final Car car = slot.getParkedCar();
            final String slotNo = slot.getSlotNumber().toString();

            outputParser.printLine(padString(slotNo, 12)
                    + padString(car.getRegistrationNumber(), 19)
                    + car.getColor());
        }
    }

    private static String padString(final String word, final int length) {
        String newWord = word;
        for (int count = word.length(); count < length; count++) {
            newWord = newWord + " ";
        }
        return newWord;
    }
}
