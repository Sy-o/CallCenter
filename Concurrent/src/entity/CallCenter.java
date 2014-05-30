package entity;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 30, 2014
 * Time: 5:24:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class CallCenter {
    private int operatorsCount;
    private ArrayBlockingQueue<Operator> freeOper;
    private ArrayBlockingQueue<Operator> busyOper;

    public CallCenter(int operCount){
        operatorsCount = operCount;
        createOperators();
    }

    private void createOperators(){
        freeOper = new ArrayBlockingQueue<Operator>(operatorsCount);
        busyOper = new ArrayBlockingQueue<Operator>(operatorsCount);
        for(int i=0; i<operatorsCount; i++){
            freeOper.offer(new Operator(i));
        }
    }

    public ArrayBlockingQueue<Operator> getFreeOperators(){
        return freeOper;
    }

    public ArrayBlockingQueue<Operator> getBusyOperators(){
        return busyOper;
    }    
}
