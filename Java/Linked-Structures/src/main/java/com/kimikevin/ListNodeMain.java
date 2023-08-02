package com.kimikevin;

public class ListNodeMain {
    public static void main(String[] args) {
        ListNode l4 = new ListNode("Messi", null);
        ListNode l3 = new ListNode("Steph Curry", l4);
        ListNode l2 = new ListNode ("Renaldo", l3);
        ListNode l1 = new ListNode("Michael Jordan", l2);

        ListNode temp = l1;

        // insert new node
        ListNode l5 = new ListNode("Garnett", null);

        // insert at end of LinkedList
        while (temp != null) {
            if (temp.next == null) {
                temp.next = l5;
                break;
            }
            temp = temp.next;
        }

        System.out.println("Insert Garnett at the End");
        System.out.println(l1);
        l4.setNext(null);
        temp = l1;

        // insert at index after M Jordan
        while (temp != null) {
            if (temp.player.equals("Michael Jordan")) {
                l5.setNext(temp.next);
                temp.setNext(l5);
            }
        }

        System.out.println();
        System.out.println("Insert Garnett after Michael Jordan");
        System.out.println(l1.toString());
    }
}
