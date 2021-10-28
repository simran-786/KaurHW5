package com.example.kaurhw5;

import android.view.ViewGroup;

public class BinaryTree
{
    private Node root;
    private int count;

    public BinaryTree()
    {
        this.root = null;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void add(int payload)
    {
        Node n = new Node(payload);
        this.count++;

        if(this.root == null)
        {
            this.root = n;
        }
        else
        {
            //we know that this.root is a thing
            this.root.add(n);
        }
    }

    public void traverseInOrder(ViewGroup vg)
    {
        vg.removeAllViews();
        if(this.root != null)
        {
            this.root.visitInOrder(vg);
        }
    }
    public void traversePreOrder(ViewGroup vg)
    {
        vg.removeAllViews();
        if(this.root != null)
        {
            this.root.visitPreOrder(vg);
        }
    }

    public void traversePostOrder(ViewGroup vg)
    {
        vg.removeAllViews();
        if(this.root != null)
        {
            this.root.visitPostOrder(vg);
        }
    }
}
