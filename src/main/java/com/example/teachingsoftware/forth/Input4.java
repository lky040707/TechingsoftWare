package com.example.teachingsoftware.forth;

import java.io.*;

public class Input4 extends Filter {
//    private File file;
//    public Input(File file,Pipe output) {
//        super(null, output);
//        this.file = file;
//    }

    private Reader reader;

    public Input4(Reader reader, Pipe output) {
        super(null, output);
        this.reader = reader;
    }
//    @Override
//    public void transform() throws IOException {
//        BufferedReader inputFile = null;
//        try {
//            inputFile = new BufferedReader(new FileReader(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String line;
//        try {
//            while ((line = inputFile.readLine()) != null) {
//                output.writerLine(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        output.closeWriter();
//    }
@Override
public void transform() throws IOException {
    BufferedReader inputFile = new BufferedReader(reader);
    String line;
    try {
        while ((line = inputFile.readLine()) != null) {
            output.writerLine(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    output.closeWriter();
}

}
