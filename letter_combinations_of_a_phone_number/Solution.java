public class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList();
      if (digits == "") {
        return result;
      }
      String[] keyMappings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      int sizeCombination = 1;
      int lengthCombination = 0; // Like decimal
      for (int i = 0; i < length; i++) {
        int stringLength = keyMappings[digits.charAt(i) - '0'].length();
        sizeCombination *= stringLength;
        if (stringLength > lengthCombination) {
          lengthCombination = stringLength;
        }
      }
      int[] indexCombination = new int[lengthCombination];
      for (int i = 0; i < sizeCombination; i++) {
        char[] combination = new char[lengthCombination];
        for (int j = 0; j < lengthCombination; j++) {
          String keyMapping = keyMappings[digits.charAt(j) - '0'];
          if (indexCombination[j] >= keyMapping.length()) {
            break;
          }
          combination[j] = keyMapping.charAt(indexCombination[j]);
        }
        // The lowest digit +1
        indexCombination[indexCombination.size() - 1]++;
        // check the digit carry
        boolean carry = false;
        for (int k = indexCombination - 1; k >= 0; k--) {
          if (carry) {
            indexCombination[k]++;
          }
          if (indexCombination[k] >= lengthCombination) {
            indexCombination[k] = 0;
            carry = true;
          } else {
            carry = false;
          }
        }
      }
      return result;
    }
    // public List<String> letterCombinations(String digits) {
    //   LinkedList<String> result = new LinkedList();
    //   if (digits == "") {
    //     return result;
    //   }
    //   String[] keyMappings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //   result.addLast("");
    //   for(int i = 0; i < digits.length(); i++) {
    //     String mappings = keyMappings[digits.charAt(i) - '0'];
    //     int times = result.size();
    //     while(times-- > 0) {
    //       String target = result.remove();
    //       for(int j = 0; j < mappings.length(); j++) {
    //         result.addLast(target + mappings.charAt(j));
    //       }
    //     }
    //   }
    //   if (result.get(0) == "") {
    //     result.remove(0);
    //   }
    //   return result;
    // }
}
