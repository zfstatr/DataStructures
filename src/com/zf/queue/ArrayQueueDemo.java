package com.zf.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {

        ArrayQuene arrayQuene = new ArrayQuene(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据");
            System.out.println("g(get)：取数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("e(exit)：退出程序");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    arrayQuene.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    arrayQuene.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQuene.getqueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQuene.headQueue();
                        System.out.printf("取出的数据是%d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序已退出");
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQuene{
    private int maxSize; //数组最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数据

    //创建队列的构造器
    public ArrayQuene(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; //指向队列尾部，指向队列尾的数据（队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列已满，加入数据失败");
            return;
        }
        rear++; //rear后移
        arr[rear] = n;

    }

    //获取数据，出队列
    public int getqueue(){
        //判断是否空
        if (isEmpty()){
            //通过抛异常来处理
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue(){
        //判断是否空
        if (isEmpty()){
            //通过抛异常来处理
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front + 1];
    }
}
