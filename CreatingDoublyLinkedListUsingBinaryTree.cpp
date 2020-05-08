#include<bits/stdc++.h>

using namespace std;

struct node
{
    int data;
    struct node *left, *right;
};
static struct node* prev= NULL;
struct node* newNode(int d)
{
    struct node *t;
    t= new(struct node);
    t->data= d;
    t->left= NULL;
    t->right= NULL;
    return(t);
}
void createDLL(struct node* root, struct node **head)
{
    if(root== NULL)
    {
        return;
    }
    createDLL(root->left, head);
    if(prev==NULL)
    {
        *head= root;
    }
    else{
        root->left= prev;
        prev->right= root;
    }
    prev= root;
    //head->left= prev;
    createDLL(root->right, head);
    //cout<<"dgdfgdf";
}

void printList(node *node)
{
    while (node!=NULL)
    {
        cout << node->data << " ";
        node = node->right;
    }
}
int main()
{
    struct node *root;// *head=NULL;
    root= newNode(10);
    root->left= newNode(12);
    root->right= newNode(15);
    root->left->left= newNode(29);
    root->left->right= newNode(30);
    root->right->left= newNode(36);
    createDLL(root);
    head->left= prev;
    prev->right= head;
    printList(head);
    return(0);
}
