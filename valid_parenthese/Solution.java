public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('(', ')');
        mapping.put('[', ']');
        mapping.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
          char symbole = s.charAt(i);
          if (symbole == '(' || symbole == '[' || symbole == '{') {
            stack.push(symbole);
          } else if (symbole == ')' || symbole == ']' || symbole == '}') {
            if (stack.isEmpty() || mapping.get(stack.pop()) != symbole) {
              return false;
            }
          }
        }
        return stack.isEmpty();
    }
}
