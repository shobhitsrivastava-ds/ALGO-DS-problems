import java.util.*;
public class Main
{
    int V;
    LinkedList<Integer> adj[];
    public Main(int v)
    {
        V= v;
        adj= new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adj[i]= new LinkedList();
        }
    }
    public void setEdge(int u, int v)
    {
        adj[u].add(v);
    }
    public void makeReach(int u)
    {
        LinkedList<Integer> temp;
        temp= adj[u];
        boolean reach[]= new boolean[V];
        LinkedList<Integer> queue= new LinkedList<Integer>();
        queue.add(u);
        Iterator<Integer> i;
        int m, k;
        while(queue.size()!=0)
        {
            m= queue.poll();
            reach[m]= true;
            System.out.println(m);
            i= adj[m].listIterator();
            while(i.hasNext())
            {
                k= i.next();
                if(reach[k]!= true)
                {
                queue.add(k);
                }
            }
        }
    }
	public static void main(String[] args) 
	{
	   int n= 5;
	   Main obj= new Main(n);
	   obj.setEdge(0,1);
	   obj.setEdge(0,2);
	   obj.setEdge(1,3);
	   obj.setEdge(2,4);
	   obj.setEdge(3,2);
	   obj.setEdge(3,4);
	   obj.setEdge(3,0);
	   obj.setEdge(4,3);
	   obj.makeReach(0);
	}
}