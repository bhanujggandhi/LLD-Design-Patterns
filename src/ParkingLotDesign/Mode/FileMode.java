package ParkingLotDesign.Mode;

import ParkingLotDesign.Commands.CommandExecutorFactory;
import ParkingLotDesign.Model.Command;
import ParkingLotDesign.Utils.OutputParser;

import java.io.*;

public class FileMode extends Mode {
    private String filename;

    public FileMode(CommandExecutorFactory commandExecutorFactory, OutputParser outputParser, final String filename) {
        super(commandExecutorFactory, outputParser);
        this.filename = filename;
    }

    @Override
    public void process() throws IOException {
        final File file = new File(filename);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            outputParser.invalidFile();
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }
}
