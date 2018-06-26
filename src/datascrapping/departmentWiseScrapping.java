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
public class departmentWiseScrapping {
    
    testProgram tp = new testProgram();
    
    public void scrapDepartment(String link) {
         try{
             
              BufferedWriter bf = new BufferedWriter (new FileWriter(new File ("C:\\Users\\Usama\\Desktop\\dumpedData.txt") ));
              
            Document document;
            
            document = Jsoup.connect(link).get();
            
            ArrayList<String> dataInsideCircularAL = new ArrayList<String>();
             ArrayList<String> readCircularAL = new ArrayList<String>();
             
            //<font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#000000">
           // Elements circularData = document.select("td[height=26]"); 
           
            Elements circularData = document.select("td[height=26]"); 
            Elements circularDescriptionLink = document.select("tr[bgcolor=#f8f8f8] a");
            
            System.out.println("Circular data  size = " + circularData.size());

            System.out.println("\n\n Circular Data \n\n");
            for(int i=0;i<circularData.size();i++){
                System.out.println(circularData.get(i).text());
                 bf.write(circularData.get(i).text()+ "\n"); 
         
            }
            
           System.out.println("Circular Description Link = " + circularDescriptionLink.size());
           System.out.println("\n\n links \n\n");
           
            for (int i=0;i<circularDescriptionLink.size();i++){
           System.out.println(circularDescriptionLink.get(i).attr("abs:href"));
           }
            
        }
    catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
