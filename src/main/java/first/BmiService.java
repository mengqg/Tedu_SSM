package first;

public class BmiService {
	public String doBmi(double height,double weight) {
		String str = "����";
		/***����ָ����BMI��=���أ�kg�������^2��m��*/
		double bmi = weight/(height*height);
		if(bmi<19) {
			str = "����";
		}
		if(bmi > 25) {
			str = "����";
		}
		return str;
	}

}
