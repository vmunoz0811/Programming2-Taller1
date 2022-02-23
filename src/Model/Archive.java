/**
 * Package that contains the methods to complete the requirements of the problem
 */
package Model;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class that initialize the CSV file with the information of the invoice
 */
public class Archive {

    /**
     * Constructor method
     */
    public Archive() {

    }

    /**
     * Method used for upload data (CSV file)
     *
     * @return List with the info of each product
     */
    public static List<ProductBean> uploadData() {
        List<ProductBean> list = new ArrayList<>();

        try {

            CSVReader reader = new CSVReader(new FileReader("data/dataShop.csv"));
            reader.readNext();
            String line[];
            while ((line = reader.readNext()) != null) {
                SimpleDateFormat rightDate = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat wrongDate = new SimpleDateFormat("MM/dd/yyyy");

                Date newDate = wrongDate.parse(line[4]);
                line[4] = rightDate.format(newDate);
                ProductBean sell = new ProductBean(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4],
                        Double.parseDouble(line[5]), line[6].length() != 0 ? Integer.parseInt(line[6]) : 0, line[7]);
                list.add(sell);
                System.out.println(line[4]);
            }
            System.out.println("La cantidad de datos almacenados -> " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * Method that calculate the sum of the total sales of all products
     *
     * @return Total price of sales
     */
    public static double sumTotalSales() {
        double total = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader("data/dataShop.csv"));
            reader.readNext();
            String line[];
            while ((line = reader.readNext()) != null) {
                SimpleDateFormat rightDate = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat wrongDate = new SimpleDateFormat("MM/dd/yyyy");

                Date newDate = wrongDate.parse(line[4]);
                line[4] = rightDate.format(newDate);

                ProductBean sell = new ProductBean(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4],
                        Double.parseDouble(line[5]), line[6].length() != 0 ? Integer.parseInt(line[6]) : 0, line[7]);

                total = (Integer.parseInt(line[3]) * Double.parseDouble(line[5])) + total;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;


    }

    /**
     * Method that finds the information of sales by invoice No.
     *
     * @param invoiceNum Invoice that the user wants to search
     * @return Invoice with the information of sales
     */
    public static String findByInvoiceNo(String invoiceNum) {
        String invoiceNo = " ";
        List<ProductBean> list = new ArrayList<>();
        list = uploadData();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getInvoiceNo().equalsIgnoreCase(invoiceNum)) {
                    invoiceNo += list.get(i).toString();

                } else {
                    if (invoiceNo != "") {
                        break;
                    } else {
                        invoiceNo = "Invoice not found";
                    }
                }
            }
        }

        return invoiceNo;
    }

    /**
     * Method that finds the quantity of sales of a product by their stock code
     *
     * @param stockCode Stock code that the user wants to search
     * @return Quantity of products sold
     */
    public static int countByStockCode(String stockCode) {
        int stockNo = 0;
        List<ProductBean> list = new ArrayList<>();
        list = uploadData();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getStockCode().equalsIgnoreCase(stockCode)) {
                    stockNo += list.get(i).getQuantity();

                } else {
                    if (stockNo != 0) {
                        break;
                    }
                }
            }
        }

        return stockNo;
    }


    public static List MonthlySales() {
        List<ProductBean> list = new ArrayList<>();
        list = uploadData();
        List<String> Date = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!Date.contains(list.get(i).getCountry())) {
                Date.add(list.get(i).getCountry());
            }

        }

        return Date;
    }

    public static List<String> avgMonthSales(boolean groupBycountry) {
        HashMap<String, Double> averageCountry = new HashMap<String, Double>();
        HashMap<String, Integer> quantity = new HashMap<String, Integer>();
        List<ProductBean> list = uploadData();
        if (groupBycountry) {
            for (ProductBean bean : list) {
                if (!averageCountry.containsKey(bean.getCountry())) {
                    averageCountry.put(bean.getCountry(), bean.getUnitPrice() * bean.getQuantity());
                    quantity.put(bean.getCountry(), 1);
                } else {
                    double current = averageCountry.get(bean.getCountry());
                    averageCountry.replace(bean.getCountry(), ((current) + (bean.getUnitPrice() * bean.getQuantity())));
                    quantity.replace(bean.getCountry(), quantity.get(bean.getCountry()) + 1);
                }
            }
            for (String index : averageCountry.keySet())
                averageCountry.replace(index, (averageCountry.get(index) / quantity.get(index)));
            List<String> lista = new ArrayList<>();
            for (Map.Entry<String, Double> elements : averageCountry.entrySet())
                lista.add(elements.getKey() + " = " + elements.getValue());
           //return averageCountry;
        } else {
            HashMap<Integer, Double> month = new HashMap<Integer, Double>();
            HashMap<Integer, Integer> quanti = new HashMap<Integer, Integer>();

            for (ProductBean bean : list) {
                String data[] = bean.getInvoiceDate().split("/");
                if (!month.containsKey(Integer.parseInt(data[0]))) {
                    month.put(Integer.parseInt(data[0]), bean.getUnitPrice() * bean.getQuantity());
                    quanti.put(Integer.parseInt(data[0]), 1);
                } else {
                    double current = month.get(Integer.parseInt(data[0]));
                    month.replace(Integer.parseInt(data[0]), (current + (bean.getUnitPrice() * bean.getQuantity())));
                    quanti.replace(Integer.parseInt(data[0]), quanti.get(Integer.parseInt(data[0]) + 1));
                }
            }
            for (Integer index : month.keySet())
                month.replace(index, (month.get(index) / quanti.get(index)));
            List<String> lista = new ArrayList<>();
            for (Map.Entry<String, Double> elements : averageCountry.entrySet())
                lista.add(elements.getKey() + " = " + elements.getValue());
        }
        return null;
    }


}
