package com.example.kaurhw5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity
{
    private EditText InputET;
    private TextView NumElementsTV;
    private BinaryTree BT;
    private ViewGroup OutputViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Core.context = this;

        this.InputET = (EditText)this.findViewById(R.id.InputET);
        this.NumElementsTV = (TextView)this.findViewById(R.id.NumElementsTV);
        this.OutputViewGroup = (ViewGroup)this.findViewById(R.id.OutputViewGroup);

        //create binaryTree
        this.BT = new BinaryTree();

        this.UpdateTreeCount();
    }

    public void InOrderButtonPressed(View v)
    {
        this.BT.traverseInOrder(this.OutputViewGroup);
    }
    public void PreOrderButtonPressed(View v)
    {
        this.BT.traversePreOrder(this.OutputViewGroup);
    }
    public void PostOrderButtonPressed(View v)
    {
        this.BT.traversePostOrder(this.OutputViewGroup);
    }

    private void UpdateTreeCount()
    {
        this.NumElementsTV.setText("" + this.BT.getCount());
    }

    private void AddToTree(String value)
    {
        int payload = Integer.parseInt(value);
        this.BT.add(payload);
        this.UpdateTreeCount();
    }

    String trimString2(String s)
    {
        return s.trim();
    }

    String trimString(String s)
    {
        String answer = "";

        //burn past leading spaces;
        int pos = 0;
        while(pos < s.length())
        {
            if(s.charAt(pos) != ' ')
            {
                break;
            }
            pos++;
        }

        int pos2 = s.length()-1;

        while(pos2 >= 0)
        {
            if(s.charAt(pos2) != ' ')
            {
                break;
            }
            pos2--;
        }

        //we know that our real value lives between pos and pos2
        for(int i = pos; i <= pos2; i++)
        {
            answer = answer + s.charAt(i);
        }
        return answer;
    }

    public void AddToTreeButtonPressed(View v)
    {
        if(this.InputET.getText().length() > 0)
        {
            String value = this.InputET.getText().toString();
            if(value.indexOf(",") == -1)
            {
                //flat number
                this.AddToTree(value);
            }
            else
            {
                //we have a comma delimited list, so parse it and add each value.
                //"10, 9, 13, 6, 6, 8,7"

                StringTokenizer st = new StringTokenizer(value, ",");
                while(st.hasMoreTokens())
                {
                    this.AddToTree(st.nextToken().trim());
                }
            }
        }
    }
}