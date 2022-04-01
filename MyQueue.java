public class MyQueue<T> {

    private Object[] data;
    private int size;
    private int first;
    private int last;

    public MyQueue() {
        this(20);
    }

    public MyQueue(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
        this.first = 0;
        this.last = -1;
    }
    
    public void increaseCapacity()
    {
        int newsize = size + size / 2 + 1;
        Object[] newArray = new Object[newsize];
        int indexIntoOrig = first;
        int indexIntoNew = first;
        int numElementsCopied = 0;
        while (numElementsCopied <= size) {
            newArray[indexIntoNew] = data[indexIntoOrig];
            if (indexIntoOrig < data.length -1)
                indexIntoOrig++;
            else
                indexIntoOrig = 0;
            if (indexIntoNew < newArray.length -1)
                indexIntoNew++;
            else
                indexIntoNew = 0;
            numElementsCopied++;
        }
        data = newArray;
    }
 
    public void enqueue(T element) {
        if ( ! (size < data.length -1) )
            increaseCapacity();

        if (last < data.length-1) {
           data[last+1] = element;
           last++;
        }
        else {
            data[0] = element;
            last = 0;
        }
        size++;
    }

    public T dequeue() {
        T temp = (T)(data[first]);
        data[first] = null;
        if (first < data.length -1)
            first++;
        else
            first = 0;
        size--;
        return temp;
    }

    public T peek() {

        return (T)(data[first]);

    }

    @Override
    public String toString() {
        String returnval = "";
        returnval += "Size: " + size + " first: " + first + " last: " + last + "\n";
        for (int i=0; i< data.length; i++) {
            returnval += data[i] + " ";
        }
        returnval += "\n";
        return returnval;
    }

    @Override
    public boolean equals(Object otherQueue) {

        if (otherQueue instanceof MyQueue) {
            // compare the equality of the objects in this queue
            // and the other queue
            //System.out.println("The other thing is a queue");
            MyQueue oq = (MyQueue)otherQueue;
            int oqfirst = oq.first;
            int oqsize = oq.size;

            int myfirst = first;
            int mysize = size;

            if (oqsize != mysize) {
                //System.out.println("mysize: " + mysize);
                //System.out.println("oqsize: " + oqsize);
    
                return false;
            }
            //System.out.println("The other thing has the same size");
            int oqcurrent = oqfirst;
            int mycurrent = myfirst;
            //System.out.println("myfirst: " + myfirst + " oqfirst: " + oqfirst);
            int num=0;
            while (num < size) {
                //System.out.println(data[myfirst] + " " + oq.data[oqfirst]);
                if ( ! data[mycurrent].equals(oq.data[oqcurrent]) ) {
                    return false; 
                }
                num++;
                mycurrent++;
                if (mycurrent == data.length)
                    mycurrent = 0;
                oqcurrent++;
                if (oqcurrent == oq.data.length)
                    oqcurrent = 0;
            }
            return true;
        }
        return false;
    }
}//END CLASS
