package global;

import java.text.DecimalFormat;

public class MathHelper {
	public static boolean isNumber(String strNumber)
	{
		try {
			Integer.parseInt(strNumber);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
	public static double roundDouble(double number,int digit)
	{
		String parten = "#.";
		for(int i=0;i<digit;i++)
			parten+="#";
		DecimalFormat round = new DecimalFormat(parten);		
		return Double.valueOf(round.format(number));
	}
}
