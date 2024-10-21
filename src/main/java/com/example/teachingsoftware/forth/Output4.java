package com.example.teachingsoftware.forth;

import java.io.*;

public class Output4 extends Filter {
//    private File file;
//    public Output(File file,Pipe input) {
//        super(input, null);
//        this.file = file;
//    }
    private Writer writer;

    public Output4(Pipe input, Writer writer) {
        super(input, null);
        this.writer = writer;
    }

//    @Override
//    public void transform() throws IOException {
//        BufferedWriter outputFile =null;
//        String line;
//        try {
//            outputFile = new BufferedWriter(new FileWriter(file));
//            while (input.hashNextLine()) {
//                outputFile.write(input.readerLine()+"\n");
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
//        input.closeReader();
//    }
@Override
public void transform() throws IOException {
    String line;
    try {
        while (input.hashNextLine()) {
            writer.write(input.readerLine() + "\n");
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
    input.closeReader();
}

}

