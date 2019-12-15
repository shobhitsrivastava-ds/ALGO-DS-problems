import java.util.HashMap;
public class Main
{
    public static int maxLen(int arr[])
    {
        HashMap<Integer, Integer> hM= new HashMap<Integer, Integer>();
        int sum= 0; int max_l= 0;
        int l= arr.length;
        for(int i=0; i<l; i++)
        {
            if(arr[i]==0 && max_l== 0)
            {
                max_l= 1;
            }
            sum= sum+ arr[i];
            Integer prev_i= hM.get(sum);
            if(prev_i!=null)
            {
                max_l= Math.max(max_l,i- prev_i);
            }
            else{
                hM.put(sum, i);
            }
        }
        return(max_l);
    }
	public static void main(String[] args) {
	int arr[]= new int[]{23, 10, 7, 1, -8, 2, -2, 15};
    System.out.println("Max_length= "+ maxLen(arr));    
	}
}