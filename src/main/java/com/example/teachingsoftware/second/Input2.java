package com.example.teachingsoftware.second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
public class Input2 {
    private ArrayList<String> lineTxt = new ArrayList<String>();

    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }

//    public void input(String fileName) {
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


    public void input(Reader reader) {
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

