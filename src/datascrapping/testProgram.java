/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datascrapping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author Usama
 */
public class testProgram {
    
    public void getCirculars(String link) {
        try{
            Document document;
            
            document = Jsoup.connect(link).get();
            
            Elements departmentName = document.select("td[height=25][bgcolor=#F8F8F8]"); 
            Elements departmentLink = document.select("td[height=25][bgcolor=#F8F8F8] > a");
            System.out.println("department size = " + departmentName.size());

            System.out.println("\n\n department names \n\n");
            for(int i=0;i<departmentName.size();i++){         
                System.out.println(departmentName.get(i).text());
            }
            
            System.out.println("department link size = " + departmentLink.size());
            System.out.println("\n\n links \n\n");
            
            for (int i=0;i<departmentLink.size();i++){
                System.out.println(departmentLink.get(i).attr("abs:href"));
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
       
    
    
     public void getYears(String link) {
        try{
           
            Document document;
            
            document = Jsoup.connect(link).get();
            
            Elements years = document.select("li"); 
            Elements yearsLink = document.select("font[color=#000000][size=2] a");
            
            System.out.println("years size = " + years.size());

            System.out.println("\n\n years listed \n\n");
            for(int i=0;i<years.size();i++){
                System.out.println(years.get(i).text());
                
            }
           
            System.out.println("years link size = " + yearsLink.size());
            System.out.println("\n\n links \n\n");
            
            for (int i=0;i<yearsLink.size();i++){
            System.out.println(yearsLink.get(i).attr("abs:href"));
            
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
       
     
     
//     public void getDataInsideCircular(String link) {
//        try{
//            Document document;
//            
//            document = Jsoup.connect(link).get();
//            
//            Elements circularData = document.select("tr[bgcolor=#f8f8f8]"); 
//            Elements circularDescriptionLink = document.select("tr[bgcolor=#f8f8f8] a");
//            
//            System.out.println("Circular data  size = " + circularData.size());
//
//            System.out.println("\n\n Circular Data \n\n");
//            for(int i=0;i<circularData.size();i++){
//                System.out.println(circularData.get(i).text());
//            }
//            
//           System.out.println("Circular Description Link = " + circularDescriptionLink.size());
//           System.out.println("\n\n links \n\n");
//           
//            for (int i=0;i<circularDescriptionLink.size();i++){
//           System.out.println(circularDescriptionLink.get(i).attr("abs:href"));
//           }
//            
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
       
// =========================================================================================

 public void getDataInsideCircular(String link) {
        try{
            Document document;
            
            document = Jsoup.connect(link).get();
            
            Elements circularData = document.select("td[height=26]"); 
            Elements circularDescriptionLink = document.select("tr[bgcolor=#f8f8f8] a");
            
            System.out.println("Circular data  size = " + circularData.size());

            System.out.println("\n\n Circular Data \n\n");
            for(int i=0;i<circularData.size();i++){
                System.out.println(circularData.get(i).text());
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
// =========================================================================================     
     
     
      public void readCircular(String link) {
        try{
            Document document;
            
            document = Jsoup.connect(link).get();
            
            Elements circularText = document.select("blockquote"); 
            //Elements circularDescriptionLink = document.select("tr[bgcolor=#f8f8f8] a");
            
            System.out.println("blockquote size = " + circularText.size());

            System.out.println("\n\n Circular Data \n\n");
            for(int i=0;i<circularText.size();i++){
                System.out.println(circularText.get(i).text());
            }
            
//           System.out.println("Circular Description Link = " + circularDescriptionLink.size());
//           System.out.println("\n\n links \n\n");
//           
//            for (int i=0;i<circularDescriptionLink.size();i++){
//           System.out.println(circularDescriptionLink.get(i).attr("abs:href"));
//           }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
       
      
      
      //==================================================================================================
      
      
      
       public void bestFood(String link) {
        try{
            Document document;
            
            document = Jsoup.connect(link).get();
            
            Elements circularText = document.select("table tbody tr td b"); 
            //Elements circularDescriptionLink = document.select("tr[bgcolor=#f8f8f8] a");
            
            System.out.println("blockquote size = " + circularText.size());

            System.out.println("\n\n Circular Data \n\n");
            for(int i=0;i<circularText.size();i++){
                System.out.println(circularText.get(i).text());
            }
            
//           System.out.println("Circular Description Link = " + circularDescriptionLink.size());
//           System.out.println("\n\n links \n\n");
//           
//            for (int i=0;i<circularDescriptionLink.size();i++){
//           System.out.println(circularDescriptionLink.get(i).attr("abs:href"));
//           }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
       
       
       //=====================================================================================
      
      public void scrapAllData() {
          
      }
       
       
       
       
       
      
     
    //===========================================================================================
       
       
       
       
       
    public void scrapData () {
    try {
        Document document;
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect("http://www.sbp.org.pk/acd/index.htm").get();

                        //Elements department = document.select("tr:contains(department)"); //Get price
                        
                        Elements department = document.select("ul"); //Get price
                        
                          Elements link = document.select("ul a");
                       System.out.println("links -> tr a[hef] \n\n");
                        for (int i=0;i<link.size();i++){
                           
                           print(link.get(i).attr("abs:href"));
                            
                           }
                        System.out.println("\n\n links end here \n\n");
                        
                        System.out.println("departments name -> tr:contains(depatment) \n\n");

                        for (int i=0; i < department.size(); i++) {
                        print(department.get(i).text());
                        }
                        
                        System.out.println("\n\n departments end \n\n");

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
	}

	public static void print(String string) {
		System.out.println(string);
	}
}
