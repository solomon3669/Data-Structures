
  class PairinSort{

    public static void main(String[] args){

        int[] a={5,7,9,12,1,3};
        int pivot=3;
        int sum=51;
        int low=pivot+1;
           System.out.println(pair(a,low,pivot,sum));
        }
    public static boolean pair(int[] a,int low,int high,int sum){
           if(high!=low){
        if((a[high]+a[low])>sum){
            
            high=(a.length+high-1)%a.length;   // this approach works because we start from the highest and lowest values
            return pair(a,low,high,sum);
        }
         if((a[high]+a[low])<sum)
        {
            low=(low+1)%(a.length);
            return pair(a,low,high,sum);
        }
             if(a[high]+a[low]==sum){
                 return true;
             }
           }
        
        return false;
      }
  }
