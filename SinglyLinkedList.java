/**
 * SinglyLinkedList
 */

public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size;i++){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }

    @Override
    public Object get(int index) {
        // Mengembalikan data pada index ke-i, head memiliki index 0
        if (index < 0 || index >= size) {
            return null;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.pointer;
        }
        return currentNode.data;
    }

    @Override
    public int indexOf(Object targetData) {
        // Mencari kemunculan pertama targetData
        // Jika tidak ditemukan, mengembalikan -1
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            if (currentNode.data.equals(targetData)) {
                return i;
            }
            currentNode = currentNode.pointer;
        }
        return -1;
    }

    @Override
    public void printReverse() {
        // Mencetak data dari tail ke head
        printReverseRecursive(head);
    }
    private void printReverseRecursive(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        printReverseRecursive(currentNode.pointer);
        System.out.println(currentNode.data);
    }

    @Override
    public boolean remove(Object targetData) {
        // Mencari dan menghapus node pertama dengan data = targetData
        if (isEmpty()) {
            return false;
        }
        // Jika data yang dihapus ada di head
        if (head.data.equals(targetData)) {
            deleteFirst();
            return true;
        }
        Node currentNode = head;
        while (currentNode.pointer != null) {
            if (currentNode.pointer.data.equals(targetData)) {
                // Jika node yang dihapus adalah tail
                if (currentNode.pointer == tail) {
                    tail = currentNode;
                }
                currentNode.pointer = currentNode.pointer.pointer;
                size--;
                return true;
            }
            currentNode = currentNode.pointer;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        // Mengubah seluruh data linked list menjadi array
        Object[] array = new Object[size];
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            array[i] = currentNode.data;
            currentNode = currentNode.pointer;
        }
        return array;
    }
}