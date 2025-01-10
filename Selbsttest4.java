package test;

class Treeroot {
	 int key;
	 Treeroot left, right;

	 public Treeroot(int key) {
	     this.key = key;
	     left = right = null;
	 }
}

public class Selbsttest4 {
	Treeroot root;
	
	public Selbsttest4() {
		root = null;
	}
	
	public void insert(int key) {
		root = insertRec(root, key);
	}
	
	public Treeroot insertRec(Treeroot root,int key) {
		if(root == null){
			root = new Treeroot(key);
			return root;
		}
		
		if(key < root.key) {
			root.left = insertRec(root.left,key);
		}
		
		if(key > root.key) {
			root.right = insertRec(root.right,key);
		}
		
		return root;
	}
	
	public boolean search(int key) {
		return searchRec(root, key);
	}
	
	public boolean searchRec(Treeroot root, int key) {
		if(root == null){
			return false;
		}
		
		if(root.key == key){
			return true;
		}
		
		return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
	}
	
	public void delete(int key){
		root = deleteRec(root, key);
	}
	
	private Treeroot deleteRec(Treeroot root, int key) {
		if(root == null) {
			return root;
		}
		
		if(key < root.key) {
			root.left = deleteRec(root.left, key);
		} else if(key > root.key){
			root.right = deleteRec(root.right, key);
		} else {
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			}
			
			root.key = minvalue(root.right);
			root.right = deleteRec(root.right, root.key);
		}
		
		return root;
	}
	
	public int minvalue(Treeroot root) {
		int min = root.key;
		while(root.left != null) {
			min = root.left.key;
			root = root.left;
		}
		return min;
	}
	
	public static int depth(Treeroot p) {
	        if(p == null) {
	            return 0;
	        }
	        int leftDepth = depth(p.left);
	        int rightDepth = depth(p.right);
	        return Math.max(leftDepth, rightDepth) + 1;
	    }
	 
	public void printout(String order) {
	    if (order.equalsIgnoreCase("preorder")) {
	        System.out.print("Pre-Order: ");
	        printPreOrder(root);
	    } else if (order.equalsIgnoreCase("inorder")) {
	        System.out.print("In-Order: ");
	        printInOrder(root);
	    } else {
	        System.out.println("Invalid order specified. Use 'preorder' or 'inorder'.");
	    }
	    System.out.println("\n");
	}
	
	private void printPreOrder(Treeroot root) {
	    if (root != null) {
	        System.out.print(root.key + " { ");
	        if (root.left != null || root.right != null) {
	            printPreOrder(root.left);
	            printPreOrder(root.right);
	        } else {
	            System.out.print("null null");
	        }
	        System.out.print(" } ");
	    }
	}
	
	private void printInOrder(Treeroot root) {
	    if (root != null) {
	        printInOrder(root.left);
	        System.out.print(root.key + " ");
	        printInOrder(root.right);
	    }
	}
	
	public static boolean isBalanced(Treeroot p) {
	    return checkBalance(p) != -1;
	}

	private static int checkBalance(Treeroot p) {
	    if (p == null) {
	        return 0;
	    }

	    int leftHeight = checkBalance(p.left);
	    int rightHeight = checkBalance(p.right);

	    if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
	        return -1; 
	    }

	    return Math.max(leftHeight, rightHeight) + 1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Selbsttest4 baum = new Selbsttest4();
		
		int[] zahlen = {3,7,6,10,9};
		for (int zahl : zahlen) {
            baum.insert(zahl);
        }
		
		baum.printout("preorder");
		baum.printout("inorder");
		
		
		System.out.println("Suche nach 7: " + baum.search(7));
		
		baum.delete(7);
        System.out.println("\nNach dem loeschen von 7: \n");
        
        System.out.println("Suche nach 7: " + baum.search(7) + "\n");
		
        baum.printout("preorder");
		baum.printout("inorder");
		
        System.out.println("Die hoehe des Baumes: " + depth(baum.root));
        
        System.out.println(isBalanced(baum.root));
	}

}
