package coreDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
	if(!tags.isEmpty()){
	    Stack<HtmlTag> openingTags = new Stack<HtmlTag>();
	    Queue<HtmlTag> closingTags = new LinkedList<HtmlTag>();

	    HtmlTag oneTag = tags.poll();
	    while(oneTag != null){
		if(oneTag.isOpenTag()){
		    openingTags.push(oneTag);
		}else if(oneTag.isSelfClosing()){
		    //do nothing
		}else{//is closing - validate
		    if(openingTags.isEmpty()){
			return null;
		    }else{
			if(!oneTag.matches(openingTags.peek())){
			    return openingTags;
			}else{
			    openingTags.pop();
			}
		    }
		}
		oneTag = tags.poll();
	    }


	    return openingTags; // this line is here only so this code will compile if you don't modify it

	}else{
	    return null;
	}
    }

}

