package com.treasurehunt.questions;

public class QuestionObject {
	
	String id, text, answer, hint, hothint;


	 public String getId() {
		return id;
	}


	public String getText() {
		return text;
	}


	public String getAnswer() {
		return answer;
	}


	public String getHint() {
		return hint;
	}


	public String getHothint() {
		return hothint;
	}


	@Override
	  public String toString() {
		 String questionObject = text+"\n"+answer+"\n"+hint+"\n"+hothint;
	    return questionObject;
	  }
	
	

}
