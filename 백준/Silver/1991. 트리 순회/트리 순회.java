import java.util.*;
import java.io.*;

public class Main {
	
	static Map<Character, Node> tree = new HashMap<>();
	static Node root;
	
	static class Node {
		char data;
		Node left, right;
		
		public Node(char data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree.putIfAbsent(parent, new Node(parent));
			
			if (left != '.') {
				tree.putIfAbsent(left, new Node(left));
				tree.get(parent).left = tree.get(left);
			}
			
			if (right != '.') {
				tree.putIfAbsent(right, new Node(right));
				tree.get(parent).right = tree.get(right);
			}
		}
		
		root = tree.get('A');
		preorder(root);
		inorder(root);
		postorder(root);
	}
	
	static void preorder(Node node) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.data);
			if (current.right != null) stack.push(current.right);
			if (current.left != null) stack.push(current.left);
		}
		
		System.out.println();
	}
	
	static void inorder(Node node) {
		Stack<Node> stack = new Stack<>();
		Node current = node;
		
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(current.data);
			current = current.right;
		}
		
		System.out.println();
	}
	
	static void postorder(Node node) {
		Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);

        while (!stack1.isEmpty()) {
            Node cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) stack1.push(cur.left);
            if (cur.right != null) stack1.push(cur.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data);
        }
        
        System.out.println();
	}
	
}
