/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package includes;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hugo
 */
public class ImpresoraHasar {

    public static void main(String[] args) {
        // Inicialización de la librería
        //ComThread.InitSTA();
        // Creacón del objeto
        ActiveXComponent HASAR = new ActiveXComponent("HASAR.Fiscal");
        // Cambio de una propiedad del objeto

        //PRUEBA FISCAL HASAR
        //ActiveXComponent hasar = new ActiveXComponent("HASAR.Fiscal"); // Creamos un objeto ActiveX, en la imagen anterior se puede ver el nombre del Servicio registrado, usamos ese mismo (EpsonFPHostControlX.EpsonFPHostControl).
        Dispatch sControl = (Dispatch) HASAR.getObject();
        System.out.println("IMPRESORA HASARRRR: " + HASAR.getProgramId());
        Dispatch.put(sControl, "Puerto", 1);
        Dispatch.put(sControl, "Modelo", 41);
        Dispatch.call(sControl, "Comenzar");

        //PARAMETROS DE TIPO DNI Y TIPO DE RESPONSABILIDAD SE PASAN EN CODIGO ASCII
        Dispatch.call(sControl, "DatosCliente", "Rising", "23287800509", "67", "73", "monseñor sueldo de mierda");
        //En este byte se declara el tipo de documento que se desea abrir: Factura/Tique-factura A
        //(A), Factura/Tique-factura B/C (B), Recibo A (a), Recibo B/C (b), Nota de Débito A (D),
        //Nota de Débito B/C (E) o Tique (DEPENDE TAMBIEN APARENTEMENTE DE LO CONFIGURADO EN LOS DATOS DE CLIENTE.. TIPO DE DNI Y TIPO DE RESPONSABILIDAD
        //PARAMETRO EN CODIGO ASCII
        Dispatch.call(sControl, "AbrirComprobanteFiscal", "97");
        
        //ImprimirItem descrip, cant, precio, alicuota, impint
        Dispatch.call(sControl, "ImprimirItem", "Camisa Lacoste M", "1", "900", "21", "0");
        Dispatch.call(sControl, "ImprimirItem", "Short Lacoste S", "1", "400", "21", "0");
        
        //Subtotal impr, items, total, iva, pagado, ivanoi, impint         ,"items","iva","pagado"
        Dispatch.call(sControl, "Subtotal", "True");
        
        Dispatch.call(sControl, "ImprimirPago", "Efectivo", "1500,00");
        Dispatch.call(sControl, "CerrarComprobanteFiscal");
        Dispatch.call(sControl, "Reportez");
        Dispatch.call(sControl, "Finalizar");
        
        

// Enjoy
    }
}
