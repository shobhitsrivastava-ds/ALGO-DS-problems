#include<bits/stdc++.h>

using namespace std;
int segment[12];
void update(int arr[], int start, int en, int Tnode, int idx, int val)
{
    if(start==en)
    {
        // Leaf Node
        arr[idx]+= val;
        segment[Tnode]+=val;
    }
    else{
        int mid= (start+en)/2;
        if(start<= idx && idx<= mid)
        {
            update(arr, start, mid, 2*Tnode, idx, val);
        }
        else
        {
            update(arr, mid+1, en, 2*Tnode+1, idx, val);
        }
        segment[Tnode]= segment[2*Tnode]+segment[2*Tnode+1];
    }
}
// FUNCTION TO QUERY THE TREE;
int query(int start, int en, int l, int r, int Tnode)
{
    if(r<start || en<l)
    {
        return(0);
    }
    if(l<=start and en<=r)
    {
        return(segment[Tnode]);
    }
    int mid= (start+en)/2;
    int sum= query(start, mid, l ,r ,2*Tnode)+ query(mid+1, en, l, r,2*Tnode+1);
    return(sum);
}

// FUNCTION TO BUILD THE TREE
void buildSegmentTree(int arr[], int start, int en, int Tnode)
{
    if(start==en)
    {
        segment[Tnode]= arr[start];
        return;
    }
    int mid= (start+en)/2;
    buildSegmentTree(arr, start, mid, 2*Tnode);
    buildSegmentTree(arr, mid+1, en, 2*Tnode+1);
    segment[Tnode]= segment[2*Tnode] + segment[2*Tnode+1];
}

// MAIN FUNCTION TO GOVERN THE WHOLE PROCESS
int main()
{
    int arr[]= {1,2,3,4,5,6};
    int n= sizeof(arr)/sizeof(arr[0]);
    buildSegmentTree(arr, 0, n-1, 1);
    int get_q1= query(0, n-1, 1, 2, 1);
    cout<<"Sum= "<<get_q1<<endl;
    update(arr, 0, n-1, 1, 1, 2);
    int get_q2= query(0, n-1, 1, 2, 1);
    cout<<"Sum= "<<get_q2<<endl;
    return(0);
}
