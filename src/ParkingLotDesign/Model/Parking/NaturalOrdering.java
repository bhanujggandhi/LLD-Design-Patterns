package ParkingLotDesign.Model.Parking;

import ParkingLotDesign.Exceptions.NoFreeSlotAvailableException;
import ParkingLotDesign.Model.Parking.Strategy.ParkingStrategy;

import java.util.TreeSet;

public class NaturalOrdering implements ParkingStrategy {

    TreeSet<Integer> slotTreeSet;

    public NaturalOrdering() {
        this.slotTreeSet = new TreeSet<>();
    }

    @Override
    public void addSlot(Integer slotNo) {
        this.slotTreeSet.add(slotNo);
    }

    @Override
    public void removeSlot(Integer slotNo) {
        this.slotTreeSet.remove(slotNo);
    }

    @Override
    public Integer getNextSlot() {
        if(slotTreeSet.isEmpty()) {
            throw new NoFreeSlotAvailableException();
        }
        return this.slotTreeSet.first();
    }
}
