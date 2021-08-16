package Trees;

public class C2_PrintPathFromRootToGivenNode {

	/*
	 
	  
	  public int[] solve(TreeNode A, int B) {
          ArrayList<Integer> an=new ArrayList<>();
          an.clear();
        ArrayList<Integer>  ans=  fun(A,B,an);
        Collections.reverse(ans);
        int [] res=new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    
    
    public static ArrayList<Integer> fun(TreeNode root,int n,ArrayList<Integer> ans){
        if(root==null) return null;
        if(root.val==n) {
            ans.add(root.val);
            return ans;
        }
        ArrayList<Integer> p1=fun(root.left,n,ans);
        ArrayList<Integer> p2=fun(root.right,n,ans);
        
        if(p1!=null && p1.size()>0 && root!=null){
            ans.add(root.val);
          
            return ans;
        }
        else if(p2!=null && p2.size()>0 && root!=null){
            ans.add(root.val);
          
            return ans;
           
        }
       
        return null;
    }
    
    
	 */
}
