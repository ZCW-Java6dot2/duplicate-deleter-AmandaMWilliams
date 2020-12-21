package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {

        super(intArray);
    }

    public Integer[] countOccurrences(){
        Integer[] duplicateCount = new Integer[array.length];
        for (int i=0; i<array.length; i++){
            int counter = 1;
            for (int j=0; j<array.length; j++){
                if (i != j){
                    if (array[i].equals(array[j])){
                        counter++;
                    }
                }
            }
            duplicateCount[i] = counter;
        }
        return duplicateCount;
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        int quantityToBeDeleted = 0;
        Integer[] duplicates = countOccurrences();
        for (Integer duplicate : duplicates) {
            if (duplicate >= maxNumberOfDuplications) {
                quantityToBeDeleted++;
            }
        }
        String[] result = new String[array.length - quantityToBeDeleted];
        if (result.length == 0){
            return result;
        }
        int j=0;
        for (int i=0; i < duplicates.length; i++){
            if (duplicates[i] < maxNumberOfDuplications){
                result[j] = array[i];
                j++;
            }
        }
        return result;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {

        int indexToDelete = 0;
        Integer[] duplicates = countOccurrences();
        for (Integer duplicate : duplicates) {
            if (duplicate == exactNumberOfDuplications) {
                indexToDelete++;
            }
        }
        String[] result = new String[array.length-indexToDelete];
        int j=0;
        for (int i=0; i < duplicates.length; i++){
            if (duplicates[i] != exactNumberOfDuplications){
                result[j] = array[i];
                j++;
            }
        }
        return result;
    }
}
