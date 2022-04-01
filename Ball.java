/**
 * Ball class for Clock to run through its mechanisms.
*/
public class Ball {

    public int data;

    /**
     * @param data Takes in a integer and wraps it in a Ball object.
     * Ball Constructor.
    */
    public Ball(int data){
    	this.data = data;
    }
 
    /**
     *  Returns the integer inside of Ball.
    */
    public int getNumber(){
        return this.data;
    }

    /**
     * Override equals method for Ball
    */
    @Override
    public boolean equals(Object o){
        if(o instanceof Ball){
            if(this.data == ((Ball)o).getNumber()){
                return true;
            }    
        }
        return false;
    }

}//END CLASS