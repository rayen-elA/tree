import badaboom.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        treevisView view =new treevisView();
        treeNode tree=new treeNode();
        treevisService object= new treevisService(tree,view);
        object.setTreeRoot(2);
        object.addNode(tree,5);
        object.addNode(tree,3);
        object.addNode(tree,8);
        object.addNode(tree,1);
        object.addNode(tree,0);





        object.updateView();
        }
    }
