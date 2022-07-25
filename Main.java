import java.util.Stack;

public class Main
{
    
    
    public static void main(String[] args) {
        
        
       
        
        String str1 = "{([{}]())}";
        
         String str2 = "{([{}]()}";
        
        System.out.println(str1+" is Balanced Brackets : "+CheckBalancedBrackets(str1));
        
        System.out.println(str2+" is Balanced Brackets : "+CheckBalancedBrackets(str2));
        
    }
    

    
    public static boolean CheckBalancedBrackets(String str)
    {
        
        Stack<Character> stack = new Stack<Character>();
 
       
        for (int i = 0; i < str.length(); i++)
        {
            char x = str.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                
                stack.push(x);
                continue;
            }
 
            
            
            if (stack.isEmpty())
                return false;
                
            char check;
            
                
               
                
            if(x == ')'){
                
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
            }
 
            else if(x == '}'){
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
            }
 
            else if(x == ']'){
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
            }
            
        }
 
     
        return (stack.isEmpty());
    }
    
}