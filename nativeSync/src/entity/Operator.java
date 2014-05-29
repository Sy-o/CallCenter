package entity;

/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 30, 2014
 * Time: 2:16:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Operator {
    public int id;

    public Operator(int id){
        this.id = id;
    }

    @Override
    public String toString(){
           return "Operator #"+Integer.toString(id);
    }
}
