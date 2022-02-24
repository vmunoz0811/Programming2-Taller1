/**
 * Package that contains the methods to complete the requirements of the problem
 */
package Model;

import java.util.List;

/**
 * Class that transfer the methods wrote on archive class
 */
public class Model {
    /**
     * Constructor method
     */
    public Model() {}

    /**
     * Method to upload data from archive
     */
    public void uploadData() {
        Archive.uploadData();
    }

    /**
     * Method to sum all sales from archive
     * @return Total of sum
     */
    public double sumatory() {
        return Archive.sumTotalSales();

    }

    /**
     * Method to search the info from invoice No.
     * @param search Number of invoice to search
     * @return The information contained of invoice searched
     */
    public String searchByInvoiceNo(String search) {
        return Archive.findByInvoiceNo(search);

    }

    /**
     * Method to search the quantity sold for each product by their stock code
     * @param search Number of stock to search
     * @return The quantity of products sold by this code
     */
    public double searchByStockCode(String search) {
        return Archive.countByStockCode(search);

    }

    /**
     * Method to look for the average per month and country
     * @param search Boolean that change the conditional
     * @return The average per month of products sold
     */
    public void avgByCountry(boolean search) {
        Archive.avgMonthSales(search).forEach(x-> System.out.println(x));
    }

    /**
     * Method that finds a product by their description found from a keyword
     * @param description Keyword that shows the products that have it
     * @param month Identify if the range selected have the month or not
     * @param range1 Init month receive by int
     * @param range2 End month receive by int
     * @return List of products that have the keyword introduce by the user
     */
    public String findPartiallyByDescription(String description, boolean month, int range1, int range2) {
        return Archive.findPartiallyByDescription(description,month,range1,range2);
    }
}

