package com.linkedlist;
import com.linkedlist.UserInputs;
import com.linkedlist.Node;

public class SLL{
	static SingleLinkedListOperation list = new SingleLinkedListOperation();
    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n1.Insert First\n2.Insert Last\n3.Insert Nth Pos\n4.Print\n5.Exit");
            System.out.println("Enter Choice: ");
            choice = UserInputs.intVal();
            switch (choice) {
                case 1:
                    System.out.println("Enter Data");
                    list.insertFirst(UserInputs.intVal());
                    break;

                case 2:
                    System.out.println("Enter Data");
                    list.insertLast(UserInputs.intVal());
                    break;
                    
                case 3:
                    System.out.println("Enter Position");
                    int pos = UserInputs.intVal();
                    System.out.println("Enter Data");
                    list.insertNthPos(UserInputs.intVal(), pos);
                    break;

                 case 4:
                    list.printList();
                    break;
                    
                case 5:
                    break;
                    
                default:
                    System.out.println("Select from Options");
            }
        } while (choice != 5);
    }
}

class SingleLinkedListOperation {
    private Node head;
    private int counter;

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        counter++;
    }
    public void insertNthPos(int data, int pos) {// 1
        Node newNode = new Node(data);
        int countNode = 0;
        if (head == null) {
            head = newNode;
        } else if (pos <= 0 ) {
            System.out.println("Invalid Position");
        } else {
            Node temp = head;
            while (countNode < (pos) ) {
                temp = temp.getNext();
                countNode++;
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode) ;
            counter++;
        }
    }
    
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        counter++;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            System.out.println("Linked List: ");
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getData() + " -> ");
                temp = temp.getNext();
            }
        }
    }
}

