public class Utils {
        /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     * @author Ahmad Naween Samandar
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace(String[] in, String[] what, String[] with) {
        String[] out = null;
        boolean valid = true;

        // Check pre-conditions
        if (in == null || what == null || with == null || what.length != with.length) {
            valid = false;
        }

        if (valid) {
            // Step 1: Create a copy of the input array
            out = new String[in.length];

            // Step 2: Copy each element from 'in' into 'out'
            for (int i = 0; i < in.length; i++) {
                String currentWord = in[i];

                // Step 3: Check if the current word needs to be replaced
                boolean replaced = false;
                for (int j = 0; j < what.length; j++) {
                    if (currentWord.equals(what[j])) {
                        out[i] = with[j];
                        replaced = true;
                        break; // Stop searching once a match is found
                    }
                }

                // Keep the original word if no replacement was made
                if (!replaced) {
                    out[i] = currentWord;
                }
            }
        }
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }
}
