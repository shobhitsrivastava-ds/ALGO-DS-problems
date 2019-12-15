//PROBLEM SET LINK : https://www.codechef.com/ENOC2019/problems/SS4
#include <bits/stdc++.h>
#define endl "\n"
using namespace std;
vector<vector<int>> adj;
int ar[100];

int bfs(int s)
{
    int max= 1, day= 1, co =1;
    queue<int> q;
    q.push(s);
    while(1)
    {
        ++co;
        queue<int> temp;
        while(!q.empty())
        {
            int x= q.front();
            ax[x]= 1;
            for(int i=0;i<adj[x].size();i++)
            {
                if(ar[adj[x][i]]==0)
                {
                    temp.push(adj[x][i]);
                    
                }
            }
            q.pop();
        }
        if(temp.empty())
        {
            break;
        }
        if(temp.size()>max)
        {
            max= temp.size(), day= co;
            q= temp;
        }
    }
    return(day);
}
int main()
{
    int n;
    cin>>n;
    adj.resize(n+1);
    memset(adj, 0, sizeof(adj));
    for(int i=0;i<n;i++)
    {
        int a,b;
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    cout<<bfs(1);
    return(0);
}
