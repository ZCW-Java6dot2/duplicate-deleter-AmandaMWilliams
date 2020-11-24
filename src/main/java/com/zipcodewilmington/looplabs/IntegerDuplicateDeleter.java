package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 *
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }
    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] clonedArray = array.clone();
        for (int i = 0; i < clonedArray.length; i++) {
            Integer currentValue = clonedArray[i];
            int numberOfOccurrences = getNumberOfOccurrences(currentValue);
            boolean isToBeDeleted = numberOfOccurrences >= maxNumberOfDuplications;
            if (isToBeDeleted) {
                clonedArray = removeElementAtIndex(clonedArray, i);
            }
        }
        return clonedArray;
    }
    public Integer[] removeElement(Integer[] arrayToBeModified, Integer valueToBeRemoved) {
        int numberOfOccurrences = getNumberOfOccurrences(valueToBeRemoved);
        int newArrayLength = arrayToBeModified.length - numberOfOccurrences;
        Integer[] newArray = new Integer[newArrayLength];
        int newArrayIndex = 0;
        for (int i = 0; i < arrayToBeModified.length; i++) {
            Integer currentValue = arrayToBeModified[i];
            if(!currentValue.equals(valueToBeRemoved)) {
                newArray[newArrayIndex] = currentValue;
            }
        }
        return newArray;
    }
    public Integer[] removeElementAtIndex(Integer[] arrayToBeCloned, int index) {
        Integer[] clonedArray = arrayToBeCloned.clone();
        Integer[] leftArray = Arrays.copyOfRange(clonedArray, 0, index);
        Integer[] rightArray = Arrays.copyOfRange(clonedArray, index + 1, arrayToBeCloned.length);
        Integer[] mergedArray = merge(leftArray,rightArray);
        return mergedArray;
    }
    public Integer[] merge(Integer[] array1, Integer[] array2) {
        Integer[] concate = new Integer[array1.length + array2.length];
        System.arraycopy(array1, 0, concate, 0, array1.length);
        System.arraycopy(array2, 0, concate, array1.length, array2.length);
        return concate;
    }
    private int getNumberOfOccurrences(Integer currentValue) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            Integer integer = array[i];
            if (integer.equals(currentValue)) {
                count++;
            }
        }
        return count;
    }
    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return new Integer[0];
    }
}