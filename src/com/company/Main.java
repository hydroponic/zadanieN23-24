package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.lang.Exception;

public class Main {
    public static void main(String[] args) {
            final String filename = "movementList.csv";
            new CSVParse().test(filename);
            HTML html=new HTML();
            System.out.println("\n-----------------\nКод страницы:\n-----------------\n"+html.code()+"\n\n\n\n-----------------\nСсылки на изображения:\n-----------------\n");
            html.imgsrc();html.download();System.out.println("\n-----------------\nЗагруженные файлы:\n-----------------");
            html.showDownloads();
    }
}
