import java.util.Scanner;

public class base extends Object {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=1;
        int first,last;
        for(int i=0;i<n;i++){
            first=sc.nextInt();
            last=sc.nextInt();
            System.out.println(min(first,last));
        }
    }
    public static int  min(int first,int last){
        int mid,cha,k=1;
        if(first==last){return 0;}
        if(first>last){
            mid=first;
            first=last;
            last=mid;
        }
        cha=last-first;
        while(k*(k+1)/2>cha){
            k++;
        }
        if(k%2!=0){
            k--;
        }
        return k;
    }

}
