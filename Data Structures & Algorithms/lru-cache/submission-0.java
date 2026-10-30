class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }

    }

    int capacity;
    Map<Integer, Node> cache ;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache= new HashMap();
        this.head= new Node(-1,-1);
        this.tail= new Node(-1,-1);
        tail.prev= head;
        head.next=tail;
        
    }
    
    public int get(int key) {
        Node cur= cache.get(key);
        if(cur==null) return -1;
        remove(cur);
        addToFront(cur);
        return cur.value;
        
    }
    
    public void put(int key, int value) {
        Node cur= new Node(key,value);
        if(cache.containsKey(key)){
            cache.get(key).value=value;
            cur=cache.get(key);
            remove(cur);
            addToFront(cur);
        }else{
        if(capacity>0){
            addToFront(cur);
            capacity--;
        }else{
            
            remove(tail.prev);
            addToFront(cur);
        }
        }
        

        
    }

    public void remove(Node node){
        cache.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        
    }

    public void addToFront(Node cur){
        cache.put(cur.key,cur);
        cur.next=head.next;
        cur.prev=head;
        head.next.prev=cur;
        head.next=cur;
        
    }
}
