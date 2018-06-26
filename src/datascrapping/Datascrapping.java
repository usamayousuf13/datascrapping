/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datascrapping;

/**
 *
 * @author Usama
 */
public class Datascrapping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // ScrapAllData sad = new ScrapAllData();
      //  sad.scrapAllDataInFile();
       testProgram tp = new testProgram();
     //   tp.getCirculars("http://www.sbp.org.pk/circulars/cir.asp");
     //   tp.getYears("http://www.sbp.org.pk/acd/index.htm");
       tp.getDataInsideCircular("http://www.sbp.org.pk/acd/2016/index.htm");
   //     tp.readCircular("http://www.sbp.org.pk/acd/2017/C3.htm");
      //tp.bestFood("http://www.karachisnob.com/restaurants-karachi.htm");
    }
    
}
