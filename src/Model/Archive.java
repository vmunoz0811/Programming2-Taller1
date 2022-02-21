/**
 * Package that contains the methods to complete the requirements of the problem
 */
package Model;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class that initialize the CSV file with the information of the invoice
 */
public class Archive {
    /**
     * SimpleDateFormat object to identify de wrong date that is in the file
     */
    private final SimpleDateFormat wrongDate = new SimpleDateFormat("MM/DD/YYYY");
    /**
     * SimpleDateFormat object to convert the wrong date into the format that we need to evaluate
     */
    private final SimpleDateFormat rightDate = new SimpleDateFormat("DD/MM/YYYY");

    /**
     * Constructor method
     */
    public Archive(){

    }

    /**
     * Method used for upload data (CSV file)
     * @return List with the info of each product
     */
    public static List <ProductBean> uploadData(){
        List <ProductBean> list = new ArrayList <> ();
        try {

            CSVReader reader = new CSVReader(new FileReader("data/dataShop.csv"));
            reader.readNext();
            String line [];
            while((line = reader.readNext()) != null) {

                ProductBean sell = new ProductBean(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4],
                        Double.parseDouble(line[5]), line[6].length() != 0? Integer.parseInt(line[6]) : 0, line[7]);
                list.add(sell);
            }
            System.out.println("La cantidad de datos almacenados -> " + list.size());
        } catch(Exception e) { e.printStackTrace(); }
        return list;
    }

    /**
     * Method that calculate the sum of the total sales of all products
     * @return Total price of sales
     */
    public static double sumTotalSales(){
        double total = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader("data/dataShop.csv"));
            reader.readNext();
            String line [];
            while((line = reader.readNext()) != null) {
                ProductBean sell = new ProductBean(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4],
                        Double.parseDouble(line[5]), line[6].length() != 0? Integer.parseInt(line[6]) : 0, line[7]);

                total = (Integer.parseInt(line[3])* Double.parseDouble(line[5])) + total;
            }
        } catch(Exception e) { e.printStackTrace(); }

        return total;


    }

    /**
     * Method that finds the information of sales by invoice No.
     * @param invoiceNum Invoice that the user wants to search
     * @return Invoice with the information of sales
     */
    public static String findByInvoiceNo(String invoiceNum){
        String invoiceNo = " ";
        List <ProductBean> list = new ArrayList <> ();
        list=uploadData();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getInvoiceNo().equalsIgnoreCase(invoiceNum)) {
                    invoiceNo += list.get(i).toString();

                }else {
                    if (invoiceNo!="") {
                        break;
                    }else {
                        invoiceNo = "Invoice not found";
                    }
                }
            }
        }

        return invoiceNo;
    }

    /**
     * Method that finds the quantity of sales of a product by their stock code
     * @param stockCode Stock code that the user wants to search
     * @return Quantity of products sold
     */
    public static int countByStockCode(String stockCode){
        int stockNo = 0;
        List <ProductBean> list = new ArrayList <> ();
        list=uploadData();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getStockCode().equalsIgnoreCase(stockCode)) {
                    stockNo += list.get(i).getQuantity();

                }else {
                    if (stockNo!=0) {
                        break;
                    }
                }
            }
        }

        return stockNo;
    }

}
