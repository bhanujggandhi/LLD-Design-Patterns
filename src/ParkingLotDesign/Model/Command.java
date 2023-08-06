package ParkingLotDesign.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

    private static final String separator = " ";
    private String commandName;
    private List<String> params;

    public Command(final String inputLine) {
//        Split the command based on space, convert all in the lowercase: take the first part of the array as command
//        and rest of the parts as token
        final List<String> tokenList = Arrays.stream(inputLine.trim().split(this.separator))
                .map(String::trim).filter(token -> (token.length() > 0))
                .collect(Collectors.toList());

        this.commandName = tokenList.get(0).toLowerCase();
        tokenList.remove(0);
        this.params = tokenList;

    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }
}
