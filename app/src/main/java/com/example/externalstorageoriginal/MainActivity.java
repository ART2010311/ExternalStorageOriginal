package com.example.externalstorageoriginal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import static android.os.Environment.getExternalStorageDirectory;




public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button btn;

    private static final String FILE_NAME="demo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText=findViewById(R.id.editTextText);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(view ->{
            createfiletoExternalprivate();
            mEditText.setText("");
        });
    }
    private void createfiletoExternalprivate()
    {
        File file=new File(getExternalStorageDirectory(),FILE_NAME);
        save(file);
    }
    public void save(File file){
        String text=mEditText.getText().toString();
        FileOutputStream fileOutputStream=null;
        try{
            fileOutputStream= new FileOutputStream(file);
            fileOutputStream.write(text.getBytes());
            mEditText.getText().clear();
            Toast.makeText(MainActivity.this,"Saved file:"+file.getName()+"path:"+file.getPath(),Toast.LENGTH_LONG).show();
        }
        catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fileOutputStream !=null){
                try{
                    fileOutputStream.close();

                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}