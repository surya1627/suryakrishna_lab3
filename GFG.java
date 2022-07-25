import java.util.*;
 
class GFG
{
 
// Node of Binary tree
static class node
{
    int data;
    node left;
    node right;
    node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};
 
// Function to find a pair
static int cntPairs(node root, int x)
{
    // Stack to store nodes for
    // forward and backward iterator
    Stack<node > it1 = new Stack<>();
    Stack<node > it2 = new Stack<>();
 
    // Initializing forward iterator
    node c = root;
    while (c != null)
    {
        it1.push(c);
        c = c.left;
    }
 
    // Initializing backward iterator
    c = root;
    while (c != null)
    {
        it2.push(c);
        c = c.right;
    }
     
    // Variable to store final answer
    int ans = 0;
 
    // two pointer technique
    while (it1.peek() != it2.peek())
    {
 
        // Variables to store the
        // value of the nodes current
        // iterators are pointing to.
        int v1 = it1.peek().data;
        int v2 = it2.peek().data;
 
        // If we find a pair
        // then count is increased by 1
        if (v1 + v2 == x)
            ans++;
 
        // Moving forward iterator
        if (v1 + v2 <= x)
        {
            c = it1.peek().right;
            it1.pop();
            while (c != null)
            {
                it1.push(c);
                c = c.left;
            }
        }
 
        // Moving backward iterator
        else
        {
            c = it2.peek().left;
            it2.pop();
            while (c != null)
            {
                it2.push(c);
                c = c.right;
            }
        }
    }
 
    // Returning final answer
    return ans;
}
 
// Driver code
public static void main(String[] args)
{
   
    node root = new node(40);
    root.left = new node(20);
    root.right = new node(60);
    root.left.left = new node(10);
    root.left.right = new node(30);
    root.right.left = new node(50);
    root.right.right = new node(70);
    int x = 70;
    
    System.out.print(cntPairs(root, x));
}
}
 