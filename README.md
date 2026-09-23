Binary Tree Implementation in Java

 Java implementation of a Binary Tree using classes, object references, arrays, and recursion.

This project was created to practice the fundamentals of binary trees and understand how recursive methods can be used to construct a tree from a preorder representation.

_______________________________________________________________________________________________________________
Project Overview

The program builds a binary tree from an integer array.

The array uses preorder representation:

Root → Left Subtree → Right Subtree

A value of -1 represents a missing node (null).

For example:

        1
       / \
      2   3
     / \   \
    4   5   6

Can be represented as:

int[] nodes = {
    1,
    2, 4, -1, -1,
    5, -1, -1,
    3, -1,
    6, -1, -1
};
_______________________________________________________________________________________________________________
Tree Representation

The input:

int[] nodes = {
    1, 2, 4, -1, -1,
    5, -1, -1,
    3, -1,
    6, -1, -1
};

creates the following binary tree:

             1
            / \
           2   3
          / \   \
         4   5   6

Each number represents a node.

Each -1 represents a missing child.

_______________________________________________________________________________________________________________
Node Structure

Each tree node is represented by the Node class:

static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

Each node contains three pieces of information:

Field	Purpose
data	Stores the value of the node
left	Reference to the left child
right	Reference to the right child

Conceptually:

          Node
        /  |  \
       /   |   \
    left data right
_______________________________________________________________________________________________________________
How buildTree() Works

The buildTree() method uses recursion to construct the tree.

public static Node buildTree(int nodes[]) {

    idx++;

    if (nodes[idx] == -1) {
        return null;
    }

    Node newNode = new Node(nodes[idx]);

    newNode.left = buildTree(nodes);
    newNode.right = buildTree(nodes);

    return newNode;
}
Step 1: Move to the next array element
idx++;

The idx variable keeps track of which value in the array we are currently processing.

Step 2: Check for -1
if (nodes[idx] == -1) {
    return null;
}

If the current value is -1, there is no node at that position.

The method returns null.

Step 3: Create a node

If the value is not -1:

Node newNode = new Node(nodes[idx]);

A new node is created using that value.

Step 4: Build the left subtree
newNode.left = buildTree(nodes);

The method calls itself to build the left child.

Step 5: Build the right subtree
newNode.right = buildTree(nodes);

After the left subtree is complete, the method recursively builds the right subtree.

Step 6: Return the node
return newNode;

The completed node is returned to the previous recursive call.

_______________________________________________________________________________________________________________
Recursion Pattern

The most important idea in this project is:

              Create Node
                  |
                  ↓
          Build Left Subtree
                  |
                  ↓
         Build Right Subtree
                  |
                  ↓
             Return Node

The recursion continues until it encounters -1.

_______________________________________________________________________________________________________________
Example Walkthrough

For this input:

int[] nodes = {
    1, 2, 4, -1, -1,
    5, -1, -1,
    3, -1,
    6, -1, -1
};

The program starts with:

1

So it creates:

Node(1)

Then it recursively builds the left subtree:

2

Then:

4

When it reaches:

-1

it knows that 4 has no left child.

It reaches another -1, so 4 has no right child either.

The same process continues for the rest of the tree.

_______________________________________________________________________________________________________________
Current Program Output

The current version of the program prints the root node:

System.out.println(root.data);

Output:

1

The tree itself is stored in memory through the Node objects and their left and right references.

_______________________________________________________________________________________________________________
Project Structure
Binarytrees.java/
│
├── src/
│   └── BinaryTrees.java
│
└── README.md

_________________________________________________________________________________________________________
Running the Project in VS Code

Requirements
Java Development Kit (JDK)
VS Code
Java Extension Pack for VS Code
1. Open the project

Open the project folder in VS Code.

2. Open BinaryTrees.java

Find the Java source file containing:

public class BinaryTrees
3. Run the program

You can either:

Click Run above the main() method
Or use the VS Code Run button

The program should print:

1

_______________________________________________________________________________________________________________
Technologies

Java
Object-Oriented Programming
Recursion
Binary Trees
Arrays
_______________________________________________________________________________________________________________
Concepts Practiced

This project helped me practice:

Creating classes and objects
Creating references between objects
Building recursive methods
Understanding base cases
Working with arrays
Representing missing tree nodes with null
Understanding preorder tree representation
Debugging Java errors
Understanding ArrayIndexOutOfBoundsException
_______________________________________________________________________________________________________________
Debugging Experience

While building this program, one important error was:


ArrayIndexOutOfBoundsException

This happened when the recursive method tried to access an array index that did not exist.

For example, an array with 11 elements has valid indexes:

0 → 10

Trying to access:

nodes[11]

causes an ArrayIndexOutOfBoundsException.

This helped me understand that the preorder representation needs enough -1 values to represent missing children and properly stop the recursion.

_______________________________________________________________________________________________________________
Future Improvements


I plan to extend this project as I learn more about binary trees.

Planned features

Preorder traversal

Inorder traversal

Postorder traversal

Level-order traversal

Calculate tree height

Count total nodes

Search for a value

Calculate the sum of nodes

Find the maximum value

Add unit tests

Improve input handling

_______________________________________________________________________________________________________________
Learning Goal

The main goal of this project is to build a stronger understanding of binary trees and recursion through implementation rather than only studying the theory.

As I learn additional tree algorithms, I will continue expanding this project.

_______________________________________________________________________________________________________________
Author

Fairooz Farzana

Java Data Structures and Algorithms Practice
