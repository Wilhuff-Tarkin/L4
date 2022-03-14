public class Run {

    public static void main(String[] args) throws InterruptedException {
        String desiredManufacturer = "BMW";
        boolean desiredTransmissionAutomatic = true;
        int desiredMinimumTrunkCapacity = 300;

        DataGenerator dataGenerator = new DataGenerator();
        Car.presentAllCars(dataGenerator.getAllCars());
        Car.printSearchConditions(desiredManufacturer, desiredTransmissionAutomatic, desiredMinimumTrunkCapacity);
        Car.findDealer(desiredManufacturer, desiredTransmissionAutomatic, desiredMinimumTrunkCapacity, dataGenerator);
    }
}