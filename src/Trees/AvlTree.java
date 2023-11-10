package Trees;

public class AvlTree {
    class Node{
        int value;
        Node left;
        Node right;
        int height;
        int balFac;
        public Node(int value){
            this.value=value;
            this.right=null;
            this.left=null;
            this.height=0;
            this.balFac=0;
        }
    }
    Node root;
//    int height;
    public AvlTree(){
        this.root=null;
//        this.height=-1;
    }

    public void insert(int value){
        if (this.root==null){
            Node node=new Node(value);
            this.root=node;
            heightManager(this.root);
            return;
        }
        if (value<= root.value){
            root.left=insert(root.left,value);
            heightManager(this.root);
            root.balFac=this.getHeight(root.left)-this.getHeight(root.right);
            if (root.balFac!=-1 && root.balFac!=0 && root.balFac!=1){
                if (this.getHeight(root.left.left)>this.getHeight(root.left.right)){
                    root.left=llRotation(root);
                }else{
                    root.left=lrRotation(root);
                }
                heightManager(this.root);
            }
        }else {
            root.right = insert(root.right, value);
            heightManager(this.root);
            root.balFac=this.getHeight(root.left)-this.getHeight(root.right);
            if (root.balFac!=-1 && root.balFac!=0 && root.balFac!=1){
                if (this.getHeight(root.right.right)>this.getHeight(root.right.left)){
                    root.right=rrRotation(root);
                }else {
                    root.right=rlRotation(root);
                }
                heightManager(this.root);
            }
        }
    }

    public int getHeight(Node node )
    {
        return node == null ? -1 : node.height;
    }

    public Node rrRotation(Node root){
        Node P=root;
        Node Y=P.right;
        P.right=Y.left;
        Y.left=P;
        return Y;
    }
    public Node rlRotation(Node root){
        Node P=root;
        Node Y=P.right;
        Node Z=Y.left;
        if(this.getHeight(Z)>=0){
            Y.left = Z.right;
        }
        Z.right=Y;
        P.right=Z.left;
        Z.left=P;
        return Z;
    }
    public Node llRotation(Node root){
        Node P=root;
        Node X=P.left;
        P.left=X.right;
        X.right=P;
        return X;
    }
    public Node lrRotation(Node root){
        Node P=root;
        Node X=P.left;
        Node Z=X.right;
        X.right=Z.left;
        Z.left=X;
        P.left=Z.right;
        Z.right=P;
        return Z;
    }
    private Node insert(Node root,int value){
        if (root==null){
            Node node=new Node(value);
            heightManager(this.root);
            return node;
        }
        if (value<=root.value){
            root.left=insert(root.left,value);
            heightManager(this.root);
            root.balFac=this.getHeight(root.left)-this.getHeight(root.right);
            if (Math.abs(root.balFac)>1){
                if (this.getHeight(root.left.left)>this.getHeight(root.left.right)){
                    root.left=llRotation(root);
                }else{
                    root.left=lrRotation(root);
                }
                heightManager(this.root);
            }
        }else{
            root.right = insert(root.right, value);
            heightManager(this.root);
            root.balFac=this.getHeight(root.left)-this.getHeight(root.right);
            if (Math.abs(root.balFac)>1){
                if (this.getHeight(root.right.right)>this.getHeight(root.right.left)){
                    root.right=rrRotation(root);
                }else {
                    root.right=rlRotation(root);
                }
                heightManager(this.root);
            }
        }
        return root;
    }

    public void delete(int value){
        if (this.root==null)return;
        if (root.value==value){
            if (root.left!=null && root.right!=null){
                root.value=inorderSuccessor(root.right);
                delete(root.right,root.value);
            }else if (root.left!=null){
                root=root.left;
            }else if (root.right!=null){
                root=root.right;
            }else{
                root=null;
            }
            return;
        }else if(value < root.value) {
            root.right= delete(root.right, value);
        }else{
            root.left=delete(root.left, value);
        }
        heightManager(this.root);
    }

    private Node delete(Node root,int value){
        if (root==null) return root;
        if (root.value==value){
            if (root.left!=null && root.right!=null){
                root.value=inorderSuccessor(root.right);
                delete(root.right,root.value);
            }else if (root.left!=null){
                root=root.left;
            }else if (root.right!=null){
                root=root.right;
            }else{
                root=null;
            }
        }
        if (root.value<value){
            root.left=delete(root.left,value);
        }else{
            root.right=delete(root.right,value);
        }
        return root;
    }
    private int heightManager(Node root){
        if (root==null)return -1;
        root.height=Math.max(heightManager(root.left),heightManager(root.right));
        return root.height++;
    }
    public void populate(int[]arr){
        for (int i = 0; i <arr.length ; i++) {
            this.insert(arr[i]);
        }
    }
    public void display(){
        display(root);
    }
    private void display(Node root){
        if (root==null)return;
        display(root.left);
        System.out.print(root.value+" ");
        display(root.right);
    }
    private int inorderSuccessor(Node root){
        if (root.left==null){
            return root.value;
        }
        int val=inorderSuccessor(root.left);
        return val;
    }
}
