//https://school.programmers.co.kr/learn/courses/30/lessons/178870

//+18
public class ContinuitySequenceSum {

        public int[] solution(int[] sequence, int k) {

            int seqLen = sequence.length;
            int seqSum = 0;

            int[] answer = {0,seqLen-1};
            int[] curIdx = {0,0};

            for(int idx=0; idx<seqLen; idx++){
                curIdx[1] = idx;
                seqSum+=sequence[idx];

                if(seqSum > k){
                    while(seqSum>k){
                        seqSum-=sequence[curIdx[0]++];
                    }
                }

                if(seqSum == k){
                    chkAns(answer, curIdx);
                }
            }

            return this.answer;
        }

        void chkAns(int[] answer,int[] curIdx){
            int curDiff = curIdx[1] - curIdx[0];
            int ansDiff = answer[1] - answer[0];

            //최근 차이가 answer보다 작을 때만 교체
            if(curDiff<ansDiff){
                answer[0] = curIdx[0];
                answer[1] = curIdx[1];
            }
        }

}