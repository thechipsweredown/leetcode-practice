package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Test {
    
    static class Name{
        private String name;
        public Name(String name){
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        Comparator<Name> comparator = Comparator.comparing(Name::getName);
        System.out.println(Math.ceil(0.4));
    }
}
