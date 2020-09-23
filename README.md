# Assignment
Cuelebre Assignment



The problem is implemented without using any java libraries and stack.

Functions

1.hashMapCreation-To create hashmap for storing key value pair.

Key   Value
{     } 
}     { 
[     ] 
]     [ 
(     ) 
)     ( 

2.checkInputCharacter-To check input parameter
No other input allowed other than (,),{,},[,]
if entered other input then meassage is printed "Enter valid input" and program ends.

3.checkParanthesisBalance -if all parameters are entered correctly then call goes to checkParanthesisBalance function
  3.1 Here string is converted to character array
  3.2 If character array length is even 
  
	  3.2.1 Check for 0th position or length-1 position.i.e if ((arrayParanthesis[0] == '}') || (arrayParanthesis[0] == ')') || (arrayParanthesis[0] == ']') || (arrayParanthesis[length - 1] == '{') || (arrayParanthesis[length - 1] == '(')	|| (arrayParanthesis[length - 1] == '[')) //check for first and last character then return false.
	  
	  3.2.2 If character array length is 2.
	  
	  3.2.3  RecurviseCheck function,which does leftCheck,rightCheck and CompleteCheck recursively.
	  
	  returns true/false accordingly.
			
  3.3 If character array length is odd then return false;




Required conditions are satisfied for input:

Enter input string:
{}()
({()})
{}(
[]
result:true
result:true
result:false
result:true



Some of the inputs checked:

true		   false
{}()		   {]
({()})		}{()
[]			   )(
[{}]{()}	[(])
({}())		()))
(()()())	(()()(()
(((())))	()((
((((((())
((()))
