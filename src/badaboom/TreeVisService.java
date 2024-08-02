
package badaboom;

import java.util.List;

public class TreeVisService {
    public TreeNode tree;

    public TreeVisService(TreeNode tree) {
        this.tree = tree;

    }

    public TreeNode setTreeRoot(int val, TreeNode tree) {
        TreeNode tree1=new TreeNode(val);

        return tree1;
    }

    public void printTree(TreeNode tree) {

        if (tree != null) {
            System.out.print(tree.getVal() + " | ");
            printTree(tree.getRight());
            printTree(tree.getLeft());
        }
        else
            return;


    }

    public void addNode(TreeNode tree, int val) {
        TreeNode current = tree;
        TreeNode newNode = new TreeNode(val);

        TreeNode parent;
        if (tree == null) {
            tree = newNode;
        } else {
            while (true) {
                parent = current;
                if (val < current.getVal()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        break;
                    }

                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        break;
                    }

                }
            }
        }


        //printTree(tree);
        System.out.println("");

    }


    private TreeNode searchTree(TreeNode current,int val ){
        TreeNode parent=null;
        while (true) {//looking for node to delete
            if (current.getVal() == val) {
                System.out.println(3);
                break;
            }

            parent = current;
            if (val < current.getVal()) {
                current = current.getLeft();
                if (current == null) {
                    System.out.println("are you blind?" + val + "doesnt exist");
                    return parent=null;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    System.out.println("are you blind?" + val + "doesnt exist");

                    return parent=null;
                }
            }
        }
        return parent;
    }
    public TreeNode deleteNode(TreeNode tree, int val) {
        TreeNode current = tree;
        TreeNode parent=null;
        TreeNode a = new TreeNode();


        if (tree == null) {// tree is empty nothing to delete
            System.out.println("tree is empty bro, the fuck are you trying to delete?");
        } else {

            if(searchTree(tree,val)!=null){
                if (current!=null)
                {
                    parent = searchTree(tree, val);
                    if (parent.getLeft()!= null)
                        if (parent.getLeft().getVal()==val)
                            current = parent.getLeft();
                    else
                        current = parent.getRight();
                }
                else
                    return tree;


            }

            if (current.getRight() == null && current.getLeft() == null) {//if deleting a leaf
                if (parent == null) {
                    return null;
                } else if (parent.getLeft() == current) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
                return tree;
            }
            if (current.getRight() == null && current.getLeft() != null) {//if there's one child on the left
                if (parent != null) {//node to delete isnt the root
                    if (parent.getLeft() == current) {//if node to delete on the left of the parent
                        parent.setLeft(current.getLeft());//skipping over the node to delete
                    } else {
                        parent.setRight(current.getLeft());//skipping over the node to delete
                    }
                } else {//node to delete is root so just skip over
                    tree = tree.getLeft();
                }
                return tree;
            } else if (current.getLeft() == null && current.getRight() != null) {//node to delete has a child on the right
                if (parent != null) {
                    if (parent.getLeft() == current) {
                        parent.setLeft(current.getRight());
                    } else {
                        parent.setRight(current.getRight());
                    }
                } else {
                    tree = tree.getRight();

                }
                return tree;
            }
            if ((current.getLeft() != null) && (current.getRight() != null)) {//node to delete has 2 children
                System.out.println("entered delete");
                if (parent == null) {//node to delete is the root
                    TreeNode x = searchSmallestNode(current.getRight()).getLeft();
                    current.setVal(x.getVal());
                    x = searchSmallestNode(current.getRight());
                    x.setLeft(null);
                } else {
                    TreeNode omi = searchSmallestNode(current.getRight());
                    if (omi == current.getRight()) {
                        if (current.getRight().getLeft() != null) {
                            current.setVal(current.getRight().getLeft().getVal());
                            current.getRight().setLeft(null);
                        } else {
                            current.setVal(current.getRight().getVal());
                            current.setRight(current.getRight().getRight());
                        }
                    } else {
                        current.setVal(omi.getLeft().getVal());
                        omi.setLeft(omi.getLeft().getRight());
                    }
                }
                return tree;
            }
        }
        return a;
    }

    public boolean searchTreeDFS(TreeNode tree, int val, List<Integer> path) {
        if (tree == null)
            return false;
        path.add(tree.getVal());
        if (tree.getVal() == val)
            return true;
        if (searchTreeDFS(tree.getRight(), val, path))
            return true;
        if (searchTreeDFS(tree.getLeft(), val, path))
            return true;
        path.removeLast();
        return false;

    }

    public TreeNode searchSmallestNode(TreeNode tree) {
        TreeNode treeNode = tree;
        while (treeNode.getLeft() != null) {

            while ((treeNode.getLeft().getLeft()) != null) {

                treeNode = treeNode.getLeft();
            }
            if(treeNode.getLeft() != null && ((treeNode.getLeft().getLeft()) == null) )
                break;
        }
        return treeNode;
    }

}

