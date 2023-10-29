public class FnM_Solutions {
    private int companyNumber;
    private Name companyName;
    private String[] productOrService;
    private int currentRanking;
    private String hqLocation;
    private int companyAge;

    // Constructor
    public FnM_Solutions(int companyNumber, Name companyName, String[] productOrService, int currentRanking, String hqLocation, int companyAge) {
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        this.productOrService = productOrService;
        this.currentRanking = currentRanking;
        this.hqLocation = hqLocation;
        this.companyAge = companyAge;
    }

    // Getters and Setters
    public int getCompanyNumber() {
        return companyNumber;
    }

    public Name getCompanyName() {
        return companyName;
    }

    public String[] getProductOrService() {
        return productOrService;
    }

    public int getCurrentRanking() {
        return currentRanking;
    }

    public void setCurrentRanking(int currentRanking) {
        this.currentRanking = currentRanking;
    }

    public String getHqLocation() {
        return hqLocation;
    }

    public void setHqLocation(String hqLocation) {
        this.hqLocation = hqLocation;
    }

    public int getCompanyAge() {
        return companyAge;
    }

    public void setCompanyAge(int companyAge) {
        this.companyAge = companyAge;
    }

    public double getAverageSharePrice() {
        return 260; 
    }

    // Full details
    public String getFullDetails() {
        return "Company number " + String.format("%03d", companyNumber) +
               ", name " + companyName.getFirstAndLastName() +
               ", HQ Location " + hqLocation + ".\n" +
               companyName.getFirstAndLastName() + " produces " + setProductOrService() +
               ", was founded " + companyAge + " years ago and has an average share price of " + getAverageSharePrice() + ".";
    }

    // Short details
    public String getShortDetails() {
        return "CN " + String.format("%03d", companyNumber) + " (" + companyName.getFirstAndLastName().charAt(0) +
               ") has an average share price of " + getAverageSharePrice();
    }

    // Helper method to format the product or service values
    private String setProductOrService() {
        StringBuilder builder = new StringBuilder();
        builder.append(productOrService[0]);
        for (int i = 1; i < productOrService.length; i++) {
            builder.append(", ").append(productOrService[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String[] products = {"Cars", "Smartphones"};
        Name companyName = new Name("Tesla", "", "");
        FnM_Solutions company = new FnM_Solutions(1, companyName, products, 1, "USA", 20);

        System.out.println(company.getFullDetails());
        System.out.println(company.getShortDetails());
    }
}