package com.company.graph;

/**
 * 背包算法
 */
public class Backpack {
    /**
     * 01背包
     * @param capacity    背包容量
     * @param num         物品数量
     * @param weight      物品重量
     * @param value       物品价值
     * @return
     */
    public Double zeroOneBackpack(Integer capacity, Integer num, Integer[] weight, Double[] value) {
        Double[] sum = new Double[capacity + 1];
        for (int i = 0; i < capacity + 1; i++)
            sum[i] = 0d;
        for (int i = 0; i < num; i ++)
            for (int j = capacity; j >=weight[i]; j--)
                sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[i]);

        return sum[capacity];
    }


    /**
     * 完全背包
     * @param capacity    背包容量
     * @param num         物品数量
     * @param weight      物品重量
     * @param value       物品价值
     * @return
     */
    public Double completeBackpack(Integer capacity, Integer num, Integer[] weight, Double[] value) {
        Double[] sum = new Double[capacity + 1];
        for (int i = 0; i < capacity + 1; i++)
            sum[i] = 0d;
        for (int i = 0; i < num; i ++)
            for (int j = weight[i]; j <= capacity; j--)
                sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[i]);

        return sum[capacity];
    }

    /**
     * 多重背包
     * @param capacity      背包容量
     * @param num         物品数量
     * @param singleNum   单个物品数量
     * @param weight      物品重量
     * @param value       物品价值
     * @return
     */
    public Double multipleBackpack(Integer capacity, Integer num, Integer[] singleNum, Integer[] weight, Double[] value) {
        Double[] sum = new Double[capacity + 1];
        for (int i = 0; i < capacity + 1; i++)
            sum[i] = 0d;

        for (int i = 0; i < num; i ++)
            for (int k = 1; k <= singleNum[i]; k++)
                for (int j = weight[i]; j <= capacity; j--)
                    sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[i]);

        return sum[capacity];
    }

    /**
     * 二维01背包
     * @param capacity    背包容量
     * @param withinVolume      背包容积
     * @param num         物品数量
     * @param weight      物品重量
     * @param volume      物品体积
     * @param value       物品价值
     * @return
     */
    public Double towDimZeroOneBackpack(Integer capacity, Integer withinVolume, Integer num,
                                  Integer[] weight, Integer[] volume, Double[] value) {
        Double[][] sum = new Double[capacity + 1][withinVolume + 1];
        for (int i = 0; i < capacity + 1; i++)
            for (int j = 0; j < withinVolume; j++)
                sum[i][j] = 0d;
        for (int i = 0; i < num; i ++)
            for (int j = capacity; j >=weight[i]; j--)
                for (int k = withinVolume; k >= volume[i]; k--)
                    sum[j][k] = Math.max(sum[j][k], sum[j - weight[i]][k - volume[i]] + value[i]);

        return sum[capacity][withinVolume];
    }

    public static void main(String[] args) {
        Integer capacity = 20, withinVolume = 15, num = 5;
        Integer weight[] = {6, 4, 5, 6, 5};
        Integer volume[] = {4, 3, 4, 5, 3};
        Double value[] = {7d, 5d, 6d, 2d, 3d};
        Backpack backpack = new Backpack();
        System.out.println(backpack.zeroOneBackpack(capacity, num, weight, value));
    }
}
