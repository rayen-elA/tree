import badaboom.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        treevisView view =new treevisView();
        treeNode tree=new treeNode();
        treevisService object= new treevisService(tree,view);
        tree=object.setTreeRoot(3);


        object.updateView();
        System.out.println("\n");
        tree=object.deleteNode(tree,3);





        object.updateView();
        }
    }
