package Model;

public class Model {
    public Model() {}

    public void uploadData() {
        Archive.uploadData();
    }

    public double sumatory() {
        return Archive.sumTotalSales();

    }

    public String searchByInvoiceNo(String search) {
        return Archive.findByInvoiceNo(search);

    }
    public double searchByStockCode(String search) {
        return Archive.countByStockCode(search);

    }
}
