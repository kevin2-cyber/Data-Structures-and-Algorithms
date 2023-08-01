public class DFS {

    public static void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val + "");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root){
        if (root == null)
            return;


        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + "");
    }

    public static void main(String[] args) {
        // constructing the binary search
        TreeNode root = new TreeNode(9);

        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);

        // Performing depth-first traversals
        System.out.println("Pre-order traversal:");
        preOrder(root);
        System.out.println("\nIn-order traversal:");
        inOrder(root);
        System.out.println("\nPost-order traversal:");
        postOrder(root);

    }
}

