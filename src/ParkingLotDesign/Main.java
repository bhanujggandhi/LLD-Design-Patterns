package ParkingLotDesign;

import ParkingLotDesign.Commands.CommandExecutorFactory;
import ParkingLotDesign.Exceptions.InvalidModeException;
import ParkingLotDesign.Mode.FileMode;
import ParkingLotDesign.Mode.InteractiveMode;
import ParkingLotDesign.Service.ParkingLotService;
import ParkingLotDesign.Utils.OutputParser;

public class Main {
    public static void main(String[] args) {
        final OutputParser outputParser = new OutputParser();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        if(isInteractiveMode(args)) {
            try {
                new InteractiveMode(commandExecutorFactory, outputParser).process();
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        } else if (isFileInputMode(args)) {
            try {
                new FileMode(commandExecutorFactory, outputParser, args[0]).process();
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new InvalidModeException();
        }

    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}
