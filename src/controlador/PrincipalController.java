package controlador;

import modelo.CalcularTotal;
import modelo.Cargar;
import vistas.*;

public class PrincipalController {
    
    private static String Mes = "";
    private static String Efectivo = "";
    private static String Cahorro = "";
    private static String Prestamo = "";
    private static String Entidades = "";
    private static String UrlUser = "";
            
    public static VistaPrincipal ventanaPrincipal = new VistaPrincipal();
    public static VistaLoad ventanaLoad = new VistaLoad();
    
    public static void mostrar()
    {
       ventanaPrincipal.setVisible(true);
    }
    public static void ocultar()
    {
       ventanaPrincipal.setVisible(false);
    }
    public static void getDatosWindow()
    {
       Mes = ventanaPrincipal.getjTextField1().getText();
       System.out.println("Mes en getDatosWindow: " + Mes);
       Efectivo = ventanaPrincipal.getjTextField2().getText();
       Cahorro = ventanaPrincipal.getjTextField3().getText();
       Prestamo = ventanaPrincipal.getjTextField4().getText();
       Entidades = ventanaPrincipal.getjTextField5().getText();
    }
    public static void eventoBotonConfirmarDatos()
    {
       System.out.println("Clicked Confirmar Datos"); 
       getDatosWindow();
       SaveController.mostrarConfirm();
       //Ir a funcion calcular total actual
       CalcularTotal calculadora = new CalcularTotal();        
       int TotalAc = calculadora.calcular(Efectivo, 
                                           Cahorro,
                                          Prestamo);
       // Total Actual a string
       String strTotalAc = String.valueOf(TotalAc);
       //System.out.println("Resultado: " + TotalAc);
       
       String Datos = ("<html>"
                    + "Mes: " + Mes 
                    + "<br>Entidades: " + Entidades
                    + "<br>Efectivo: " + Efectivo
                    + "<br>Cuenta de ahorro: " + Cahorro
                    + "<br>Prestamo: " + Prestamo
                    + "<br>Total: " + strTotalAc
                    + "</html>");
       //Envio datos a controlador de ventana save
       SaveController.setDatos(Datos);
    }
    public static void BottonLoadSave()
    {
        System.out.println("Load Save clicked!");
        getDataWindowSave();
        System.out.println("2:"+Mes+UrlUser);
        
        String[] Carga;            
        //getDatosWindow();
        String textoMesAct = Mes;
        String referencia = "Mes Actual";
       
        // método para cargar contenido anterior de archivo
        Carga = Cargar.cargarArchivo(textoMesAct,referencia,UrlUser);
     
        // Extraer número de la linea 
        String numeroMes = Carga[0].split(": ")[1].trim();
        String numeroEfectivo = Carga[2].split(": ")[1].trim();
        String numeroCahorro = Carga[3].split(": ")[1].trim();
        String numeroPrestamo = Carga[4].split(": ")[1].trim();
        //String numeroTotal = Carga[5].split(": ")[1].trim();
        String entidades = Carga[1].split(": ")[1].trim();
           
        // Asignar el valor al campoEfectivo
        ventanaPrincipal.setjTextField1(numeroMes);
        ventanaPrincipal.setjTextField2(numeroEfectivo);
        ventanaPrincipal.setjTextField3(numeroCahorro);
        ventanaPrincipal.setjTextField4(numeroPrestamo);
        ventanaPrincipal.setjTextField5(entidades);    
        ocultarLoadSave();
    }

    static String SendMes() 
    {
       String Datos2 = ventanaPrincipal.getjTextField1().getText();     
       //System.out.println("field1 es:"+Datos2);
       return Datos2;
    }
    
    public static void mostrarLoadSave()
    {
       ventanaLoad.setVisible(true);
    }
    public static void ocultarLoadSave()
    {
       ventanaLoad.setVisible(false);
    }
    public static void getDataWindowSave()
    {
       Mes = ventanaLoad.getjTextField1().getText();
       UrlUser = ventanaLoad.getjTextField2().getText();
       System.out.println(Mes+UrlUser);
    }
}
