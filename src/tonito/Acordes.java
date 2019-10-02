package tonito;

public class Acordes {
    private String acordes, tonoA, nombre;
    public Acordes(String acor, String tono, String nom) {
    	acordes=acor;		//La secuencia de acordes
    	tonoA=tono;			//El tono que posee actualmente la secuencia de acordes
    	nombre=nom;		//El nombre de cada secuencia de acordes (Ej. Coro o Inicio)
    }
    
    //Set y Get
    public String getAcordes(){
    	return acordes;
    }
    public void setAcordes(String acord){
    	acordes=acord;
    }
    
    public String getTonoA(){
    	return tonoA;
    }
    public void setTonoA(String tone){
    	tonoA=tone;
    }
    
    public String getNombre(){
    	return nombre;
    }
    public void setNombre(String nombre){
    	this.nombre=nombre;
    }
    //Fin Set y Get
    
    public String toString(){
    	return nombre+" en "+tonoA; //Imprimiría, por ejemplo, Coro en Am (La menor)
    }
}
