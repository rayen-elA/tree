package badaboom;
import java.util.Scanner;
public class treevisView {
public treevisView(){}

public void update(treeNode tree) {
        while(tree!=null)
        {
            System.out.println(tree.getVal()+"\n");
            update(tree.getRight());
            update(tree.getLeft());
        }


    }

}
