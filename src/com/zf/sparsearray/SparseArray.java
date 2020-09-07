package com.zf.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];

        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //输出原始数组
        System.out.println("----------------原始数组----------------");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        //1.遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum = " + sum);

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];

        //3.给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，把非0的值存放到sparseArr中
        int count = 0; //用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];

                }
            }
        }

        //输出稀疏数组
        System.out.println("----------------稀疏数组----------------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.println(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" +sparseArr[i][2]);
        }

        //稀疏数组重构
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("----------------重构后的数组----------------");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }


    }
}
