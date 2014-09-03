/*
 THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
 CODE WRITTEN BY OTHER STUDENTS. Andrew Burkus
 */
/*=============================================
=            Binary Search Tree
=============================================*/

public class BSTIndex
{
	private Node root;
	/*=============================================
	=            Constructor
	=============================================*/

	public BSTIndex()
	{
		this.root = null;
	}

	/*=============================================
	=            Public Interface
	=============================================*/

		/*==========  return the data element MovieInfo where the shortName
			matches the key exactly (can have different capitalization). ==========*/

	public MovieInfo findExact(String key)
	{
		Node node;
		if((node = findExact(key, root)) != null)
			return node.info;
		return null;
	}
		/*==========  return the data element MovieInfo where the shortName
			starts with the prefix (can have different capitalization). ===========*/

	public MovieInfo findPrefix(String prefix)
	{
		Node node;
		if((node = findPrefix(prefix, root)) != null)
			return node.info;
		return null;
	}
		/*==========  insert the given data element 
			into the proper place in the BST  ==========*/

	public void insert(MovieInfo data)
	{
		root = insert(data, root);
	}

	/*=============================================
	=            Private Methods
	=============================================*/

		/*==========  Insert Method  ==========*/

	private Node insert(MovieInfo data, Node root)
	{
		if(root == null)
			root = new Node(data);
		else
		{
			int diff = root.info.shortName.compareToIgnoreCase(data.shortName);
			if(diff < 0)
				root.setLeft(insert(data, root.getLeft()));
			else
				root.setRight(insert(data, root.getRight()));
		}
		return root;
	}

		/*==========  Find Exact Method  ==========*/

	private Node findExact(String key, Node root)
	{
		if(root == null)
			return null;
		else
		{
			int diff = root.info.shortName.compareToIgnoreCase(key);
			if(diff == 0)
				return root;
			else if(diff < 0)
				return findExact(key, root.getLeft());
			else
				return findExact(key, root.getRight());
		}
	}

		/*==========  Find Prefix Method  ==========*/

	private Node findPrefix(String prefix, Node root)
	{
		if(root == null)
			return null;
		else
		{
			int diff = root.info.shortName.toLowerCase().startsWith(prefix.toLowerCase()) ? 0 :
				root.info.shortName.compareToIgnoreCase(prefix);
			if(diff == 0)
				return root;
			else if(diff < 0)
				return findPrefix(prefix, root.getLeft());
			else
				return findPrefix(prefix, root.getRight());
		}
	}

	/*=============================================
	=            Private Class Node
	=============================================*/

	private class Node
	{
		private MovieInfo info;
		private Node right, left;

			/*==========  Constructor  ==========*/

		Node(MovieInfo info)
		{
			this.info = info;
		}

		/*=============================================
		=            Getters and Setters
		=============================================*/

			/*==========  Left Node ==========*/

		Node getLeft()
		{
			return this.left;
		}

		void setLeft(Node node)
		{
			this.left = node;
		}

			/*==========  Right Node ==========*/

		Node getRight()
		{
			return this.right;
		}

		void setRight(Node node)
		{
			this.right = node;
		}
	}
}