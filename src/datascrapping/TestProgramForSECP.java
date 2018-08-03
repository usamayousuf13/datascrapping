/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datascrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Usama
 */
public class TestProgramForSECP {
    
    public void getLaws(String link) {
        try{
            Document document;
            
            document = Jsoup.connect(link).timeout(10000).validateTLSCertificates(false).get();
            
            Elements departmentName = document.select("*"); 
           // Elements departmentLink = document.select("td[height=25][bgcolor=#F8F8F8] > a");
            System.out.println("department size = " + departmentName.size());

            System.out.println("\n\n department names \n\n");
            for(int i=0;i<departmentName.size();i++){         
                System.out.println(departmentName.get(i).text());
            }
            
//            System.out.println("department link size = " + departmentLink.size());
//            System.out.println("\n\n links \n\n");
//            
//            for (int i=0;i<departmentLink.size();i++){
//                System.out.println(departmentLink.get(i).attr("abs:href"));
//            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
       
    
    
    
    
}
