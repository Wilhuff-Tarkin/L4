import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    protected ArrayList<Country> allCountries = createCountries();
    protected ArrayList<Market> allMarkets = createMarkets();
    protected ArrayList<Producer> allProducers = createProducers();
    protected ArrayList<Dimension> allDimensionsSets = createDimensionsSets();
    protected ArrayList<Car> allCars = createCars();


    private static ArrayList<Producer> createProducers() {
        Producer fso1 = new Producer("FSO", "Matiz");
        Producer fso2 = new Producer("FSO", "Polonez");
        Producer tarpan1 = new Producer("Tarpan", "233");
        Producer tarpan2 = new Producer("Tarpan", "Honker");
        Producer bmw1 = new Producer("BMW", "X3");
        Producer bmw2 = new Producer("BMW", "E21");
        Producer honda1 = new Producer("Honda", "Civic");
        Producer honda2 = new Producer("Honda", "Legend");
        Producer toyota1 = new Producer("Toyota", "Hilux");
        Producer toyota2 = new Producer("Toyota", "Camry");
        return new ArrayList<>(Arrays.asList(fso1, fso2, tarpan1, tarpan2, bmw1, bmw2, honda1, honda2, toyota1, toyota2));
    }

    private static ArrayList<Dimension> createDimensionsSets() {
        Dimension miniCompact = new Dimension(120, 220, 50);
        Dimension subCompact = new Dimension(140, 230, 100);
        Dimension compact = new Dimension(160, 240, 150);
        Dimension midSize = new Dimension(200, 260, 300);
        Dimension large = new Dimension(220, 280, 350);
        Dimension pickups = new Dimension(230, 280, 400);
        Dimension vans = new Dimension(200, 260, 200);
        Dimension miniVans = new Dimension(180, 240, 180);
        Dimension bus = new Dimension(300, 280, 500);
        Dimension minibus = new Dimension(180, 240, 220);
        return new ArrayList<>(Arrays.asList(miniCompact, subCompact, compact, midSize, large, pickups, vans, miniVans, bus, minibus));
    }

    public ArrayList<Car> getAllCars() {
        return allCars;
    }

    private ArrayList<Country> createCountries() {
        Country poland = new Country("Poland", 'P');
        Country belgium = new Country("Belgium", 'B');
        Country japan = new Country("Japan", 'J');
        Country sweden = new Country("Sweden", 'S');
        Country uruguay = new Country("Uruguay", 'U');
        return new ArrayList<>(Arrays.asList(poland, belgium, japan, sweden, uruguay));
    }

    private ArrayList<Market> createMarkets() {
        Market cargoMarket = new Market("cargo", List.of(allCountries.get(0), allCountries.get(1), allCountries.get(2)));
        Market businessMarket = new Market("business", List.of(allCountries.get(1), allCountries.get(2), allCountries.get(3)));
        Market transportMarket = new Market("transport", List.of(allCountries.get(2), allCountries.get(3), allCountries.get(4)));
        Market taxiMarket = new Market("taxi", List.of(allCountries.get(3), allCountries.get(4), allCountries.get(1)));
        Market specialMarket = new Market("special", List.of(allCountries.get(4), allCountries.get(0), allCountries.get(1)));
        return new ArrayList<>(Arrays.asList(cargoMarket, businessMarket, transportMarket, taxiMarket, specialMarket));
    }

    private ArrayList<Car> createCars() {
        Car fsoMatiz = new Car(allProducers.get(0), allMarkets.get(1), "standard", false, allDimensionsSets.get(0));
        Car fsoPolonez = new Car(allProducers.get(1), allMarkets.get(2), "standard", false, allDimensionsSets.get(2));
        Car tarpan233 = new Car(allProducers.get(2), allMarkets.get(3), "standard", false, allDimensionsSets.get(3));
        Car tarpanHonker = new Car(allProducers.get(3), allMarkets.get(0), "standard", false, allDimensionsSets.get(5));
        Car bmwX3manual = new Car(allProducers.get(4), allMarkets.get(1), "standard", false, allDimensionsSets.get(1));
        Car bmwX3automatic = new Car(allProducers.get(4), allMarkets.get(2), "standard", true, allDimensionsSets.get(5));
        Car bmwE21manual = new Car(allProducers.get(5), allMarkets.get(3), "standard", false, allDimensionsSets.get(1));
        Car bmwE21automatic = new Car(allProducers.get(5), allMarkets.get(4), "standard", true, allDimensionsSets.get(4));
        Car hondaCivic = new Car(allProducers.get(6), allMarkets.get(1), "standard", false, allDimensionsSets.get(5));
        Car hondaLegendManual = new Car(allProducers.get(7), allMarkets.get(4), "standard", false, allDimensionsSets.get(7));
        Car hondaLegendAutomatic = new Car(allProducers.get(7), allMarkets.get(3), "standard", true, allDimensionsSets.get(0));
        Car toyotaHiluxAutomatic = new Car(allProducers.get(8), allMarkets.get(2), "standard", true, allDimensionsSets.get(2));
        Car toyotaHiluxManual = new Car(allProducers.get(8), allMarkets.get(1), "standard", false, allDimensionsSets.get(3));
        Car toyotaCamryAutomatic = new Car(allProducers.get(9), allMarkets.get(3), "standard", true, allDimensionsSets.get(5));
        Car toyotaCamryManual = new Car(allProducers.get(9), allMarkets.get(4), "standard", false, allDimensionsSets.get(7));
        return new ArrayList<>(Arrays.asList(fsoMatiz, fsoPolonez, tarpan233, tarpanHonker, bmwX3manual, bmwX3automatic, bmwE21manual, bmwE21automatic,
                hondaCivic, hondaLegendManual, hondaLegendAutomatic, toyotaHiluxAutomatic, toyotaHiluxManual, toyotaCamryAutomatic, toyotaCamryManual));
    }
}
