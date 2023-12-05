import java.util.Arrays;

class Solution {

    private static final int[] RATE = {90, 80, 70, 60};
    private static int EMOTICON_PLUS = 0;
    private static int TOTAL_SALES = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        getPrices(emoticons, users, 0, new int[emoticons.length]);
        return new int[]{EMOTICON_PLUS, TOTAL_SALES};
    }

    private void getPrices(int[] emoticons, int[][] users, int cur, int[] rates) {
        if (cur == emoticons.length) {
            updateAnswer(emoticons, users, rates);
            return;
        }

        for (int rate : RATE) {
            rates[cur] = rate;
            getPrices(emoticons, users, cur + 1, rates);
        }
    }

    private void updateAnswer(int[] emoticons, int[][] users, int[] rates) {

        int ePlus = 0;
        int totalExpense = 0;

        for (int[] user : users) {
            int expense = 0;
            int rate = user[0];
            int price = user[1];
            for (int i = 0; i < rates.length; i++) {
                if (100 - rates[i] >= rate) {
                    expense += emoticons[i] * rates[i] / 100;
                }
                if (expense >= price) {
                    ePlus += 1;
                    expense = 0;
                    break;
                }
            }
            totalExpense += expense;
        }

        if (ePlus > EMOTICON_PLUS) {
            EMOTICON_PLUS = ePlus;
            TOTAL_SALES = totalExpense;
        } else if (ePlus == EMOTICON_PLUS) {
            TOTAL_SALES = Math.max(totalExpense, TOTAL_SALES);
        }
    }


}