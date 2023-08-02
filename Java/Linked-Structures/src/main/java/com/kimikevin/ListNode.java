package com.kimikevin;

public class ListNode {
    String player;
    ListNode next;

    public ListNode(String player, ListNode next) {
        this.player = player;
        this.next = next;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }

    public String toString() {
        String result = "";
        ListNode temp = this;
        while (temp != null) {
            result += " [" + temp.player + "]";
            temp = temp.next;
        }
        return  result;
    }
}
