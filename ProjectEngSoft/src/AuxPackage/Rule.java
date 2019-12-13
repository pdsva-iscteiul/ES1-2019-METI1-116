package AuxPackage;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;

/**
 * The class rule defines what a rule is in this project
 * @author Filipe
 *
 */
public class Rule {

	private ArrayList<String> rulecomponentes;
	private String name;
	private String TypeOfcomparation;


	/**
	 * @param name is the name of the rule
	 * @param TypeOfcomparation in this project can only be is_long_method or is_feature_envy
	 * @param subrule is a array of subrules that compose a rule
	 */
	public Rule(String name, String TypeOfcomparation,String... subrule) {
		this.name=name;
		rulecomponentes = new ArrayList<String>();
		subrule[0]=subrule[0].replaceFirst(" ", "");
		for (String string : subrule) {
			rulecomponentes.add(string);
		}
		this.TypeOfcomparation=TypeOfcomparation;

		
	}
	/**
	 * @return returns the arrylist of subrules
	 */
	public ArrayList<String> getRulecomponentes(){
		return this.rulecomponentes;
	}

	/**
	 * @return returns the name of the rule
	 */
	public String getName() {
		return name;
	}

	

	/**
	 * @return returns the type of the rule
	 */
	public String getType() {
		return TypeOfcomparation;
	}

	/**
	 * @author Derick Piedade
	 * This function receive a array of boolean and compares it with an array of operators
	 * Example {true,false,true} and {and,or} will return the result of (true && false || true);
	 * @param booleanlist array list of boolean to be compared
	 * @param operatorlist array list of operators to compare the boolean array
	 * @return returns the result of the operation 
	 */
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
	
	
	/**Compares the rule with a row in the excel file
	 * @param r row of the excel file
	 * @return the result of the comparation 
	 */
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
	
	

	/**
	 * This enum was used to now where the column of each metric were 
	 * @author Filipe
	 *
	 */
	private enum Metric{
		LOC(4), 
		CYCLO(5), 
		ATFD(6), 
		LAA(7);

		int column;
		Metric(int column){
			this.column=column;
		}
		
		/**
		 * Returns the column associated with a specific metric 
		 * @return returns the numeric value of a column
		 */
		public int getColumn() {
			return column;
		}

		/**
		 * used to help translating the excel file to the enum
		 * @param s String to be converted to Metric
		 * @return the metric associated with the String
		 */
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
