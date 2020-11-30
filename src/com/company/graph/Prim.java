package com.company.graph;

/**
 * prim算法
 */
public class Prim {
    /**
     * prim算法
     * @param data   费用信息
     * @param num    节点数量
     * @return       -1为不可全部连接
     */
    public Double prim(Double[][] data, Integer num){
        Boolean[] judgmentVisit = new Boolean[num + 1];
        judgmentVisit[1] = true;
        Double sum = 0d;
        Double[] record = new Double[num + 1];
        for (int i = 2; i < num + 1; i++) {
            record[i] = data[1][i];
        }
        int compareKey;
        Double compareVal;
        for (int i = 2; i < num + 1; i++) {
            compareKey = 1;
            compareVal = null;
            for (int j = 2; j < num + 1; j++) {
                if(judgmentVisit[j] != true && (compareVal == null || compareVal > record[j])) {
                    compareVal = record[j];
                    compareKey = j;
                }
            }
            //没有找到路了，跳出不可连接
            if(compareVal == null)
                return -1d;

            judgmentVisit[compareKey] = true;
            sum += compareVal;
            //更新
            for (int j = 2; j < num + 1; j++ ) {
                if(j != compareKey && record[j] > data[compareKey][j]) {
                    record[j] = data[compareKey][j];
                }
            }
        }
        return sum;
    }
}
