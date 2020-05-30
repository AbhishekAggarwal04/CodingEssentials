package com.ds.linklist;


import com.ds.input.InputFromUser;

public class LinkList extends InputFromUser
{
    Node head;
    public static void main(String[] args)
    {
        LinkList ls = new LinkList();

        System.out.print("Enter the link list nodes to be created: ");
        int noOfInputs = ls.sc.nextInt();

        System.out.println("Enter the nodes data one at a time and press enter: ");
        Node nPrevious = new Node();
        for(int i=0;i<noOfInputs;i++)
        {
            int data = ls.sc.nextInt();
            if(i==0)
            {
                ls.head =  new Node(data);
                nPrevious = ls.head;
            }
            else
            {
                Node newNode = new Node(data);
                nPrevious.next = newNode;
                nPrevious = newNode;
            }
        }

        System.out.println("\n Link List created:");
        ls.traversal(ls);

        System.out.print("\nDo you want to add a node:");
        String strAdd = ls.sc.next();
        ls.addNodeandDisplay(strAdd,ls);

        System.out.print("\nDo you want to delete a node:");
        String strDel = ls.sc.next();
        if("Y".equalsIgnoreCase(strDel))
        {
            ls.deleteNodeandDisplay(ls);
        }
    }

    protected void traversal(LinkList lsObject)
    {
        System.out.println("Link List: ");
        boolean iterate = true;
        Node itr = lsObject.head;
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

    protected void addNodeandDisplay(String strAdd,LinkList lsObject)
    {
        if("Y".equalsIgnoreCase(strAdd))
        {
            System.out.println("Please select the following options: ");
            System.out.println("1 - Add to the Start.");
            System.out.println("2 - Add to the End.");
            System.out.println("3 - Add to a Selected Position.");

            int option = lsObject.sc.nextInt();
            switch(option)
            {
                case 1: lsObject.add(lsObject,"Start");
                        lsObject.traversal(lsObject);
                        break;

                case 2: lsObject.add(lsObject,"End");
                        lsObject.traversal(lsObject);
                        break;

                case 3: System.out.print("Enter position to add: ");
                        int pos = lsObject.sc.nextInt();
                        lsObject.add(lsObject,pos);
                        lsObject.traversal(lsObject);
                        break;
            }
        }
    }

    protected void add (LinkList lsObject,String strPosition)
    {
        boolean bIterate = true;
        Node itr = lsObject.head;
        while(bIterate)
        {
            if("Start".equalsIgnoreCase(strPosition))
            {
                System.out.print("Enter value of the node: ");
                int dataVal = lsObject.sc.nextInt();
                Node newNode = new Node(dataVal);
                newNode.next = itr;
                lsObject.head = newNode;
                bIterate=false;
            }
            if("End".equalsIgnoreCase(strPosition))
            {
                if(itr.next != null)
                {
                    itr = itr.next;
                }
                else
                {
                    System.out.print("Enter value of the node: ");
                    int dataVal = lsObject.sc.nextInt();
                    Node newNode = new Node(dataVal);
                    itr.next = newNode;
                    bIterate=false;
                }
            }
        }
    }

    protected void add (LinkList lsObject,int iPosition)
    {
        boolean bIterate = true;
        Node itr = lsObject.head;
        Node nPrevious = new Node();
        int count = 1;
        while(bIterate)
        {
            if(count == iPosition)
            {
                System.out.print("Enter value of the node: ");
                int dataVal = lsObject.sc.nextInt();
                Node newNode = new Node(dataVal);
                if(iPosition == 1)
                {
                    lsObject.head = newNode;
                }
                else
                {
                    nPrevious.next = newNode;
                }
                newNode.next = itr;
                bIterate = false;
            }
            else
            {
                count++;
                nPrevious = itr;
                if(itr.next == null && iPosition>count)
                {
                    System.out.println("Node cannot be added as the position to add is one more than the last position.");
                    break;
                }
                itr = itr.next;

            }
        }
    }

    protected void deleteNodeandDisplay(LinkList lsObject)
    {
        System.out.print("\n Enter the value you want to delete: ");
        int iVal = lsObject.sc.nextInt();

        Node itr = lsObject.head;
        boolean iterate = true;
        Node nPrevious = new Node();

        while(iterate)
        {
            if(itr.data == iVal)
            {
                if(nPrevious.next == null)
                {
                    lsObject.head = itr.next;
                    break;
                }
                else
                {
                    nPrevious.next = itr.next;
                    break;
                }
            }
            else
            {
                nPrevious = itr;
                if(itr.next == null)
                {
                    iterate = false;
                }
                itr = itr.next;
            }
        }

        lsObject.traversal(lsObject);
    }
}
