

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;


public class CenaAmigos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tecla = new Scanner(System.in);
		System.out.println("-------------------------RECETAS------------------------");
		// pedir y escribir recetas y recetas 
		// por teclado y guardar en arraylist
		System.out.println(" Pedir recetas e ingredientes y guardarlos en sus arraylists");
		System.out.println("\nCuantas recetas son?");
		int cantRecetas = tecla.nextInt();
		//arraylist para guardar todas las recetas
		ArrayList<Receta> listaRecetas = new ArrayList<Receta>();
					
		for (int i=0; i<cantRecetas; i++) {
						
			Receta r1 = new Receta();
						
			System.out.println("Nombre de la receta "+(i+1)+":");
			r1.setNombreReceta(tecla.next());
			System.out.println("Cuantos ingredientes tiene?");
			int cantIngredientes = tecla.nextInt();
		
			//arraylist para guardar todas los ingredientes
			ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
						
			for (int j=0; j<cantIngredientes; j++) {		
				Ingrediente ing1 = new Ingrediente();
							
				System.out.println("Nombre del ingrediente "+(j+1)+":");
				ing1.setNombreIngrediente(tecla.next());
							
				//variable para saber si son gramos o unidades
				String como=" ";
				do {
					System.out.println("Se mide en gramos(g) o unidades(u)?");
					como = tecla.next();
					switch (como) {
						case "g":
							System.out.println("Cuantos gramos?");
							ing1.setCantidadGramos(tecla.nextInt()); 
							ing1.setCantidadUnidad(-1);
							ing1.setEnGramos(true);
							break;
						case "u":
							System.out.println("Cuantas unidades?");
							ing1.setCantidadUnidad(tecla.nextInt());
							ing1.setCantidadGramos(-1);
							ing1.setEnGramos(false);
							break;
						default:
							System.out.println("Opcion incorrecta");
							break;
					} //fin del switch	
				} while((!como.equalsIgnoreCase("g")) && (!como.equalsIgnoreCase("u")));
				//añadir ingrediente al arraylist de ingredientes
				listaIngredientes.add(ing1);				
			} //final de bucle de ingredientes
						
			r1.setIngredientes(listaIngredientes);

			System.out.println("Como se prepara?");
			r1.setPreparacion(tecla.next());
						
			// añadir recetas al arraylist de recetas
			listaRecetas.add(r1);
		} // final de bucle de recetas

		
		
		try {
			// crear fichero
			File archivo = new File("/home/zubiri/ProyectosJava/examen/src","listRecetas.txt");

			if (archivo.createNewFile()) {
				System.out.println("Se ha creado el archivo 'listRecetas.txt' correctamente");
			} else {
				System.out.println("Ya existe el archivo 'listRecetas.txt'");
			}
		
			//crea el FileWriter, para escribir en el fichero
			FileWriter fw = new FileWriter("./listRecetas.txt");

			for (int i=0;i<listaRecetas.size();i++) {
				
				fw.write(listaRecetas.get(i).getNombreReceta()+";");
				ArrayList<Ingrediente> listaIng = listaRecetas.get(i).getIngredientes();	

				for (int k=0;k<listaIng.size();k++) {
					fw.write(listaIng.get(k).getNombreIngrediente()+"*");
					fw.write(listaIng.get(k).getCantidadGramos()+"*");
					fw.write(listaIng.get(k).getCantidadUnidad()+"*");
					if (k == listaIng.size()-1){
						fw.write(listaIng.get(k).getEnGramos()+";");
					} else {
						fw.write(listaIng.get(k).getEnGramos()+"#");
					}
				}
				fw.write(listaRecetas.get(i).getPreparacion()+"\n");
			}
			fw.close(); //cerrar objeto FileWriter 
	
			// Leer fichero y mostrar	
			System.out.println("Leer el contenido del fichero, identificar los objetos y atributos, y mostrarlos por pantalla\n");
	
			Scanner leerFichero = new Scanner (archivo);

			int cont = 1;
			while (leerFichero.hasNextLine()) {
				String fila = leerFichero.nextLine();//lerro bat irakurri fitxategitik eta string moduan gorde
				String [] atributos = fila.split(";");//atributuak koma eta hutsuneaz bereiztu eta string motako array batean gorde 
				
				System.out.println("Receta "+cont);
				System.out.println();
				System.out.println("\tNombre: "+atributos[0]);
				System.out.println();

				String [] ingSeparados = atributos[1].split("#");
				System.out.println("\tIngredientes:");

				for (int i=0; i<ingSeparados.length; i++) {
					
					String [] atribIng = ingSeparados[i].split("\\*");
					
					if (Boolean.parseBoolean(atribIng[3])) {
						System.out.println("\t\t"+atribIng[0]+", "+atribIng[1]+" gramo(s)");
					}else{
						System.out.println("\t\t"+atribIng[0]+", "+atribIng[2]+" unida(es)");
					}
				}
				System.out.println();
				System.out.println("\tPreparacion: "+atributos[2]);
				System.out.println();
				cont++;
			}
			leerFichero.close();
		} catch (Exception e) {
				System.out.println("Error: "+e);
		}
		
		tecla.close();

	}

}
