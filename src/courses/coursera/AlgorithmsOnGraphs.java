package courses.coursera;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import domain.BinaryTree;

public class AlgorithmsOnGraphs {

    /**
     * Traverse binary tree.
     */
    public void traverseBinaryTree() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(50, "Boss");
        tree.addNode(25, "VP");
        tree.addNode(15, "Office Manager");
        tree.addNode(30, "Secretary");
        tree.addNode(75, "Sales Manager");
        tree.addNode(85, "Salesman");
//        tree.inOrderTraverseTree(tree.getRoot());
//        tree.preOrderTraverseTree(tree.getRoot());
        tree.postOrderTraverseTree(tree.getRoot());
        System.out.println();
        System.out.println("Search for key " + 30);
        System.out.println("key: " + tree.findNode(30).getKey() + " | name: " + tree.findNode(30).getName());
    }


    /**
     * Find largest sum of two dimensional array.
     */
    public void findLargestSumOfTwoDimensionalArray() {
        Scanner scanner = new Scanner(System.in);
        String[][] arr = new String[6][6]; //assuming array to be 6x6
        int max = 0;
        int rowLength = 6;
        for (int h = 0; scanner.hasNext() && h <= 5; h++) {
            arr[h] = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < rowLength - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int sum = Integer.valueOf(arr[i][j]) +
                        Integer.valueOf(arr[i][j + 1]) +
                        Integer.valueOf(arr[i][j + 2]) +
                        Integer.valueOf(arr[i + 1][j + 1]) +
                        Integer.valueOf(arr[i + 2][j]) +
                        Integer.valueOf(arr[i + 2][j + 1]) +
                        Integer.valueOf(arr[i + 2][j + 2]);
                if (i == 0 && j == 0 || sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }

    /**
     * Find exit from maze
     */
    public void findExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int[] path = {scanner.nextInt(), scanner.nextInt()};
        System.out.println(search(adj, path));
    }

    /**
     * @param adj  matrix
     * @param path .
     * @return num
     */
    public int search(ArrayList<Integer>[] adj, int[] path) {
        int result = 0;
        int[] visitedArr = new int[adj.length];
        Queue<Integer> queue = new LinkedList<>();
        //Add start node to queue
        queue.add(adj[0].get(1));
        //Set visited node to first node (0)
        visitedArr[0] = queue.peek();
        while (!queue.isEmpty()) {
            //Dequeue start node
            int node = queue.remove();
            System.out.println("Node: " + node);
            for (int i = 0; i < visitedArr.length - 1; i++) {
                //check if route exists and node is not visited
                if (adj[node].get(i) == 1 && visitedArr[i] == 0) {
                    visitedArr[i] = 1;
                    queue.add(i);
                    node = queue.remove();
                    System.out.println("--Node: " + node);
                }
            }
        }
        return result;
    }
}
