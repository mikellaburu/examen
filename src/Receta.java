import java.util.*;
public class Receta{
	private String nombreReceta;
	private ArrayList <Ingrediente> ingredientes;
	private String preparacion;
	
	//getters
	public String getNombreReceta(){
		return this.nombreReceta;
	}
	public ArrayList <Ingrediente> getIngredientes(){
		return this.ingredientes;
	}
	public String getPreparacion(){
		return this.preparacion;
	}
	
	//setters
	public void setNombreReceta(String nombre){
		this.nombreReceta=nombre;
	}
	public void setIngredientes(ArrayList <Ingrediente> lista){
		this.ingredientes=lista;
	}
	public void setPreparacion(String descripcion){
		this.preparacion=descripcion;
	}
	
}