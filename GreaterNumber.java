import java.util.Arrays;
import java.util.Stack;

public class GreaterNumber {
    //stack - o(2n) and o(n)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        Arrays.fill(result,-1);
        //since we want to do 2 pass 
        for(int i = 0; i < 2*n; i++){ 
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i < n){
                //so only during first pass we push elements 
                st.push(i%n);
            }
            else if(st.peek() == i%n) break; //if we reach the top of the stack like 14, then early stop
        }
        return result;
    }
}
