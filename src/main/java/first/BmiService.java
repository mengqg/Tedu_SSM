package first;

public class BmiService {
	public String doBmi(double height,double weight) {
		String str = "正常";
		/***体质指数（BMI）=体重（kg）÷身高^2（m）*/
		double bmi = weight/(height*height);
		if(bmi<19) {
			str = "过轻";
		}
		if(bmi > 25) {
			str = "过重";
		}
		return str;
	}

}
