package mylibrary;

public final class ArrayUtils {
    private ArrayUtils() { }

    public static int sum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }

        int summ = 0;

        for (int number : arr) {
            summ += number;
        }
        return summ;
    }

    public static double average(int[] arr) {
        if (arr == null || arr.length == 0) {
//            throw new IllegalArgumentException(
//                    "Массив не должен быть null или пустым"
//            );
            return 0;
        }
        else {
            double sum = 0;

            for (int number : arr) {
                sum += number;
            }

            return sum / arr.length;
        }

    }

    public static int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }
        int maxx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxx] < arr[i]) {
                maxx = i;
            }
        }
        return maxx;
    }

    public static int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }

        int minn = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[minn] > arr[i]) {
                minn = i;
            }
        }
        return minn;
    }

    public static int[] reverse(int[] arr)  {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }
        int[] arrReverse = new int [arr.length];
        for(int i = 0; i < arr.length; i++) {
            arrReverse[i] = arr[arr.length - i - 1];
        }
        return arrReverse;
    }

    public static boolean contains(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }
        boolean mark = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                mark = true;
                break;
            }
        }
        return mark;
    }

    public static int countEven(int[] arr)  {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] copy(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }
        int[] arrCopy = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }
        int[] arrMerge = new int[a.length + b.length];
        for(int i = 0; i < a.length; i++) {
            arrMerge[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            arrMerge[a.length + i] = b[i];
        }
        return arrMerge;
    }

    public static void print(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть null или пустым"
            );
        }

        for(int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + "-");
            }
        }
        System.out.println("");

    }
}