public class LinkedList {
    Node head;
    Node temp;

    //Add Data at head
    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            temp = newNode;
        } else {
            Node temp = head;
            this.head = newNode;
            newNode.next = temp;
        }
    }

    //Add Data at tail
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            temp = newNode;
        } else {
            Node temp = this.temp;
            this.temp = newNode;
            temp.next = newNode;
        }
    }

    //Add Data at middle
    public void insertNode(Node prev_node, int newNode) {
        if (prev_node == null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_Node = new Node(newNode);
        new_Node.next = prev_node.next;
        prev_node.next = new_Node;
    }

    //Delete head Data
    public void pop() {
        if(this.head != null) {
            Node temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
    }

    //Delete tail Data
    public void  popLast () {
        Node temp = head;
        while (!temp.next.equals(this.temp)) {
            temp = temp.next;
        }
        this.temp = temp;
        temp.next = null;
    }

    //find Data by value
    public void findNode(int value) {
        Node tempNode = head;
        int index = 1;
        boolean flag = false;

        //checking head is null or not
        if (head == null) {
            System.out.println("List is empty");
        }
        else {
            //searching element using loop
            while (tempNode != null) {
                if (tempNode.data ==  value) {
                    flag = true;
                    break;
                }
                index++;
                tempNode = tempNode.next;
            }
        }
        if (flag == true) {
            System.out.println("The Value (" + value + ") you are searching is present at Index : " + (index-1) + " in the list.");
        }
        else {
            System.out.println("Element is not present in the list");
        }
    }

    //delete any node from list
    public void deleteANode(int value) {
        if (this.head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node tempNode = head;
        while (tempNode.next.data != value) {
            tempNode = tempNode.next;
        }
        Node previousNode = tempNode;
        Node nextNode = tempNode.next.next;
        previousNode.next = nextNode;
    }

    //sort the list in ascending order
    public void sort() {
        Node initialStart = head, index = null;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (initialStart != null) {
            index = initialStart.next;
            while (index != null) {
                if (initialStart.data > index.data) {
                    int temp = initialStart.data;
                    initialStart.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            initialStart = initialStart.next;
        }
    }

    //print the list
    public void print() {
        if (head == null) {
            System.out.println("Linked List is Empty");
        }
        else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data+ " ");
                temp = temp.next;
            }
        }
    }
}
