package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListAndSet {
    public static void main(String[] args) {

        //List declaration
        List<Integer> ls = new ArrayList<>();
        {
            ls.add(5);
            ls.add(4);
            ls.add(3);

            //Set decleration
            Set<Integer> st = new HashSet<>();
            {
                st.add(5);
                st.add(9);
                st.add(15);

                //printing
                System.out.println(ls);
                System.out.println(st);
            }
        }
    }
}
