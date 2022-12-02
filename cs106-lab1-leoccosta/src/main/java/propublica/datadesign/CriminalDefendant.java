package propublica.datadesign;

/**
 * @author Leonardo Costa
 * @version February 19, 2020
 * Class that represents a criminal defendent with details about their identity,
 * charge, COMPAS scores, recidivation 
 */
public class CriminalDefendant {
	enum Sex {MALE, FEMALE};
	enum Race {OTHER, CAUCASIAN, AFRICAN_AMERICAN, HISPANIC, NATIVE_AMERICAN, ASIAN};
	enum Orig_Degree {F, M}; // felony or misdemeanor I think
	enum Score {LOW, MEDIUM, HIGH};
	enum Recid_Degree {CO3, F1, F2, F3, F5, F6, F7, M1, M2, MO3, NA};
	
	Sex sex;
	Race race;
	Orig_Degree origDegree;
	String origDescription;
	int decileScore;
	Score scoreText;
	boolean twoYearRecid;
	String recidDescription;
	Recid_Degree recidDegree;
	
	static boolean filter = false;
	
	/**
	 * Contructor that takes inputs where no parsing is necessary
	 */
	public CriminalDefendant(Sex inSex, Race inRace, Orig_Degree inOrigDeg, 
			String inOrigDesc, int inDecScore, Score inScore, boolean in2YrRec, 
			String inRecDesc, Recid_Degree inRecDeg) {
		sex = inSex;
		race = inRace;
		origDegree = inOrigDeg;
		origDescription = inOrigDesc;
		decileScore = inDecScore;
		scoreText = inScore;
		twoYearRecid = in2YrRec;
		recidDescription = inRecDesc;
		recidDegree = inRecDeg;
	}
	
	/**
	 * Contructor that takes the input of a String array
	 * @param row String array that contains all the information we have about
	 * the defendant
	 */
	public CriminalDefendant(String[] row) throws IllegalArgumentException {
		try {
			
			sex = parseSex(row[0]); // sex
			race = parseRace(row[1]); // race
			origDegree = parseOrigDeg(row[2]); // original degree
			origDescription = row[3]; // description of original conviction
			decileScore = parseDecileScore(row[4]); // decile score
			scoreText = parseTextScore(row[5]); // text score
			twoYearRecid = parseBoolean(row[6]); // recidivated?
			
			// description of recidivation
			if (filter) {
				recidDescription = filterRecidDesc(row[7]);
			} else {
				recidDescription = row[7]; 
			}
			
			recidDegree = parseRecidDegree(row[8]); // recidivation degree	
		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * Getter method for race
	 * @return the race
	 */
	public Race race() {
		return race;
	}
	
	
	/**
	 * Getter method for text score
	 * @return the text score
	 */
	public Score getTextScore() {
		return scoreText;
	}
	
	
	/**
	 * Setter method for recidivation
	 * @param b boolean input for recidivation
	 */
	public void setRecid(boolean b) {
		twoYearRecid = b;
	}
	
	
	/**
	 * Setter method for recidivation description
	 * @param s String input for description
	 */
	public void setRecidDesc(String s) {
		recidDescription = s;
	}
	
	/**
	 * Setter method for recidivation degree
	 * @param d enum of type Recid_Degree input
	 * for recidivation degree
	 */
	public void setRecidDeg(Recid_Degree d) {
		recidDegree = d;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Sex: " + sex +
				"\nRace: " + race +
				"\nOriginal offence: " + origDescription + " (" + origDegree + ")" + 
				"\nScore: " + scoreText + " (" + decileScore + ")");
		
		if (twoYearRecid) {
			s.append("\nRecidivation: " + recidDescription + " (" + recidDegree + ")");
		}
		
		return s.toString() + "\n";
	}
	
	
	/**
	 * @return true if the defendant's score is medium or high
	 */
	public boolean highRisk() {
		return scoreText == Score.HIGH || scoreText == Score.MEDIUM;
	}
	
	/**
	 * @return true if the defendant's score is low
	 */
	public boolean lowRisk() {
		return scoreText == Score.LOW;
	}
	
	/**
	 * @return true if the defendant is caucasian
	 */
	public boolean white() {
		return race == Race.CAUCASIAN;
	}
	
	/**
	 * @return true if the defendant is african-american
	 */
	public boolean black() {
		return race == Race.AFRICAN_AMERICAN;
	}
	
	/**
	 * @return true if the defendant has recidivated
	 */
	public boolean recidivated() {
		return twoYearRecid;
	}
	
	
	/**
	 * Converts from String to Sex enum
	 * (our data has only 2 sexes)
	 * @param s a String that holds the input for sex
	 * @return enum of type Sex depending on input
	 */
	public Sex parseSex(String s) {
		if (s.toLowerCase().equals("male")) {
			return Sex.MALE;
		}
		else if (s.toLowerCase().equals("female")) {
			return Sex.FEMALE;
		}
		else {
			throw new IllegalArgumentException("Invalid "
					+ "sex input.");
		}
	}
	
	/** 
	 * Converts from String to Race enum
	 * @param s a String that holds the input for race
	 * @return enum of type Race depending on input
	 */
	public Race parseRace(String s) {
		switch (s.toLowerCase()) {
			case "african-american":
				return Race.AFRICAN_AMERICAN;
			case "caucasian":
				return Race.CAUCASIAN;
			case "hispanic":
				return Race.HISPANIC;
			case "native american":
				return Race.NATIVE_AMERICAN;
			case "asian":
				return Race.ASIAN;
			case "other":
				return Race.OTHER;
			
			default:
				throw new IllegalArgumentException("Invalid "
						+ "race input.");
		}
	}

	/** 
	 * Converts from String to Orig_Degree enum
	 * @param s a String that holds the input for the
	 * degree of the defendant's original conviction
	 * @return enum of type Orig_Degree depending on input
	 */
	public Orig_Degree parseOrigDeg(String s) {
		if (s.toLowerCase().equals("f")) {
			return Orig_Degree.F;
		}
		else if (s.toLowerCase().equals("m")) {
			return Orig_Degree.M;
		}
		else {
			throw new IllegalArgumentException("Invalid original "
					+ "degree input.");
		}
	}
	
	/** 
	 * Converts from String to Recid_Degree enum
	 * @param s a String that holds the input
	 * for the degree of recidivation charge
	 * @return enum of type Recid_Degree depending on input
	 */
	public Recid_Degree parseRecidDegree(String s) {
		
		switch (s.toLowerCase()) {
			case "(f1)": 
				return Recid_Degree.F1;
			case "(f2)":
				return Recid_Degree.F2;
			case "(f3)":
				return Recid_Degree.F3;
			case "(m1)":
				return Recid_Degree.M1;
			case "(m2)":
				return Recid_Degree.M2;
			case "(mo3)":
				return Recid_Degree.MO3;
			case "(f5)":
				return Recid_Degree.F7;
			case "(f6)":
				return Recid_Degree.F6;
			case "(f7)":
				return Recid_Degree.F7;
			case "(co3)":
				return Recid_Degree.CO3;
			case "":
				return Recid_Degree.NA;
//			default: 
//				return Recid_Degree.NA;
			default: 
				throw new IllegalArgumentException("Invalid "
						+ "recidivation degree input.");
//			default:
//				return Recid_Degree.INVALID;
		}
	}
	
	/**
	 * Converts from String to boolean
	 * @param s a String that holds the input;
	 * valid: "0" or "1"
	 * @return true if s is "1"; false if s is "0"
	 */
	public boolean parseBoolean(String s) {
		if (s.equals("0")) {
			return false;
		}
		
		else if (s.equals("1")) {
			return true;
		}
		
		else {
			throw new IllegalArgumentException("Invalid boolean"
					+ " input.");
		}
	}
	
	/**
	 * Converts from String to decile score
	 * @param s a String that holds the input
	 * @return int equivalent if it is between 1 and 10 (inclusive)
	 */
	public int parseDecileScore(String s) {
		if (Integer.parseInt(s) <= 10 && Integer.parseInt(s) >= 0) {
			return Integer.parseInt(s);
		}
		else {
			throw new IllegalArgumentException("Invalid decile "
					+ "score input.");
		}
	}
	
	/** 
	 * Converts from String to enum Score
	 * @param s a String that holds the input
	 * for the defendant's text score
	 * @return enum of type Score depending on input
	 */
	public Score parseTextScore(String s) {
		switch (s.toLowerCase()) {
			case "low": 
				return Score.LOW;
			case "medium":
				return Score.MEDIUM;
			case "high":
				return Score.HIGH;
			default:
				throw new IllegalArgumentException("Invalid text "
						+ "score input.");
		}
	}
	
	/**
	 * Check's if the charge meets certain filters – if it does,
	 * the defendant's additional charge does not count as recidivism
	 * @param s the String being filtered; should be a charge description
	 * @return the inputted String
	 */
	public String filterRecidDesc(String s) {
		if (s.contains("Fail To Obey Police Officer") 
				|| s.contains("W/O Violence")
				|| s.contains("Susp Drivers Lic 1st Offense")
				|| s.contains("Driving License Suspended")
				|| s.contains("Racing On Highway")
				) {
			this.twoYearRecid = false;
		}
		return s;
	}
}