package AuxPackage;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;

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
	
	public boolean compare(Row r) {
		ArrayList<Boolean> result = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < rulecomponentes.size(); i++) {
			if(i%2==0) {
				String[] arrayaux = rulecomponentes.get(i).split(" ");
				Metric metricaux = Metric.StringToMetric(arrayaux[1]);
				Integer number = Integer.parseInt(arrayaux[3]);
				boolean tester = false;
					switch (arrayaux[2]) {
					case "=":
						if(number==Integer.parseInt(r.getCell(metricaux.getColumn()).toString())) {
							tester = true;
						}
						break;
					case ">":
						if(number>Integer.parseInt(r.getCell(metricaux.getColumn()).toString())) {
							tester = true;
						}
						break;
					case "<":
						if(number<Integer.parseInt(r.getCell(metricaux.getColumn()).toString())) {
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
