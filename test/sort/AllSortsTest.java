package sort;/*
 * Date: 06.09.13 13:27
 * Author: ivan.bendyna
 */

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

//TODO: test stability of some sorts
//TODO: time tests
//TODO: tests for arrays with the same element
//TODO: tests for arrays with 2 different element
public class AllSortsTest {

    private final static int COUNT_RANDOM_TESTS = 1000;
    private final static int LENGTH_RANDOM_TESTS = 1000;

    @Test
    public void testAll() throws Exception {
        Sort[] sorts = new Sort[]{new MergeSort(), new QuickSort()};
        for(Sort sort : sorts){
            testSort(sort);
        }
    }

    private void testSort(Sort sort) throws Exception {
        testEmpty(sort);
        testRandomLongArrays(sort);
        testRandomIntArrays(sort);
        testRandomCharArrays(sort);
        testRandomShortArrays(sort);
        testRandomByteArrays(sort);
        testRandomFloatArrays(sort);
        testRandomDoubleArrays(sort);
        testRandomObjectArrays(sort);
    }

    private void testEmpty(Sort sort) throws Exception {
        //test for exceptions
        sort.sort(new int[]{});
    }

    private void testRandomLongArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            long[] array = generateLongArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private void testRandomIntArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            int[] array = generateIntArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private void testRandomCharArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            char[] array = generateCharArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private void testRandomByteArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            byte[] array = generateByteArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private void testRandomShortArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            short[] array = generateShortArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private void testRandomDoubleArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            double[] array = generateDoubleArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private void testRandomFloatArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            float[] array = generateFloatArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private void testRandomObjectArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            String[] array = generateStringArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private long[] generateLongArray(Random rand){
        long[] array = new long[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = rand.nextLong();
        }
        return array;
    }

    private int[] generateIntArray(Random rand){
        int[] array = new int[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = rand.nextInt();
        }
        return array;
    }

    private char[] generateCharArray(Random rand){
        char[] array = new char[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = (char) rand.nextInt();
        }
        return array;
    }

    private short[] generateShortArray(Random rand){
        short[] array = new short[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = (short) rand.nextInt();
        }
        return array;
    }

    private byte[] generateByteArray(Random rand){
        byte[] array = new byte[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = (byte) rand.nextInt();
        }
        return array;
    }

    private double[] generateDoubleArray(Random rand){
        double[] array = new double[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = rand.nextDouble();
        }
        return array;
    }

    private float[] generateFloatArray(Random rand){
        float[] array = new float[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = rand.nextFloat();
        }
        return array;
    }

    private String[] generateStringArray(Random rand){
        String[] array = new String[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            byte[] chars = new byte[rand.nextInt(10) + 5];
            for(int i = 0; i < chars.length; i++){
                chars[i] = (byte) ('A' + rand.nextInt('z' - 'A'));
            }
            array[j] = new String(chars);
        }
        return array;
    }

    private boolean checkArray(long[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    private boolean checkArray(int[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    private boolean checkArray(char[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    private boolean checkArray(short[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    private boolean checkArray(byte[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    private boolean checkArray(double[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    private boolean checkArray(float[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    private boolean checkArray(String[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i].equals(array[i + 1])) {
                continue;
            }
            if((array[i].compareTo(array[i + 1]) < 0) ^ ascending ){
                return false;
            }
        }
        return true;
    }

}
