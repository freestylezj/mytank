package test.DesignPatters.Strategy;

/**
 * @Auther: zhongj
 * @Date: 2021/8/6 - 08 - 06 - 23:47
 * @Description: test.DesignPatters.Strategy
 * @version: 1.0
 */
public class Sorter<T> {

    public void sort(T[] arr,Comparator<T> comparator){
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = comparator.compareTo(arr[minPos],arr[j])>0?j:minPos;
            }
            swap(arr, i, minPos);
        }
    }

    private void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
