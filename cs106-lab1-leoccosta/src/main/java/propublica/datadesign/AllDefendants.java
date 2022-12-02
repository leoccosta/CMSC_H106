package propublica.datadesign;
import java.util.ArrayList;

/**
 * Holds all the defendants' data
 * @author Leonardo Costa
 * @version February 19, 2020
 */
public class AllDefendants {

		ArrayList<CriminalDefendant> defendantList = new ArrayList<CriminalDefendant>();
		
		public AllDefendants(ArrayList<String[]> in) {
			for (String[] defendant : in) {
				CriminalDefendant d = new CriminalDefendant(defendant);
				defendantList.add(d);
			}
		}
		
		@Override
		public String toString() { 
			StringBuilder s = new StringBuilder();
			for (CriminalDefendant d : defendantList) {
				s.append(d.toString() + "\n");
			}
			return s.toString();
		} 
		
		/**
		 * Goes through array of defendants and returns the amount of 
		 * white defendants that ended up being false positives
		 * @return percent of white defendants labeled high risk that
		 * did not reoffend
		 */
		public double whiteFP() {
			double numFP = 0;
			double numWhiteHR = 0;
			
			for (int i = 0; i < defendantList.size(); i++) {
				CriminalDefendant curr = defendantList.get(i);
				
				if (curr.white() && curr.highRisk()) {
					numWhiteHR++;
					if (!curr.recidivated()) {
						numFP++;
					}
				}
			}
			
			return numFP / numWhiteHR;
		}
		
		/**
		 * Goes through array of defendants and returns the amount of 
		 * black defendants that ended up being false positives
		 * @return percent of black defendants labeled high risk that
		 * did not reoffend
		 */
		public double blackFP() {
			double numFP = 0;
			double numBlackHR = 0;
			
			for (int i = 0; i < defendantList.size(); i++) {
				CriminalDefendant curr = defendantList.get(i);
				
				if (curr.black() && curr.highRisk()) {
					numBlackHR++;
					if (!curr.recidivated()) {
						numFP++;
					}
				}
			}
			
			return numFP / numBlackHR;
		}
		
		/**
		 * Goes through array of defendants and returns the amount of 
		 * white defendants that ended up being false negatives
		 * @return percent of white defendants labeled low risk that
		 * did reoffend
		 */
		public double whiteFN() {
			double numFNs = 0;
			double numWhite = 0;
			
			for (int i = 0; i < defendantList.size(); i++) {
				CriminalDefendant curr = defendantList.get(i);
				
				if (curr.white() && curr.lowRisk()) {
					if (curr.recidivated()) {
						numFNs++;
					} 
					numWhite++;
				}
			}
			
			return numFNs / numWhite;
		}
		
		/**
		 * Goes through array of defendants and returns the amount of 
		 * black defendants that ended up being false negatives
		 * @return percent of black defendants labeled low risk that
		 * did reoffend
		 */
		public double blackFN() {
			double numFNs = 0;
			double numBlack = 0;
			
			for (int i = 0; i < defendantList.size(); i++) {
				CriminalDefendant curr = defendantList.get(i);
				
				if (curr.black() && curr.lowRisk()) {
					if (curr.recidivated()) {
						numFNs++;
					} 
					numBlack++;
				}
			}
			
			return numFNs / numBlack;
		}
		
		/**
		 * Getter method for the amount of defendants in the class
		 * @return size of the class' ArrayList defendantList
		 */
		public int size() {
			return defendantList.size();
		}
		
}
