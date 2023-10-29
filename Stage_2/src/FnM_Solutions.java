public class FnM_Solutions {
    private int companyNumber;
    private Name companyName;
    private String[] productOrService;
    private int currentRanking;
    private String hqLocation;
    private int companyAge;
    private int[] sharePrices;
    private double pollutionLevel; // A variable representing the pollution level (0 to 1)

    // Constructor
    public FnM_Solutions(int companyNumber, Name companyName, String[] productOrService, int currentRanking, String hqLocation, int companyAge, int[] sharePrices, double pollutionLevel) {
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        this.productOrService = productOrService;
        this.currentRanking = currentRanking;
        this.hqLocation = hqLocation;
        this.companyAge = companyAge;
        this.sharePrices = sharePrices;
        this.pollutionLevel = pollutionLevel;
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

    public int[] getSharePricesArray() {
        return sharePrices;
    }

    public double getPollutionLevel() {
        return pollutionLevel;
    }

    public void setPollutionLevel(double pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    // Method to calculate the average share price with weighted average
    public double getAverageSharePrice() {
        double weightedSum = 0.0;
        double weightSum = 0.0;

        for (int i = 0; i < sharePrices.length; i++) {
            double weight = 1 - pollutionLevel; // Adjust weight based on pollution level
            weightedSum += sharePrices[i] * weight;
            weightSum += 1;
        }
        
        return weightedSum / weightSum;
         //System.out.println(" Testing : " + weightedSum + "," + weightSum +","+ ans   + ".");
    }

    // Method to get full details of the company
    public String getFullDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Company number ").append(String.format("%03d", companyNumber))
               .append(", name ").append(companyName.getFirstAndLastName())
               .append(", country ").append(hqLocation).append(".\n")
               .append(companyName.getFirstAndLastName())
               .append(" is a ").append(formatProductOrService())
               .append(", founded ").append(companyAge).append(" years ago and has a past five-day share price: ");

        for (int i = 0; i < sharePrices.length; i++) {
            details.append(sharePrices[i]);
            if (i < sharePrices.length - 1) {
                details.append(", ");
            }
        }

        details.append("\nTherefore, they have an average unaltered share price of ").append(getAverageSharePrice()).append(".");
        return details.toString();
    }

    // Helper method to format the product or service values
    private String formatProductOrService() {
        StringBuilder builder = new StringBuilder();
        builder.append(productOrService[0]);
        for (int i = 1; i < productOrService.length; i++) {
            builder.append(", ").append(productOrService[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // Example usage
        int[] teslaSharePrices = {246, 244, 242, 259, 244};
        String[] products = {"Cars"};
        Name teslaName = new Name("Tesla Inc", "", "");
        double teslaPollutionLevel = 0.2; // Example pollution level

        FnM_Solutions teslaCompany = new FnM_Solutions(1, teslaName, products, 1, "USA", 20, teslaSharePrices, teslaPollutionLevel);

        System.out.println(teslaCompany.getFullDetails());
        System.out.println("Average Share Price: " + teslaCompany.getAverageSharePrice());
    }
}