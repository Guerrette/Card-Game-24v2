/**
 *  ArithmeticTree class creates a binary tree with the specific purpose of arithmetic
 *  using the TreeEntry class as each node of the tree
 *  
 * @author Patrick Guerrette
 *
 * @param <E>
 */
public class ArithmeticTree<E> 
{	
	/**
	 * 	TreeEntry class specifically created a node used for a binary tree
	 * 
	 * @author Patrick Guerrette
	 *
	 * @param <E>
	 */
	public static class TreeEntry<E>
	{
		private E Value;
		private TreeEntry<E> Left;
		private TreeEntry<E> Right;
		private TreeEntry<E> Parent;
		private TreeEntry<E> Sibling;
		
		//Constructor
		public TreeEntry(E value, TreeEntry<E> left, TreeEntry<E> right, TreeEntry<E> parent, TreeEntry<E> sibling)
		{
			Value = value;
			Right = right;
			Left = left;
			Parent = parent;
			Sibling = sibling;
		}
		
		public E getValue() //returns value of the Node
		{
			return Value;
		}
		
		public void setValue(E value) // sets the value of the Node
		{
			Value = value;
		}
		
		public TreeEntry<E> getLeft() //returns the left Node
		{
			return Left;
		}
		
		public void setLeft(E value) // sets value of the left Node
		{
			if(Left == null)
			{
				Left = new TreeEntry<E>(value,null,null,this, this.getSibling());
			}
			else
			{
				Left.setValue(value);
			}
		}
		
		public TreeEntry<E> getRight() //returns the Right Node
		{
			return Right;
		}
		
		public void setRight(E value) // sets value of the Right Node
		{
			if(Right == null)
			{
				Right = new TreeEntry<E>(value,null,null,this, this.getSibling());
			}
			else
			{
				Right.setValue(value);
			}
		}
		
		public TreeEntry<E> getParent() // returns Parent Node
		{
			return Parent;
		}
		
		public void setParent(TreeEntry<E> parent) // sets the Node Parent
		{
			Parent = parent;
		}
		public TreeEntry<E> getSibling() 
		{
			return Sibling;
		}
		public String toString() // to string method
		{
			return Value.toString();
		}
	}
	//////////////////////////////////////////////////////////// end of TreeEntry
	private TreeEntry<E> Root;
	private int Size = 0;
	
	//Constructor
	public ArithmeticTree( E value)
	{
		TreeEntry<E> root = new TreeEntry<E>(value,null,null,null,null);
		Root = root;
	}
	
	public int numChild(TreeEntry<E> node) // finds and returns the number of children per node
	{
		if(node.getLeft() == null && node.getRight() == null) // if there is no right node or left node
		{
			return 0;
		}
		else if(node.getLeft() != null && node.getRight() != null) // if node has a right and left node
		{
			return 2;
		}
		else // if left or right node is present
		{
			return 1;
		}
	}
	
	public boolean isInternal(TreeEntry<E> node) // tells if the node is internal
	{
		return numChild(node) > 0;
		
	}
	
	public boolean isExternal(TreeEntry<E> node) // tells if the node is external
	{
		return numChild(node) == 0;
	}

	public boolean isRoot(TreeEntry<E> node) // tells if the node is the root of the tree
	{
		return node == Root;
	}
	
	public boolean isEmpty() // tells if the tree is empty
	{
		return Size == 0;
	}
	
	public int depth(TreeEntry<E> node) // return the depth of certain node in the tree
	{
		if(isRoot(node)) // if node is the root
		{
			return 0;
		}
		else // if node is not the root
			return 1 + depth(node.getParent()); //find the depth of the parent node. This will recur until it reaches the root at size 0.
	}
	
	public void addLeft(E value, TreeEntry<E> parent) // adds node to the left of the parent node
	{
		if(parent.getLeft() == null) // if there is not left node
		{
			parent.setLeft(value);
		}
		else // if there already is a left node
		{
			System.out.println("Already a left TreeNode for this Parent Node");
		}
	}
	
	public void addRight(E value, TreeEntry<E> parent) // adds node to the right of the parent node
	{
		if(parent.getRight() == null) // if there is no right node
		{
			parent.setRight(value);
		}
		else // if there already is a right node
		{
			System.out.println("Already a right TreeNode for this Parent Node");
		}
	}
	public TreeEntry<E> getRoot() // returns root of the tree
	{
		return Root;
	}
	
	
		
	

	
}
