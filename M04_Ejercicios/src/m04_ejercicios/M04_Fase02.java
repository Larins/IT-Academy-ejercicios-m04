package m04_ejercicios;
import java.util.*;
import javax.swing.*;

public class M04_Fase02 {
	
	public static void main(String[] args) {
				
		//Declarar e inicializar las variables de los billetes.
		
		int eu5 = 5;
		int eu10 = 10;
		int eu20 = 20;
		int eu50 = 50;
		int eu100 = 100;
		int eu200 = 200;
		int eu500 = 500;
		
		//Declarar la variable para el precio total de la comida.
		
		int ticket = 0;
		
		//Declarar y poblar el array con los platos del menú.
		
		String[] platos = {"Ensalada de la casa", "Escalivada con anchoas", "Canelones de espinaca", "Tortilla de alcachofas", "Macarrones boloñesa", "Fajitas de pollo", "Alubias con chorizo", "Pepito de ternera"};
					
		//Declarar y poblar el array con los precios de los platos.
		
		int[] precios = {40,100,20,50,70,150,120,30};
		
		//Integrar ambos arrays en un HashMap.
		
		HashMap<String, Integer> menu = new HashMap<String, Integer>();
		
		for(int i= 0; i < platos.length; i++){
			   menu.put(platos[i], precios[i]);
			}

		//Printamos el menú por consola.
		
		     Set<String> keys = menu.keySet();
		     Iterator<String> iter = keys.iterator();
		     
		     System.out.println("RESTAURANTE LARA\nMENÚ A LA CARTA\nEscoge el plato deseado:\n");
		     
		     while(iter.hasNext()){
		        String key = iter.next();

		        System.out.println("\t" + key + ":\t\t" + menu.get(key) + " €");
		     }
		     
		     String pedido = (String) JOptionPane.showInputDialog(null, "Escoge el plato deseado:",
		         "Restaurante Lara", JOptionPane.QUESTION_MESSAGE, null, platos, platos[0]); 
		     System.out.println("\nLos platos pedidos hasta ahora son: \n\n\t" + pedido);
		     
		     int pedirmas = 0;
		     
		     while (pedirmas == JOptionPane.YES_OPTION) {	
		    	 
		    	 pedirmas = JOptionPane.showConfirmDialog(null,"¿Deseas tomar algo más?","Restaurante Lara",JOptionPane.YES_NO_OPTION);
		    	 
		    	 if (pedirmas == JOptionPane.NO_OPTION){
					System.out.println("\nGracias por su pedido.");
					System.exit(0);
				}
				else if (pedirmas == JOptionPane.YES_OPTION){
					String pedidoextra = (String) JOptionPane.showInputDialog(null, "Escoge el siguiente plato deseado:", "Restaurante Lara", JOptionPane.QUESTION_MESSAGE, null, platos, platos[0]); 
					System.out.println("\t" + pedidoextra);
			    }
		    } 
	}

}