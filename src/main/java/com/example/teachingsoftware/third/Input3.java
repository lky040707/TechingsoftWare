package com.example.teachingsoftware.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Input3 implements Observer{

    private ArrayList<String> lineTxt = new ArrayList<String>();
    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }
//    private String fileName;
//    public Input(String fileName) {
//        this.fileName = fileName;
//    }
    private Reader reader;

    public Input3(Reader reader) {
        this.reader = reader;
    }
//    @Override
//    public void toDo() {
//        BufferedReader inputFile = null;
//        try {
//            inputFile = new BufferedReader(new FileReader(fileName));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String line;
//        try {
//            while ((line = inputFile.readLine()) != null) {
//                lineTxt.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public void toDo() {
        BufferedReader inputFile = new BufferedReader(reader);
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

