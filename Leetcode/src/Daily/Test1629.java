package Daily;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Jacob
 * @creator 2022/1/9-10:29
 */
public class Test1629 {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] chars = keysPressed.toCharArray();
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for(int i = 0; i < releaseTimes.length; i++){
            if(i == 0)
                characterIntegerHashMap.put(chars[i], releaseTimes[i]);
            else{
                int time = releaseTimes[i] - releaseTimes[i-1];
                Object o = characterIntegerHashMap.get(chars[i]);
                if(o!=null){
                    if(time > (Integer)o)
                        characterIntegerHashMap.put(chars[i],time);
                }else{
                    characterIntegerHashMap.put(chars[i],time);
                }
            }
        }
        Iterator<Character> iterator = characterIntegerHashMap.keySet().iterator();
        char ans = 'a';
        int maxTime = 0;
        while(iterator.hasNext()){
            Character c = iterator.next();
            Integer integer = characterIntegerHashMap.get(c);
            if(integer > maxTime){
                ans = c;
                maxTime = integer;
            }
            else if(integer == maxTime && c > ans){
                ans = c;
                maxTime = integer;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] releaseTimes = new int[]{12,23,36,46,62};
        String keysPressed = "spuda";
        System.out.println(slowestKey(releaseTimes, keysPressed));
    }
}
