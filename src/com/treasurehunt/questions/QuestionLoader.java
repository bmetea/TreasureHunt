package com.treasurehunt.questions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class QuestionLoader {

	public static List<QuestionObject> loadGame(String gameName) throws Exception {
		//Get the DOM Builder Factory
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();

		//Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Load and Parse the XML document
		//document contains the complete XML as a Tree.
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(gameName);
		
		Document document = 
				builder.parse(input);

		List<QuestionObject> questionList = new ArrayList<>();

		//Iterating through the nodes and extracting the data.
		NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			//We have encountered an <question> tag.
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				QuestionObject question = new QuestionObject();
				question.id = node.getAttributes().
						getNamedItem("id").getNodeValue();

				NodeList childNodes = node.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = childNodes.item(j);

					//Identifying the child tag of the question encountered. 
					if (cNode instanceof Element) {
						String content = cNode.getLastChild().
								getTextContent().trim();
						switch (cNode.getNodeName()) {
						case "text":
							question.text = content;
							break;
						case "answer":
							question.answer = content;
							break;
						case "hint":
							question.hint = content;
							break;
						case "hothint":
							question.hothint = content;
							break;
						}
					}
				}
				questionList.add(question);
			}

		}
		for (QuestionObject q : questionList) {
		      System.out.println(q);    
		}
		
		return questionList;

	}
}


