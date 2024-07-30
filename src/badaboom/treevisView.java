package badaboom;
import java.util.Scanner;
public class treevisView {
public treevisView(){}

public void update(treeNode tree) {
    if (tree==null){
        return;
    }else
    {
        System.out.println(tree.getVal()+"  ");
        update(tree.getRight());
        update(tree.getLeft());

    }


}

}
