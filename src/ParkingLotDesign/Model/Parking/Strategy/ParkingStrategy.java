package ParkingLotDesign.Model.Parking.Strategy;

public interface ParkingStrategy {
    public void addSlot(Integer slotNo);

    public void removeSlot(Integer slotNo);

    public Integer getNextSlot();
}
