
public class PostFixOp 
{
	/**
	 * Assumes the string entered is a in correct format and numbers are separated with a space
	 * There are 5 valid post fix notations so notation should only range 1 through 5
	 * 1 = num1 num2 op1 num3 num4 op2 op3 Equivalent:(num1 op1 num2) op3(num3 op2 num4)
	 * 2 = num1 num2 op1 num3 op2 num4 op3 Equivalent:((num1 op1 num2) op2 num3) op4 num4
	 * 3 = num1 num2 num3 num4 op1 op2 op3 Equivalent: num1 op3(num2 op2(num3 op1 num4))
	 * 4 = num1 num2 num3 op1 num4 op2 op3 Equivalent: num1 op3((num2 op1 num3) op2 num4)
	 * 5 = num1 num2 num3 op1 op2 num4 op3 Equivalent: (num1 op2 (num2 op1 num3) op3 num4
	 * The reason for the notation is only for the requirement of the output of the equation
	 * Each if statement does the exact same calculation with the stack the only difference is the output.
	 * @param postfix
	 * @param num1  // all int parameters are only use for the output.
	 * @param num2
	 * @param num3
	 * @param num4
	 * @return
	 */
	public static double Math(String str) // assumes string is in proper format. 
	{
		int num1 = 0,num2 = 0,num3 = 0,num4 = 0;
		
		char[] Ops = OpCombo();
		if(checkString(str)) // valid input meaning the string contains spaces numbers and letters
		{
			//operates the string of 4 numbers as PostFix 1
				for(int x=0;x<str.length();x++)
				{
					char current = str.charAt(x);
					if(current == ' ')
					{
						
					}
					else if(current == 'k' || current == 'K')
					{
						if(num1 == 0) // num1 has no value in it
						{
							num1 = 13;
						}
						else if(num2 == 0) // num2 has no value in it
						{
							num2  = 13;
						}
						else if(num3 == 0) // num3 has no value
						{
							num3 = 13;
						}
						else if(num4 == 0) // num4 has no value
						{
							num4 = 13;
						}
						else
						{
							return -888; // invalid input
						}
					}
					else if(current == 'q' || current == 'Q')
					{
						if(num1 == 0) // num1 has no value in it
						{
							num1 = 12;
						}
						else if(num2 == 0) // num2 has no value in it
						{
							num2  = 12;
						}
						else if(num3 == 0) // num3 has no value
						{
							num3 = 12;
						}
						else if(num4 == 0) // num4 has no value
						{
							num4 = 12;
						}
						else
						{
							return -888; // invalid input
						}
					}
					else if(current == 'j' || current == 'J')
					{
						if(num1 == 0) // num1 has no value in it
						{
							num1 = 11;
						}
						else if(num2 == 0) // num2 has no value in it
						{
							num2  = 11;
						}
						else if(num3 == 0) // num3 has no value
						{
							num3 = 11;
						}
						else if(num4 == 0) // num4 has no value
						{
							num4 = 11;
						}
						else
						{
							return -888; // invalid input
						}
					}
					else // current is not a space or letter
					{
						char next = 'x';
						if(x<str.length()-1)
						{
							next = str.charAt(x+1);
						}
						else 
						{
							//char next stays as x
						}
						
						if(next == ' ' || next == 'x') // next character is a space or x. If x means current is the last value in string
						{
							String z = "";
							if(num1 == 0) // num1 has no value in it
							{
								z = "" + current;
								num1 = Integer.parseInt(z);
							}
							else if(num2 == 0) // num2 has no value in it
							{
								z = "" + current;
								num2 = Integer.parseInt(z);
							}
							else if(num3 == 0) // num3 has no value
							{
								z = "" + current;
								num3 = Integer.parseInt(z);
							}
							else if(num4 == 0) // num4 has no value
							{
								z = "" + current;
								num4 = Integer.parseInt(z);
							}
							else
							{
								return -888; // invalid input
							}
						}
						else //next char is a number or letter
						{
							String n = "";
							// the next character cannot be a letter 
							if(next == 'k' || next == 'K') // next is a king
							{
								 return -888;
							}
							else if(next == 'q' || next == 'Q') // next is a queen
							{
								 return -888;
							}
							else if(next == 'j' || next == 'J')// next is a jack
							{
								 return -888;
							}
							else// next is a number
							{
								 n = "" + current + "" + next;
							}
							 // these statements only occur in the next char and current char are single digit numbers
							if(num1 == 0) // no value is stored in num1
							{
								num1 = Integer.parseInt(n);
							}
							else if(num2 == 0) // no value in num2
							{
								num2  = Integer.parseInt(n);
							}
							else if(num3 == 0) // no value in num3
							{
								num3 = Integer.parseInt(n);
							}
							else if(num4 == 0) // no value in num4
							{
								num4 = Integer.parseInt(n);
							}
							else
							{
								return -888; // invalid input
							}
							x++; // increase x because the next char was used
						}
					}
				}
				if(num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) // not enought numbers entered or too many number entered
				{
					return -888;
				}
				int[] combos = Permutate(num1,num2,num3,num4);
				for(int p=0;p<combos.length;p+=4)
				{
					for(int g =0; g<Ops.length;g+=3)
					{
						String n1 = "" + combos[p];
						String n2 = "" + combos[p+1];
						String n3 = "" + combos[p+2];
						String n4 = "" + combos[p+3];
						String o1 = "" + Ops[g];
						String o2 = "" + Ops[g+1];
						String o3 = "" + Ops[g+2];
						//System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+o1+" "+o2+" "+o3);
						
						//Creates tree for postfix1
						
						ArithmeticTree<String> post1 = new ArithmeticTree<String>(o3);
						post1.addLeft(o1, post1.getRoot()); // add left of root
						post1.addRight(o2, post1.getRoot()); // add right of root
						post1.addLeft(n1, post1.getRoot().getLeft()); // add left of roots left child
						post1.addRight(n2, post1.getRoot().getLeft()); // add right to rots left child
						post1.addLeft(n3, post1.getRoot().getRight()); //add left to roots right child
						post1.addRight(n4, post1.getRoot().getRight()); // add right to roots right child
						
						
						//Creates tree for postfix2
						ArithmeticTree<String> post2 = new ArithmeticTree<String>(o3);
						post2.addLeft(o2, post2.getRoot()); //add left of root
						post2.addRight(n4, post2.getRoot()); // add right of root
						post2.addLeft(o1, post2.getRoot().getLeft()); // add left of roots left child
						post2.addRight(n3, post2.getRoot().getLeft()); // add right to roots left child
						post2.addLeft(n1, post2.getRoot().getLeft().getLeft()); // add left to root left child's left child
						post2.addRight(n2, post2.getRoot().getLeft().getLeft()); // add right to root left child's left child
						
						//Creates tree for postfix3
						ArithmeticTree<String> post3 = new ArithmeticTree<String>(o3);
						post3.addLeft(n1, post3.getRoot()); //add left to roots left child
						post3.addRight(o2, post3.getRoot()); //add right to roots right child
						post3.addLeft(n2, post3.getRoot().getRight()); //add left to roots right child
						post3.addRight(o1, post3.getRoot().getRight()); // add right to roots right child
						post3.addLeft(n3, post3.getRoot().getRight().getRight()); //add left to root right child's right child
						post3.addRight(n4, post3.getRoot().getRight().getRight()); // add right to root right child's right child
						
						//Creates tree for postfix4
						ArithmeticTree<String> post4 = new ArithmeticTree<String>(o3);
						post4.addLeft(n1, post4.getRoot()); // add left to roots left child
						post4.addRight(o2, post4.getRoot()); // add right to root
						post4.addLeft(o1, post4.getRoot().getRight()); // add left to roots right child
						post4.addRight(n4, post4.getRoot().getRight()); // add right to roots right child
						post4.addLeft(n2, post4.getRoot().getRight().getLeft()); // add left to roots right child's left child
						post4.addRight(n3, post4.getRoot().getRight().getLeft()); // add right to root right child's left child
						
						//Creates tree for postfix5
						ArithmeticTree<String> post5 = new ArithmeticTree<String>(o3);
						post5.addLeft(o2, post5.getRoot()); // add left to the root
						post5.addRight(n4, post5.getRoot()); // add right to the root
						post5.addLeft(n1, post5.getRoot().getLeft()); // add left to the roots left child
						post5.addRight(o1, post5.getRoot().getLeft()); // add right to roots left child
						post5.addLeft(n2, post5.getRoot().getLeft().getRight()); // add left to the root left child's right child
						post5.addRight(n3, post5.getRoot().getLeft().getRight()); // add right to the root left child's right child
						
						double result1 = EvalTree(post1, 1);
						double result2 = EvalTree(post2, 2);
						double result3 = EvalTree(post3 ,3);
						double result4 = EvalTree(post4, 4);
						double result5 = EvalTree(post5, 5);
						//System.out.println(result1 + " " + result2 + " " + result3 + " " + result4 + " " + result5);
						
						if(result1 <=24.1) // if result is between 23.9 and 24.1. I did this because there is error with double. 
						{					// .1 is tolerance zone
							if(result1 >= 23.9)
							{
								printOp(post1);
							}
						}
						
						if(result2 <=24.1) // if result is between 23.9 and 24.1. I did this because there is error with double. 
						{					// .1 is tolerance zone
							if(result2 > 23.9)
							{
								printOp(post2);
							}
						}
						
						if(result3 <=24.1) // if result is between 23.9 and 24.1. I did this because there is error with double. 
						{					// .1 is tolerance zone
							if(result3 >= 23.9)
							{
								printOp(post3);
							}
						}
						
						if(result4 <=24.1) // if result is between 23.9 and 24.1. I did this because there is error with double. 
						{					// .1 is tolerance zone
							if(result5 >= 23.9)
							{
								printOp(post4);
							}
						}
						
						if(result5 <=24.1) // if result is between 23.9 and 24.1. I did this because there is error with double. 
						{					// .1 is tolerance zone
							if(result5 >= 23.9)
							{
								printOp(post5);
							}
						}
						
					}
				}
				return 0;
			}
	
		return -888; //invalid input
	}
	/**
	 * returns a string of the expression in infix with correct parenthesis
	 * uses in order traversal
	 * @param tree
	 * @return
	 */
	public static void printOp(ArithmeticTree<String> tree)
	{			
		StackPostFixOp<ArithmeticTree.TreeEntry<String>> stack = new StackPostFixOp<ArithmeticTree.TreeEntry<String>>(7);
		ArithmeticTree.TreeEntry<String> root = tree.getRoot();
		boolean contin = true;
		while(contin)
		{
			if(root != null) // node is not null
			{
				stack.push(root); //push into stack
				root = root.getLeft(); // node is not the left child and while loop restarts
				
			}
			else // node is null
			{
				//System.out.print("stack size" + stack.Size());
				if(!stack.isEmpty()) // stack as elements in it
					{
						root = stack.pop(); // node is popped off and set to root
						String s = root.getValue(); //value of the root
						if(root == tree.getRoot())
						{
							System.out.print(s);// print root
						}
						else
						{
							if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) //if value is not an operator
							{
								if(root.getParent().getRight() == root) // root is the right child node
								{
									System.out.print(s + ")"); // print with parenthesis
								}
								else if(root.getParent().getLeft() == root)// if root is left child
								{
									System.out.print("("+s);
								}
							}
							
						
							else
							{
								System.out.print(s); // if value is an operator
							}
						}
						
					
					root = root.getRight(); //gets right child node of node that was just output and loop restarts
				  }
				
				else // stack is empty
				{
					contin = false; // if stack is empty loop ends
					System.out.println("");
				}
				
			
			}	
		}
	}

		
	
	/**
	 * Does post order traversal for the trees assuming each tree is set up in either post fix order 1 2 3 4 or 5
	 * @param tree
	 * @param postfixnum
	 * @return
	 */
	public static double EvalTree(ArithmeticTree<String> tree, int postfixnum)
	{
		double result = 0;
		double result2 = 0;
		if(postfixnum ==1) // post fix 1
		{
			//gets values of the tree to be operated in its proper post fix notation
			double num1 = (Double.parseDouble(tree.getRoot().getLeft().getLeft().getValue())); // left most node
			double num2 = (Double.parseDouble(tree.getRoot().getLeft().getRight().getValue()));
			double num3 = Double.parseDouble(tree.getRoot().getRight().getLeft().getValue());
			double num4 = Double.parseDouble(tree.getRoot().getRight().getRight().getValue());
			String op1 = tree.getRoot().getLeft().getValue();
			String op2 = tree.getRoot().getRight().getValue();
			String op3 = tree.getRoot().getValue();
			
			if(op1 .equals("+")) //add
			{
				result = num1+num2;
			}
			else if( op1 .equals("-")) // subtract
			{
				result = num1-num2;
			}
			else if(op1 .equals("*")) // multiply
			{
				result = num1*num2;
			}
			else// operator is divide
			{
				result = num1/num2;
			}
			
			
			//operator 2
			if(op2 .equals("+")) //add
			{
				result2 = num3+num4;
			}
			else if( op2 .equals("-")) // subtract
			{
				result2 = num3-num4;
			}
			else if(op2 .equals("*")) // multiply
			{
				result2 = num3*num4;
			}
			else// operator is divide
			{
				result2 = num3/num4;
			}
			
			//operator 3
			if(op3 .equals("+")) //add
			{
				result = result + result2;
			}
			else if( op3 .equals("-")) // subtract
			{
				result = result-result2;
			}
			else if(op3 .equals("*")) // multiply
			{
				result = result * result2; 
			}
			else// operator is divide
			{
				if(result2 == 0)
				{
					return 0;
				}
				else
					result = result/result2;
			}
			
			return result;
			
		}
		else if(postfixnum == 2)// post fix 2
		{
			//gets values of the tree to be operated in its proper post fix notation
			double num1 = Double.parseDouble(tree.getRoot().getLeft().getLeft().getLeft().getValue());
			double num2 = Double.parseDouble(tree.getRoot().getLeft().getLeft().getRight().getValue());
			double num3 = Double.parseDouble(tree.getRoot().getLeft().getRight().getValue());
			double num4 = Double.parseDouble(tree.getRoot().getRight().getValue());
			String op1 = tree.getRoot().getLeft().getLeft().getValue();
			String op2 = tree.getRoot().getLeft().getValue();
			String op3 = tree.getRoot().getValue();
			
			if(op1 .equals("+")) //add
			{
				result = num1+num2;
			}
			else if( op1 .equals("-")) // subtract
			{
				result = num1-num2;
			}
			else if(op1 .equals("*")) // multiply
			{
				result = num1*num2;
			}
			else// operator is divide
			{
				result = num1/num2;
			}
			
			
			//operator 2
			if(op2 .equals("+")) //add
			{
				result2 = result+num3;
			}
			else if( op2 .equals("-")) // subtract
			{
				result2 = result-num3;
			}
			else if(op2 .equals("*")) // multiply
			{
				result2 = result*num3;
			}
			else// operator is divide
			{
				result2 = result/num3;
			}
			//operator 3
			if(op3 .equals("+")) //add
			{
				result = result2 + num4;
			}
			else if( op3 .equals("-")) // subtract
			{
				result = result2-num4;
			}
			else if(op3 .equals("*")) // multiply
			{
				result = result2 * num4;
			}
			else// operator is divide
			{
					result = result/num4;
			}
			
			return result;
		}
		else if(postfixnum == 3) //post fix 3
		{
			//gets values of the tree to be operated in its proper post fix notation
			double num1 = Double.parseDouble(tree.getRoot().getLeft().getValue());
			double num2 = Double.parseDouble(tree.getRoot().getRight().getLeft().getValue());
			double num3 = Double.parseDouble(tree.getRoot().getRight().getRight().getLeft().getValue());
			double num4 = Double.parseDouble(tree.getRoot().getRight().getRight().getRight().getValue());
			String op1 = tree.getRoot().getRight().getRight().getValue();
			String op2 = tree.getRoot().getRight().getValue();
			String op3 = tree.getRoot().getValue();
			
			if(op1 .equals("+")) //add
			{
				result = num3+num4;
			}
			else if( op1 .equals("-")) // subtract
			{
				result = num3-num4;
			}
			else if(op1 .equals("*")) // multiply
			{
				result = num3*num4;
			}
			else// operator is divide
			{
				result = num3/num4;
			}
			
			
			//operator 2
			if(op2 .equals("+")) //add
			{
				result2 = num2+result;
			}
			else if( op2 .equals("-")) // subtract
			{
				result2 = num2-result;
			}
			else if(op2 .equals("*")) // multiply
			{
				result2 = num2*result;
			}
			else// operator is divide
			{
				if(result == 0)
				{
					return 0;
				}
				else
				{
					result2 = num2/result;
				}
			}
			//operator 3
			if(op3 .equals("+")) //add
			{
				result = num1 + result2;
			}
			else if( op3 .equals("-")) // subtract
			{
				result = num1-result2;
			}
			else if(op3 .equals("*")) // multiply
			{
				result = num1 * result2;
			}
			else// operator is divide
			{
				if(result2 == 0)
				{
					return 0;
				}
				else
				{
					result = num1/result;
				}
			}
			return result;
		}
		else if(postfixnum == 4) // post fix 4
		{
			//gets values of the tree to be operated in its proper post fix notation
			double num1 = Double.parseDouble(tree.getRoot().getLeft().getValue());
			double num2 = Double.parseDouble(tree.getRoot().getRight().getLeft().getLeft().getValue());
			double num3 = Double.parseDouble(tree.getRoot().getRight().getLeft().getRight().getValue());
			double num4 = Double.parseDouble(tree.getRoot().getRight().getRight().getValue());
			String op1 = tree.getRoot().getRight().getLeft().getValue();
			String op2 = tree.getRoot().getRight().getValue();
			String op3 = tree.getRoot().getValue();
			
			if(op1 .equals("+")) //add
			{
				result = num2+num3;
			}
			else if( op1 .equals("-")) // subtract
			{
				result = num2-num3;
			}
			else if(op1 .equals("*")) // multiply
			{
				result = num2*num3;
			}
			else// operator is divide
			{
				result = num2/num3;
			}
			
			
			//operator 2
			if(op2 .equals("+")) //add
			{
				result2 = result+num4;
			}
			else if( op2 .equals("-")) // subtract
			{
				result2 = result-num4;
			}
			else if(op2 .equals("*")) // multiply
			{
				result2 = result*num4;
			}
			else// operator is divide
			{
				result2 = result/num4;
			}
			//operator 3
			if(op3 .equals("+")) //add
			{
				result = num1+result2;
			}
			else if( op3 .equals("-")) // subtract
			{
				result = num1-result2;
			}
			else if(op3 .equals("*")) // multiply
			{
				result = num1 * result2;
			}
			else// operator is divide
			{
					if(result2 == 0)
					{
						return 0;
					}
					else
					{
						result = num1/result2;
					}
			}
			return result;
			
		}
		else // post fix 5
		{
			//gets values of the tree to be operated in its proper post fix notation
			double num1 = Double.parseDouble(tree.getRoot().getLeft().getLeft().getValue());
			double num2 = Double.parseDouble(tree.getRoot().getLeft().getRight().getLeft().getValue());
			double num3 = Double.parseDouble(tree.getRoot().getLeft().getRight().getRight().getValue());
			double num4 = Double.parseDouble(tree.getRoot().getRight().getValue());
			String op1 = tree.getRoot().getLeft().getRight().getValue();
			String op2 = tree.getRoot().getLeft().getValue();
			String op3 = tree.getRoot().getValue();
			
			if(op1 .equals("+")) //add
			{
				result = num2+num3;
			}
			else if( op1 .equals("-")) // subtract
			{
				result = num2-num3;
			}
			else if(op1 .equals("*")) // multiply
			{
				result = num2*num3;
			}
			else// operator is divide
			{
				result = num2/num3;
			}
			
			
			//operator 2
			if(op2 .equals("+")) //add
			{
				result2 = num1+result;
			}
			else if( op2 .equals("-")) // subtract
			{
				result2 = num1-result;
			}
			else if(op2 .equals("*")) // multiply
			{
				result2 = num1*result;
			}
			else// operator is divide
			{
				if(result == 0)
				{
					return 0;
				}
				else
				{
					result2 = num1/result;
				}
			}
			//operator 3
			if(op3 .equals("+")) //add
			{
				result = result2 + num4;
			}
			else if( op3 .equals("-")) // subtract
			{
				result = result2-num4;
			}
			else if(op3 .equals("*")) // multiply
			{
				result = result2 * num4;
			}
			else// operator is divide
			{
					result = result/num4;
			}
			return result;
		}
	}
	
	/**
	 * Checks if the string input is 4 numbers including K Q J and 10  11 12 13
	 * @param str
	 * @return
	 */
	public static boolean checkString(String str)
	{
		for(int x=0; x<str.length();x++)
		{
			char current = str.charAt(x);
			if(current == ' ') // if character is a space
			{
				
			}
			// if character is a number
			else if(current == '0' || current == '1' ||current == '2' ||current == '3' ||current == '4' ||current == '5' ||current == '6' ||current == '7' || current == '8' || current == '9')
			
			{
				
			}
			// if character is a jack queen or king
			else if( current == 'J'|| current == 'Q' || current == 'K' || current == 'j' || current == 'q' || current == 'k')
			{
				
			}
			else // invalid character
			{
				return false;
			}
		}
		//every character is a number or jqk or JQK
		return true;
	}
	private static String[] Permutate2(int c1, int c2)
	{
		String[] strings = new String[2]; // array that is returned return
		String str1 = Integer.toString(c1) + " " + Integer.toString(c2) + " "; // combination 1
		String str2 = Integer.toString(c2) + " " + Integer.toString(c1) + " "; // combination 2
		strings[0] = str1;
		strings[1] = str2;
		return strings;
	}
	/**
	 *  Finds all permutation of 3 numbers. There are 6 permutations per 3 numbers
	 *  returns the in an array of strings
	 * @param c1
	 * @param c2
	 * @param c3
	 * @return
	 */
	private static String[] Permutate3(int c1, int c2, int c3)
	{
		String[] strings = new String[6];
		String[] strs1 = Permutate2(c1,c2); // find the permutations between 2 of the three numbers
		String[] strs2 = Permutate2(c1,c3);	// does this three times with every combination of the of 2 numbers of the three numbers
		String[] strs3 = Permutate2(c3,c2); // there are 3 combinations total
		int k = 0; // continuous location of the array that is returned
		// all three for loops do the exact same thing with different set of two numbers
		// loop goes through the the string array and adds the number no present in the two card combination to the string and stores it into the main
		// array that will be returned
		for(String x : strs1)
		{
			x += Integer.toString(c3) + " "; // adds missing number to the end of the original string
			strings[k] = x; // stores the new string into the returned array
			k++;
		}
		
		for(String x : strs2)
		{
			
			x += Integer.toString(c2) + " ";
			strings[k] = x;
			k++;
		}
		
		for(String x : strs3)
		{
			
			x += Integer.toString(c1) + " ";
			strings[k] = x;
			k++;
		}
		return strings;
		
	}
	/**
	 * This method permutates  4 number which is done by calling permuate3 4 times and adding the 4th number to the end of the string
	 * @param c1
	 * @param c2
	 * @param c3
	 * @param c4
	 * @return
	 */
	private static int[] Permutate(int c1, int c2 , int c3 , int c4)
	{
		int[] permutations = new int[96]; // 24 combinations for four numbers, but i store each number separately in order
		String[] strings = new String[24]; // stores each string of four numbers into an array of strings
		String[] strs1 = Permutate3(c1,c2,c3); // gets permutations of three numbers
		String[] strs2 = Permutate3(c1,c2,c4);	// i call it four times because there are four combinations of 3 numbers being together in any order
		String[] strs3 = Permutate3(c1,c3,c4);
		String[] strs4 = Permutate3(c2,c3,c4);
		int k = 0; // continuous location of the array of strings being stored.
		
		// each loop does the exact same thing with different numbers so ill comment one 
		// loop goes through every string of 3 number permutations there are 6 permutations per 3 numbers
		// adds the number not included in the 3 number permutation to the end of the string, then stores it back into another the main array
		for(String x: strs1)
		{
			x += Integer.toString(c4) + " "; // adds the number not included in the permutations to every string in the 3 permutation array
			strings[k] = x; // stores the new string into the main array
			k++; // increases k every time a value is stored into the array
		}
		
		for(String x: strs2)
		{
			
			x += Integer.toString(c3) + " ";
			strings[k] = x;
			k++;
		}
		
		for(String x: strs3)
		{
			x += Integer.toString(c2) + " ";
			strings[k] = x;
			k++;
		}
		
		for(String x: strs4)
		{
			x +=  Integer.toString(c1) + " ";
			strings[k] = x;
			k++;
		}
		permutations = StringtoInt(strings);
		return permutations;
		
		
	}
	
	/**
	 * this method specifically works for the Permutations method which is why it is private
	 * Converts a string of numbers separated by spaces into separate integers and stores them in an int array of 96
	 * @param strings
	 * @return
	 */
	private static int[] StringtoInt(String[] strings)
	{
		int[] permutations = new int[96];
		int k = 0; // continues location for array.
		char next = 'x';
		for(String x : strings)
		{
			for(int i=0;i<x.length();i++)
			{
				char current = x.charAt(i);
				
				if(i < (x.length() -1) ) // length -1 because the last character is always a space so we know its not a number
				{
					next = x.charAt(i+1); // set char to next char
				}
				if(current == ' ')
				{
					//do nothing go to next loop
				}
				else if(next == ' ') //  next character is a space
				{ 
					int y = Character.getNumericValue(current);
					permutations[k] = y; // add current character to array because it is a single digit number
					k++;
				}
				else // next character is a number
				{
					
					String str = "" + current + "" + next;
					int y = Integer.parseInt(str);
					permutations[k] = y; // double digit number to array
					i++; // increase i because I don't need to test the next character anymore
					k++;
				}
			}
		}
		return permutations;
	}
	/**
	 * creates an array of all operator combinations but stores each character 1 by 1
	 * so if you want the 3 operator combo you need to extract 3 cells at a time.
	 * @return
	 */
	
	private static char[] OpCombo()
	{
		char[] ops = new char[192]; // stores combinations, note 64 *3 is 192
		int k = 0; // represents the continuous location of the array that needs to be filled
		for(int i1 = 0; i1<4;i1++) // each loop goes from 1 to 4 because there are only 4 operators
		{
			for(int i2 = 0; i2<4; i2++)
			{
				for(int i3 = 0; i3<4; i3++)
				{
					// each for loop increment represents an operation
					// the character the increment represents is stored in an array 1 by 1 
					// each iteration of the loop stores 3 variables in 3 different cells which represent 1 combination.
					if( i1 == 0)
					{
						ops[k] = '+';
					}
					else if( i1 == 1)
					{
						ops[k] = '-';
					}
					else if(i1 == 2)
					{
						ops[k] = '/';
					}
					else
					{
						ops[k] = '*';
					}
					
					k++;
					
					if( i2 == 0)
					{
						ops[k] = '+';
					}
					else if( i2 == 1)
					{
						ops[k] = '-';
					}
					else if(i2 == 2)
					{
						ops[k] = '/';
					}
					else
					{
						ops[k] = '*';
					}
					
					k++;
					
					if( i3 == 0)
					{
						ops[k] = '+';
					}
					else if( i3 == 1)
					{
						ops[k] = '-';
					}
					else if(i3 == 2)
					{
						ops[k] = '/';
					}
					else
					{
						ops[k] = '*';
					}
					k++;
				}
			}
		}
		return ops;
	}	
}