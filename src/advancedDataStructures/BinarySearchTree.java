package advancedDataStructures;

public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
	E value;
	Node leftChild = null;
	Node rightChild = null;
	Node(E value) {
	    this.value = value;
	}
	@Override
	public boolean equals(Object obj) {
	    if ((obj instanceof BinarySearchTree.Node) == false)
		return false;
	    @SuppressWarnings("unchecked")
	    Node other = (BinarySearchTree<E>.Node)obj;
	    return other.value.compareTo(value) == 0 &&
		    other.leftChild == leftChild && other.rightChild == rightChild;
	}
    }

    protected Node root = null;

    protected void visit(Node n) {
	System.out.println(n.value);
    }

    public boolean contains(E val) {
	return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
	if (n == null) return false;

	if (n.value.equals(val)) {
	    return true;
	} else if (n.value.compareTo(val) > 0) {
	    return contains(n.leftChild, val);
	} else {
	    return contains(n.rightChild, val);
	}
    }

    public boolean add(E val) {
	if (root == null) {
	    root = new Node(val);
	    return true;
	}
	return add(root, val);
    }

    protected boolean add(Node n, E val) {
	if (n == null) {
	    return false;
	}
	int cmp = val.compareTo(n.value);
	if (cmp == 0) {
	    return false; // this ensures that the same value does not appear more than once
	} else if (cmp < 0) {
	    if (n.leftChild == null) {
		n.leftChild = new Node(val);
		return true;
	    } else {
		return add(n.leftChild, val);
	    } 	
	} else {
	    if (n.rightChild == null) {
		n.rightChild = new Node(val);
		return true;
	    } else {
		return add(n.rightChild, val);
	    } 	
	}
    }	

    public boolean remove(E val) {
	return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
	if (n == null) return false;

	if (val.compareTo(n.value) == -1) {
	    return remove(n.leftChild, n, val);
	} else if (val.compareTo(n.value) == 1) {
	    return remove(n.rightChild, n, val);
	} else {
	    if (n.leftChild != null && n.rightChild != null){
		n.value = maxValue(n.leftChild);
		remove(n.leftChild, n, n.value);
	    } else if (parent == null) {
		root = n.leftChild != null ? n.leftChild : n.rightChild;
	    } else if (parent.leftChild == n){
		parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    } else {
		parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    }
	    return true;
	}
    }

    protected E maxValue(Node n) {
	if (n.rightChild == null) {
	    return n.value;
	} else {
	    return maxValue(n.rightChild);
	}
    }

    public void inOrder(Node n){
	if(n != null){
	    if(n.leftChild != null)
		inOrder(n.leftChild);
	    visit(n);
	    if(n.rightChild != null)
		inOrder(n.rightChild);
	}

    }
    /*********************************************
     * 
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/


    /**
     * Given a value that is stored in the BST, it returns 
     * the corresponding Node that holds it. If the value 
     * does not exist in this BST, this method should 
     * return null.
     * @param val
     * @return
     */
    public Node findNode(E val) {
	if(val == null)
	    return null;
	return findNode(root, val); // this line is here only so this code will compile if you don't modify it
    }

    protected Node findNode(Node n, E val) {

	if(n == null)
	    return null;
	int cmp = val.compareTo(n.value);
	if(cmp == 0){ // we found the value and it is a node n
	    return n;   
	}else if(cmp < 0){
	    return findNode(n.leftChild, val);
	}else{
	    return findNode(n.rightChild, val);
	}
    }

    /**
     * Then, implement the depth method. Given a value, this method
     * should return the “depth” of its Node, which is the number
     * of ancestors between that node and the root, including the
     * root but not the node itself. The depth of the root is defined
     * to be 0; the depth of its two children (if any) is defined
     * to be 1; the depth of the root’s grandchildren (if any) is
     * defined to be 2; and so on. If the value is null or does 
     * not exist in this BST, this method should return -1.
     * @param val
     * @return
     */
    protected int depth(E val) {
	if(val == null)
	    return -1;
	Node n = findNode(val);
	if(n == null)
	    return -1;

	return depth(root, val);

    }

    private int depth(Node n, E val) {
	int cmp = val.compareTo(n.value);
	if(cmp == 0){ // we found it
	    return 0;
	}else if(cmp < 0){ //  check left
	    return 1 + depth(n.leftChild, val);
	}else{ //check right
	    return 1 + depth(n.rightChild, val);
	}

    }


    /**
     * Next, implement the height method. Given a value, this
     * method should return the “height” of its Node, which is 
     * the greatest number of nodes between that node and any 
     * descendant node that is a leaf, including the leaf but 
     * not the node itself. The height of a leaf node (i.e., 
     * one which has no children) is defined to be 0. If the 
     * input value is null or does not exist in this BST, this 
     * method should return -1.
     * @param val
     * @return
     */
    protected int height(E val) {

	if(val == null)
	    return -1;
	Node n = findNode(val);
	if(n == null)
	    return -1;

	return height(n);


    }


    private int height(Node n) {
	if (n == null)
	    return -1;
	return 1 + Math.max(height(n.leftChild), height(n.rightChild));
    }

  /**
   * Given a Node, return true if the absolute value of the difference 
   * in heights of its left and right children is 0 or 1, and return 
   * false otherwise. If the Node is null or does not exist in this 
   * BST, this method should return false.
   * @param n
   * @return
   */
    protected boolean isBalanced(Node n) {
	if( n == null || findNode(n.value) == null)
	    return false;
	int diff = Math.abs(height(n.leftChild) - height(n.rightChild));
	
	return diff == 0 || diff == 1;
    }

    /**
     * Finally, implement isBalanced() so that it returns true if 
     * isBalanced(Node) returns true for all Nodes in the tree. 
     * This method then allows the user of the BST to determine 
     * whether the BST is balanced, using the methods you’ve 
     * implemented above. Note that the root being balanced 
     * does not imply that the entire tree is balanced (see hint below).
     * @return
     */
    public boolean isBalanced() {

	return isBalancedTree(root); // this line is here only so this code will compile if you don't modify it

    }

    private boolean isBalancedTree(Node n) {
	if(n == null)
	    return true;
	return isBalanced(n) && isBalancedTree(n.leftChild) && isBalancedTree(n.rightChild);
    }

    public static void main (String args []){
	BinarySearchTree<Integer> BST = new BinarySearchTree<Integer> ();
	BST.add(8);
	BST.add(6);
	BST.add(16);
	BST.add(4);
	BST.add(2);
	BST.add(10);
	BST.add(20);
	BST.add(9);
	BST.add(12);

	BST.inOrder(BST.root.leftChild.leftChild);

	int number = 20;
	int findD = 20;
	int findH = 9;
	
	System.out.println("Looking for a number " + number +
		"\nFound: " + BST.findNode(number).value);
	System.out.println("Calculating depth of: " +
		findD + "\nDepth of "+ findD+" is: " + BST.depth(findD));

	System.out.println("Calculating height of: " +
		findH + "\nHeight of "+ findH+" is: " + BST.height(findH));
	
	System.out.println("Checking if the tree is balanced " + "\nBalance "
	+" is: " + BST.isBalanced());
	
	System.out.println("Checking if left child is balanced " + "\nBalance "
	+" is: " + BST.isBalancedTree(BST.root.leftChild));
	
	System.out.println("Checking if right child is balanced " + "\nBalance "
	+" is: " + BST.isBalancedTree(BST.root.rightChild));
	
	System.out.println(BST.isBalanced(BST.root.leftChild.leftChild));
	
	BinarySearchTree<Integer> BST1 = new BinarySearchTree<Integer> ();
	BST1.add(8);
	BST1.add(10);
	System.out.println(BST1.isBalanced(BST1.root));
    }
}
