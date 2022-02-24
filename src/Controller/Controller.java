/**
 * Package that contains the methods made in model to interact with the user and return information
 */
package Controller;

import Model.Model;
import View.Window;

/**
 * Class that contains the methods imported from view and model to interact with the user
 */
public class Controller {
    /**
     * Object Window to import window class
     */
    private Window view;
    /**
     * Object Model to import model class
     */
    private Model model;

    /**
     * Constructor method
     */
    public Controller() {
        view = new Window();
        model = new Model();
        init();
    }

    /**
     * Method to initialize the methods that we imported from classes
     */
    private void init() {
        String msg ="";
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
                        msg =view.readString("Ingrese el número de factura");
                        view.showInfo("" + model.searchByInvoiceNo(msg));
                        break;
                    case 4:
                        msg =view.readString("Ingrese el stockCode de factura");
                        view.showInfo("" + model.searchByStockCode(msg));
                        break;
                    case 5:
                        model.avgByCountry(true);

                        break;
                    case 6:
                        boolean t= true;
                        msg =view.readString("Ingrese el producto deceseado");
                        String msg2=view.readString("desea filtrar por mes");
                        if(msg2.equalsIgnoreCase("si")){

                            int msg3=view.readInt("Ingrese el inicio del rango de meses");
                            int msg4=view.readInt("Ingrese el fin del rango de meses\"");
                            view.showInfo("" + model.findPartiallyByDescription(msg,t,msg3,msg4));
                        }else {
                            t= false;
                            view.showInfo("" + model.findPartiallyByDescription(msg,t,0,0));
                        }


                        break;
                }
            }while(menu != 0);
        } catch(NumberFormatException formato) {}
    }
}
