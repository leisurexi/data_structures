package com.leisurexi.datastructures.sortalgorithm.heap;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: leisurexi
 * @date: 2019-12-09 9:32 下午
 * @description: 堆排序示例
 * @since JDK 1.8
 */
@Slf4j
public class HeapSort {

    /**
     * "下沉"调整
     *
     * @param array       待调整的堆
     * @param parentIndex 要"下沉"的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值，则直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            //无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序（升序）
     *
     * @param array 待调整的堆
     */
    public static void heapSort(int[] array) {
        //1.把无序数组构建成最大堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        log.info(Arrays.toString(array));
        //2.循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            //最后1个元素和第1个元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //"下沉"调整最大堆
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(array);
        log.info(Arrays.toString(array));
    }

}
