package coreDataStructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) throws IOException {
	/*Queue<HtmlTag> corQ = HtmlReader.getTagsFromHtmlFile("correct1.html");
	Stack<HtmlTag> corS = HtmlValidator.isValidHtml(corQ);
	System.out.println(corS);
	
	Queue<HtmlTag> corQ1 = HtmlReader.getTagsFromHtmlFile("TagsWronglyClosed.html");
	Stack<HtmlTag> corS1 = HtmlValidator.isValidHtml(corQ1);
	System.out.println(corS1);

	Queue<HtmlTag> corQ2 = HtmlReader.getTagsFromHtmlFile("ClosingTagWithNoOpeningTag.html");
	Stack<HtmlTag> corS2 = HtmlValidator.isValidHtml(corQ2);
	System.out.println(corS2);
	
	Queue<HtmlTag> corQ3 = HtmlReader.getTagsFromHtmlFile("OpeningTagNeverClosed.html");
	Stack<HtmlTag> corS3 = HtmlValidator.isValidHtml(corQ3);
	System.out.println(corS3);
	
	
	Queue<HtmlTag> corQ4 = HtmlReader.getTagsFromHtmlFile("OnlyClosingTag.html");
	Stack<HtmlTag> corS4 = HtmlValidator.isValidHtml(corQ4);
	System.out.println(corS4);
	*/
	
	String filename = "test1.txt";
	LinkedList<Sentence> ls1 = (LinkedList<Sentence>) Analyzer.readFile(filename);
	ArrayList<Sentence> ls2 = (ArrayList<Sentence>) Analyzer2.readFile(filename);
	
	HashSet<Word> hsw = (HashSet<Word>) Analyzer.allWords(ls1);
	HashSet<Word> hsw2 = (HashSet<Word>) Analyzer2.allWords(ls1);
	System.out.println(hsw.size() + " " + hsw2.size());
	
	for (Word s : hsw)
	    System.out.println(s.text);
	System.out.println();
	
	for (Word s : hsw2)
	    System.out.println(s.text);

    }

}
