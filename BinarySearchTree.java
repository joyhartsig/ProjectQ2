//CLASS BinarySearchTree

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    /**
     * Finds the location of the target in the binary search tree, and returns a
     * reference to the data. Returns null if the target is not in the tree.
     *
     * @param target
     * The thing to search for,
     * @return A reference to the data in the tree if it is found, or null
     * otherwise.
     */

    public E find(E target) {

        // Implement this method.
        // Hint: Look at both the public and the private contains methods.
        // You'll need a private helper method version of find just like the
        // contains method. However, contains just determines if the target
        // is in the tree, returning a boolean. Your find method will instead
        // return the data that is found.
        return find(root,target);

    }

    private E find(Node<E> subtreeRoot, E target) {

        if (subtreeRoot == null)

            return null;

        if (target.compareTo(subtreeRoot.data) == 0)

            return subtreeRoot.data;

        else if (target.compareTo(subtreeRoot.data) < 0)

            return find(subtreeRoot.left, target);

        else

            return find(subtreeRoot.right, target);

    }

    /**

     * Searches tree for target.

     *

     * @param target

     * The element to look for.

     * @return true if in tree, and false otherwise

     */

    public boolean contains(E target) {

        return contains(root, target);

    }

    /**

     * Adds target to tree if it doesn't already exist.

     *

     * @param target

     * The element to add.

     * @return true if target added and false otherwise.

     */

    public boolean add(E target) {

        if (root == null) {

            root = new Node<E>(target);

            return true;

        }

        return add(root, target);

    }

    /**

     * Output contents in order.

     */

    public void printOrderedData() {

        inOrderTraversal(new ProcessData<E>() {

                @Override

                public void process(E data) {

                    System.out.print(data + " ");

                }

            });

    }

    private boolean contains(Node<E> subtreeRoot, E target) {

        if (subtreeRoot == null)

            return false;

        if (target.compareTo(subtreeRoot.data) == 0)

            return true;

        else if (target.compareTo(subtreeRoot.data) < 0)

            return contains(subtreeRoot.left, target);

        else

            return contains(subtreeRoot.right, target);

    }

    private boolean add(Node<E> subtreeRoot, E target) {

        if (target.compareTo(subtreeRoot.data) == 0)

            return false;

        else if (target.compareTo(subtreeRoot.data) < 0) {

            if (subtreeRoot.left == null) {

                subtreeRoot.left = new Node<E>(target);

                return true;

            }

            return add(subtreeRoot.left, target);

        } else {

            if (subtreeRoot.right == null) {

                subtreeRoot.right = new Node<E>(target);

                return true;

            }

            return add(subtreeRoot.right, target);

        }

    }

}