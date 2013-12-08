package global;

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
}
