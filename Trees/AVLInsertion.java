//Author : Simran Gupta

class Sol
{
    int height(Node node)
    {
        if(node==null)
        return 0;
        
        else return node.height;
    }
    int balance(Node node)
    {
        if(node==null)
        return 0;
        
        return height(node.left) - height(node.right);
    }

    
    public  Node insertToAVL(Node node,int data)
    {
        if(node==null)
        return new Node(data);
        
        if(node.data>data)
        node.left = insertToAVL(node.left,data);
        
        else if(node.data<data)
        node.right = insertToAVL(node.right,data);
        
        else return node;
        
        node.height = 1 + Math.max(height(node.left),height(node.right));
        
        int balance = balance(node);
        
        //RR
        if(balance<-1 && node.right.data<data)
        {
          return leftRotate(node);  
        }
        //LL
        else if(balance>1 && node.left.data>data)
        {
          return rightRotate(node);  
        }
        //LR
        else if(balance>1 && node.left.data<data)
        {
           node.left = leftRotate(node.left);     
           return rightRotate(node);  
        }
        //RL
        else if(balance<-1 && node.right.data>data)
        {
            node.right = rightRotate(node.right); 
           return leftRotate(node);    
        }
        
        return node;
    }
    
    
    
    
    Node rightRotate(Node a)
    {
      Node b = a.left;
      Node T2 = b.right;
      
      b.right = a;
      a.left = T2;
      
      a.height = 1 + Math.max(height(a.left),height(a.right));
      b.height = 1 + Math.max(height(b.left),height(b.right));
      
      return b;
    }
    Node leftRotate(Node a)
    {
       Node b = a.right;
      Node T2 = b.left;
      
      b.left = a;
      a.right = T2;
      
      a.height = 1 + Math.max(height(a.left),height(a.right)); 
      b.height = 1 + Math.max(height(b.left),height(b.right));
      
      return b;
    }
}    
