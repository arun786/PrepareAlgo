# PrepareAlgo


## To find duplicates in an array, where the values in the array are less than the length of the array

    public List<Integer> findDuplicatesWhenValueIsLessThanSizeOfArray(List<Integer> numbers) {
    
            /**
             *         Iterate the List
             *         Get the value of at index.
             *         get the absolute value of that index.
             *         go to index of that value.
             *         check the sign of the value at that valued index.
             *         If it is positive, change the sign to negative
             *         if it is negative the indexed value has been repeated
             */
    
            List<Integer> duplicates = new ArrayList<>();
    
            for (int i = 0; i < numbers.size(); i++) {
                Integer valueAtThatIndex = numbers.get(i);
                int abs = Math.abs(valueAtThatIndex);
                Integer value = numbers.get(abs);
                if (value > 0) {
                    numbers.set(abs, -value);
                } else {
                    duplicates.add(abs);
                }
            }
    
            return duplicates;
        } 
