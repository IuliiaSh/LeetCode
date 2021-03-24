public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] splited = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = splited.length - 1; i >= 0; i--) {
            if (!splited[i].isEmpty()) {
                sb.append(splited[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
