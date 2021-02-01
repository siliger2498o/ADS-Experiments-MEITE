package AVL_Expt;

import static AVL_Expt.AVL_Swing.insertionFlag;
import java.time.Duration;
import java.time.Instant;
import javax.swing.JOptionPane;
/**
 *
 * @author sushma r iliger
 */
class AVLTree {
public AVLNode root;

public AVLTree() {
  this.root = null;
}

public static int max(int a, int b) {
  if(a > b)
    return a;
  return b;
}

public int height(AVLNode n) {
  if(n == null)
    return -1;
  return n.height;
}

public AVLNode minimum(AVLNode x) {
  while(x.leftChild != null)
    x = x.leftChild;
  return x;
}

public void leftRotate(AVLNode x) {
  AVLNode y = x.right;
  x.right = y.leftChild;
  if(y.leftChild != null) {
    y.leftChild.parent = x;
  }
  y.parent = x.parent;
  if(x.parent == null) { 
    this.root = y;
  }
  else if(x == x.parent.leftChild) { 
    x.parent.leftChild = y;
  }
  else { 
    x.parent.right = y;
  }
  y.leftChild = x;
  x.parent = y;

  x.height = 1 + max(height(x.leftChild), height(x.right));
  y.height = 1 + max(height(y.leftChild), height(y.right));
}

public void rightRotate(AVLNode x) {
  AVLNode y = x.leftChild;
  x.leftChild = y.right;
  if(y.right != null) {
    y.right.parent = x;
  }
  y.parent = x.parent;
  if(x.parent == null) { 
    this.root = y;
  }
  else if(x == x.parent.right) {
    x.parent.right = y;
  }
  else { 
    x.parent.leftChild = y;
  }
  y.right = x;
  x.parent = y;

  x.height = 1 + max(height(x.leftChild), height(x.right));
  y.height = 1 + max(height(y.leftChild), height(y.right));
}

public int balanceFactor(AVLNode n) {
  if(n == null)
  { return 0;}
  return(height(n.leftChild) - height(n.right));
}

public void insert(AVLNode response) {
    AVLNode newnode = null;
    AVLNode temp = this.root;
    while(temp != null) {
        newnode = temp;
        if(response.socialSecurityNumber < temp.socialSecurityNumber){ temp = temp.leftChild;}
        else{temp = temp.right;}
    }
    
    response.parent = newnode;
    
    if(newnode == null)  {this.root = response;}
    else if(response.socialSecurityNumber < newnode.socialSecurityNumber) { newnode.leftChild = response;}
    else{newnode.right = response;}
    
    AVLNode z = response;    
    
    while(newnode != null) {
        newnode.height = 1 + max(height(newnode.leftChild), height(newnode.right));
        AVLNode x = newnode.parent;
        
        if(balanceFactor(x) <= -2 || balanceFactor(x) >= 2) {
            if(newnode == x.leftChild) {
                if(z == x.leftChild.leftChild) {rightRotate(x);}
                else if(z == x.leftChild.right) { leftRotate(newnode);  rightRotate(x);}
            }
            else if(newnode == x.right) {
                if(z == x.right.right) {leftRotate(x);}
                else if(z == x.right.leftChild) { rightRotate(newnode); leftRotate(x);}
            }
            break;
        }
        newnode = newnode.parent;
        z = z.parent;
    }
    insertionFlag=true;
}

public void replace(AVLNode u, AVLNode v) {
  if(u.parent == null)
  {this.root = v;}
  else if(u == u.parent.leftChild)
  {u.parent.leftChild = v;}
  else 
  { u.parent.right = v;}

  if(v != null)
  {v.parent = u.parent;}
}

public void balanceAfterDeletion(AVLNode n) {
    AVLNode p = n;
    while(p != null) {
        p.height = 1 + max(height(p.leftChild), height(p.right));
        if(balanceFactor(p) <= -2 || balanceFactor(p) >= 2) {
            AVLNode x, y, z;
            x = p;
      
            if(x.leftChild.height > x.right.height){y = x.leftChild;}
            else{y = x.right;}
            
            if(y.leftChild.height > y.right.height) {z = y.leftChild;}
            else if(y.leftChild.height < y.right.height) {z = y.right;}
            else { 
                if(y == x.leftChild){z = y.leftChild;}
                else{z = y.right;}
            }
            
            if(y == x.leftChild) {
                if(z == x.leftChild.leftChild) 
                    rightRotate(x);
                else if(z == x.leftChild.right) {
                    leftRotate(y);
                    rightRotate(x);
                }
            }
            else if(y == x.right) {
                if(z == x.right.right){leftRotate(x);}
                else if(z == x.right.leftChild) {
                    rightRotate(y);
                    leftRotate(x);
                }
            }
        }
        p = p.parent;    
    }
}

public long delete(AVLNode z) {
    Duration timeElapsed;
    Instant start = Instant.now();            
    
    if(z.leftChild == null) {
        replace(z, z.right);
        if(z.right != null)        
        {
            balanceAfterDeletion(z.right);    
            Instant end = Instant.now();
            timeElapsed = Duration.between(start, end);                               
            return timeElapsed.toNanos();
        }
    }
    else if(z.right == null) {
        replace(z, z.leftChild);
        if(z.leftChild != null){
            balanceAfterDeletion(z.leftChild);
            Instant end = Instant.now();
            timeElapsed = Duration.between(start, end);             
            return timeElapsed.toNanos();
        }
    }      
    else {
        AVLNode y = minimum(z.right);
        if(y.parent != z) {
            replace(y, y.right);
            y.right = z.right;
            y.right.parent = y; 
        }
        replace(z, y);
        y.leftChild = z.leftChild;
        y.leftChild.parent = y;
        if(y != null)
        {
            balanceAfterDeletion(y);
            Instant end = Instant.now();
            timeElapsed = Duration.between(start, end);             
            return timeElapsed.toNanos();
        }    
    } 
    return (long) 0.0;
}

public AVLNode search(AVLNode r, int val){
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.socialSecurityNumber;
             if (val < rval)
             {r = r.leftChild;}
             else if (val > rval)
             {r = r.right;}
             else
             {
                 found = true;                                  
                 break;
             }
             search(r, val);
         }
         if(found){
             return r;
         }
         else{
         return null;
         }         
}

public AVLNode getRoot(){
    return this.root;
}
}
