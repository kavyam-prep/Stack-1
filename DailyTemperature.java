import java.util.*;

public class DailyTemperature{
    //tc - o(2n) sc- o(n) monotonic increasing stack
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        for(int i =0; i < n;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}