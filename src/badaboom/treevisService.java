
package badaboom;
import javax.swing.*;
public class treevisService {
    public treeNode tree ;
    public treevisView view;
    public treevisService(){}
    public treevisService(treeNode tree,treevisView view){
        this.tree=tree;
        this.view=view;
    }
    public treeNode setTreeRoot(int val){
         tree.setVal(val);
        return tree;
    }
    public void addNode(treeNode tree,int val){
        treeNode current=tree;
        treeNode newNode =new treeNode(val);

        treeNode parent =null;
        if (tree==null){
            tree=newNode;
            return;
        }
        else {

            while (true) {
                parent=current;
                if(val< current.getVal()){
                    current=current.getLeft();
                    if(current==null){
                        parent.setLeft(newNode);
                        return;
                    }

                }
                else{
                    current=current.getRight();
                    if(current==null) {
                        parent.setRight(newNode);
                        return;
                    }

                }
            }
        }
        }
    public treeNode deleteNode(treeNode tree,int val){
        treeNode current=tree;
        treeNode parent =null;
        treeNode a=new treeNode();
        if (tree==null){// tree is empty nothing to delete
            System.out.println("tree is empty bro, the fuck are you trying to delete?");
        }
        else {

            while (true) {//looking for node to delete
                if (current.getVal()==val)
                    break;
                parent=current;
                if(val< current.getVal()){
                    current=current.getLeft();
                    if(current==null){
                        System.out.println("is you blind? that doesnt exist");
                        return tree;
                    }


                }
                else{
                    current=current.getRight();
                    if(current==null) {
                        System.out.println("is you blind?"+ val +"doesnt exist");
                        return tree;
                    }
                }


            }


            if (current.getRight()==null && current.getLeft()==null) {//if deleting a leaf
                if(parent==null) {
                    System.out.println("asba");
                    return parent;

                }
                else if (parent.getLeft()==current) {
                    parent.setLeft(null);

                }
                else {parent.setRight(null);


                }
                return tree;
            }
            if (current.getRight()==null && current.getLeft()!=null) {//if there's one child
                if (parent != null) {
                    if (parent.getLeft() == current) {
                        parent.setLeft(current.getLeft());

                    } else {
                        parent.setRight(current.getLeft());

                    }


                } else {
                    tree = tree.getLeft();
                }
                return tree;
            }
            else if (current.getLeft()==null && current.getRight()!=null){
                if(parent!=null) {
                    if (parent.getLeft() == current) {
                        parent.setLeft(current.getRight());

                    } else {
                        parent.setRight(current.getRight());

                    }
                }
                else{
                    tree=tree.getRight();

                }
                return tree;
            }
            if ((current.getLeft() != null) && (current.getRight() != null)){
                if (parent==null){
                    treeNode x=searchsmallestnode(current.getRight());
                    current.setVal(x.getVal());
                    x=searchsmallestnode1(current.getRight());
                    x.setLeft(null);


                }
                else{treeNode omi=searchsmallestnode1(current.getRight());
                    if(omi==current.getRight()){
                    if (current.getRight().getLeft()!=null){
                        current.setVal(current.getRight().getLeft().getVal());
                        current.getRight().setLeft(null);

                    }
                    else{
                        current.setVal(current.getRight().getVal());
                        current.setRight(current.getRight().getRight());

                    }


                }
                    else{current.setVal(omi.getLeft().getVal());
                        omi.setLeft(omi.getLeft().getRight());


                    }

                }

                return tree;
            }


        }
        return a;
    }
    public treeNode searchTree(treeNode tree,int val){
        treeNode placeholder=tree;
        if (tree==null)return tree;
        while (val!=placeholder.getVal() || placeholder==null){
            if( val< placeholder.getVal()) placeholder=placeholder.getLeft();
            else placeholder=placeholder.getRight();
        }
        if (placeholder.getVal()!=val)
        return null;
        else
            return placeholder;


    }
    public treeNode searchsmallestnode(treeNode tree){
        treeNode omek=tree;

        while((omek.getLeft())!= null) {
            omek = omek.getLeft();
        }
        return omek;
    }
    public treeNode searchsmallestnode1(treeNode tree){
        treeNode omek=tree;

        while (omek.getLeft()!= null){
            while ((omek.getLeft().getLeft()) != null) {
                omek = omek.getLeft();
            }
        }
        return omek;
    }
    public void updateView(){
        view.update(tree);
    }
}

