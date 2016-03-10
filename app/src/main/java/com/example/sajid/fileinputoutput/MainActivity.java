package com.example.sajid.fileinputoutput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView outputTV;
    EditText inputET;
    Button btnSave;
    Button btnRetreive;

    public static final String FILE_NAME="file";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputTV=(TextView)findViewById(R.id.textView);
        inputET=(EditText)findViewById(R.id.editText);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnRetreive=(Button)findViewById(R.id.btnRetrieve);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToBeSave=inputET.getText().toString();
                writeFIle(textToBeSave);
            }
        });

        btnRetreive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputText=readFile();
                outputTV.setText(outputText);
            }
        });

    }

    public void writeFIle(String text){
        try {
            OutputStreamWriter writer=new OutputStreamWriter(openFileOutput(FILE_NAME,MODE_PRIVATE));
            writer.write(text);
            writer.close();
        }
        catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public String readFile(){
        String output="";
        try {
            InputStream inputStream = openFileInput(FILE_NAME);
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String receivedInput = "";
                StringBuilder builder = new StringBuilder();
                while ((receivedInput = bufferedReader.readLine()) != null) {
                        builder.append(receivedInput);
                }
                inputStream.close();
                output=builder.toString();
            }
        }catch (FileNotFoundException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }catch(IOException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }


        return output;

    }
}
