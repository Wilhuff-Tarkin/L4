import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car implements ConsoleFormatting {

    private Producer producer;
    private Market market;
    private String segment;
    private boolean isAutomaticGear;
    private Dimension dimensions;

    public Car(Producer producer, Market market, String segment, boolean isAutomaticGear, Dimension dimensions) {
        this.producer = producer;
        this.market = market;
        this.segment = segment;
        this.isAutomaticGear = isAutomaticGear;
        this.dimensions = dimensions;
    }

    public static void findDealer(String desiredManufacturer, boolean shouldBeAutomatic, int minimumTrunkCapacity, DataGenerator dataGenerator) {
        Stream<Car> allCars = dataGenerator.getAllCars().stream();
        List<Car> result = allCars
                .filter(car -> car.isAutomaticGear == shouldBeAutomatic)
                .filter(car -> (car.getProducer().getModel()).equals(desiredManufacturer))
                .filter(car -> car.getDimensions().getTrunkCapacity() >= minimumTrunkCapacity)
                .collect(Collectors.toList());

        if (result.size() == 0) {
            printNegativeResult(desiredManufacturer, shouldBeAutomatic, minimumTrunkCapacity);
        } else {
            System.out.println();
            System.out.println("Found " + ANSI_YELLOW + result.size() + ANSI_RESET + " car(s) matching search conditions:");

            for (Car car : result) {
                System.out.println();
                printPositiveResult(car, desiredManufacturer, shouldBeAutomatic, minimumTrunkCapacity);
            }
        }
    }

    public static void presentAllCars(ArrayList<Car> allCars) {
        int counter = 1;
        System.out.println(GREEN_UNDERLINED + "All cars for sale are:" + ANSI_RESET);
        for (Car car : allCars) {
            System.out.println(ANSI_YELLOW + counter + ". " + car.getProducer().model + " " + car.getProducer().getType() + ANSI_RESET);
            System.out.println("with " + setTransmissionInfo(car.isAutomaticGear) + " and trunk capacity of " + car.getDimensions().getTrunkCapacity() + "l.");
            counter++;
        }
    }

    public static void printSearchConditions(String desiredManufacturer, boolean desiredTransmissionAutomatic, int desiredMinimumTrunkCapacity) throws InterruptedException {
        System.out.println();
        System.out.println("Looking for a car produced by " + ANSI_YELLOW + desiredManufacturer + ANSI_RESET + " with " + ANSI_GREEN + setTransmissionInfo(desiredTransmissionAutomatic) + ANSI_RESET + " and trunk capacity of " + ANSI_YELLOW + desiredMinimumTrunkCapacity + ANSI_RESET + "l...");
        Thread.sleep(750);
    }

    private static void printPositiveResult(Car car, String manufacturer, boolean shouldBeAutomatic, int minimumTrunkCapacity) {
        System.out.println(GREEN_UNDERLINED + manufacturer + " (" + car.getProducer().getType() + ")" + ANSI_RESET + " with " + setTransmissionInfo(shouldBeAutomatic) + setTrunkCapacityInfo(car.getDimensions().getTrunkCapacity(), minimumTrunkCapacity));
        car.getMarket().printCountries();
    }

    private static void printNegativeResult(String manufacturer, boolean shouldBeAutomatic, int minimumTrunkCapacity) {
        System.out.println();
        System.out.println("I did not found car produced by " + manufacturer + " with " + setTransmissionInfo(shouldBeAutomatic) + " and minimal trunk capacity of " + minimumTrunkCapacity + "l. " + ANSI_RED + "Sorry." + ANSI_RESET);
    }

    private static String setTransmissionInfo(boolean shouldBeAutomatic) {
        String transmission;
        if (shouldBeAutomatic) {
            transmission = "automatic transmission";
        } else {
            transmission = "manual transmission";
        }
        return transmission;
    }

    private static String setTrunkCapacityInfo(int trunkCapacity, int requestedTrunkCapacity) {
        String trunkCapacityInfo;
        int trunkCapacityDifference = trunkCapacity - requestedTrunkCapacity;

        if (trunkCapacityDifference == 0) {
            trunkCapacityInfo = " and trunk capacity of " + requestedTrunkCapacity + "l. exactly as you looked for (" + requestedTrunkCapacity + "l.).";
        } else {
            trunkCapacityInfo = " and trunk capacity of " + trunkCapacity + "l. - " + trunkCapacityDifference + "l. bigger that you have looked for (" + requestedTrunkCapacity + "l.).";
        }
        return trunkCapacityInfo;
    }

    public Market getMarket() {
        return market;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public Producer getProducer() {
        return producer;
    }

}
