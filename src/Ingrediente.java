
public class Ingrediente {
	private String nombreIngrediente;
	private int cantidadUnidad;
	private int cantidadGramos;
	private boolean enGramos;

	//getters
	public String getNombreIngrediente(){
		return this.nombreIngrediente;
	}
	public int getCantidadUnidad(){
		return this.cantidadUnidad;
	}
	public int getCantidadGramos(){
		return this.cantidadGramos;
	}
	public boolean getEnGramos(){
		return this.enGramos;
	}

	//setters
	public void setNombreIngrediente(String nombre){
		this.nombreIngrediente=nombre;
	}
	public void setCantidadUnidad(int unidad){
		this.cantidadUnidad=unidad;
	}
	public void setCantidadGramos(int gramos){
		this.cantidadGramos=gramos;
	}
	public void setEnGramos(boolean como){
		this.enGramos=como;
	}
}