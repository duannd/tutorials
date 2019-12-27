package com.duannd.core.regex;

public class CommonMatchingSymbolsTest {

    public static void main(String[] args) {
        // . Matches any single character
        matchesAnySingleCharacter();
        // ^xxx	Matches xxx regex at the beginning of the line
        matchesAtBeginningOfLine();
        // xxx$	Matches regex xxx at the end of the line
        matchesAtTheEndOfLine();
        // [abc] Can match any of the letter a, b or c. [] are known as character classes.
        matchesAnyLetterInCharacterClasses();
        // [abc][12] Can match a, b or c followed by 1 or 2
        canMatchesAndFollowByOthers();
        // [^abc] When ^ is the first character in [], it negates the pattern, matches anything except a, b or c
        negateMatcher();
        // [a-e1-8]	Matches ranges between a to e or 1 to 8
        matchesRanges();
        // xx|yy	Matches regex xx or yy
        matchesRegexOr();
    }

    private static void matchesRegexOr() {
        String regex = "aa|b."; // required 2 chars. 'aa' or 'b' + any char.
        print("Matches regex 'xx' or 'b.'", regex, "aa"); // true
        print("Matches regex 'xx' or 'b.'", regex, "b0"); // true
        print("Matches regex 'xx' or 'b.'", regex, "ba"); // true
        print("Matches regex 'xx' or 'b.'", regex, "ab"); // false
        print("Matches regex 'xx' or 'b.'", regex, "cb"); // false
        print("Matches regex 'xx' or 'b.'", regex, "a"); // false
        print("Matches regex 'xx' or 'b.'", regex, "aab"); // false
    }

    private static void matchesRanges() {
        String regex = "[1-5a-c]d."; // required 3 chars: 1st in [1,2,3,4,5,a,b,c], 2nd is 'd', 3th is any char.
        print("Matches ranges between 1 to 5 or a to c", regex, "1d@"); // true
        print("Matches ranges between 1 to 5 or a to c", regex, "cd9"); // true
        print("Matches ranges between 1 to 5 or a to c", regex, "6d."); // false
        print("Matches ranges between 1 to 5 or a to c", regex, "ddd"); // false
        print("Matches ranges between 1 to 5 or a to c", regex, "1ee"); // false
        print("Matches ranges between 1 to 5 or a to c", regex, "1d"); // false
        print("Matches ranges between 1 to 5 or a to c", regex, "1def"); // false
    }

    private static void negateMatcher() {
        String regex = "[^xyz]ab"; // string required 3 char & first char not in [x,y,z] and 2nd, 3th are 'ab'
        print("it negates the pattern, matches anything except x, y or z", regex, "aab"); // true
        print("it negates the pattern, matches anything except x, y or z", regex, "0ab"); // true
        print("it negates the pattern, matches anything except x, y or z", regex, "xab"); // false
        print("it negates the pattern, matches anything except x, y or z", regex, "yab"); // false
        print("it negates the pattern, matches anything except x, y or z", regex, "zab"); // false
        print("it negates the pattern, matches anything except x, y or z", regex, "0aa"); // false
        print("it negates the pattern, matches anything except x, y or z", regex, "0cd"); // false
    }

    private static void canMatchesAndFollowByOthers() {
        String regex = "[abc][12]"; // string required length = 2 & in [abc] and [12]
        print("Can match a, b or c followed by 1 or 2", regex, "a1"); // true
        print("Can match a, b or c followed by 1 or 2", regex, "b2"); // true
        print("Can match a, b or c followed by 1 or 2", regex, "c3"); // false
        print("Can match a, b or c followed by 1 or 2", regex, "d3"); // false
        print("Can match a, b or c followed by 1 or 2", regex, "ab1"); // false
        print("Can match a, b or c followed by 1 or 2", regex, "a1b"); // false
    }

    private static void matchesAnyLetterInCharacterClasses() {
        print("Can match any of the letter x, y or z", "^[xyz]abc", "xabc"); // true
        print("Can match any of the letter x, y or z", "^[xyz]abc", "aabc"); // false
        print("Can match any of the letter x, y or z", "^[xyz]abc", "yabc"); // true
        print("Can match any of the letter x, y or z", "^[xyz]abc", "zab"); // true
    }

    private static void matchesAtTheEndOfLine() {
        String regex = "..cd$";
        print("Matches regex xxx at the end of the line", regex, "xycd"); // true
        print("Matches regex xxx at the end of the line", regex, "10cd"); // true
        print("Matches regex xxx at the end of the line", regex, "acd"); // false
        print("Matches regex xxx at the end of the line", regex, "cd00"); // false
    }

    private static void matchesAtBeginningOfLine() {
        print("Matches xxx regex at the beginning of the line", "^a.b", "acb"); // true
        print("Matches xxx regex at the beginning of the line", "^a.b", "abc"); // false
        print("Matches xxx regex at the beginning of the line", "^a.b", "acbc"); // false
    }

    private static void matchesAnySingleCharacter() {
        print("Matches any single character", ".", "a"); // true
        print("Matches any single character", ".", "aa"); // false
    }

    static void print(String description, String regex, String str) {
        String message = String.format("%s: '%s' matches '%s'? %s", description, regex, str, str.matches(regex));
        System.out.println(message);
    }


}
