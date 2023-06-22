package com.example.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn[] = new Button[9];
    TextView txt,txt1;
    ArrayList list = new ArrayList();
    int cnt=0,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<btn.length;i++)
        {
            int id = getResources().getIdentifier("btn"+i,"id",getPackageName());
            btn[i] = findViewById(id);
            btn[i].setOnClickListener(this);
            System.out.println("btn id = "+i);
        }
    }

    @Override
    public void onClick(View view) {
        for(int i=0;i<btn.length;i++)
        {
            if(view.getId()==btn[i].getId())
            {
                btn[i].setText("X");
                list.add(i);
                btn[i].setEnabled(false);
                System.out.println("list = "+list);
                cnt++;

                while(cnt<5)
                {
                    r = (int) (Math.random() * 9);
                    if(list.contains(r) == false)
                    {
                        btn[r].setText("O");
                        list.add(r);
                        btn[r].setEnabled(false);
                        System.out.println("Random = "+r);
                        break;
                    }
                }
            }
        }
        System.out.println("List = "+list);
    }

    void Win()
    {
        if(btn[0].getText()=="X" && btn[1].getText()=="X" && btn[2].getText()=="X"||
           btn[0].getText()=="X" && btn[3].getText()=="X" && btn[6].getText()=="X"||
           btn[0].getText()=="X" && btn[8].getText()=="X" && btn[8].getText()=="X"||
           btn[1].getText()=="X" && btn[4].getText()=="X" && btn[7].getText()=="X"||
           btn[2].getText()=="X" && btn[5].getText()=="X" && btn[8].getText()=="X"||
           btn[2].getText()=="X" && btn[4].getText()=="X" && btn[6].getText()=="X"||
           btn[3].getText()=="X" && btn[4].getText()=="X" && btn[5].getText()=="X"||
           btn[6].getText()=="X" && btn[7].getText()=="X" && btn[8].getText()=="X")
        {
            txt1.setText("X IS Win THE MATCH");
        }
        else if(btn[0].getText()=="O" && btn[1].getText()=="O" && btn[2].getText()=="O"||
                btn[0].getText()=="O" && btn[3].getText()=="O" && btn[6].getText()=="O"||
                btn[0].getText()=="O" && btn[8].getText()=="O" && btn[8].getText()=="O"||
                btn[1].getText()=="O" && btn[4].getText()=="O" && btn[7].getText()=="O"||
                btn[2].getText()=="O" && btn[5].getText()=="O" && btn[8].getText()=="O"||
                btn[2].getText()=="O" && btn[4].getText()=="O" && btn[6].getText()=="O"||
                btn[3].getText()=="O" && btn[4].getText()=="O" && btn[5].getText()=="O"||
                btn[6].getText()=="O" && btn[7].getText()=="O" && btn[8].getText()=="O")
        {
            txt1.setText("O IS Win THE MATCH");
        }
    }
}