/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyabossscrapper.crawler;

import static com.kyabossscrapper.utility.FetchPageWithProxy.fetchPage;
import com.kyabossscrapper.utility.FetchSource;
import java.io.BufferedReader;
import java.io.FileReader;
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
public class KyaBossScrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // TODO code application logic here
        KyaBossScrapper objKyaBossScrapper = new KyaBossScrapper();
//        objKyaBossScrapper.CrawlingUrls();
//        objKyaBossScrapper.categoryHollywoodPlus();
//        objKyaBossScrapper.categoryPrettyWoman();
//        objKyaBossScrapper.categoryBoredAtWork();
        objKyaBossScrapper.categoryBeAMan();

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

                String response = obj.fetchPageSourceWithProxyPOST("http://www.kyaboss.com/wp-admin/admin-ajax.php", urlParameter, "http://www.kyaboss.com/", "www.kyaboss.com", "52.88.215.36", "8083", "", "");

                JSONObject json = new JSONObject(response);

                JSONArray objJSONArray = json.getJSONArray("items");

                System.out.println("" + objJSONArray.length());

                for (int j = 0; j < objJSONArray.length(); j++) {

                    String imageurl = objJSONArray.getJSONObject(j).getString("content");

                    org.jsoup.nodes.Document doc1 = Jsoup.parse(imageurl);

                    Elements ee = doc1.select("div[class^=wall__item post  loaded] a");//.first();

                    for (Element e1 : ee) {

                        try {

                            System.out.println(j + " Href Url : " + e1.attr("href"));

                            String urls = e1.attr("href");

                            org.jsoup.nodes.Document doc2 = Jsoup.parse(fetchPage(new URI(urls)));

                            Element e = doc2.select("div[class=thecontent] div p a img").first();

                            System.out.println(j + "Image Url : " + e.attr("src"));

                            Element eee = doc2.select("div[class=single_post] header h1").first();

                            System.out.println(j + "Tags : " + eee.text());

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

    public void categoryHollywoodPlus() {

        try {

            String url = "http://www.kyaboss.com/category/hollywood-plus";

            org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));

            FetchSource obj = new FetchSource();

            Boolean check = true;

            int i = 1;

            do {

                String urlParameter = "action=hubbwall_js&wall=662&category=3&method=loadContent&wallscroll=" + i;

                String response = obj.fetchPageSourceWithProxyPOST("http://www.kyaboss.com/wp-admin/admin-ajax.php", urlParameter, "http://www.kyaboss.com/category/hollywood-plus", "www.kyaboss.com", "52.88.215.36", "8083", "", "");

                JSONObject json = new JSONObject(response);

                JSONArray objJSONArray = json.getJSONArray("items");

                System.out.println("" + objJSONArray.length());

                for (int j = 0; j < objJSONArray.length(); j++) {

                    String imageurl = objJSONArray.getJSONObject(j).getString("content");

                    org.jsoup.nodes.Document doc1 = Jsoup.parse(imageurl);

                    Elements ee = doc1.select("div[class^=wall__item post  loaded] a");//.first();

                    for (Element e1 : ee) {

                        try {

                            System.out.println(j + " Href Url : " + e1.attr("href"));

                            String urls = e1.attr("href");

                            org.jsoup.nodes.Document doc2 = Jsoup.parse(fetchPage(new URI(urls)));

                            Element e = doc2.select("div[class=thecontent] div p a img").first();

                            System.out.println(j + "Image Url : " + e.attr("src"));

                            Element eee = doc2.select("div[class=single_post] header h1").first();

                            System.out.println(j + "Tags : " + eee.text());

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

    public void categoryPrettyWoman() {

        try {

            String url = "http://www.kyaboss.com/category/pretty-woman";

            org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));

            FetchSource obj = new FetchSource();

            Boolean check = true;

            int i = 1;

            do {

                String urlParameter = "action=hubbwall_js&wall=664&category=4&method=loadContent&wallscroll=" + i;

                String response = obj.fetchPageSourceWithProxyPOST("http://www.kyaboss.com/wp-admin/admin-ajax.php", urlParameter, "http://www.kyaboss.com/category/pretty-woman", "www.kyaboss.com", "52.88.215.36", "8083", "", "");

                JSONObject json = new JSONObject(response);

                JSONArray objJSONArray = json.getJSONArray("items");

                System.out.println("" + objJSONArray.length());

                for (int j = 0; j < objJSONArray.length(); j++) {

                    String imageurl = objJSONArray.getJSONObject(j).getString("content");

                    org.jsoup.nodes.Document doc1 = Jsoup.parse(imageurl);

                    Elements ee = doc1.select("div[class^=wall__item post  loaded] a");//.first();

                    for (Element e1 : ee) {

                        try {

                            System.out.println(j + " Href Url : " + e1.attr("href"));

                            String urls = e1.attr("href");

                            org.jsoup.nodes.Document doc2 = Jsoup.parse(fetchPage(new URI(urls)));

                            Element e = doc2.select("div[class=thecontent] div p a img").first();

                            System.out.println(j + "Image Url : " + e.attr("src"));

                            Element eee = doc2.select("div[class=single_post] header h1").first();

                            System.out.println(j + "Tags : " + eee.text());

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

    public void categoryBoredAtWork() {

        try {

            String url = "http://www.kyaboss.com/category/bored-at-work";

            org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));

            FetchSource obj = new FetchSource();

            Boolean check = true;

            int i = 1;

            do {

                String urlParameter = "action=hubbwall_js&wall=663&category=5&method=loadContent&wallscroll=" + i;

                String response = obj.fetchPageSourceWithProxyPOST("http://www.kyaboss.com/wp-admin/admin-ajax.php", urlParameter, "http://www.kyaboss.com/category/bored-at-work", "www.kyaboss.com", "52.88.215.36", "8083", "", "");

                JSONObject json = new JSONObject(response);

                JSONArray objJSONArray = json.getJSONArray("items");

                System.out.println("" + objJSONArray.length());

                for (int j = 0; j < objJSONArray.length(); j++) {

                    String imageurl = objJSONArray.getJSONObject(j).getString("content");

                    org.jsoup.nodes.Document doc1 = Jsoup.parse(imageurl);

                    Elements ee = doc1.select("div[class^=wall__item post  loaded] a");//.first();

                    for (Element e1 : ee) {

                        try {

                            System.out.println(j + " Href Url : " + e1.attr("href"));

                            String urls = e1.attr("href");

                            org.jsoup.nodes.Document doc2 = Jsoup.parse(fetchPage(new URI(urls)));

                            Element e = doc2.select("div[class=thecontent] div p a img").first();

                            System.out.println(j + "Image Url : " + e.attr("src"));

                            Element eee = doc2.select("div[class=single_post] header h1").first();

                            System.out.println(j + "Tags : " + eee.text());

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

    public void categoryBeAMan() {

        try {

            String url = "http://www.kyaboss.com/category/be-a-man";

            org.jsoup.nodes.Document doc = Jsoup.parse(fetchPage(new URI(url)));

            FetchSource obj = new FetchSource();

            Boolean check = true;

            int i = 1;

            do {

                String urlParameter = "action=hubbwall_js&wall=666&category=6&method=loadContent&wallscroll=" + i;

                String response = obj.fetchPageSourceWithProxyPOST("http://www.kyaboss.com/wp-admin/admin-ajax.php", urlParameter, "http://www.kyaboss.com/category/be-a-man", "www.kyaboss.com", "52.88.215.36", "8083", "", "");

                JSONObject json = new JSONObject(response);

                JSONArray objJSONArray = json.getJSONArray("items");

                System.out.println("" + objJSONArray.length());

                for (int j = 0; j < objJSONArray.length(); j++) {

                    String imageurl = objJSONArray.getJSONObject(j).getString("content");

                    org.jsoup.nodes.Document doc1 = Jsoup.parse(imageurl);

                    Elements ee = doc1.select("div[class^=wall__item post  loaded] a");//.first();

                    for (Element e1 : ee) {

                        try {

                            System.out.println(j + " Href Url : " + e1.attr("href"));

                            String urls = e1.attr("href");

                            org.jsoup.nodes.Document doc2 = Jsoup.parse(fetchPage(new URI(urls)));

                            Element e = doc2.select("div[class=thecontent] div p a img").first();

                            System.out.println(j + "Image Url : " + e.attr("src"));

                            Element eee = doc2.select("div[class=single_post] header h1").first();

                            System.out.println(j + "Tags : " + eee.text());

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