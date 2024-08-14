package badaboom;


import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class TreeVisView {



    public void run(){

        int choice;

        Scanner sc=new Scanner(System.in);
        TreeNode tree=null;
        List<Integer> list = new ArrayList<>();
        TreeVisService service = new TreeVisService(tree);
        while(true){
            System.out.println("tree is: ");
            service.printTree(tree);
            System.out.println("");
            System.out.println("1-add node\n2-delete node\n3-give path to a given node\n4-stop");
            choice =sc.nextInt();


            switch (choice){
                case 1:
                    System.out.println("give node value to add: ");
                    int value = sc.nextInt();
                    if(tree==null) {


                    tree = service.setTreeRoot(value, tree);
                }
                    else {

                        service.addNode(tree, value);
                    }
                    break;
                case 2:

                    System.out.println("give node value to delete: ");
                    int value2=sc.nextInt();
                    tree=service.deleteNode(tree,value2);
                    break;
                case 3:
                    System.out.println("give node value to search: ");
                    int value3=sc.nextInt();
                    if(service.searchTreeDFS(tree,value3,list)) {
                        System.out.println("the path is " + list);
                        list.clear();
                    }
                    else
                        System.out.println("sorry,node doesnt exist.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("please enter a number between 1 and 4");
                    break;
            }
        }
    }

}
