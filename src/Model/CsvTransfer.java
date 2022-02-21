package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that transfer the CSV file to link ProductBean with the information taken from file
 * The code of this class is taken from: https://github.com/programming2-unbosque/OpenCSVTutorial/blob/master/src/main/java/edu/unbosque/opencsvtutorial/CsvTransfer.java
 */
public class CsvTransfer {

    private List<ProductBean> csvList;

    public CsvTransfer() {}

    public List<ProductBean> getCsvList() {
        if (csvList != null) return csvList;
        return Collections.emptyList();
    }
    public void setCsvList(List<ProductBean> csvList) {
        this.csvList = csvList;
    }

}
