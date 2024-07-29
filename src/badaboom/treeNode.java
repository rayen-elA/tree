package badaboom;



public class treeNode {
      private int val;
      private treeNode left;
      private treeNode right;
      public treeNode() {}
      public treeNode(int val) { this.val = val; }
      treeNode(int val, treeNode left, treeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      public int getVal(){
           return val;
          }
      public void setVal(int val){
          this.val=val;
          }
      public treeNode getLeft(){
          return  left ;
      }
      public treeNode getRight(){
        return  right ;
      }
      public void setLeft(treeNode left)
      {
          this.left=left;
      }
      public void setRight(treeNode right){
          this.right=right;
    }






  
}
