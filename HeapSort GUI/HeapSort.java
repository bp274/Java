import java.util.Scanner;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.lang.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HeapSort extends JFrame
{
    public int arr[], arr2[];
    public int size;
    public int deletion;

    public void paint(Graphics g)
    {
        int thisLevel = 1;

        g.clearRect(0, 0, 1920, 1080);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 18));

        int p;
        int x;
        int y;

        x = 800;
        y = 100;
        p = 2*x;

        int nodeCount = 0;
        int edgeCount = size - 1;

        while(nodeCount != size - deletion)
        {
            int count = 0;
            while(count != thisLevel && nodeCount != size - deletion)
            {
                g.setColor(Color.BLUE);
                g.drawOval(x + p*count - 20, y - 20, 40, 40);

                g.setColor(Color.RED);
                g.drawString(Integer.toString(arr[nodeCount]) , x + p*count - 5 , y + 5);

                g.setColor(Color.GREEN);
                if(edgeCount != deletion)
                {
                    g.drawLine(x + p*count, y + 20, x + p*count - p / 4 , y + 100 - 20);
                    edgeCount = edgeCount - 1;
                }
                if(edgeCount != deletion)
                {
                    g.drawLine(x + p*count, y + 20, x + p*count + p / 4 , y + 100 - 20);
                    edgeCount = edgeCount - 1;
                }
                count = count + 1;
                nodeCount = nodeCount + 1;
            }
            p = x;

            thisLevel = thisLevel * 2;

            x = x / 2;
            y = y + 100;
        }
    }


    private int leftChildIndex(int index)
    {
        return 2 * index + 1;
    }
    private int rightChildIndex(int index)
    {
        return 2 * index + 2;
    }


    private int leftChildValue(int index)
    {
        return arr[leftChildIndex(index)];
    }
    private int rightChildValue(int index)
    {
        return arr[rightChildIndex(index)];
    }


    public void heapify(int n, int index)
    {

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        repaint();

        int largestIndex;
        largestIndex = index;

        // finding the index of the largest element among the two childs and their parent itself
        if(leftChildIndex(index) < n && leftChildValue(index) > arr[largestIndex])
        {
            largestIndex = leftChildIndex(index);
        }
        if(rightChildIndex(index) < n && rightChildValue(index) > arr[largestIndex])
        {
            largestIndex = rightChildIndex(index);
        }

        //if heap property not satisfied
        if(largestIndex != index)
        {
            swap(index, largestIndex);

            repaint();

            // recursively heapifying each sub-tree
            heapify(n, largestIndex);
        }
    }

    public void input()
    {
        String s1, s2;

        s1 = JOptionPane.showInputDialog("Enter the number of elements :- ");
        size = Integer.parseInt(s1);

        arr = new int[size];
        for(int i = 0; i < size; i++)
        {
            s2 = JOptionPane.showInputDialog("Enter the elements :- ");
            arr[i] = Integer.parseInt(s2);
        }
        deletion = 0;
    }

    public void buildHeap()
    {
        for(int i = (size / 2) - 1; i >= 0; i--)
        {
            heapify(size, i);
        }
    }

    public void display()
    {
        setSize(1920,1080);
        setLocation(100,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        repaint();
    }

    public void heapSort()
    {
        // constructing the heap

        buildHeap();

        // placing each element at correct position

        for(int i = size - 1; i >= 0; i--)
        {
            deletion = deletion + 1;
            swap(0, i);
            heapify(i, 0);
        }
    }

    public void displayArray()
    {
        System.out.print("The sorted array becomes :- ");

        for(int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    private void swap(int indexA, int indexB)
    {
        int temp;

        temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void main(String args[])
    {

        HeapSort obj = new HeapSort();
        obj.input();
        obj.display();
        obj.heapSort();
        obj.displayArray();
    }

}
