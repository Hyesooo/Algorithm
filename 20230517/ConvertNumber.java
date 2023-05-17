//https://school.programmers.co.kr/learn/courses/30/lessons/154538
import java.util.Queue;
import java.util.PriorityQueue;

public class ConvertNumber{
    public int solution(int x, int y, int n) {
        int answer = 0;

        if( x == y ) return answer;

        Queue<Integer> numberQueue = new LinkedList();
        numberQueue.add(y);

        while(!numberQueue.isEmpty()){
            int queueLen = numberQueue.size();
            answer++;

            for(int i =0; i<queueLen;i++){

                int number = numberQueue.poll();

                int numberPlus1 = number - n;
                if(numberPlus1>0 && numberPlus1 > x) numberQueue.add(numberPlus1);
                else if(numberPlus1 == x) return answer;

                int numberMulti2 = number / 2;
                if(number%2==0 && numberMulti2 > x) numberQueue.add(numberMulti2);
                else if(number%2==0 && numberMulti2 == x) return answer;

                int numberMulti3 = number / 3;
                if(number%3==0 && numberMulti3 > x) numberQueue.add(numberMulti3);
                else if(number%3==0 && numberMulti3 == x) return answer;

            }
        }

        return -1;
    }
}