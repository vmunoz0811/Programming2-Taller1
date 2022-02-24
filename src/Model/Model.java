/**
 * Package that contains the methods to complete the requirements of the problem
 */
package Model;

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
     * Method to avg the average per month and country
     * @param search
     * @return The average per month of products sold by this code
     */
    public void avgByCountry(boolean search) {
        Archive.avgMonthSales(search).forEach(x-> System.out.println(x));
    }

    public String findPartiallyByDescription(String search,boolean t, int mth1,int moth2) {
        return Archive.findPartiallyByDescription(search,t, mth1,moth2);

    }
}

