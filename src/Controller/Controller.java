package Controller;

import Model.Model;
import View.Window;

public class Controller {
    private Window view;
    private Model model;

    public Controller() {
        view = new Window();
        model = new Model();
        init();
    }

    private void init() {
        String j="";
        try {
            int menu = 0;
            do {
                menu = view.readInt("" +
                        "\n Selecciona la opcion a realizar" +
                        "\n 1. Cantidad total de datos" +
                        "\n 2. Cantidad total de ventas"+
                        "\n 3. Consulta factura"+
                        "\n 4. Consulta Stock" +
                        "\n 5. Promedio Ventas" +
                        "\n 0. Salir");

                switch(menu) {
                    case 1:
                        model.uploadData();
                        break;
                    case 2:
                        view.showInfo("La cantidad de ventas es: " + model.sumatory());
                        break;

                    case 3:
                        j=view.readString("Ingrese el número de factura");
                        view.showInfo("" + model.searchByInvoiceNo(j));
                        break;
                    case 4:
                        j=view.readString("Ingrese el stockCode de factura");
                        view.showInfo("" + model.searchByStockCode(j));
                        break;
                    case 5:
                        j=view.readString("Desea que el promedio sea por pais? SI / NO");
                        String SI="";
                        boolean rta = true;
                        if (j.equalsIgnoreCase(SI)){
                            rta = true;
                        }else{
                            rta = false;
                        }
                        view.showInfo("" + model.avgByCountry(rta));
                        break;
                }
            }while(menu != 0);
        } catch(NumberFormatException formato) {}
    }
}
