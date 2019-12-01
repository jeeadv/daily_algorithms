//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
//https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
//https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
class Tree{
    int diameter(Node node){
        return fun(node).dia;
    }
    Ans fun(Node node){
        if(node == null){
            return new Ans(0,0);
        }
        Ans left = fun(node.left);
        Ans right = fun(node.right);
        
        return new Ans(max(left.height, right.height)+1,
            max(left.dia,right.dia,left.height+right.height+1));
    }
    int max(int a, int b, int c){
        int max = a>b?a:b;
        return max>c?max:c;
    }
    int max(int a, int b){
        return a>b?a:b;
    }
}
class Ans{
    int height;
    int dia;
    Ans(int height, int dia){
        this.height = height;
        this.dia = dia;
    }
}
