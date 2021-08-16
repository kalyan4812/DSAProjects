package Graphs;

public class C9_CloneAGraph {

	// check leetcode solution.
	
	// do dfs store nodes in map.
	// iterate through map,connect nodes.
	// same as Linked list clone.
	
	
	/*
	static Map<Node,Node> mp=new HashMap<>();
	
    public Node cloneGraph(Node node) {
        if(node==null ) return null;
        mp.clear();
        Set<Node> vis=new HashSet<>();
        doDfs(node,vis);
        
      return  linkEdges(node);
    }
    
    
    
    static Node linkEdges(Node n){
        
        for(Map.Entry<Node,Node> p:mp.entrySet()){
           System.out.print(p.getKey().val+" ");
            
            for(Node nbr:p.getKey().neighbors){
                 p.getValue().neighbors.add(mp.get(nbr));
            }
          
        }
        
        return mp.get(n);
    }
    
    
    
    static void doDfs(Node n,Set<Node> vis ){
        vis.add(n);
        Node copy=new Node(n.val);
        mp.put(n,copy);
        
        for(Node p:n.neighbors){
            if(!vis.contains(p)){
              doDfs(p,vis);   
          }
       }
   }
    
	 
	 
	 
	 
	 
	 */
}
