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
        TreeMap<Name, Integer> map = new TreeMap<>(comparator);
    
        TreeMap<Name, Integer> map1 = new TreeMap<>(map);
        map1.put(new Name("b"), 1);
        map1.put(new Name("a"), 1);
    
        System.out.println(map1.firstKey().getName());
        HashMap<Integer,Integer> map2 = new HashMap<>();
        long a = 109/36;
        System.out.println(a);
    }
}
