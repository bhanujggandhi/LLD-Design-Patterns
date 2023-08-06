package ParkingLotDesign.Model;

import ParkingLotDesign.Exceptions.InvalidSlotException;
import ParkingLotDesign.Exceptions.ParkingLotException;
import ParkingLotDesign.Exceptions.SlotAlreadyOccupiedException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static int MAX_CAPACITY = 100000;
    private int capacity;
    private Map<Integer, Slot> slots;

    public int getCapacity() {
        return capacity;
    }

    public ParkingLot(int capacity) {
        if(capacity <= 0 || capacity > MAX_CAPACITY) {
            throw new ParkingLotException("Invalid capacity given for parking lot.");
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    public Map<Integer, Slot> getSlots() {
        return slots;
    }

    private Slot getSlot(final Integer slotNo) {
        if(slotNo > getCapacity() || slotNo <= 0) {
            throw new InvalidSlotException();
        }

        final Map<Integer, Slot> allSlots = getSlots();
        if(!allSlots.containsKey(slotNo)) {
            allSlots.put(slotNo, new Slot(slotNo));
        }

        return allSlots.get(slotNo);
    }

    public Slot park(final Car car, final Integer slotNo) {
        final Slot slot = getSlot(slotNo);

        if(!slot.isSlotFree()) {
            throw new SlotAlreadyOccupiedException();
        }

        slot.setParkedCar(car);
        return slot;
    }

    public Slot makeSlotFree(final Integer slotNo) {
        final Slot slot = getSlot(slotNo);
        slot.removeParkedCar();
        return slot;
    }

}
