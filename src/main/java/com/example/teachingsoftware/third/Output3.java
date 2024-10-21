package com.example.teachingsoftware.third;


import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

public class Output3 implements Observer {
    private ArrayList<String> kwicList;
//    private BufferedWriter outputFile;
//    private String filename;
//    public Output(ArrayList<String> kwicList,String filename) {
//        this.kwicList = kwicList;
//        this.filename = filename;
//    }
    private Writer writer;

    public Output3(ArrayList<String> kwicList, Writer writer) {
        this.kwicList = kwicList;
        this.writer = writer;
    }

//    @Override
//    public void toDo(){
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
@Override
public void toDo() {
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

    public Writer getWriter() {
        return writer;
    }

}


