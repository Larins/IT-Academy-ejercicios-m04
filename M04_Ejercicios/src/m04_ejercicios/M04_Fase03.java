/**
* El programa RESTAURANTE ofrece un menú al cliente.
* El cliente puede solicitar tantos platos como desee.
* A diferencia de la fase anterior, 
* El cliente no selecciona los platos disponibles en un drop-down.
* Debe escribirlos por teclado, aun a riesgo de pedir algo fuera de carta.
* De este modo podemos experimentar con las funcionalidades siguientes:
* (1) Control de errores.
* (2) Excepciones.
* Para facilitar el proceso, los platos son ahora más sencillos.
* Ejemplo: "ensalada" en lugar de "ensalada de la casa".
*  
* 
* @author  Lara Saiz
* @version 1.0
* @since   2020-11-20 
*/


package m04_ejercicios;
import java.util.*;
import javax.swing.*;

public class M04_Fase03 {
	
	public static void main(String[] args) {
						
		//Declaramos y poblamos el Array con los platos del menú.
		//Para que sea más sencillo aplicar el control de errores, abreviamos el nombre de los platos y los escribimos en mayúsculas.
		//También nos construimos un ArrayList auxiliar con los mismos contenidos para algunos cálculos.
		
			String[] platos = {"ENSALADA", "ESCALIVADA", "CANELONES", "TORTILLA", "MACARRONES", "FAJITAS", "ALUBIAS", "TERNERA"};
			List<String> platoslista = Arrays.asList(platos);
			
		//Declaramos y poblamos el Array con los precios de los platos.
		
			int[] precios = {40,100,20,50,70,150,120,30};
		
		//Integramos ambos Arrays en un HashMap.
		
			HashMap<String, Integer> menu = new HashMap<String, Integer>();
			
			for(int i= 0; i < platos.length; i++){
				   menu.put(platos[i], precios[i]);
				}
		
		//Damos la bienvenida a los clientes.
		
			int vercarta = JOptionPane.showConfirmDialog(null,"Bienvenid@ al Restaurante Lara. \n¿Deseas ver la carta?","Restaurante Lara",JOptionPane.YES_NO_OPTION); 	 
			
			if (vercarta == JOptionPane.NO_OPTION){
				System.out.println("De acuerdo, estoy en la barra si necesitas algo.");
			}
			
			if (vercarta == JOptionPane.YES_OPTION) {
				
				//Printamos el menú por consola.
					
				     Set<String> keys = menu.keySet();
				     Iterator<String> iter = keys.iterator();
				     
				     System.out.println("RESTAURANTE LARA\nMENÚ A LA CARTA\nEscoge el plato deseado:\n");
				     
				     while(iter.hasNext()){
				        String key = iter.next();
		
				        System.out.println("\t" + key + ":\t\t" + menu.get(key) + " €");
				     }
			}
		     
		//Pasamos a tomarle nota al cliente.
		     
		     System.out.println("\nApuntaremos aquí los platos que nos indiques:\n");
		     
		//Declaramos una variable que nos servirá para seguir iterando si el cliente desea más platos.
		     
		     int pedirmas = 0;
		     
		//Declaramos un ArrayList donde iremos almacenando los precios de cada plato pedido por el cliente.
		     
		     List<Integer> preciopedido = new ArrayList<Integer>();
		
		//Declaramos una variable donde se irán sumando esos precios.
				
			int subtotal = 0;
				
		//Lanzamos el bucle while, que tomará nota de los platos que sucesivamente vaya pidiendo el cliente.
		//También irá almacenando los precios de los platos.
		//E irá sumándolos en un subtotal.
		     
			while (pedirmas == JOptionPane.YES_OPTION){
		    	 
			    String platopedido = (String) JOptionPane.showInputDialog(null, "Escoge el plato deseado.",JOptionPane.QUESTION_MESSAGE); 
				 
			    //Vamos poblando el ArrayList con los precios de cada plato pedido por el cliente.
			    //Siempre y cuando el plato introducido por teclado se corresponda con un plato del menú.
			    
			    if (platoslista.contains(platopedido.toUpperCase())) {
			    	preciopedido.add(menu.get(platopedido.toUpperCase()));

			    //Calculamos un subtotal, sumando esos precios.
			     
			    	subtotal = subtotal + menu.get(platopedido.toUpperCase());
		        
			    //Le vamos recordando al cliente qué es lo que ha ido pidiendo.
			     
			    	System.out.println("\t" + platopedido.toUpperCase() + ":\t\t" + menu.get(platopedido.toUpperCase()) + "€" + "\t\tSubtotal: " + subtotal + "€");
		        
			    //Le vamos preguntando al cliente si desea añadir algún plato más. 
			
			    	pedirmas = JOptionPane.showConfirmDialog(null,"¿Deseas pedir algo más?","Restaurante Lara",JOptionPane.YES_NO_OPTION);
		    	 
			     //Mientras (while) el cliente vaya diciendo que quiere pedir otro plato, el bucle seguirá iterando. 
			     //La condición de ruptura del bucle es que el cliente diga que no quiere pedir más platos.
		    	 
					
			    	 if (pedirmas == JOptionPane.NO_OPTION){
						System.out.println("\nGracias por tu pedido.\nTu cuenta asciende a " + subtotal + "€.");
					}
			    }
			    else {
			    	System.out.print("Vaya, nos hemos podido apuntarlo. ¿Has dicho " + platopedido.toUpperCase() + "? Vuelve a intentarlo o escoge otro plato, por favor.\n");
			    	
			    }
			}

			//El cliente ha solicitado todos los platos que deseaba y hemos comprobado que fueran correctos.
		    //En la variable subtotal tenemos almacenado a cuánto sube la cuenta.
		    //Vamos ahora a calcular la combinación óptima de billetes para pagar la cuenta.
			//Declaramos e inicializamos una variables para cada billete.
			
				int eu5 = 5;
				int eu10 = 10;
				int eu20 = 20;
				int eu50 = 50;
				int eu100 = 100;
				int eu200 = 200;
				int eu500 = 500;
			
			//Declaramos y poblamos un array con estos billetes.
			
				int[] billetes = new int[]{eu500, eu200, eu100, eu50, eu20, eu10, eu5};
			
			//Declaramos un array tan largo como diferentes billetes hay (7). 
			//Cada posición de este array está relacionada con las posiciones del Array que contiene los valores de los billetes.
			//Con un bucle, lo poblaremos con números correspondientes al número de billetes de cada tipo.
			//Ejemplo: si usamos 2 billetes de 5€, billetes[0]=5 y billetesusados[0]=2.
			
				int[] billetesusados = new int[7];
			
			//Usamos un bucle for para calcular los billetes óptimos (número de billetes de cada tipo):
			
				for (int i = 0; i< 7; i++) {
					if (subtotal >= billetes[i]) {
						billetesusados[i] = subtotal/billetes[i];
						subtotal = subtotal - billetesusados[i] * billetes[i];
					}
				}
			
			//Usamos otro bucle for para printarlo por consola.
			
				System.out.println("\nTe recomendamos que pagues con estos billetes: ");
				
				for (int i=0; i<7; i++) {
					System.out.println("\t" + billetes[i] + "€:\t" + billetesusados[i] + " billete/s." );
				}
			
			//Printamos un mensaje de despedida.
			
				System.out.println("\n¡Gracias por tu visita!\nEsperamos verte de nuevo muy pronto ;)" );
		     
	}
}