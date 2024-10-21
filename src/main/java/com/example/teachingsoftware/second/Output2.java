package com.example.teachingsoftware.second;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
public class Output2 {
    private ArrayList<String> kwicList;
//    private BufferedWriter outputFile;

    public Output2(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

//    public void output(String filename){
//        Iterator<String> it = kwicList.iterator();
//        try {
//            outputFile = new BufferedWriter(new FileWriter(filename));
//            while (it.hasNext()) {
//                outputFile.write(it.next()+"\n");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (outputFile!=null) {
//                    outputFile.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
public void output(Writer writer) {
    Iterator<String> it = kwicList.iterator();
    try {
        while (it.hasNext()) {
            writer.write(it.next() + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}

