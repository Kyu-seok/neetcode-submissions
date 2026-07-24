class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueNames = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();

            int i = 0;

            while (email.charAt(i) != '@' && email.charAt(i) != '+') {
                if (email.charAt(i) != '.') {
                    sb.append(email.charAt(i));
                }
                i++;
            }

            while (email.charAt(i) != '@') {
                i++;
            }

            sb.append(email.substring(i, email.length()));

            uniqueNames.add(sb.toString());
        }

        return uniqueNames.size();
    }
}