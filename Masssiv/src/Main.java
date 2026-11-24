//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

void main() {
//    int[] numbers; //рекомендуется
//    int numbers2[];

//    int[] numb = {10, 20, 30, 40, 50};
//    System.out.println(numb[0]);
//    numb[2] = 99;
//    System.out.println(numb.length);
//
//    for (int i = 0; i < numb.length; i++) {
//        System.out.println(numb[i]);
//    }
//
//    for (int value : numb) {
//        System.out.println(value);
//    }
//
//    int[][] nums2 = {{0,1,2}, {3,4,5 }};
//    nums2[1][0] = 44;
//    System.out.println(nums2[1][0]);
//
//    for (int i = 0; i < numb.length; i += 2) {
//        System.out.println(numb[i]);
//    }
//
//    for (int i = 0; i < nums2.length; i++) {
//        for (int j = 0; j < nums2[i].length; j++) {
//            System.out.println(nums2[i][j]);
//        }
//        System.out.println();
//    }

    int[] task = { 3, 7, 1, 9, 5};
    int res = 0;
    for (int i = 0; i < task.length; i++) {
        res += task[i];
    }
    System.out.println(res);
}

