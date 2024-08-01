import badaboom.TreeNode;
import badaboom.TreeVisService;
import badaboom.TreeVisView;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TreeVisView view = new TreeVisView();
        //view.run();

        TreeNode tree = new TreeNode();
        List<Integer> list = new ArrayList<>();
        TreeVisService service = new TreeVisService(tree, view);
        tree = service.setTreeRoot(33, tree);
        service.addNode(tree,25);
        service.addNode(tree,55);
        service.addNode(tree,35);
        service.addNode(tree,15);
        //tree = service.deleteNode(tree, 33);

        service.printTree(tree);
        /*if(service.searchTreeDFS(tree,22,list))
            System.out.println("the path is "+list);
        else
            System.out.println("YNA3N DIN ZA7I YA BHIM E TREE 9ODEMEK");*/


    }
}
