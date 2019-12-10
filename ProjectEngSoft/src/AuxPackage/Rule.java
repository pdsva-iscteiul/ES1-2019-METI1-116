package AuxPackage;

import java.util.ArrayList;

public class Rule {
	
	private ArrayList<String> rulecomponentes;
	private String name;
	

	public Rule(String name, String... subrule) {
		this.name=name;
		rulecomponentes = new ArrayList<String>();
		for (String string : subrule) {
			rulecomponentes.add(string);
		}
	}
	public ArrayList<String> getRulecomponentes(){
		return this.rulecomponentes;
	}
	
	public String getName() {
		return name;
	}
	
	 
}
