import java.util.*;

public class Test {
 
	public static void main(String[] args) {
		
        int number;
        Scanner scanner = new Scanner(System.in);
        Clock clockRunner;
        Clock clockOriginal;
        
        while(scanner.hasNextInt()){
            
            number = scanner.nextInt();
            clockRunner = new Clock(number);
            clockOriginal = new Clock(number);

            if(number == 0){                            //if input = 0 : stop
                break;
            } else if(number > 127 || number < 27){     //if input isnt in range : ignore
                continue;
            } else {
                while(true){
                    clockRunner.advance();
                    if(clockRunner.equals(clockOriginal)){
                        break;
                    }
                }
                System.out.println(number + " balls cycle after " + clockRunner.getTime() + " days.");
            }
        }
    }
 
}//END CLASS