package com.example.kaurhw5;

import android.telecom.TelecomManager;
import android.view.ViewGroup;
import android.widget.TextView;

public class Node
{
    private int payload;
    private Node LeftChild;
    private Node RightChild;

    //the rules for binary tree:
    //everything to the left  is <=
    //everything to the right is >

    public Node(int payload)
    {
        this.payload = payload;
        this.LeftChild = null;
        this.RightChild = null;
    }

    private void visitMyself(ViewGroup vg)
    {
        //visit ourselves
        TextView tv = new TextView(Core.context);
        tv.setText("" + this.payload);
        vg.addView(tv);
    }
    private void visitLeft(ViewGroup vg)
    {
        if(this.LeftChild != null)
        {
            this.LeftChild.visitPreOrder(vg);
        }
    }
    private void visitRight(ViewGroup vg)
    {
        //visit right
        if(this.RightChild != null)
        {
            this.RightChild.visitPreOrder(vg);
        }
    }

    public void visitPreOrder(ViewGroup vg)
    {
        this.visitMyself(vg);
        if(this.LeftChild != null)
        {
            this.LeftChild.visitPreOrder(vg);
        }
        //visit right
        if(this.RightChild != null)
        {
            this.RightChild.visitPreOrder(vg);
        }
    }
    public void visitPostOrder(ViewGroup vg)
    {
        if(this.LeftChild != null)
        {
            this.LeftChild.visitPostOrder(vg);
        }
        //visit right
        if(this.RightChild != null)
        {
            this.RightChild.visitPostOrder(vg);
        }
        this.visitMyself(vg);
    }
    public void visitInOrder(ViewGroup vg)
    {
        if(this.LeftChild != null)
        {
            this.LeftChild.visitInOrder(vg);
        }
        this.visitMyself(vg);
        //visit right
        if(this.RightChild != null)
        {
            this.RightChild.visitInOrder(vg);
        }
    }

    public void add(Node n)
    {
        //everything to the left  is <=
        if(n.getPayload() <= this.payload)
        {
            //i don't have a left child
            if(this.LeftChild == null)
            {
                this.LeftChild = n;
            }
            else
            {
                // i have a left child
                this.LeftChild.add(n);
            }
        }
        else
        //everything to the right is >
        {
            if(this.RightChild == null)
            {
                this.RightChild = n;
            }
            else
            {
                // i don't have a right child
                this.RightChild.add(n);
            }
        }
    }

    public int getPayload()
    {
        return payload;
    }

    public Node getLeftChild()
    {
        return LeftChild;
    }

    public void setLeftChild(Node leftChild)
    {
        LeftChild = leftChild;
    }

    public Node getRightChild()
    {
        return RightChild;
    }

    public void setRightChild(Node rightChild)
    {
        RightChild = rightChild;
    }

}
