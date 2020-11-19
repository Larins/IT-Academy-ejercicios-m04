package m04_ejercicios;
import java.util.*;

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
		
		String[] platos = {"Ensalada de la casa", "Escalivada con anchoas", "Espinacas a la catalana", "Tortilla de alcachofas", "Macarrones boloñesa", "Fajitas de pollo", "Alubias con chorizo", "Pepito de ternera"};
					
		//Declarar y poblar el array con los precios de los platos.
		
		int[] precios = {40,100,20,50,70,150,120,30};
		
		//Integrar ambos arrays en un HashMap.
		
		HashMap<String, Integer> menu = new HashMap<String, Integer>();
		
		for(int i= 0; i < platos.length; i++){
			   menu.put(platos[i], precios[i]);
			}

		
		System.out.println(menu);
		

	}

}