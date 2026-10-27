class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString=new StringBuilder();
        Iterator it = strs.iterator();
        while (it.hasNext()) {
            String text = (String) it.next();
            encodedString.append("["+text.length()+"]").append(text);
        }
        return encodedString.toString();

    }

    public List<String> decode(String encodedString) {
        
         List<String> strs2 = new ArrayList<>();
        for (int lengthHopper = 0; lengthHopper < encodedString.length(); lengthHopper++) {
    System.out.println("\n--- Loop Start ---");
    System.out.println("Current lengthHopper (loop start): " + lengthHopper);

    int openingBracketIndex = lengthHopper;
    System.out.println("openingBracketIndex: " + openingBracketIndex);

    int closingBracketIndex = encodedString.indexOf(']', lengthHopper);
    System.out.println("closingBracketIndex: " + closingBracketIndex);

    // Parsing the length written inside the brackets
    int textLength = Integer.parseInt(encodedString.substring(openingBracketIndex + 1, closingBracketIndex));
    System.out.println("textLength (parsed): " + textLength);

    // Extracting the actual string segment
    String extractedStr = encodedString.substring(closingBracketIndex + 1, closingBracketIndex + 1 + textLength);
    strs2.add(extractedStr);
    System.out.println("Extracted String added to list: \"" + extractedStr + "\"");

    // Calculate where the next block starts. 
    // Subtracted 1 because lengthHopper++ will increment it right after this block.
    lengthHopper = closingBracketIndex + 1 + textLength - 1; 
    System.out.println("Next lengthHopper (adjusted for loop increment): " + (lengthHopper + 1));
}

        return strs2;

    }
}
