
package modelo;

public class CalcularTotal {
    
     public int calcular( String textoEfectivo, String textoCahorro, String textoPrestamo) 
     {
         // Obtener textos de cada campo
         int numEfecAc = Integer.parseInt(textoEfectivo);
         int numCaAc = Integer.parseInt(textoCahorro);
         int numPresAc = Integer.parseInt(textoPrestamo);

         // Calculo Total actual
         int totalAc = numEfecAc + numCaAc + numPresAc;

         return totalAc;
    } 
    
}
