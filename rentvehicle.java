public abstract class Vehicle {
    protected int vehicleID;
    protected String brand;
    protected float rentalPricePerDay;
    
    public Vehicle(int vehicleID, String brand, float rentalPricePerDay) {
        this.vehicleID = vehicleID; 
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
    }
 
    public int getVehicleID() {
        return this.vehicleID;
    }
    public String getBrand() {
        return this.brand;
    }
    public float getRentalPricePerDay() {
        return this.rentalPricePerDay;
    }
    
    abstract public void startVehicle();
    abstract public void stopVehicle();
    abstract public float calcRentalCost();
}

interface FuelPowerable {
    public String getFuelType();
    public float getFuelLevel();
}

interface ElectricPowerable {
    public String getChargingBehaviour();
    public float getBatteryStatus();
    public String getChargingTime();
}
    

class Car extends Vehicle {
        
     

