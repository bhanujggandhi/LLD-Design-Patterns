package ParkingLotDesign.Utils;

/*
This class is for printing the messages on the terminal.
All the output shown can be added or removed from here.
We are using System Out, in future if file output needs to be provided, we can easily integrate that too

 */

public class OutputParser {
    public void printLine(final String inp) {
        System.out.println(inp);
    }

    public void welcome() {
        printLine("Welcome to CarParkerLot");
    }

    public void endOut() {
        printLine("Thanks for using CarParkerLot");
    }

    public void notFound() {
        printLine("Not Found!");
    }

    public void statusHeader() {
        printLine("Slot No.    Registration No.    Color");
    }

    public void lotFull() {
        printLine("Sorry, currently we are working at peak, hope to serve you next time!");
    }

    public void lotEmpty() {
        printLine("Parking lot is empty!");
    }

    public void invalidFile() {
        printLine("Invalid file provided!");
    }
}
