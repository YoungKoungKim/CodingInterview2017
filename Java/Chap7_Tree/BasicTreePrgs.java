import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BasicTreePrgs {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//트리 생성
		BinaryTree tree = new BinaryTree();
		
		TreeNode n7 = tree.link(null, 'D', null);
		TreeNode n6 = tree.link(null, 'C', null);
		TreeNode n5 = tree.link(null, 'B', null);
		TreeNode n4 = tree.link(null, 'A', null);
		TreeNode n3 = tree.link(n6, '/', n7);
		TreeNode n2 = tree.link(n4, '*', n5);
		TreeNode n1 = tree.link(n2, '-', n3);
		
		while (true) {
			System.out.println("--------------------------");
			System.out.println("1.InsertNode 2.Traversing");
			System.out.println("--------------------------");
			
			System.out.print("Select Menu >> ");
			int select = scan.nextInt();
			
			if (select == 1) {
				System.out.print("Input data >> ");
				Object inputData = scan.next();
				tree.insertInBinaryTree(n1, inputData);
			} else if (select == 2) {
				System.out.println("----------------------------------------------");
				System.out.println("1.Preorder 2.Inorder 3.Postorder 4.Levelorder");
				System.out.println("----------------------------------------------");
				
				int selectTraversing = scan.nextInt();
				
				if (selectTraversing == 1) {
					System.out.println("PreOrder");
					tree.preorder(n1);
				} else if (selectTraversing == 2) {
					System.out.println("InOrder");
					tree.inorder(n1);
				} else if (selectTraversing == 3) {
					System.out.println("PostOrder");
					tree.postorder(n1);
				} else if (selectTraversing == 4) {
					System.out.println("LevelOrder");
					tree.levelorder(n1);
				}
				System.out.println();
				System.out.println();
			}
		}
	}
}

class TreeNode {
	Object data;
	TreeNode left;
	TreeNode right;
}

class BinaryTree {
	private TreeNode root;
	
	public TreeNode link(TreeNode left, Object data, TreeNode right) {
		TreeNode root = new TreeNode();
		root.data = data;
		root.left = left;
		root.right = right;
		return root;
	}
	
	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data);
		}
	}
	
	public void levelorder(TreeNode root) {
		TreeNode temp;
		Queue<TreeNode> Q = new ArrayDeque<>();
		
		if (root == null)
			return;
		
		Q.add(root);
		while (!Q.isEmpty()) {
			temp = Q.remove();
			
			System.out.print(temp.data);
			
			if (temp.left != null) {
				Q.add(temp.left);
			}
			if (temp.right != null) {
				Q.add(temp.right);
			}
		}
	}
	
	public void insertInBinaryTree(TreeNode root, Object data) {
		Queue<TreeNode> Q = new ArrayDeque<>();
		TreeNode temp;
		TreeNode newNode = new TreeNode();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		
		if (newNode == null) {
			System.out.println("Memory Error");
			return;
		}
		if (root == null) {
			root = newNode;
			return;
		}
		
		Q.add(root);
		while (!Q.isEmpty()) {
			temp = Q.remove();
			if (temp.left != null) {
				Q.add(temp.left);
			} else {
				temp.left = newNode;
				Q = null;
				return;
			}
			
			if (temp.right != null) {
				Q.add(temp.right);
			} else {
				temp.right = newNode;
				Q = null;
				return;
			}
		}
		Q = null;
	}
	
}
