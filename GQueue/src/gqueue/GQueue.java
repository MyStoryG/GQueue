package gqueue;

interface Queue{
    boolean isEmpty();
    void enQueue(char element);
    void deQueue();
    void printQueue();
}

class ArrayQueue implements Queue{
    public int front;
    public int rear;
    public int size;
    public char arr[];
    public int count;

    public ArrayQueue(int size){
        this.size = size;
        this.front = -1;
        this.rear = -1;
        this.arr = new char[size];
        this.count = -1;
    }

    @Override
    public boolean isEmpty() {
        if(rear < 0){
            return true;
        }
        return false;
    }

    @Override
    public void enQueue(char element) {
        count++;
        System.out.print("enQueue ) " + (count+1) + " &&& ");
        
        
        if(count > size-1){
            count = size-1;
            System.out.println("It's full.");
            return;
        }
        rear++;
        
        if(rear < size){
            arr[rear] = element;
        }else{
            rear = 0;
            if(rear < front){
                arr[rear] = element;
            }
        }
        System.out.println("rear : " + rear + " front : " + front);
    }

    @Override
    public void deQueue() {
        if(count > -1){
            count--;
        }
        System.out.print("deQueue ) " + (count+1) + " &&& ");
        if(!isEmpty()){
            front++;
            if(front >= size){
               front = 0; 
            }
            if(front == rear){
                System.out.println("It's empty!");
                front = -1;
                rear = -1;
            }else if(front > size){
                front = 0;
            }
        }else{
            System.out.println("It's empty!");
        }
        System.out.println("rear : " + rear + " front : " + front);
    }

    @Override
    public void printQueue(){
        System.out.print("*** Print Queue :");
        if(!isEmpty()){
            if(front < rear && rear < size){
                for(int i=front+1; i<=rear; i++){
                    System.out.print(" " + arr[i]);
                }
            }else{
                if(rear < size ){
                    for(int i=0; i<=rear; i++){
                        System.out.print(arr[i] + " ");
                    }
                    for(int i=front+1; i<size; i++){
                        System.out.print(arr[i] + " ");
                    }
                }
            }
        }else{
            System.out.print("It's empty!");
        }
        System.out.println("");
    }
}

public class GQueue{
    public static void main(String []args){
        ArrayQueue aq = new ArrayQueue(5);

        aq.enQueue('1');
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.enQueue('2');
        aq.printQueue();
        aq.enQueue('3');
        aq.printQueue();
        aq.enQueue('4');
        aq.printQueue();
        aq.enQueue('5');
        aq.printQueue();
        aq.enQueue('6');
        aq.printQueue();
        aq.enQueue('7');
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.enQueue('A');
        aq.printQueue();
        aq.enQueue('B');
        aq.printQueue();
        aq.enQueue('C');
        aq.printQueue();
        aq.enQueue('C');
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.deQueue();
        aq.printQueue();
        aq.enQueue('C');
        aq.printQueue();
    }
}