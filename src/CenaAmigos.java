

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

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
					
		for (int i=0; i<cantRecetas; i++){
						
			Receta r1 = new Receta();
						
			System.out.println("Nombre de la receta "+(i+1)+":");
			r1.setNombreReceta(tecla.next());
			System.out.println("Cuantos ingredientes tiene?");
			int cantIngredientes = tecla.nextInt();
		
			//arraylist para guardar todas los ingredientes
			ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
						
			for (int j=0; j<cantIngredientes; j++){		
				Ingrediente ing1 = new Ingrediente();
							
				System.out.println("Nombre del ingrediente "+(j+1)+":");
				ing1.setNombreIngrediente(tecla.next());
							
				//variable para saber si son gramos o unidades
				String como=" ";
				do{
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
				}while((!como.equalsIgnoreCase("g")) && (!como.equalsIgnoreCase("u")));
				//añadir ingrediente al arraylist de ingredientes
				listaIngredientes.add(ing1);				
			} //final de bucle de ingredientes
						
			r1.setIngredientes(listaIngredientes);

			System.out.println("Como se prepara?");
			r1.setPreparacion(tecla.next());
						
			// añadir recetas al arraylist de recetas
			listaRecetas.add(r1);
		} // final de bucle de recetas

		
		// crear fichero
		try{

			File archivo=new File("/home/zubiri/ProyectosJava/examen/src","listRecetas.txt");

			if(archivo.createNewFile()){
				System.out.println("Se ha creado el archivo 'listRecetas.txt' correctamente");
			}else{
				System.out.println("No se ha podido crear el archivo 'listRecetas.txt'");
			}
		}catch(Exception e){
			System.out.println("Error con el archivo");
		}
		
		// escribir en el fichero
		try{
			//crea el FileWriter, para escribir en el fichero
			FileWriter fw=new FileWriter("./listRecetas.txt");

			for (int i=0;i<listaRecetas.size();i++){
				fw.write(listaRecetas.get(i).getNombreReceta()+";");
				ArrayList<Ingrediente> listaIng = listaRecetas.get(i).getIngredientes();	

				for (int k=0;k<listaIng.size();k++){
					fw.write(listaIng.get(k).getNombreIngrediente()+"*");
					fw.write(listaIng.get(k).getCantidadGramos()+"*");
					fw.write(listaIng.get(k).getCantidadUnidad()+"*");
					//fw.write(listaIng.get(k).getEnGramos());
					if (k == listaIng.size()-1){
						fw.write(listaIng.get(k).getEnGramos()+";");
					}else{
						fw.write(listaIng.get(k).getEnGramos()+"#");
					}
				}
				fw.write(listaRecetas.get(i).getPreparacion()+"\n");
			}
			fw.close(); //cerrar objeto FileWriter 
		}catch(Exception e){
			System.out.println("Error escribiendo archivo");
		}
				
					System.out.println("Leer el contenido del fichero, identificar los objetos y atributos, y mostrarlos por pantalla\n");

								//mostrar contenido del arraylist de recetas
								for (int i=0; i<listaRecetas.size(); i++){
									System.out.println("Receta "+(i+1)+":");
									System.out.println(listaRecetas.get(i).getNombreReceta());
									System.out.println(listaRecetas.get(i).getIngredientes());
									System.out.println(listaRecetas.get(i).getPreparacion());
								}

		/* escribir en el fichero
		try{

			//crea el FileWriter, para escribir en el fichero
			FileWriter fw=new FileWriter("./listRecetas.txt");

			for (int i=0;i<listaRecetas.size();i++){

				fw.write(listaRecetas.get(i).getNombreReceta()+";");
				
				ArrayList<Ingrediente> listaIng = listaRecetas.get(i).getIngredientes();
				
				for (int k=0;k<listaIng.size();k++){

					fw.write(listaIng.get(k).getNombreIngrediente()+"*");
					fw.write(listaIng.get(k).getCantidadGramos()+"*");
					fw.write(listaIng.get(k).getCantidadUnidad()+"*");
					fw.write(listaIng.get(k).getEnGramos()+"#");
				}

				fw.write(listaRecetas.get(i).getPreparacion()+";");
			}
			fw.close(); //cerrar objeto FileWriter 
			
			FileReader fr=new FileReader("D:\\fichero1.txt");

		            //Leemos el fichero y lo mostramos por pantalla

		            int valor=fr.read();

		            while(valor!=-1){

		                System.out.print((char)valor);

		                valor=fr.read();

		            }

		            //Cerramos el stream

		            fr.close();

		}catch(Exception e){

			System.out.println("Error E/S: "+e);
		} */
		tecla.close();

	}

}
