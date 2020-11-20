//BRUJERÍAS :p


package m04_ejercicios;
import java.util.*;
import javax.swing.*;

public class M04_Fase02 {
	
	public static void main(String[] args) {
						
		//Declaramos y poblamos el array con los platos del menú.
		
		String[] platos = {"Ensalada de la casa", "Escalivada con anchoas", "Canelones de espinaca", "Tortilla de alcachofas", "Macarrones boloñesa", "Fajitas de pollo", "Alubias con chorizo", "Pepito de ternera"};
					
		//Declaramos y poblamos el array con los precios de los platos.
		
		int[] precios = {40,100,20,50,70,150,120,30};
		
		//Integramos ambos arrays en un HashMap.
		
		HashMap<String, Integer> menu = new HashMap<String, Integer>();
		
		for(int i= 0; i < platos.length; i++){
			   menu.put(platos[i], precios[i]);
			}
		//Damos la bienvenida a los clientes.
		
		int vercarta = JOptionPane.showConfirmDialog(null,"Bienvenid@ al restaurante Lara. \n¿Deseas ver la carta?","Restaurante Lara",JOptionPane.YES_NO_OPTION); 	 
		
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
		     
		     while (pedirmas == JOptionPane.YES_OPTION) {	
		    	 
			    String platopedido = (String) JOptionPane.showInputDialog(null, "Escoge el plato deseado:","Restaurante Lara", JOptionPane.QUESTION_MESSAGE, null, platos, platos[0]); 
				 
			    //Vamos poblando el ArrayList con los precios de cada plato pedido por el cliente.
			     
			    preciopedido.add(menu.get(platopedido));

			    //Y calculamos un subtotal, sumando esos precios.
			     
			 	subtotal = subtotal + menu.get(platopedido);
		        
			    //Y le vamos recordando al cliente qué es lo que ha ido pidiendo.
			     
			    System.out.println("\t" + platopedido + ":\t\t" + menu.get(platopedido) + "€" + "\t\tSubtotal: " + subtotal + "€");
		        
			    //Le vamos preguntando al cliente si desea añadir algún plato más. 
			
			     pedirmas = JOptionPane.showConfirmDialog(null,"¿Deseas pedir algo más?","Restaurante Lara",JOptionPane.YES_NO_OPTION);
		    	 
			     //Mientras (while) el cliente vaya diciendo que quiere pedir otro plato, seguirá iterando el bucle. Si dice que no, se cierra.	
		    	 
			     if (pedirmas == JOptionPane.NO_OPTION){
					System.out.println("\nGracias por tu pedido.\nTu cuenta asciende a " + subtotal + "€.");
					
				}
			
	        }   
		    
			//Vamos ahora a calcular la combinación óptima de billetes para pagar la cuenta.
			
			//Declaramos e inicializamos las variables de los billetes.
			
			int eu5 = 5;
			int eu10 = 10;
			int eu20 = 20;
			int eu50 = 50;
			int eu100 = 100;
			int eu200 = 200;
			int eu500 = 500;
			
			//Declaramos y poblamos un array con estos billetes estándar.
			
			int[] billetes = new int[]{eu500, eu200, eu100, eu50, eu20, eu10, eu5};
			
			//Declaramos un array tan largo como diferentes billetes hay (7). 
			//Cada posición de este array está relacionada con las posiciones del array billetes.
			//Con un loop, lo poblaremos con números correspondientes al número de billetes de cada tipo.
			//Ejemplo: si usamos 2 billetes de 5€, billetesusados[0] = 2.
			
			int[] billetesusados = new int[7];
			
			//int preciofinal = 650;
			
			//Usamos un for para calcular los billetes óptimos (número de billetes de cada tipo):
			
			for (int i = 0; i< 7; i++) {
				if (subtotal >= billetes[i]) {
					billetesusados[i] = subtotal/billetes[i];
					subtotal = subtotal - billetesusados[i] * billetes[i];
				}
			}
			
			//Usamos otro for para printarlo por consola.
			
			System.out.println("\nTe recomendamos que pagues con estos billetes: ");
			for (int i=0; i<7; i++) {
				System.out.println("\t" + billetes[i] + "€:\t" + billetesusados[i] + " billete/s." );
				
			}
			System.out.println("\n¡Gracias por tu visita!\nEsperamos verte de nuevo muy pronto ;)" );
		     
	}
}