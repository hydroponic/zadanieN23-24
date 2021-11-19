package com.company;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;
import java.util.Set;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class HTML {
    ArrayList<String> urls = new ArrayList<>();
    final String sn="https://www.mirea.ru";
    public Elements code() {
        try {

            Document doc = Jsoup.connect(sn).userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            return doc.select("HTML");
        }
        catch (Exception e) {System.out.println("#error");}
        return null;
    }
    public void imgsrc() {
        try {
            Document doc = Jsoup.connect(sn).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get();
            for (Element el : doc.select("img")) {
                if (el.attr("abs:src") != "")
                {String str=el.attr("abs:src");this.urls.add(str);}

            }
        }
        catch (Exception e) {System.out.println("#error");}
        Set<String> set = new HashSet<>(urls);
        urls.clear();urls.addAll(set);
    }
    public String getName(String path) {
        String name="";
        int i = path.length()-1;
        int k=1;
        while (path.charAt(i) !='/')
        {
            if (path.charAt(i)=='.') k=0;
            name+=path.charAt(i);
            i--;
        }
        return new StringBuilder(name).reverse().toString();
    }
    public void download(){
        String url="";String fileName="";
        FileOutputStream fout =null;
        BufferedInputStream in = null;
            for (int i=0;i<=urls.size()-1;i++)
            {
                url=urls.get(i);fileName=getName(urls.get(i));
                System.out.print("\n"+urls.get(i));

                try {
                    in=new BufferedInputStream(new URL(url).openStream());
                    fout = new FileOutputStream(fileName);
                    byte data[]= new byte[6000];
                    int count;
                    while((count=in.read(data,0,6000))!=-1) {
                        fout.write(data,0,count);fout.flush();
                    }
                }
                catch(MalformedURLException e) {e.printStackTrace();}
                catch(IOException e) {e.printStackTrace();}
                finally {
                    try {in.close();} catch (IOException e) {e.printStackTrace();}
                    finally {
                        try {fout.close();} catch (IOException e) {e.printStackTrace();}
                    }
                }
            }
    }
    public void showDownloads() {
    for (int i=0;i<urls.size();i++)
        System.out.print("\n"+getName(urls.get(i)));
    }
}
