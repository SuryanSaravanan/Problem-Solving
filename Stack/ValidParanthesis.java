/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Example 1:
    Input: s = "()"
    Output: true

Example 2:
    Input: s = "()[]{}"
    Output: true

Example 3:
    Input: s = "(]"
    Output: false

*/

package Stack;

import java.util.Stack;

class ValidParanthesis {

    public boolean isValid(String s) {
        
        Stack<Character> bracketChecker = new Stack<Character>();
        
        for(int i = 0 ; i < s.length() ; i++ )
        {
            Character bracket = s.charAt(i);
            
            if ( bracket == '[' || bracket == '(' || bracket == '{' )
                bracketChecker.push( bracket );
            else if ( bracket == ']' ) {
                if ( bracketChecker.empty() )
                    return false;
                if( bracketChecker.peek() == '[' )
                    bracketChecker.pop();
                else
                    return false;
            }
            else if ( bracket == ')' ) {
                if (bracketChecker.empty())
                    return false;
                if( bracketChecker.peek() == '(' )
                    bracketChecker.pop();
                else
                    return false;
            }
            else if ( bracket == '}' ) {
                if (bracketChecker.empty())
                    return false;
                if( bracketChecker.peek() == '{' )
                    bracketChecker.pop();
                else
                    return false;
            }
        }
        
        return bracketChecker.empty() ? true : false;
        
    }
}

