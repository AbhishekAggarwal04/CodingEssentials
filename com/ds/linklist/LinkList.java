package com.ds.linklist;


public class LinkList
{
    Node head;
    public static void main(String[] args)
    {
        LinkList ls = new LinkList();

        ls.head =  new Node(5);
        Node second = new Node(10);
        Node third = new Node(11);

        ls.head.next = second;
        second.next = third;
        third.next = null;

        boolean iterate = true;
        Node itr = ls.head;
        while(iterate)
        {
            System.out.println(itr.data);
            itr = itr.next;
            if(itr == null)
            {
                iterate = false;
            }
        }
    }
}
