package cc.shixw.algorithms;

/**
 * 快速排序
 * @author shixianwei
 * @date 2019/3/6 15:43
 */
public class QuickSort {

    public static void sort(int[] c,int left,int right){
        int i,j,t,temp;

        if (left>right){
            return;
        }
        i = left;
        j = right;
        temp = c[left];
        while (i!=j){
            while (c[j]>=temp && i<j){
                j--;
            }

            while (c[i]<=temp && i<j){
                i++;
            }

            if (i<j){
                t=c[i];
                c[i]=c[j];
                c[j]=t;
            }
        }

        c[left] = c[i];
        c[i] = temp;

        sort(c,left,i-1);
        sort(c,i+1,right);

    }

    public static void main(String[] args) {
        int[] c = {6,7,8,9,1,2,3,4,5,0};
        sort(c,0,c.length-1);

        for (int i : c) {
            System.out.println(i);
        }
    }
}
