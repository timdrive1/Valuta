package Classes;

import java.util.HashSet;

public class Expirement {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("123");
        set.add("234");
        set.add("123");
        for (int i = 0; i < set.size() ; i++) {
            System.out.println(set);
        }
    }
}
