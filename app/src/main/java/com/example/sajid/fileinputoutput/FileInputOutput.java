package com.example.sajid.fileinputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by sajid on 3/11/16.
 */
public class FileInputOutput {
    public static final String FILE_NAME="test.txt";
    public FileInputOutput() {
    }

    public String createDirectory(){
        File aFile=new File("/sdcard/"+FILE_NAME);
        try {
            aFile.createNewFile();
            return aFile.toString();
        } catch (IOException e) {
            //e.printStackTrace();
            return "3";
        }
    }

    public boolean writeOnFile(String text,String dir){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(""+dir);
            OutputStreamWriter writer=new OutputStreamWriter(fileOutputStream);
            writer.write(text);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
    public String ReadFromFile(String dir){
        String output="";
        try {
            FileInputStream fileInputStream=new FileInputStream(new File(""+dir));
            if(fileInputStream!=null) {
                InputStreamReader reader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String receivedChar = "";
                StringBuilder builder = new StringBuilder();
                while ((receivedChar = bufferedReader.readLine()) != null) {
                    builder.append(receivedChar);
                }
                fileInputStream.close();
                output = builder.toString();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

      return output;

    }
}
