package HuaweiMachineExamPrepare.Medium.HJ16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int count = scanner.nextInt();
        Item[] items = new Item[count];
        ArrayList<Item> mainItems = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Item item = new Item();
            item.setPrice(scanner.nextInt());
            item.setPriority(scanner.nextInt());
            item.setItems(new ArrayList<>());
            item.setRelationIndex(scanner.nextInt());
            items[i] = item;
        }
        for (int i = 0; i < count; i++) {
            if (items[i].getRelationIndex() == 0) {
                mainItems.add(items[i]);
            } else {
                items[items[i].getRelationIndex() - 1].getItems().add(items[i]);
            }
        }

        int mainCount = mainItems.size();
        int[][] dp = new int[mainCount + 1][money + 1];
        for (int i = 1; i <= mainCount; i++) {
            Item currentItem = mainItems.get(i - 1);
            for (int j = 1; j <= money; j++) {
                dp[i][j] = dp[i - 1][j];
                int valueWithOnlyMain = currentItem.getPrice();
                int valueWithSecondaryItemOne = 0;
                int valueWithSecondaryItemTwo = 0;
                int valueWithSecondaryAllItem = 0;
                if (currentItem.getItems().size() >= 1) {
                    valueWithSecondaryItemOne = currentItem.getPrice() + currentItem.getItems().get(0).getPrice();
                }
                if (currentItem.getItems().size() >= 2) {
                    valueWithSecondaryItemTwo = currentItem.getPrice() + currentItem.getItems().get(1).getPrice();
                    valueWithSecondaryAllItem = currentItem.getPrice() + currentItem.getItems().get(0).getPrice() + currentItem.getItems().get(1).getPrice();
                }
                int additionalPrice = 0;
                if (j >= valueWithOnlyMain && valueWithOnlyMain != 0) {
                    additionalPrice = currentItem.getPrice() * currentItem.getPriority();
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - valueWithOnlyMain] + additionalPrice);
                }
                if (j >= valueWithSecondaryItemOne && valueWithSecondaryItemOne != 0) {
                    additionalPrice = currentItem.getPrice() * currentItem.getPriority() + currentItem.getItems().get(0).getPrice() * currentItem.getItems().get(0).getPriority();
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - valueWithSecondaryItemOne] + additionalPrice);
                }
                if (j >= valueWithSecondaryItemTwo && valueWithSecondaryItemTwo != 0) {
                    additionalPrice = currentItem.getPrice() * currentItem.getPriority() + currentItem.getItems().get(1).getPrice() * currentItem.getItems().get(1).getPriority();
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - valueWithSecondaryItemTwo] + additionalPrice);
                }
                if (j >= valueWithSecondaryAllItem && valueWithSecondaryAllItem != 0) {
                    additionalPrice = currentItem.getPrice() * currentItem.getPriority() + currentItem.getItems().get(1).getPrice() * currentItem.getItems().get(1).getPriority() + currentItem.getItems().get(0).getPrice() * currentItem.getItems().get(0).getPriority();
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - valueWithSecondaryAllItem] + additionalPrice);
                }
            }
        }
        System.out.println(mainCount);
        System.out.println(money);
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[mainCount][money]);
    }

    private static class Item {
        private int price;
        private int priority;
        private ArrayList<Item> items;
        private int relationIndex;


        public int getRelationIndex() {
            return relationIndex;
        }

        public void setRelationIndex(int relationIndex) {
            this.relationIndex = relationIndex;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }
    }
}
