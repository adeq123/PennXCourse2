package coreDataStructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static final String[] partToSkip = {"\\.", "\\,", "'s", "\\!"};
    public static List<Sentence> readFile(String filename) {
	if(filename != null){

	    LinkedList<Sentence> sentenceList = new LinkedList<Sentence> ();
	    FileReader fr;
	    String line;
	    int scoreVal;
	    String sentence;
	    try {
		fr = new FileReader(filename);
	    } catch (FileNotFoundException e) {
		return new LinkedList<Sentence> ();
	    }

	    BufferedReader rd = new BufferedReader(fr);
	    try {
		while((line = rd.readLine()) != null){
		    try{
			if(!line.equals("")){
			    scoreVal = Integer.parseInt(line.split(" ", 2)[0]);
			    sentence  = line.split(" ", 2)[1];
			    if(scoreVal >= -2 && scoreVal <= 2 && (line.substring(1, 2).equals(" ") || line.substring(2, 3).equals(" ")))
				sentenceList.add(new Sentence(scoreVal, sentence));
			}
		    }catch(NumberFormatException | ArrayIndexOutOfBoundsException j){

		    }
		}
		rd.close();
	    } catch (IOException e) {

		return new LinkedList<Sentence> ();
	    }

	    return sentenceList; // this line is here only so this code will compile if you don't modify it
	}else{
	    return new LinkedList<Sentence> ();
	}

    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {
	LinkedList <Word> wordList = new LinkedList<Word>();
	if(sentences != null && !sentences.isEmpty()){
	    StringTokenizer st;
	    String singleLine;

	    for(Sentence s : sentences){
		if(s != null && !s.text.equals("")){
		    singleLine = s.text;
		    singleLine = singleLine.toLowerCase();
		    Word wr;
		    String wordS = "";
		    for(String toReplace : partToSkip)
			singleLine = singleLine.replaceAll(toReplace, "");
		    st = new StringTokenizer(singleLine);
		    //if(st.hasMoreTokens()) wordS = st.nextToken();
		    while(st.countTokens() > 0){
			wordS = st.nextToken();
			if(Character.isLetter(wordS.charAt(0))){
			    wr = new Word(wordS);
			    if(wordList.contains(wr)){
				wordList.get(wordList.indexOf(wr)).increaseTotal(s.score);
			    }else{
				wr.increaseTotal(s.score);
				wordList.add(wr);
			    }
			    //wordS = st.nextToken();
			}
		    }
		}

	    }
	}
	return new HashSet<Word>(wordList); // this line is here only so this code will compile if you don't modify it

    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
	HashMap<String, Double> mappedWords = new HashMap<String, Double>();
	if(words != null && !words.isEmpty()){
	    for(Word singleWord : words)
		if(singleWord != null)
		    mappedWords.put(singleWord.getText(), singleWord.calculateScore());
	}
	return mappedWords; // this line is here only so this code will compile if you don't modify it

    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
	double sentenceScore = 0;
	int wordCount = 0;
	int sentenceValue = 0;
	String oneWord = "";
	if(wordScores != null && !wordScores.isEmpty() && sentence != null && !sentence.isEmpty()){
	    StringTokenizer st;
	    st = new StringTokenizer(sentence);
	    while(st.hasMoreTokens() && (oneWord = st.nextToken()) != null){	 
		wordCount ++;
		oneWord = oneWord.toLowerCase();
		if(wordScores.containsKey(oneWord))
		    sentenceValue += wordScores.get(oneWord);
	    }
	    sentenceScore = sentenceValue / ((double) wordCount);
	}
	return sentenceScore; // this line is here only so this code will compile if you don't modify it

    }

    /*
     * This method is here to help you run your program. Y
     * You may modify it as needed.
     */
    public static void main(String[] args) {

	String filename = "testSentences.txt";
	System.out.print("Please enter a sentence: ");
	Scanner in = new Scanner(System.in);
	String sentence = in.nextLine();
	in.close();
	List<Sentence> sentences = Analyzer.readFile(filename);
	Set<Word> words = Analyzer.allWords(sentences);
	Map<String, Double> wordScores = Analyzer.calculateScores(words);
	double score = Analyzer.calculateSentenceScore(wordScores, sentence);
	System.out.println("The sentiment score is " + score);
    }
}
