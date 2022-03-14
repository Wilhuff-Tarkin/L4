import java.util.List;

public class Market implements ConsoleFormatting {

    private String name;
    private List<Country> countries;

    public Market(String name, List<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    public void printCountries() {
        System.out.println("Requested car is available for purchase in following countries:");
        for (Country country : countries) {
            System.out.println(country.getCountryName() + " " + ANSI_YELLOW + country.getCountrySign() + ANSI_RESET);
        }
    }
}
