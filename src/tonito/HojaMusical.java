package tonito;

/**
 *
 * @author Federico Teixeira G
 */
public class HojaMusical {	//Hojamusical puede interpretarse como canción y Hoja puede interpretarse como una serie o secuencia de acordes
	private Acordes hojas[];
	private String nombre, autor;
	private int contador=0;	
	private String[] acordes={"Cb","Db","Eb","Fb","Gb","Ab","Bb",	"C","D","E","F","G","A","B",	"C#","D#","E#","F#","G#","A#","B#",		"Db", "Eb", "F", "Gb", "Ab", "Bb", "C", 	"D", "E", "F#", "G", "A", "B", "C#", 	"Eb", "F", "G", "Ab", "Bb", "C", "D",		"E", "F#", "G#", "A", "B", "C#", "D#", 		"F", "G", "A", "Bb", "C", "D", "E", 		"F#", "G#", "A#", "B", "C#", "D#", "E#", 		"Gb", "Ab", "Bb", "Cb", "Db", "Eb", "F", 		"G", "A", "B", "C", "D", "E", "F#", 		"Ab", "Bb", "C", "Db", "Eb", "F", "G", 		"A", "B", "C#", "D", "E", "F#", "G#", 		"Bb", "C", "D", "Eb", "F", "G", "A",  	"B", "C#", "D#", "E", "F#", "G#", "A#"};	//NEW
	
	
		
    public HojaMusical(String au, String nom, int n) {  //n es la cantidad  máxima de hojas que se pueden hacer (Se establece como 100)
    	hojas= new Acordes[n];
    	autor=au; //El autor de la hojamusical
    	nombre=nom; //El nombre de la hojamusical (Ej. el nombre de una canción)
    	
    }
    
    //Set y Get    
    public String getNombre(){
    	return nombre;
    }
    public void setNombre(String nom){
    	nombre=nom;
    }
    
    public String getAutor(){
    	return autor;
    }
    public void setAutor(String aut){
    	autor=aut;
    }   
    
    public int getContador(){
    	return contador;
    }
    
    public String getNombrehoja(int posicion){
        return hojas[posicion].getNombre();
    }
    
    public String getAcordeshoja(int posicion){
        return hojas[posicion].getAcordes();
    }
    
    public String getTonoActualhoja(int posicion){
        return hojas[posicion].getTonoA();
    }
    
    
    
    //Fin Set y Get
    
    //Métodos    
    public void nuevahoja(Acordes acord){			//Recibe la secuencia de acordes que se va a guardar en hojas[contador]
    	if(contador<hojas.length){
    		hojas[contador]=acord;
    		if(contador+1<hojas.length){
    			contador++;
    		}	
    	}
    }	
    
    public void editarhoja(int posicion, String nomb, String tone, String acor){	//Recibe el nombre, el tono, y el string de acordes para modificarlos (Ej. Coro o Verso 1), sería como la cédula en los ejemplos de las clases
    		
    	hojas[posicion].setNombre(nomb);
    	hojas[posicion].setTonoA(tone);
    	hojas[posicion].setAcordes(acor);
    }
    
    
    public void eliminarhoja(int posicion){		//Recibe el nombre de la hoja que se va a eliminar 
        hojas[posicion]=hojas[contador-1];      //ESTO ESTÁ MAL
        contador--;
    }	
    
    public void transportarhoja(int po, String tono) {
    	
    	String [] guardar, acordesguardados, modosguardados, almacen;
    	
    	
    	guardar=hojas[po].getAcordes().split(" ");			//Los separa por Acordes-modo
    	
    	acordesguardados=new String[guardar.length];		//Inicialización acordesguardados 
    	modosguardados= new String[guardar.length];			//Inicialización modosguardados

    	for(int i=0; i<guardar.length; i++){
    		
    		if(guardar[i].contains("-")){			//Si contiene un guión
	    		
	    		almacen=guardar[i].split("-");		//En almacen se guarda el acorde completo separado en i=0 el acorde y en i=1 el modo 
	    		acordesguardados[i]=almacen[0];		//En acordesguardados se guarda el acorde que está en almacen[0]
	    		modosguardados[i]=almacen[1];		//En modosguardados se guarda el modo que está en almacen[1]
	    		
	    		
    		}else{									//Si no contiene un guión
    			acordesguardados[i]=guardar[i];		//En acordesguardados se guarda el acorde como tal puesto que no se usa el almacén	
    			modosguardados[i]="";				//En modosguardados se guarda una cadena vacía
    			
    		}
 				
    	}
    		
    	for(int i=0; i<guardar.length; i++){
    		for(int l=numeracion(hojas[po].getTonoA()); l<numeracion(hojas[po].getTonoA())+7; l++){		//Guardar la posición del tonoactual y verifica las siguientes 6 casillas que es donde están los acordes de ese tono 
	    		if(acordesguardados[i].equals(acordes[l])){
	    			acordesguardados[i]=acordes[numeracion(tono)+(l-numeracion(hojas[po].getTonoA()))];
	    			break;
	    								
    			}
    		}
   		}
   	hojas[po].setAcordes(""); //Se reinicia para poder guardar los acordes transportados
        hojas[po].setTonoA(tono);   //Se actualiza el tono de la hoja
        
   	for(int i=0; i<guardar.length; i++){
            if(modosguardados[i].equals("")){
    		hojas[po].setAcordes(hojas[po].getAcordes()+acordesguardados[i]+" ");
            }else hojas[po].setAcordes(hojas[po].getAcordes()+acordesguardados[i]+"-"+modosguardados[i]+" "); 
    	}
        
        
    			
    }
    	
    public int numeracion(String tono){		//Devuelve la posición de un tono
    	for(int i=0; i<acordes.length; i+=7){	//Avanza de 7 en 7 porque la base para los tonos está en cada 7 acordes
    		if(acordes[i].equals(tono)){
    			return i;
    		}		
    	}
    	return 0;	//Si hay un fallo retorna la posición 0 que equivale a C (Do mayor)
    } 
    
    public Acordes mostrar(int posicion){
        
        return hojas[posicion];
        
    }

    public String toString(){
    	return "Nombre: "+nombre+"\nAutor: "+autor;
    }
    
    //Fin Métodos
}
