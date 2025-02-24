package calculator;

import java.util.*;

public class Calculator {
    private final List<Integer> numbers = new LinkedList<>();
    
    public void enter(int i){
        this.numbers.add(i);
        if (this.numbers.size() > 2){
            throw new IllegalStateException();
        }
    }
    
    public void add(){
        if (this.numbers.size() != 2){
            throw new IllegalStateException();
        }
        this.numbers.set(0, this.numbers.get(0) + this.numbers.get(1));
        this.numbers.remove(1);
    }
    
    public void multiply() {
        if (this.numbers.size() != 2){
            throw new IllegalStateException();
        }
        this.numbers.set(0, this.numbers.get(0) * this.numbers.get(1));
        this.numbers.remove(1);
    }
    
    public int getResult(){
        if (this.numbers.size() != 1){
            throw new IllegalStateException();
        }
        return this.numbers.getFirst();
    }
}