/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyabossscrapper.thread;

import com.kyabossscrapper.dao.KyaBossDaoImpl;
import com.kyabossscrapper.entity.CategoriesCrawledData;
import static com.kyabossscrapper.utility.FetchPageWithProxy.fetchPage;
import com.kyabossscrapper.utility.FetchSource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author GLB-214
 */
public class HomeThread extends Thread {

    KyaBossDaoImpl objKyaBossDaoImpl = null;

    public HomeThread(KyaBossDaoImpl objKyaBossDaoImpl) {
        this.objKyaBossDaoImpl = objKyaBossDaoImpl;
    }

    @Override
    public void run() {
        try {
            
            CrawlingUrls();

        } catch (Exception e) {
        }

    }

    public void CrawlingUrls() throws URISyntaxException, IOException, InterruptedException {

        try {

            String url = "http://www.kyaboss.com/";

            org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));

            FetchSource obj = new FetchSource();

            Boolean check = true;

            int i = 0;

            do {

                String urlParameter = "action=hubbwall_js&wall=669&category=0&method=loadContent&wallscroll=" + i;

                String response = obj.fetchPageSourceWithProxyPOST("http://www.kyaboss.com/wp-admin/admin-ajax.php", urlParameter, "http://www.kyaboss.com/", "www.kyaboss.com", "192.158.228.196", "7631", "mongoose", "y7uQAZuLA");

                JSONObject json = new JSONObject(response);

                JSONArray objJSONArray = json.getJSONArray("items");

                System.out.println("" + objJSONArray.length());

                for (int j = 0; j < objJSONArray.length(); j++) {

                    String imageurl = objJSONArray.getJSONObject(j).getString("content");

                    org.jsoup.nodes.Document doc1 = Jsoup.parse(imageurl);

                    Elements ee = doc1.select("div[class^=wall__item post  loaded] a");//.first();

                    for (Element e1 : ee) {

                        try {

                            JSONObject jsonObject = new JSONObject();

                            JSONArray array = new JSONArray();

                            CategoriesCrawledData objCategoriesCrawledData = new CategoriesCrawledData();

                            System.out.println(j + " Href Url : " + e1.attr("href"));

                            String urls = e1.attr("href");

                            org.jsoup.nodes.Document doc2 = Jsoup.parse(fetchPage(new URI(urls)));

                            Element e = doc2.select("div[class=thecontent] div p a img").first();

                            System.out.println(j + "Image Url : " + e.attr("src"));

                            String imageUrl = e.attr("src");

                            Element eee = doc2.select("div[class=single_post] header h1").first();

                            System.out.println(j + "Tags : " + eee.text());

                            String description = eee.text();

                            array.put(description);

                            jsonObject.put("Desc : ", array);

                            objCategoriesCrawledData.setCategoryUrl(url);

                            objCategoriesCrawledData.setImageUrl(imageUrl);

                            objCategoriesCrawledData.setTitle(jsonObject.toString());

                            objKyaBossDaoImpl.insertCategoriesCrawledData(objCategoriesCrawledData);

                            System.out.println("----------------------------------------------------------------");

                        } catch (Exception e) {
                        }

                    }
                }

                check = json.getBoolean("success");

                i++;

            } while (check);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
