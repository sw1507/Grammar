import java.util.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String oneRow = "ADJPHRASE::= ADJECTIVE   |  ADJECTIVE ADJPHRASE";
		String[] pieces = oneRow.split("::=");//["ADJPHRASE", " ADJECTIVE   |  ADJECTIVE ADJPHRASE"]
		String key = pieces[0].trim();//"ADJPHRASE"
		String[] rule = pieces[1].split("\\|");//[" ADJECTIVE   ", "  ADJECTIVE ADJPHRASE"]
		//for(int j = 0; j < rule.length; j++){
			String ruleList[] = rule[1].trim().split("\\s+");
			//String ruleList[] = rule[1].trim().split("\\s+");
		//}
		//Random index = new Random(10);
		int num =(int)(Math.random()*5);
		System.out.println(num);
//		System.out.println(result[1]);
//		System.out.println(result[2]);
//		System.out.println(result[3]);
//		System.out.println(result.length);
	}	

}
