import java.io.*;

/**
    Clock class that will build a clock object with mechanisms that imitate that of the Ball Clock.
*/
public class Clock{

    int time = 0;
    Ball movingBall = null;
    MyQueue<Ball> queue;
    MyStack<Ball> minStack;
    MyStack<Ball> fiveMinStack;
    MyStack<Ball> hourStack;

    /**
        @param nBalls Takes in a integer input representing the number of balls in the queue.
        Constructor for ClockRunner
    */
    public Clock(int nBalls){
        this.queue = new MyQueue<Ball>();
        this.minStack = new MyStack<Ball>();
        this.fiveMinStack = new MyStack<Ball>();
        this.hourStack = new MyStack<Ball>();
        
        for(int i = 1; i <= nBalls; i++){
            queue.enqueue(new Ball(i));
        }
    }
    
    /**
     * Ball clock algorithm, moves one ball at a time through its mechanisms.
    */
    public void advance(){    
        minStack.push(queue.dequeue());
        if(minStack.size() == 5){
            fiveMinStack.push(minStack.pop());
            for(int i = 0; i < 4; i++){
                queue.enqueue(minStack.pop());
            }
            if(fiveMinStack.size() == 12){
                hourStack.push(fiveMinStack.pop());
                for(int i = 0; i < 11; i++){
                    queue.enqueue(fiveMinStack.pop());
                }
                if(hourStack.size() == 12){
                    Ball twelvth = hourStack.pop();
                    for(int i = 0; i < 11; i++){
                        queue.enqueue(hourStack.pop());
                    }
                    queue.enqueue(twelvth);

                }
            }
        }
        time++;
    }

    /**
     * @param o Takes in a object for comparison.
    */
    public boolean equals(Object o){
        if(o instanceof Clock){
            if(this.queue.equals(((Clock)o).getQueue()) 
            && this.minStack.equals(((Clock)o).getMinStack()) 
            && this.fiveMinStack.equals(((Clock)o).getFiveMinStack()) 
            && this.hourStack.equals(((Clock)o).getHourStack()))
            {
                return true;
            }    
        }
        return false;
    }

    /**
     * Returns this clocks time.
    */
    public int getTime(){
        return this.time / 1440;
    }

    /**
     * Returns this clocks queue.
    */
    public MyQueue<Ball> getQueue(){
        return queue;
    }

    /**
     * Returns this clocks minute stack.
    */
    public MyStack<Ball> getMinStack(){
        return minStack;
    }

    /**
     * Returns this clocks five minute stack.
    */
    public MyStack<Ball> getFiveMinStack(){
        return fiveMinStack;
    }

    /**
     * Returns this clocks hours stack.
    */
    public MyStack<Ball> getHourStack(){
        return hourStack;
    }
 
}//END CLASS