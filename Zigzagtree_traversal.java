#include <iostream>
#include <stack>

using namespace std;

struct node
{
    int data;
    struct node *left, *right;
};
struct node* newNode(int data)
{
    struct node *t= (struct node*)malloc(sizeof(struct node));
    t->data= data;
    t->left= t->right= NULL;
    return(t);
}
void treeTraversal(struct node *root)
{
    if(!root)
    {
        return;
    }
    stack<struct node*> currentlevel;
    stack<struct node*> nextlevel;
    
    currentlevel.push(root);
    bool lefttoright= true;
    while(!currentlevel.empty())
    {
        struct node *temp= currentlevel.top();
        currentlevel.pop();
        if(temp)
        {
            cout<<temp->data<<" ";
        if(lefttoright)
        {
        if(temp->left)
        {
            nextlevel.push(temp->left);
        }
        if(temp->right)
        {
            nextlevel.push(temp->right);
        }
        }
        else
        if(temp->right)
        {
            nextlevel.push(temp->right);
        }
        if(temp->left)
        {
            nextlevel.push(temp->left);
        }
        if(currentlevel.empty())
        {
            lefttoright= !lefttoright;
            swap(currentlevel, nextlevel);
        }
    }
}

}

int main()
{
    struct node *root= newNode(1);
    root->left= newNode(2);
    root->right= newNode(3);
    root->left->left= newNode(7);
    root->left->right= newNode(6);
    root->right->left= newNode(5);
    root->right->right= newNode(4);
    return 0;
}
