
public class main
{
    public static final int M= 100;
    public static final int N= 100;
    static int find_min_odd_Cost(int given[][], int m, int n)
    {
        int floor[][]= new int[]
        int min_cost= 0;
        int i, j, temp;
        for(int j=0;j<n;j++)
        {
            floor[0][j]= given[0][j];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<m;j++100)
            {
                if(j==0)
                {
                    floor[i][j]= given[i][j];
                    floor[i][j]= min(floor[i-1][j], floor[i-1][j+1]);
                }
                else if(j==n-1)
                {
                    floor[i][j]= given[i][j];
                    floor[i][j]+= min(floor[i-1][j], floor[i-1][j-1]);
                }
                else
                {
                    temp= min(floor[i-1][j], floor[i-1][j-1], floor[i-1][j+1]);
                    floor[i][j]= given[i][j]+temp;
                }
            }
        }
        min_odd_cost= Integer.MAX_VALUE;
        for(j=0;j<n;j++)
        {
            if(floor[n-1][j]%2==1)
            {
                if(min_odd_cost>floor[n-1][j])
                {
                    min_odd_cost= floor[n-1][j];
                }
            }
        }
        if(min_odd_cost==Integer.MIN_VALUE)
        {
            return(-1);
        }
        return(min_odd_cost);
    }

    public static void main(String []args)
    {
        int m=5;int n=5;
        int given[][]= {{1,2,3,4,6},
                        {1,2,3,4,5},
                        {1,2,3,4,5},
                        {1,2,3,4,5},
                        {100,2,3,4,5}};
        System.out.println("Minimum odd cost is "+find_min_odd_Cost(given, m,n));
    }
}


