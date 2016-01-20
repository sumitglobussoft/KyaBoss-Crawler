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

/**
 *
 * @author GLB-214
 */
public class demo {
    
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        
        String url = "http://www.kyaboss.com/15-funny-photos-showing-superheroes-in-daily-life";
        org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));
        Element e = doc.select("div[class=thecontent] div p a img").first();
        System.out.println("---"+e.attr("src"));
        
        Element ee = doc.select("div[class=single_post] header h1").first();
        System.out.println("---"+ee.text());
    }
    
}
