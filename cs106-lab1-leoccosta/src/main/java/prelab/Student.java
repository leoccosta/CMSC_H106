package prelab;

public class Student {
	String name;
	int age;
	ClassYear classYear;
	Dorm dorm;
	boolean job;
	Dean dean;
	
	enum ClassYear {
		FIRSTYEAR, SOPHOMORE, JUNIOR, SENIOR
		};
	enum Dorm {
		BARCLAY, TRITTON, JONES, GUMMERE, APARTMENTS, LEEDS,
		KIM, LLOYD, QHOUSE, DRINKER, BBC, COMFORT, LUNT
		};
	enum Dean {
		ELIAS, GLANZER, DENNEY, TENSUAN, WILCOX, CUZZOLINA
		};
	
	public Student(String inName, int inAge, ClassYear inYear, Dorm inDorm, boolean inJob, Dean inDean) {
		name = inName;
		age = inAge;
		classYear = inYear;
		dorm = inDorm;
		job = inJob;
		dean = inDean;
	}
	
	public Student(String inName, String inAge, String inYear, String inDorm, String inJob, String inDean) {
		name = inName;
		age = Integer.parseInt(inAge);
		
		inYear = inYear.toLowerCase();
		switch (inYear) {
			case "first year": 
				classYear = ClassYear.FIRSTYEAR;
				break;
			case "sophomore":
				classYear = ClassYear.SOPHOMORE;
				break;
			case "junior":
				classYear = ClassYear.JUNIOR;
				break;
			case "senior": 
				classYear = ClassYear.SENIOR;
		}
		
		inDorm = inDorm.toLowerCase();
		switch (inDorm) {
			case "barclay": 
				dorm = Dorm.BARCLAY;
				break;
			case "tritton":
				dorm = Dorm.TRITTON;
				break;
			case "jones":
				dorm = Dorm.JONES;
				break;
			case "gummere": 
				dorm = Dorm.GUMMERE;
				break;
			case "apartments": 
				dorm = Dorm.APARTMENTS;
				break;
			case "leeds": 
				dorm = Dorm.LEEDS;
				break;
			case "kim": 
				dorm = Dorm.KIM;
				break;
			case "lloyd": 
				dorm = Dorm.LLOYD;
				break;
			case "qhouse": 
				dorm = Dorm.QHOUSE;
				break;
			case "drinker": 
				dorm = Dorm.DRINKER;
				break;
			case "bbc": 
				dorm = Dorm.BBC;
				break;
			case "comfort": 
				dorm = Dorm.COMFORT;
				break;
			case "lunt": 
				dorm = Dorm.LUNT;
		}
		
		job = Boolean.parseBoolean(inJob);
		if (inJob.equals("Yes")) {
			job = true;
		}
		
		if (inJob.equals("No")) {
			job = false;
		}
		
		inDean = inDean.toLowerCase();
		switch (inDean) {
			case "michael elias": 
				dean = Dean.ELIAS;
				break;
			case "katrina glanzer":
				dean = Dean.GLANZER;
				break;
			case "martha denney":
				dean = Dean.DENNEY;
				break;
			case "theresa tensuan": 
				dean = Dean.TENSUAN;
				break;
			case "kelly wilcox": 
				dean = Dean.WILCOX;
				break;
			case "brian cuzzolina": 
				dean = Dean.CUZZOLINA;
		}
		
	}
	
	Student(String[] in) {
		this(in[0], in[1], in[2], in[3], in[4], in[5]);
	}
	
	public String name() {
		return name;
	}
	
	public void altName(String inName) {
		name = inName;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(name + " is " + age + " year old " + classYear + " who lives in " + dorm);
		
		if (job) {
			s.append(", has an on-campus job");
		}
		else {
			s.append(", does not have an on-campus job");
		}
		
		s.append(", and has Dean " + dean + " as a dean.");
		return s.toString();
	}
}
