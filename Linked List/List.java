import java.util.Scanner ;

class Node
{
    int data ;
    Node next ;

    public Node(int data)
    {
        this.data = data ;
        this.next = null ;
    }

    public Node(int data, Node next)
    {
        this.data = data ;
        this.next = next ;
    }
}

class LinkedList
{
    Node head ;

    public LinkedList()
    {
        Node temp ;
        Scanner in = new Scanner(System.in) ;
        System.out.print("\nEnter the data for the first node :- ") ;
        head = new Node(in.nextInt()) ;
        temp = head ;
        while(true)
        {
            System.out.print("\nDo you want to continue ? (Press 'N'/'n' to stop adding nodes else press any other key) ") ;
            char ch = in.next().charAt(0) ;
            if(ch == 'N' || ch == 'n')
            {
                break ;
            }
            System.out.print("\nEnter the data for this node :- ") ;
            temp.next = new Node(in.nextInt()) ;
            temp = temp.next ;
        }
    }

    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Invalid command !\nThe list is empty\n") ;
            return ;
        }
        Node temp = head ;
        while(temp != null)
        {
            System.out.print(temp.data + " => ") ;
            temp = temp.next ;
        }
        System.out.println("null") ;
    }

    public void revDisplay(Node ptr)
    {
        if(ptr == null)
        {
            return ;
        }
        revDisplay(ptr.next) ;
        System.out.print(ptr.data + " => ") ;
    }

    public void insert(int data, int position)
    {
        Node temp = head ;
        if(position < -1)
        {
            System.out.println("\nInvalid Command !\n") ;
            return ;
        }
        if(isEmpty())
        {
            position = 0 ;
        }
        switch(position)
        {
            case 0 :
                head = new Node(data, head) ;
                break ;
            case -1 :
                while(temp.next != null)
                {
                    temp = temp.next ;
                }
                temp.next = new Node(data) ;
                break ;
            default :
                while(position > 1)
                {
                    temp = temp.next ;
                    position-- ;
                }
                temp.next = new Node(data, temp.next) ;
        }
    }

    public void deleteByPosition(int position)
    {
        Node temp = head ;
        if(isEmpty() || position < -1)
        {
            System.out.println("\nInvalid Command !\n") ;
            return ;
        }
        if(head.next == null)
        {
            position = 0 ;
        }
        switch(position)
        {
            case 0 :
                temp = temp.next ;
                head = temp ;
                break ;
            case -1 :
                while(temp.next.next != null)
                {
                    temp = temp.next ;
                }
                temp.next = null ;
                break ;
            default :
                position = position - 1 ;
                while(position > 1)
                {
                    temp = temp.next ;
                    position-- ;
                }
                if(temp.next != null)
                {
                    temp.next = temp.next.next ;
                }
                else
                {
                    temp = null ;
                }
        }
    }

    public void deleteByData(int data)
    {
        Node temp = head ;
        if(isEmpty())
        {
            System.out.println("Invalid Command !\nList is empty\n") ;
            return ;
        }
        if(head.data == data)
        {
            head = head.next ;
            return ;
        }
        while(temp != null && temp.next != null)
        {
            if(temp.next.data == data)
            {
                temp.next = temp.next.next ;
                return ;
            }
            temp = temp.next ;
        }
        System.out.println("Invalid Command !\nNo node has data = " + data) ;
    }

    public int search(int data)
    {
        Node temp = head ;
        int position = 0 ;
        while(temp != null)
        {
            position = position + 1 ;
            if(temp.data == data)
            {
                return position ;
            }
            temp = temp.next ;
        }
        return -1 ;
    }

    public int getData(int position)
    {
        Node temp = head ;
        while(position > 1)
        {
            temp = temp.next ;
            position-- ;
        }
        return temp.data ;
    }

    public int getSize()
    {
        Node temp = head ;
        int size = 0 ;
        while(temp != null)
        {
            size = size + 1 ;
            temp = temp.next ;
        }
        return size ;
    }

    public boolean isEmpty()
    {
        if(head == null)
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }

    public void reverse()
    {
        Node temp1 = head, temp2, temp3 = null ;
        while(temp1 != null)
        {
            temp2 = temp1.next ;
            temp1.next = temp3 ;
            temp3 = temp1 ;
            temp1 = temp2 ;
        }
        head = temp3 ;
    }
}

public class List
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList() ;
        while(true)
        {
            int choice, location, value ;
            Scanner in = new Scanner(System.in) ;

            System.out.println("\n1  : Display the list") ;
            System.out.println("2  : Display the list in reverse") ;
            System.out.println("3  : Insert a node") ;
            System.out.println("4  : Delete the node at a position") ;
            System.out.println("5  : Delete the first node with a certain value") ;
            System.out.println("6  : Search for a given value") ;
            System.out.println("7  : Get the data of a node at a given position") ;
            System.out.println("8  : Get the size of the list") ;
            System.out.println("9  : Check if the list is empty") ;
            System.out.println("10 : Reverse the list") ;
            System.out.println("11 : Terminate the program") ;

            choice = in.nextInt() ;
            switch(choice)
            {
                case 1 :
                    list.display() ;
                    break ;
                case 2 :
                    if(!list.isEmpty())
                    {
                        list.revDisplay(list.head) ;
                        System.out.println("null") ;
                    }
                    else
                    {
                        System.out.println("Invalid Command !\nThe list is empty") ;
                    }
                    break ;
                case 3 :
                    System.out.print("Enter the position of the node after which the new node is to be inserted (Press 0 for insertion at head and -1 for insertion at the end) :- ") ;
                    location = in.nextInt() ;
                    System.out.print("\nEnter the data of the new node :- ") ;
                    value = in.nextInt() ;
                    list.insert(value, location) ;
                    break ;
                case 4 :
                    System.out.print("Enter the position of the node to be deleted (Press 0 for deletion of first node and -1 for deletion of last node) :- ") ;
                    location = in.nextInt() ;
                    list.deleteByPosition(location) ;
                    break ;
                case 5 :
                    System.out.print("Enter the data of the node to be deleted :- ") ;
                    value = in.nextInt() ;
                    list.deleteByData(value) ;
                    break ;
                case 6 :
                    System.out.print("Enter the data value that is to be searched :- ") ;
                    value = in.nextInt() ;
                    location = list.search(value) ;
                    if(location < 1)
                    {
                        System.out.print("The node with data " + value + " does not exist") ;
                    }
                    else
                    {
                        System.out.print("The node with the given data is at position " + location) ;
                    }
                    break ;
                case 7 :
                    System.out.print("Enter the position of the node whose data has to be found :- ") ;
                    location = in.nextInt() ;
                    if(location < 1 || location > list.getSize())
                    {
                        System.out.println("\nInvalid Command !") ;
                    }
                    else
                    {
                        value = list.getData(location) ;
                        System.out.println("The data in the node at position " + location + " is " + value) ;
                    }
                    break ;
                case 8 :
                    System.out.println("The size of the list is :- " + list.getSize()) ;
                    break ;
                case 9 :
                    if(list.isEmpty())
                    {
                        System.out.println("This list is empty") ;
                    }
                    else
                    {
                        System.out.println("The list is not empty") ;
                    }
                    break ;
                case 10 :
                    list.reverse() ;
                    break ;
                case 11 :
                    return ;
                default :
                    System.out.println("\nInvalid Command !") ;
            }
        }
    }
}
