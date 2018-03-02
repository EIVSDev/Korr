package com.dev.slava.korr;
import android.os.AsyncTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
/**
 * Created by Slava on 25.10.2017.
 */
public class ParseKorr extends AsyncTask<String, Void, String> { //1 парам.-ссылка до кот-1 нужн достучатьсч
                                                                 //3 парам.-сама строчка с статьей
    @Override
    protected String doInBackground(String... strings) {

        String str = " ";

        try {
            Document document = Jsoup.connect(strings[0]).get();
            Element element = document.select(".col__big").first();//класс всего текста внутри ссылки
            str = element.text();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
