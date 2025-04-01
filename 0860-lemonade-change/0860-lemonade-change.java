class Solution { // tc is O(n) and sc is O(1)
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for(int bill:bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){// bill $10
                if(five == 0) return false;
                five--;
                ten++;
            }else{// bill $20
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}