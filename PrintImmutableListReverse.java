class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        printReverse(head);
    }
    
    public void printReverse(ImmutableListNode node) {
        if(node != null) {
            printReverse(node.getNext());
            node.printValue();
        }
    }
}
