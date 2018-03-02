package com.dev.slava.korr;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Slava on 25.10.2017.
 */

public class ParseTitle extends AsyncTask<Void,Void,HashMap<String,String>> {
    @Override
    protected HashMap<String, String> doInBackground(Void... voids) {

         HashMap<String,String>hashMap=new HashMap<>();

        try {
            Document doc = Jsoup.connect("http://korrespondent.net/").get();
            Elements elements = doc.select(".article");

            for(Element element : elements){
                                                                                  //.first перв. ссылка кот-ю найдет jsoup
                Element element1 = element.select("a[href]").first();//a[href]-ссылка, т.к. таких ссылок может быть много необх first
/////////////////////////////////////////////////////////////////////////////////////////////
                hashMap.put(element.text(),element1.attr("abs:href"));//где key название статей, а velues уже сама ссылка
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
