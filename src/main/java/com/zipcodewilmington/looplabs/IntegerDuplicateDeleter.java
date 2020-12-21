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

    public Integer[] countOccurrences() {
        Integer[] duplicateCount = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            int counter = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i].equals(array[j])) {
                        counter++;
                    }
                }
            }
            duplicateCount[i] = counter;
        }
        return duplicateCount;
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        int quantityToBeDeleted = 0;
        Integer[] duplicates = countOccurrences();
        for (Integer duplicate : duplicates) {
            if (duplicate >= maxNumberOfDuplications) {
                quantityToBeDeleted++;
            }
        }
        Integer[] result = new Integer[array.length - quantityToBeDeleted];
        if (result.length == 0) return result;
        int j = 0;
        for (int i = 0; i < duplicates.length; i++) {
            if (duplicates[i] < maxNumberOfDuplications) {
                result[j] = array[i];
                j++;
            }
        }
        return result;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int indexToDelete = 0;
        Integer[] duplicates = countOccurrences();
        for (Integer duplicate : duplicates) {
            if (duplicate == exactNumberOfDuplications) {
                indexToDelete++;
            }
        }
        Integer[] result = new Integer[array.length - indexToDelete];
        int j = 0;
        for (int i = 0; i < duplicates.length; i++) {
            if (duplicates[i] != exactNumberOfDuplications) {
                result[j] = array[i];
                j++;
            }
        }
        return result;
    }
}
