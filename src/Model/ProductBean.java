/**
 * Package that contains the methods to complete the requirements of the problem
 */
package Model;

import com.opencsv.bean.CsvBindByName;

public class ProductBean {

    @CsvBindByName (column="InvoiceNo")
    private String InvoiceNo;

    @CsvBindByName (column="StockCode")
    private String StockCode;

    @CsvBindByName (column="Description")
    private String Description;

    @CsvBindByName (column="Quantity")
    private int Quantity;

    @CsvBindByName (column="InvoiceDate")
    private String InvoiceDate;

    @CsvBindByName (column="UnitPrice")
    private double UnitPrice;

    @CsvBindByName (column="CustomerID")
    private long CustomerID;

    @CsvBindByName (column="Country")
    private String Country;

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

    public String toString() {
        String line1 = " No. Factura " + " | " + " No. inventario " + " | "  + " Descripcion " + " | " + " Cantidad "
                + " | " + " Fecha " + " | " + " Precio " + " | " + " ID cliente " + " | " + " Pais " + "\n";
        return  "\n" + line1 + InvoiceNo + " | " +
                StockCode + " | " + Description + " | " + Quantity + " | " + InvoiceDate + " | " + UnitPrice + " | " + CustomerID
                + " | " + Country + "\n";
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        InvoiceNo = invoiceNo;
    }

    public String getStockCode() {
        return StockCode;
    }

    public void setStockCode(String stockCode) {
        StockCode = stockCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        InvoiceDate = invoiceDate;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(long customerID) {
        CustomerID = customerID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
