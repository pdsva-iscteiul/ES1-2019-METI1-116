package AuxPackage;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;

public class Rule {

	private ArrayList<String> rulecomponentes;
	private String name;
	private String TypeOfcomparation;


	public Rule(String name, String TypeOfcomparation,String... subrule) {
		this.name=name;
		rulecomponentes = new ArrayList<String>();
		subrule[0]=subrule[0].replaceFirst(" ", "");
		for (String string : subrule) {
			rulecomponentes.add(string);
		}
		this.TypeOfcomparation=TypeOfcomparation;

		
	}
	public ArrayList<String> getRulecomponentes(){
		return this.rulecomponentes;
	}

	public String getName() {
		return name;
	}

	

	public String getType() {
		return TypeOfcomparation;
	}

	private boolean andOr(ArrayList<Boolean> booleanlist,ArrayList<String> operatorlist) {
		boolean result = booleanlist.get(0);
		for (int i = 1; i < booleanlist.size(); i++) {
			if(operatorlist.get(i-1).contains("OR")) {
				result = result || booleanlist.get(i);
			}
			if(operatorlist.get(i-1).contains("AND")) {
				result = result && booleanlist.get(i);
			}
		}
		return result;
	}
	
	public boolean compare(Row r) {
		ArrayList<Boolean> result = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < rulecomponentes.size(); i++) {
			if(i%2==0) {
				String[] arrayaux = rulecomponentes.get(i).split(" ");
				Metric metricaux = Metric.StringToMetric(arrayaux[1]);
				Double number = Double.parseDouble((arrayaux[3]));
				boolean tester = false;
				switch (arrayaux[2]) {
					
					case "=":
						if(( Double.parseDouble(r.getCell(metricaux.getColumn()).toString())==number)) {
							tester = true;
						}
						break;
					case ">":
						if(( Double.parseDouble(r.getCell(metricaux.getColumn()).toString())>number)) {
							tester = true;
						}
						break;
					case "<":
						if(( Double.parseDouble(r.getCell(metricaux.getColumn()).toString())<number)) {
							tester = true;
						}
						break;

					default:
						break;
					
				}
					result.add(tester);
			}if(i%2==1) {
				if(rulecomponentes.get(i).contains("OR")){
					aux.add("OR");
				}else {
					aux.add("AND");
				}
			}

		}
		return andOr(result,aux);

	}
	
	

	private enum Metric{
		LOC(4), 
		CYCLO(5), 
		ATFD(6), 
		LAA(7);

		int column;
		Metric(int column){
			this.column=column;
		}
		
		public int getColumn() {
			return column;
		}

		static public Metric StringToMetric(String s) {
			switch (s) {
			case "LOC":
				return LOC;
			case "CYCLO":
				return CYCLO;
			case "ATFD":
				return ATFD;
			case "LAA":
				return LAA;
			default:
				break;
			}
			return null;
		}
	}
	
}
