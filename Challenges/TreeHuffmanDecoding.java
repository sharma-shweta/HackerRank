/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 

void decode(String S ,Node root)
    {
        String result = "";
        Node origRoot = root;
        for (int i=0; i<S.length(); i++){
            if (S.charAt(i) == '1'){
                root = root.right;
            }
            if (S.charAt(i) == '0'){
                root = root.left;
            }
            if (isLeaf(root)) {
                result += root.data;
                root = origRoot;
            }
        }
        System.out.println(result);
    }

boolean isLeaf(Node node){
    return (node.left==null && node.right==null);
}