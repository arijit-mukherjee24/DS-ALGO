package com.graph.assignment;

import java.util.ArrayList;

// Leetcode 207. Course Schedule
//Ref: https://www.youtube.com/watch?v=kXy0ABd1vwo Techdose 

public class CourseSchedule {

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{1,0}, {0,1}};
		System.out.println(canFinish(numCourses, prerequisites));
	}
	
	//check if the given graph has cycle of not
    private static boolean isCycleExist(int currNode, ArrayList<ArrayList<Integer>> adj, int[] visited ) {
        
        //check if the current node was already in processing state
        if(visited[currNode]==2){
            return true; //cycle is present
        }
        
        //change state of current node to processing (i.e. 2)
        visited[currNode]=2;
        
        //traverse all neighbours of current node
        for(int neighbour: adj.get(currNode)){
            //check if the neigbour is already processed or not
            if(visited[neighbour]!=1){
                //if it's not processed
                if(isCycleExist(neighbour, adj, visited)){
                    return true;//cycle is present
                }
            }
        }
        
        //update the state of current node from processing(2) -> processed(1)
        visited[currNode]=1;
        return false;//no cycle exists
        
    }
    
    //driver function
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);   
        
        //add empty array list for every node/vertice
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        //add edges to adjacency list
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        //this will maintain the state of every node/vertice
        /*
            0 -> unvisited (default)
            1 -> processed
            2 -> processing
        */
        int[] visited = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(isCycleExist(i, adj, visited)){ 
                    //if it has cycle, then there is no way in which all the courses can be done
                    return false;
                }                
            }

        }
        //if there is no cycle, all courses can be done
        return true;
    }

}
