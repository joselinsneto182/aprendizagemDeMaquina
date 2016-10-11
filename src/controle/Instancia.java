package controle;

public class Instancia {
	
	String age;
	String workclass;
	String fnlwgt;
	String education;
	String educationNum;
	String maritalStatus;
	String occupation;
	String relationship;
	String race;
	String sex;
	String capitalGain;
	String capitalLoss;
	String hoursPerWeek;
	String nativeCountry;
	String classe;

	
	public Instancia(String age,
					 String workclass,
					 String fnlwgt,
					 String education,
					 String educationNum,
					 String maritalStatus,
					 String occupation,
					 String relationship,
					 String race,
					 String sex,
					 String capitalGain,
					 String capitalLoss,
					 String hoursPerWeek,
					 String atributoNativeCountry,
					 String atributoClasse){
		
		this.age = age;
		this.workclass = workclass;
		this.fnlwgt = fnlwgt;
		this.education = education;
		this.educationNum = educationNum;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.relationship = relationship;
		this.race = race;
		this.sex = sex;
		this.capitalGain = capitalGain;
		this.capitalLoss = capitalLoss;
		this.hoursPerWeek = hoursPerWeek;
		this.nativeCountry = atributoNativeCountry;
		this.classe = atributoClasse;
		
	}
	
	public String getAtributo(int valor){
		String nome;
		
		switch(valor){
			case 0 : nome = age+""; break;
			case 1 : nome = workclass+""; break;
			case 2 : nome = fnlwgt+""; break;
			case 3 : nome = education+""; break;
			case 4 : nome = educationNum+""; break;
			case 5 : nome = maritalStatus+""; break;
			case 6 : nome = occupation+""; break;
			case 7 : nome = relationship+""; break;
			case 8 : nome = race+""; break;
			case 9 : nome = sex+""; break;
			case 10 : nome = capitalGain+""; break;
			case 11 : nome = capitalLoss+""; break;
			case 12 : nome = hoursPerWeek+""; break;
			case 13 : nome = nativeCountry+""; break;
			case 14 : nome = classe+""; break;
			default : nome = "erro"; break;
		}
		
		return nome;
	}
	
	public String toString(){
		return age+";"+
			   workclass+";"+
			   fnlwgt+";"+
			   education+";"+
			   educationNum+";"+
			   maritalStatus+";"+
			   occupation+";"+
			   relationship+";"+
			   race+";"+
			   sex+";"+
			   capitalGain+";"+
			   capitalLoss+";"+
			   hoursPerWeek+";"+
			   nativeCountry+";"+
			   classe;
	}
	
}
