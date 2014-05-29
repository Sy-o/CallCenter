package entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 30, 2014
 * Time: 2:16:34 AM
 * To change this template use File | Settings | File Templates.
 */

public class CallCenter {
    
    private int operatorsCount;
    private List<Operator> freeOper;
    private List<Operator> busyOper;

    public CallCenter(int operCount){
        operatorsCount = operCount;
        createOperators();
    }

    private void createOperators(){
        freeOper = new LinkedList<Operator>();
        busyOper = new LinkedList<Operator>();
        for(int i=0; i<operatorsCount; i++){
            freeOper.add(new Operator(i));
        }
    }

    public synchronized Operator call(int waitTime) throws InterruptedException{
        long start = System.currentTimeMillis();
        while (freeOper.size() == 0 && (  waitTime == 0 || ((System.currentTimeMillis() - start) <= waitTime))) {
            wait();
        }

        Operator operator = null;
        if (freeOper.size() != 0) {
            operator  = ((LinkedList<Operator>)freeOper).pollFirst();
            ((LinkedList<Operator>)busyOper).offerLast(operator);
        }
        return operator;
    }

    public synchronized boolean endCall(Operator operator){
        boolean status = busyOper.remove(operator);
        if (status) {
            freeOper.add(operator);
        }
        notifyAll();
        return status;
    }
}
