package com.kodilla.stream.beautifier;

public class StreamMainBeautifier {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("HelloWorld", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("HelloWorld", text -> text.toUpperCase());
        poemBeautifier.beautify("HelloWorld", text -> text.toLowerCase());
        poemBeautifier.beautify("HelloWorld", text -> text.replaceAll("l", "@"));
    }
}
