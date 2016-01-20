/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyabossscrapper.crawler;

import com.kyabossscrapper.dao.KyaBossDaoImpl;
import com.kyabossscrapper.entity.CategoriesCrawledData;
import com.kyabossscrapper.thread.BeAManThread;
import com.kyabossscrapper.thread.BoredAtWorkThread;
import com.kyabossscrapper.thread.HollywoodPlusThread;
import com.kyabossscrapper.thread.HomeThread;
import com.kyabossscrapper.thread.PrettyWomanThread;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Nitesh Shah
 */
public class KyaBossScrapper {

    CategoriesCrawledData objCategoriesCrawledData;

    ApplicationContext context
            = new ClassPathXmlApplicationContext("Beans.xml");
    // TODO code application logic here

    KyaBossDaoImpl objKyaBossDaoImpl
            = (KyaBossDaoImpl) context.getBean("KyaBossDaoImpl");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // TODO code application logic here

//        objKyaBossScrapper.CrawlingUrls();
//        objKyaBossScrapper.categoryHollywoodPlus();
//        objKyaBossScrapper.categoryPrettyWoman();
//        objKyaBossScrapper.categoryBoredAtWork();
//        objKyaBossScrapper.categoryBeAMan();
        KyaBossScrapper objKyaBossScrapper = new KyaBossScrapper();
        objKyaBossScrapper.callAllThreads();

    }

    public void callAllThreads() {

        HomeThread objHomeThread = new HomeThread(objKyaBossDaoImpl);
        Thread obj = new Thread(objHomeThread);
        obj.start();

        HollywoodPlusThread objHollywoodPlusThread = new HollywoodPlusThread(objKyaBossDaoImpl);
        Thread objHollywood = new Thread(objHollywoodPlusThread);
        objHollywood.start();

        PrettyWomanThread objPrettyWomanThread = new PrettyWomanThread(objKyaBossDaoImpl);
        Thread objPretty = new Thread(objPrettyWomanThread);
        objPretty.start();

        BeAManThread objBeAManThread = new BeAManThread(objKyaBossDaoImpl);
        Thread objMan = new Thread(objBeAManThread);
        objMan.start();

        BoredAtWorkThread objBoredAtWorkThread = new BoredAtWorkThread(objKyaBossDaoImpl);
        Thread objBored = new Thread(objBoredAtWorkThread);
        objBored.start();

    }
}
