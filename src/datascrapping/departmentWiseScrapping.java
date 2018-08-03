/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datascrapping;


import static datascrapping.testProgram.NBSP_IN_UTF8;
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
    
    public static final String NBSP_IN_UTF8 = "\u00a0"; 

    testProgram tp = new testProgram();
    
    public void scrapDepartment(String link) {
         try{
             
            BufferedWriter bf = new BufferedWriter (new FileWriter(new File ("C:\\Users\\Usama\\Desktop\\dumpedData.txt") ));
              
            Document document;
            
            document = Jsoup.connect(link).get();
            
            ArrayList<String> dataInsideCircularAL = new ArrayList<String>();
            ArrayList<String> readCircularAL = new ArrayList<String>();
            ArrayList<String> pdfLinks = new ArrayList<String>();
            
           //<font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#000000">
           // Elements circularData = document.select("td[height=26]"); 
           
            Elements circularData = document.select("tr[bgcolor=#f8f8f8]");     // To get circular Data inside years
            Elements circularDescriptionLink = document.select("tr[bgcolor=#f8f8f8] a");    // To get links attached to each circular data
            
       //     System.out.println("Circular data  size = " + circularData.size());

        //    System.out.println("Circular Data \n\n");
            
            for(int i=0;i<circularData.size();i++){
            
            if ( !circularData.get(i).hasText() || circularData.get(i).text().replaceAll(NBSP_IN_UTF8, "").trim().equals("") )
                {   
                 circularData.get(i).remove();  //// this if statements deletes empty rows while scrapping
                 continue;  // to skip the useless itteration
                }
                dataInsideCircularAL.add(circularData.get(i).text()) ;   // Adds  the circular data to arraylist
            }
            
        //    System.out.println("Size of arraylist = " + circularData.size());
            
            
           for (int t=0;t<dataInsideCircularAL.size();++t) { 
             
           System.out.println("==> "+dataInsideCircularAL.get(t));
//           System.out.println("\n Circular Description Link Size = " + circularDescriptionLink.size());
//           System.out.println("links \n\n");
//           
          //  for (int i=0;i<circularDescriptionLink.size();i++){
          
           System.out.println("-> "+circularDescriptionLink.get(t).attr("abs:href"));
           
 // ==============  Now scrappiing data inside each circular ================================          
         
                document = Jsoup.connect(circularDescriptionLink.get(t).attr("abs:href")).get();
            
                
           //   Elements circularText = document.select("td[colspan=2]"); 
                Elements circularText = document.select("blockquote");
               //Elements circularText = document.select("td[bgcolor=#f8f8f8]");
                Elements documentsLink = document.select("[href*=pdf]");
           
         //   System.out.println("blockquote size = " + circularText.size());

           // System.out.println("Circular Data \n\n");
           // for(int j=0;j<circularText.size();j++){
           try {
                System.out.println("==> "+circularText.get(0).text());
           } catch(Exception e) {
               System.out.println("Error agaya bhai");
                circularText = document.select("td[bgcolor=#f8f8f8]");
               System.out.println("==> "+circularText.get(0).text());
           }
                //  }
            
        //   System.out.println("PDF Documents Link inside circular Size = " + documentsLink.size());
       //    System.out.println("links \n\n");
//           
           for (int k=0;k<documentsLink.size();k++){
               
          System.out.println("O "+ documentsLink.get(k).attr("abs:href"));
          }
            System.out.println("\n===========================================================================\n");
          
            }    // t loop ends here 
            
        }   // Main TRY block ends here 
         
    catch(Exception e) {
            e.printStackTrace();
            
        } // Main Catch block ends here 
         
    }   // function ends here 
    
    
   //==============================================================================================================================
    
    
    
    
  
    
    public void scrapDepartment4(String link) {
         try{
             
            BufferedWriter bf = new BufferedWriter (new FileWriter(new File ("C:\\Users\\Usama\\Desktop\\dumpedData.txt") ));
              
            Document document;
            
            document = Jsoup.connect(link).get();
            
            ArrayList<String> dataInsideCircularAL = new ArrayList<String>();
            ArrayList<String> readCircularAL = new ArrayList<String>();
            ArrayList<String> pdfLinks = new ArrayList<String>();
            
           //<font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#000000">
           // Elements circularData = document.select("td[height=26]"); 
           
            Elements circularData = document.select("tr td[height=26]");     // To get circular Data inside years
            Elements circularDescriptionLink = document.select("tr td[height=26] a");    // To get links attached to each circular data
            
            System.out.println("Circular data  size = " + circularData.size());

        //    System.out.println("Circular Data \n\n");
            
            for(int i=0;i<circularData.size();i++){
            if ( !circularData.get(i).hasText() || circularData.get(i).text().replaceAll(NBSP_IN_UTF8, "").trim().equals("") )
                {   
                 circularData.get(i).remove();  //// this if statements deletes empty rows while scrapping
                 continue;  // to skip the useless itteration
                }
                dataInsideCircularAL.add(circularData.get(i).text()) ;   // Adds  the circular data to arraylist
            }
        //    System.out.println("Size of arraylist = " + circularData.size());
            
           for (int t=0;t<dataInsideCircularAL.size();++t) { 
            System.out.println("==> "+dataInsideCircularAL.get(t));
             
//           System.out.println("\n Circular Description Link Size = " + circularDescriptionLink.size());
//           System.out.println("links \n\n");
//           
          //  for (int i=0;i<circularDescriptionLink.size();i++){
          
           System.out.println("-> "+circularDescriptionLink.get(t).attr("abs:href"));
           
 // ==============  Now scrappiing data inside each circular ================================          
         
                document = Jsoup.connect(circularDescriptionLink.get(t).attr("abs:href")).ignoreContentType(true).get();
            
                
             // Elements circularText = document.select("td[colspan=2]"); 
                Elements circularText = document.select("blockquote");
             // Elements circularText = document.select("td[bgcolor=#f8f8f8]");
                Elements documentsLink = document.select("[href*=pdf]");
           
            System.out.println("blockquote size = " + circularText.size());

           // System.out.println("Circular Data \n\n");
           // for(int j=0;j<circularText.size();j++){
           try {
                System.out.println("==> "+circularText.get(0).text());
           } catch(Exception e) {
               System.out.println("Error agaya bhai");
                     circularText = document.select("td[colspan=2]"); 
                    System.out.println("==> "+circularText.get(0).text());
           }
                //  }
            
        //   System.out.println("PDF Documents Link inside circular Size = " + documentsLink.size());
       //    System.out.println("links \n\n");
//           
           for (int k=0;k<documentsLink.size();k++){
               
          System.out.println("O "+ documentsLink.get(k).attr("abs:href"));
          }
            System.out.println("\n===========================================================================\n");
          
            }
            
        }
    catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
} // class end 
