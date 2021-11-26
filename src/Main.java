import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "1";
            }
        }

        String[][] array2 = new String[4][5];

        String[][] array3 = new String[4][4];
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                array3[i][j] = "a";
            }
        }
        ArrayList<String[][]> listArray = new ArrayList<>();
        listArray.add(array);
        listArray.add(array2);
        listArray.add(array3);
        for(String [][] ar : listArray){
            try {
                System.out.println(arraySum(ar));
            }catch (MyArraySizeException e){
                System.out.println(e);
                System.out.println("Неверный размер массива!");

            }catch (MyArrayDataException e){
                System.out.println(e);
                System.out.println("Неверный формат!");
            }
        }
    }
    public static int arraySum(String[][] ar){
        int sum = 0;
        checkArray(ar);
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                try{
                    sum+=Integer.parseInt(ar[i][j]);
                }catch (Exception e){
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] лежат неверные данные");
                }
            }
        }
        return sum;

    }
    public static void checkArray(String[][] ar){
        if(ar.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < ar.length; i++) {
            if(ar[i].length != 4) throw new MyArraySizeException();
        }
    }
}
