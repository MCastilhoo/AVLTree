import java.io.*;

public class Main {
    static class AVLTree {
        class Node {
            int key, height, size;
            Node left, right;

            Node(int key) {
                this.key = key;
                this.height = 1;
                this.size = 1;
            }
        }

        private Node root;

        private int height(Node node) {
            return node == null ? 0 : node.height;
        }

        private int size(Node node) {
            return node == null ? 0 : node.size;
        }

        private void updateNode(Node node) {
            if (node != null) {
                node.height = 1 + Math.max(height(node.left), height(node.right));
                node.size = 1 + size(node.left) + size(node.right);
            }
        }

        private Node rotateRight(Node y) {
            Node x = y.left;
            Node T = x.right;
            x.right = y;
            y.left = T;
            updateNode(y);
            updateNode(x);
            return x;
        }

        private Node rotateLeft(Node x) {
            Node y = x.right;
            Node T = y.left;
            y.left = x;
            x.right = T;
            updateNode(x);
            updateNode(y);
            return y;
        }

        private int getBalance(Node node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        private Node balance(Node node) {
            if (node == null) return null;

            updateNode(node);

            int balance = getBalance(node);

            if (balance > 1) {
                if (getBalance(node.left) < 0) {
                    node.left = rotateLeft(node.left);
                }
                return rotateRight(node);
            }

            if (balance < -1) {
                if (getBalance(node.right) > 0) {
                    node.right = rotateRight(node.right);
                }
                return rotateLeft(node);
            }

            return node;
        }

        public void insert(int key) {
            root = insert(root, key);
        }

        private Node insert(Node node, int key) {
            if (node == null) return new Node(key);

            if (key < node.key) {
                node.left = insert(node.left, key);
            } else if (key > node.key) {
                node.right = insert(node.right, key);
            }

            return balance(node);
        }

        public void delete(int key) {
            root = delete(root, key);
        }

        private Node delete(Node node, int key) {
            if (node == null) return null;

            if (key < node.key) {
                node.left = delete(node.left, key);
            } else if (key > node.key) {
                node.right = delete(node.right, key);
            } else {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;

                Node minLargerNode = getMin(node.right);
                node.key = minLargerNode.key;
                node.right = delete(node.right, minLargerNode.key);
            }

            return balance(node);
        }

        private Node getMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public boolean exists(int key) {
            return exists(root, key);
        }

        private boolean exists(Node node, int key) {
            if (node == null) return false;
            if (key < node.key) return exists(node.left, key);
            if (key > node.key) return exists(node.right, key);
            return true;
        }

        public String next(int key) {
            Node succ = null;
            Node current = root;

            while (current != null) {
                if (key < current.key) {
                    succ = current;
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            return succ == null ? "none" : String.valueOf(succ.key);
        }

        public String prev(int key) {
            Node pred = null;
            Node current = root;

            while (current != null) {
                if (key > current.key) {
                    pred = current;
                    current = current.right;
                } else {
                    current = current.left;
                }
            }

            return pred == null ? "none" : String.valueOf(pred.key);
        }

        public String kth(int k) {
            if (k <= 0 || k > size(root)) return "none";
            return String.valueOf(kth(root, k));
        }

        private int kth(Node node, int k) {
            int leftSize = size(node.left);

            if (k == leftSize + 1) {
                return node.key;
            } else if (k <= leftSize) {
                return kth(node.left, k);
            } else {
                return kth(node.right, k - leftSize - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AVLTree tree = new AVLTree();
        String line;

        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "insert":
                    tree.insert(Integer.parseInt(parts[1]));
                    break;
                case "delete":
                    tree.delete(Integer.parseInt(parts[1]));
                    break;
                case "exists":
                    System.out.println(tree.exists(Integer.parseInt(parts[1])) ? "true" : "false");
                    break;
                case "next":
                    System.out.println(tree.next(Integer.parseInt(parts[1])));
                    break;
                case "prev":
                    System.out.println(tree.prev(Integer.parseInt(parts[1])));
                    break;
                case "kth":
                    System.out.println(tree.kth(Integer.parseInt(parts[1])));
                    break;
            }
        }
    }
}
