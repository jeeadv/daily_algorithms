//N-ary Tree Postorder Traversal
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        postorder(root, list);
        return list;
        
    }
    public void postorder(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        for(Node child: root.children){
            postorder(child, list);
        }
        list.add(root.val);
    }
}

//iterative
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node top = stack.pop();
            for(Node child: top.children){
                stack.push(child);
            }
            list.addFirst(top.val);
        }
        
        return list;
        
    }
}
