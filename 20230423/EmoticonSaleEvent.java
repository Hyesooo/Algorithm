public class EmoticonSaleEvent{

    private int[] salePrcnt = {10, 20, 30, 40};
    int[][] salePrice;
    int userNum;
    int[] answer={0,0};

    //1012
    public int[] solution(int[][] users, int[] emoticons) {

        userNum = users.length;
        int[] userPriceSum = new int[users.length];

        calcSalePrice(emoticons);
        calcEmoticonSales(0,users, userPriceSum, 0, 0);

        return answer;
    }

    public void calcSalePrice(int[] emoticons){

        int emoticonNum = emoticons.length;

        salePrice = new int[emoticonNum][4];

        for(int emtcnIdx=0;emtcnIdx<emoticonNum;emtcnIdx++){
            for(int prcntIdx=0;prcntIdx<4;prcntIdx++){
                salePrice[emtcnIdx][prcntIdx]
                        = emoticons[emtcnIdx]*(100-salePrcnt[prcntIdx])/100;
            }
        }
    }

    public void calcEmoticonSales(int depth, int[][] users, int[] userPriceSum, int priceSum, int emoticonPlusNum){

        int emoticonNum = salePrice.length;
        if(depth>=emoticonNum){
            if(emoticonPlusNum>answer[0]){
                answer[0] = emoticonPlusNum;
                answer[1] = priceSum;
            }else if(emoticonPlusNum==answer[0] && answer[1] < priceSum){
                answer[1] = priceSum;
            }
            return;
        }else {
            for (int prcntIdx = 0; prcntIdx < 4; prcntIdx++) {
                int priceSumRslt=0;
                int plusNum=0;
                int[] userSumList = new int[userNum];
                for(int userIdx =0; userIdx<userNum; userIdx++) {
                    userSumList[userIdx] = userPriceSum[userIdx];
                    if(users[userIdx][0]<=salePrcnt[prcntIdx]){
                        if(userPriceSum[userIdx]==-1){
                            continue;
                        } else if (userPriceSum[userIdx]+ salePrice[depth][prcntIdx] < users[userIdx][1]) {
                            userSumList[userIdx] += salePrice[depth][prcntIdx];
                            priceSumRslt+=salePrice[depth][prcntIdx];
                        }else {
                            userSumList[userIdx] = -1;
                            priceSumRslt-=userPriceSum[userIdx];
                            plusNum++;
                        }
                    }
                }
                calcEmoticonSales(depth+1,users,userSumList, priceSum+priceSumRslt,emoticonPlusNum+plusNum);
            }
        }
    }
}