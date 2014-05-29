package entity;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 30, 2014
 * Time: 2:16:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Caller extends Thread{
    CallCenter center;
    int id;
    Random rand;

    public Caller(CallCenter center, int id){
        this.center = center;
        this.id = id;
        rand = new Random();
    }

    @Override
    public void run(){
        try{
            int recall;
            Operator operator;
            int waitTime;
            do{
                recall = rand.nextInt(2);
                if( recall == 1)
                    waitTime = 3000;
                else
                    waitTime = 15000;
                System.out.println("Caller #"+Integer.toString(id)+" is calling to center...");
                operator = center.call(waitTime);

                if(operator != null)
                {
                    System.out.println("Caller #"+Integer.toString(id)+" is talking with "+operator.toString());
                    sleep(10000);
                    if( center.endCall(operator) )
                        System.out.println("Caller #"+Integer.toString(id)+" finished talking with "+operator.toString());
                    recall = 0;
                }
                else{
                    if( recall == 1 ) {
                        System.out.println("Caller #"+Integer.toString(id)+" will call in few minutes");
                        sleep(5000);
                    }
                    else
                        System.out.println("Caller #"+Integer.toString(id)+" hung up");
                }
            }while( recall == 1);
        }
        catch( InterruptedException e ){
            System.out.println("Error in Caller thread " + Thread.currentThread());            
        }
    }
}
