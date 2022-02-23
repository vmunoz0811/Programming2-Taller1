/**
 * Package that contains the methods to complete the requirements of the problem
 */
package Model;

import com.opencsv.bean.CsvBindByName;

/**
 * Class that instance the objects that a product in the CSV file has
 */
public class ProductBean {
    /**
     * Objet String to identify 'InvoiceNo' column
     */
    @CsvBindByName (column="InvoiceNo")
    private String InvoiceNo;
    /**
     * Object String to identify 'StockCode' column
     */
    @CsvBindByName (column="StockCode")
    private String StockCode;
    /**
     * Object String to identify 'Description' column
     */
    @CsvBindByName (column="Description")
    private String Description;
    /**
     * Object String to identify 'Quantity' column
     */
    @CsvBindByName (column="Quantity")
    private int Quantity;
    /**
     * Object String to identify 'InvoiceDate' column
     */
    @CsvBindByName (column="InvoiceDate")
    private String InvoiceDate;
    /**
     * Object String to identify 'UnitPrice' column
     */
    @CsvBindByName (column="UnitPrice")
    private double UnitPrice;
    /**
     * Object String to identify 'CustomerID' column
     */
    @CsvBindByName (column="CustomerID")
    private long CustomerID;
    /**
     * Object String to identify 'Country' column
     */
    @CsvBindByName (column="Country")
    private String Country;

    /**
     * Constructor method
     * @param invoice String InvoiceNo that has every product on file
     * @param number String StockCode that has every product on file
     * @param description String Description that has every product on file
     * @param quantity int Quantity that has every product on file
     * @param date String InvoiceDate that has every product on file
     * @param price double UnitPrice that has every product on file
     * @param id int CustomerID that has every product on file
     * @param country String Country that has every product on file
     */
    public ProductBean(String invoice, String number, String description, int quantity, String date, double price, int id, String country) {
        InvoiceNo = invoice;
        StockCode = number;
        Description = description;
        Quantity = quantity;
        InvoiceDate = date;
        UnitPrice = price;
        CustomerID = id;
        Country = country;
    }

    /**
     * Method that creates a String with objects that has every product
     * @return String structure that we create
     */
    public String toString() {
        String line1 = " No. Factura " + " | " + " No. inventario " + " | "  + " Descripcion " + " | " + " Cantidad "
                + " | " + " Fecha " + " | " + " Precio " + " | " + " ID cliente " + " | " + " Pais " + "\n";
        return  "\n" + line1 + InvoiceNo + " | " + StockCode + " | " + Description + " | " + Quantity + " | " + InvoiceDate + " | " + UnitPrice + " | " + CustomerID
                + " | " + Country + "\n";
    }

    /**
     * Get of InvoiceNo
     * @return String InvoiceNo
     */
    public String getInvoiceNo() {
        return InvoiceNo;
    }

    /**
     * Set of InvoiceNo
     * @param invoiceNo InvoiceNo that we searched
     */
    public void setInvoiceNo(String invoiceNo) {
        InvoiceNo = invoiceNo;
    }

    /**
     * Get of StockCode
     * @return String Stockcode
     */
    public String getStockCode() {
        return StockCode;
    }

    /**
     * Set of StockCode
     * @param stockCode Stock code of the product that we searched
     */
    public void setStockCode(String stockCode) {
        StockCode = stockCode;
    }

    /**
     * Get Description of the product
     * @return String Description
     */
    public String getDescription() { return Description; }

    /**
     * Set Description of the product
     * @param description Description of product that we searched
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * Get Quantity sold of the product
     * @return Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Set Quantity sold of the product
     * @param quantity Quantity of the product that we searched
     */
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * Get InvoiceDate of the product sold
     * @return InvoiceDate
     */
    public String getInvoiceDate() {
        return InvoiceDate;
    }

    /**
     * Set InvoiceDate of the product sold
     * @param invoiceDate InvoiceDate from the product that we searched
     */
    public void setInvoiceDate(String invoiceDate) {
        InvoiceDate = invoiceDate;
    }

    /**
     * Get UnitPrice of the product sold
     * @return UnitPrice
     */
    public double getUnitPrice() {
        return UnitPrice;
    }

    /**
     * Set UnitPrice of the product sold
     * @param unitPrice UnitPrice from the product that we searched
     */
    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    /**
     * Get CustomerID of the buyer from the product sold
     * @return CustomerID
     */
    public long getCustomerID() {
        return CustomerID;
    }

    /**
     * Set CustomerID of the buyer from the product sold
     * @param customerID CustomerID from the buyer of the product that we searched
     */
    public void setCustomerID(long customerID) {
        CustomerID = customerID;
    }

    /**
     * Get Country where the product had been sold
     * @return Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * Set Country where the product had been sold
     * @param country Country where the product had been sold
     */
    public void setCountry(String country) {
        Country = country;
    }
}
