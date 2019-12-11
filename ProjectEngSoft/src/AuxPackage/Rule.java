package AuxPackage;

import java.util.ArrayList;

public class Rule {

	private ArrayList<String> rulecomponentes;
	private String name;
	private boolean feature_envy;
	private boolean long_method;


	public Rule(String name, boolean long_method,boolean feature_envy,String... subrule) {
		this.name=name;
		rulecomponentes = new ArrayList<String>();
		for (String string : subrule) {
			rulecomponentes.add(string);
		}
		this.feature_envy=feature_envy;
		this.long_method=long_method;
		//DEBUG
		System.out.println(name +"   "+rulecomponentes.toString()+" " +long_method + " " + feature_envy);
	}
	public ArrayList<String> getRulecomponentes(){
		return this.rulecomponentes;
	}

	public String getName() {
		return name;
	}

	public boolean isfeture_envy() {
		return feature_envy;
	}

	public boolean isLong_method() {
		return long_method;
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
	
	public boolean compare(String metric ,int intToCompare, boolean long_method, boolean feture_envy) {
		ArrayList<Boolean> result = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < rulecomponentes.size(); i++) {
			if(i%2==0) {
				String[] arrayaux = rulecomponentes.get(i).split(" ");
				Metric metricaux = Metric.StringToMetric(arrayaux[1]);
				Integer number = Integer.parseInt(arrayaux[3]);
				Metric metricChosen = Metric.StringToMetric(metric);
				if(metricChosen==metricaux) {
					switch (arrayaux[2]) {
					case "=":
						
						break;
					case ">":

						break;
					case "<":

						break;

					default:
						break;
					}
				}
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
		LOC, 
		CYCLO, 
		ATFD, 
		LAA;

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
	//	public class MetricToCompare{
	//		private int integer;
	//		private Metric metric;
	//		
	//		public MetricToCompare(int i, Metric m) {
	//			this.integer = i;
	//			this.metric = m;
	//		}
	//
	//		public int getInteger() {
	//			return integer;
	//		}
	//
	//		public void setInteger(int integer) {
	//			this.integer = integer;
	//		}
	//
	//		public Metric getMetric() {
	//			return metric;
	//		}
	//
	//		public void setMetric(Metric metric) {
	//			this.metric = metric;
	//		}
	//		
	//	}

}
