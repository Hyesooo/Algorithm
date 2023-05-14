// https://school.programmers.co.kr/learn/courses/30/lessons/154539
import java.util.Stack;

public class FindBigNumber {

    public int[] solution(int[] numbers) {

        int numbersLen= numbers.length;
        int[] answer = new int[numbersLen];

        Stack<Integer> indexStack = new Stack();

        for(int idx=numbersLen-1; idx>=0; idx--){
            answer[idx] = -1;

            while(!indexStack.isEmpty()){
                if (indexStack.peek()>numbers[idx]) {
                    answer[idx] = indexStack.peek();
                    break;
                }

                indexStack.pop();
            }

            indexStack.add(numbers[idx]);
        }

        return answer;
    }

}