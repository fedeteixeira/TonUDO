/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonito;

/**
 *
 * @author Federico Teixeira G
 */





public class PruebaTonUDO {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HojaMusical music = new HojaMusical("","",50);
        InicioFrame frameinicio= new InicioFrame(music);
        frameinicio.setVisible(true);
    }
    
}
