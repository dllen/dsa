package dsa.stack;

public class StackExample {
	
	public static boolean matchHtml(String html) {
		
		return false;
	}

	public static boolean match1(String str) {
		Stack stack = new StackArray();
		for (int i = 0; i < str.length(); i++) {
			Character character = str.charAt(i);
			switch (character) {
			case '(':
			case '[':
			case '{':
				stack.push(character);
				break;
			case ')':
			case ']':
			case '}':
				if (stack.isEmpty()) {
					return false;
				}
				if (!character.equals(getMatchChar((Character) stack.pop()))) {
					return false;
				}
				break;
			default:
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static Character getMatchChar(Character character) {
		Character result = ' ';
		switch (character) {
		case '(':
			result = ')';
			break;
		case '{':
			result = '}';
			break;
		case '[':
			result = ']';
			break;
		default:
			break;
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
