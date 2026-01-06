package Praktikum4;

import java.util.Arrays;

class BaumKnoten {
	// beachte keine Kapselung
	BaumKnoten left;
	BaumKnoten right;

	int value;

	public BaumKnoten(int value) {
		this.value = value;
	}
}

public class BinarySearchTree {

	BaumKnoten root;

	// ===== SEARCH =====
	public boolean search(int value) {
		return searchHelp(root, value);
	}

	private boolean searchHelp(BaumKnoten root, int value) {
		// Baum Traversierung (in Order)
		if (root == null) {
			return false;
		} else if (root.value == value) {
			return true;
		} else if (root.value > value) {
			return searchHelp(root.left, value);
		} else {
			return searchHelp(root.right, value);
		}
	}

	// ===== INSERT =====
	public void insert(BaumKnoten node) {
		root = insertHelp(root, node);
	}

	private BaumKnoten insertHelp(BaumKnoten root, BaumKnoten node) {
		int value = node.value;

		if (root == null) {
			root = node;
			return root;
		} else if (value < root.value) {
			root.left = insertHelp(root.left, node);
		} else {
			root.right = insertHelp(root.right, node);
		}

		return root;
	}

	// ===== REMOVE =====
	public void remove(int value) {
		if (search(value)) {
			// WICHTIG: Ergebnis zurück an root (sonst kann Löschen der Wurzel schiefgehen)
			root = removeHelp(root, value);
		} else {
			System.out.println(value + " nicht auffindbar.");
		}
	}

	private BaumKnoten removeHelp(BaumKnoten root, int value) {
		if (root == null) {
			return root;
		} else if (value < root.value) {
			root.left = removeHelp(root.left, value);
		} else if (value > root.value) {
			root.right = removeHelp(root.right, value);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else {
				if (root.right != null) {
					// Es muss ein Nachfolger gesucht werden, der den Knoten ersetzt
					root.value = getSuccessor(root);
					root.right = removeHelp(root.right, root.value);
				} else {
					// Es muss ein Vorgaenger gesucht werden, der den Knoten ersetzt
					root.value = getPredecessessor(root);
					root.left = removeHelp(root.left, root.value);
				}
			}
		}
		return root;
	}

	// ===== SUCCESSOR =====
	private int getSuccessor(BaumKnoten root) {
		// diese Methode sucht den kleinsten Wert unter dem rechten Kind des Wurzelknotens
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root.value;
	}

	// ===== PREDECESSOR =====
	private int getPredecessessor(BaumKnoten root) {
		// diese Methode sucht den groessten Wert unter dem linken Kind des Wurzelknotens
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
		return root.value;
	}

	// ===== TO STRING =====
	public String toString() {
		return printTeilBaum(this.root);
	}

	private String printTeilBaum(BaumKnoten currentRootNode) {
		String ret = "";

		if (currentRootNode == null) {
			ret = " null";
		} else {
			ret += " (";
			ret += " " + currentRootNode.value + " ";
			ret += printTeilBaum(currentRootNode.left);
			ret += printTeilBaum(currentRootNode.right);
			ret += ") ";
		}
		return ret;
	}

	// =====================================================
	// Baumtraversierungen (Praktikum 4: Traversierungen)
	// =====================================================

	// Inorder: links, node, rechts  -> bei BST: sortiert
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	private void inOrder(BaumKnoten node) {
		if (node == null) return;
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	// Preorder: node, links, rechts
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}

	private void preOrder(BaumKnoten node) {
		if (node == null) return;
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// ==== binarySearch auf sortiertes Array (Skript 8) ====
	public static int binarySearch(int[] a, int x) {
		int l = 0;
		int r = a.length - 1;

		while (l <= r) {
			int m = (l + r) / 2;

			if (a[m] == x) {
				return m;
			} else if (x < a[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	// ===== MAIN =====
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(new BaumKnoten(1));
		tree.insert(new BaumKnoten(13));
		tree.insert(new BaumKnoten(4));
		tree.insert(new BaumKnoten(17));
		tree.insert(new BaumKnoten(18));
		tree.insert(new BaumKnoten(9));
		tree.insert(new BaumKnoten(11));
		tree.insert(new BaumKnoten(2));

		System.out.println("Baum (Klammerform):");
		System.out.println(tree);

		System.out.println("Inorder:    ");
		tree.inOrder();

		System.out.println("Preorder:   ");
		tree.preOrder();

		tree.remove(4);
		System.out.println("\nNach remove(4):");
		System.out.println(tree);

		System.out.println("search(2): " + tree.search(2));

		tree.remove(2);
		System.out.println("\nNach remove(2):");
		System.out.println(tree);

		System.out.println("search(2): " + tree.search(2));

		// Binary Search Test
		int[] arr = { 1, 13, 4, 17, 18, 9, 11, 2 };
		Arrays.sort(arr);
		System.out.println("\nSortiertes Array: " + Arrays.toString(arr));
		int index = binarySearch(arr, 11);
		System.out.println("binarySearch(11) -> Index: " + index);
	}
}
