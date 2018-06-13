/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datascrapping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Usama
 */
public class ScrapAllData {
    
    testProgram tp = new testProgram();
    
    public void scrapAllDataInFile () {
        try {
    ArrayList<String> circularNameAL = new ArrayList<String>();
    ArrayList<String> yearsAL = new ArrayList<String>();
    ArrayList<String> dataInsideCircularAL = new ArrayList<String>();
    ArrayList<String> readCircularAL = new ArrayList<String>();
    
     BufferedWriter bf = new BufferedWriter (new FileWriter(new File ("C:\\Users\\Usama\\Desktop\\dumpedData.txt") ));
        
      Document document;
            
            document = Jsoup.connect("http://www.sbp.org.pk/circulars/cir.asp").get();
            
            Elements departmentName = document.select("td[height=25][bgcolor=#F8F8F8]"); 
            Elements departmentLink = document.select("td[height=25][bgcolor=#F8F8F8] > a");
            System.out.println("department size = " + departmentName.size());

            //System.out.println("\n\n department names \n\n");
//            for(int i=0;i<departmentName.size();i++){
//                // storin circular names in an arraylist
//               circularNameAL.add(departmentName.get(i).text()); 
//                //System.out.println(departmentName.get(i).text());
//            }
//            
           System.out.println("department link size = " + departmentLink.size());
//            System.out.println("\n\n links \n\n");
//            
            for  (int i=0;i<departmentLink.size();i++){
           
                 // storin circular names in an arraylist
               circularNameAL.add(departmentName.get(i).text()); 
               
                bf.write(departmentName.get(i).text()+ "\n");         
//System.out.println(departmentLink.get(i).attr("abs:href"));

//=======================================================================================
            // printing years of each circular 
            
                        
            document = Jsoup.connect(departmentLink.get(i).attr("abs:href")).get();
            
            Elements years = document.select("li"); 
            Elements yearsLink = document.select("font[color=#000000][size=2] a");
            
            System.out.println("years size = " + years.size());

           // System.out.println("\n\n years listed \n\n");
          //  bf.write("years of "+ circularNameAL.get(i)+"\n");
        
             for(int j=0;j<years.size();j++){
               // System.out.println(years.get(i).text());
        // storin circular names in an arraylist
            yearsAL.add(years.get(j).text());
            bf.write(years.get(j).text()+"\n");
            
            
 // =====================     printing data inside circulars =======================

            document = Jsoup.connect(yearsLink.get(j).attr("abs:href")).get();
            
            Elements circularData = document.select("td[height=26]"); 
            Elements circularDescriptionLink = document.select("tr[bgcolor=#f8f8f8] a");
            
            System.out.println("Circular data  size = " + circularData.size());

           // System.out.println("\n\n Circular Data \n\n");
            
            for(int k=0;k<circularData.size();k++){
                //System.out.println(circularData.get(i).text());
// storing circular data in arraylist
                dataInsideCircularAL.add(circularData.get(k).text());
                bf.write(circularData.get(k).text()+"\n");
                
            } // k nested loop ends here 
            
//           System.out.println("Circular Description Link = " + circularDescriptionLink.size());
//           System.out.println("\n\n links \n\n");
//           
//            for (int i=0;i<circularDescriptionLink.size();i++){
//           System.out.println(circularDescriptionLink.get(i).attr("abs:href"));
//          
//            }
            
            } // j nested for ends here 
            bf.write("\n");
           
            System.out.println("years link size = " + yearsLink.size());
//            System.out.println("\n\n links \n\n");
//            
//            for (int i=0;i<yearsLink.size();i++){
//            System.out.println(yearsLink.get(i).attr("abs:href"));
//            
//            }
            
            
            //======================= printing years end here =====================
           
            }
            bf.close();
        
        }catch(Exception e) {
    System.out.println("Error " + e);
            }
    }

    
    
    
    
}
