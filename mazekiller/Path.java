//position nodes linked = path

public class Path
{
	private Node root;

	public Path ()
	{
		this.root = new Node("X", 0, 0);
	}

	/*=============================================
	=            Recursive Node Class            
	=============================================*/

	private class Node
	{
		Integer row, col;
		String marker;
		Node next;

		Node(String marker, int row, int col)
		{
			this.marker = marker;
			this.row = row;
			this.col = col;
		}

		public boolean equals(Object obj)
		{
			boolean row = ((Node)obj).row == this.row;
			boolean col = ((Node)obj).col == this.col;

			return row && col;
		}
	}

	/*=============================================
	=            Methods           
	=============================================*/

	public void add(int row, int col, String marker)
	{
		Node newNode = new Node(marker, row, col);

		if(!this.contains(this.root, newNode))
			this.add(this.root, newNode);
	}

	private void add(Node node, Node newNode)
	{
		if(node.next == null)
		{
			node.next = newNode;
			return;
		}

		this.add(node.next, newNode);
	}

	/*=============================================
	=            Contains Method           
	=============================================*/

	private boolean contains(Node node, Node other)
	{
		if(node.equals(other))
			return true;

		if(node.next != null) 
			this.contains(node.next, other);

		return false;
	}

	/*=============================================
	=            Delete Methods           
	=============================================*/
	
	public void deleteFromLocation(int row, int col)
	{
		Node n = new Node(null, row, col);

		if(this.contains(this.root, n))
			delete(this.root, n);
	}

	private void delete(Node node, Node toDelete)
	{
		if(node.next.equals(toDelete))
		{
			node.next = null;
			return;
		}

		if(node.next != null)
		{
				this.delete(node.next, toDelete);
				return;
		}
	}
}