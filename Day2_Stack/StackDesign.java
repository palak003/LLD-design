package Day2_Stack;

import java.util.ArrayList;
import java.util.List;

class Stack<T> {
    private List<T> stack;

    public Stack(){
        stack=new ArrayList<>();
    }

    public List<T> getStack(){
        return this.stack;
    }

    public void setStack(List<T> stack){
        this.stack=stack;
    }

    public void pushElement(T obj){
        stack.add(obj);
    }

    public T peekElement(){
        return !isEmpty()?stack.get(getSize()-1):null;
    }

    public void removeElement(){
        if(!isEmpty())
         stack.remove(getSize()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int getSize(){
        return stack.size();
    }
}

public class StackDesign{
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        System.out.println(stack.getSize());
        stack.pushElement(1);
        stack.pushElement(2);
        stack.pushElement(3);
        System.out.println(stack.getSize());
        System.out.println(stack.peekElement());
        stack.removeElement();
        System.out.println(stack.getSize());
        System.out.println(stack.peekElement());

    }
}


