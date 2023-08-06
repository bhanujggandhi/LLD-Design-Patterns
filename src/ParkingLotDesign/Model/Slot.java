package ParkingLotDesign.Model;

public class Slot {
    private Car parkedCar;
    private Integer slotNumber;

    public Slot(final Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public boolean isSlotFree() {
        return parkedCar == null;
    }

    public void setParkedCar(Car parkedCar) {
        this.parkedCar = parkedCar;
    }

    public void removeParkedCar() {
        this.parkedCar = null;
    }
}
