package Deep_Thought_Into_Java;

import java.util.HashMap;

public class HashmapTest {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<100;i++){
            hashMap.put(i,i);
        }
    }
}
