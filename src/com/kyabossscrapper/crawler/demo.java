/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyabossscrapper.crawler;

import static com.kyabossscrapper.utility.FetchPageWithProxy.fetchPage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Nitesh Shah
 */
public class demo {
    
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

//        String url = "http://www.kyaboss.com/15-funny-photos-showing-superheroes-in-daily-life";
//        org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));
//        Element e = doc.select("div[class=thecontent] div p a img").first();
//        System.out.println("---"+e.attr("src"));
//        
//        Element ee = doc.select("div[class=single_post] header h1").first();
//        System.out.println("---"+ee.text());
        String url = "http://www.kyaboss.com/";
        org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));        
        Elements e = doc.select("div[id=sticky] nav ul li a");
        for (Element e1 : e) {
            System.out.println("Href : " + e1.attr("href"));
        }
    }
    
}
//             Elements e = doc.select("div[id=jsHubbSocialWall] div div a img");//.first();
//            for (Element e1 : e) {
//                System.out.println("Href ::::: " + e1.attr("src"));
//            }
//            System.out.println("" + json);
//            String response1 = "";
//            FileReader fileReader = new FileReader("D:\\AuditMySite Project\\AuditeMySite\\KyaBossScrapper\\string.txt");
//            BufferedReader br = new BufferedReader(fileReader);
//            String line;
//            while ((line = br.readLine()) != null) {
//                response1 = response1 + line;
//            }
//            JSONObject json = new JSONObject(response1);