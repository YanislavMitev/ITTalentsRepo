package skladovSoftwer;

public final class StaticMethods {
	public static final boolean checkString(String text) {
		if(text != null && text.trim().length() > 0) {
			return true;
		}
		return false;
	}
}
