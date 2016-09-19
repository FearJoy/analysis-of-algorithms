import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * 
 */

/**
 * @author 
 *
 */
public class TSP {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Log a start time
		long startTime = System.currentTimeMillis();
		
		//Check inputs and print
		//for(int i = 0; i < args.length; i++ ) {
		//	System.out.println("Input:" + i + " is " + args[i]);
		//}
		
		//Array List that holds all the site names and x,y coordinates
		//Uses funtion openFile to file list
		ArrayList<site> sites = openFile(args[0]);
		
		//Uncomment to print parsed ojects
		//for(int i = 0; i < sites.size(); i++){
		//	System.out.println("Name:" + sites.get(i).name +
		//			" x:" + sites.get(i).x + " y:" + sites.get(i).y);
		//}
		
		//Create 2d array to hold distances
		long[] [] distances = new long [sites.size()] [sites.size()];
		
		//Fill 2d array in with all the distances
		for(int x = 0; x < sites.size(); x++) {
			for(int y = 0; y < sites.size(); y++) {
				distances[x] [y] = calcDist(sites.get(x), sites.get(y));
			}
		}
		
		int currentSite = 0;
		long tempShortestDistance;
		int tempNextSite = 0;
		long totalDistance = 0;
		
		//Int array to hold 
		int[] currentRoute = new int[sites.size()];
		
		//We always start with the first site so we can add that right away
		currentRoute[0] = 0;
		sites.get(0).visited = true;
		
		//Use greedy method to establish initial route
		for(int i = 0; i < sites.size() - 1; i++) {
			tempShortestDistance = 999999999;
			currentSite = tempNextSite;
			for(int a = 0; a < sites.size(); a++) {
				//if(tempShortestDistance == 0){
				//	tempShortestDistance = distances[currentSite][a];
				//}
				if(sites.get(a).visited == false && a != currentSite) {
					if(distances[currentSite][a] <  tempShortestDistance) {
						tempShortestDistance = distances[currentSite][a];
						tempNextSite = a;
					}
				}
			}
			//Add the next shortest leg to our current route
			currentRoute[i + 1] = tempNextSite;
			totalDistance = totalDistance + tempShortestDistance;
			sites.get(tempNextSite).visited = true;
			//System.out.println("Next site is: " + tempNextSite
				//	+ " current total distance is " + totalDistance
			//		+ " tempdistance is " + tempShortestDistance);
		}
		totalDistance = totalDistance + distances[0][currentRoute[sites.size() -1]];
		
		//Log and print a finished time.
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time: " + totalTime + " milliseconds");
		System.out.println("Distance: " + totalDistance);
		
		//Print file
		FileWriter out = null;

	      try {
	        
	         out = new FileWriter(args[0] + ".tour");
	         
	         out.write("" + totalDistance + "\n");
	         for(int i = 0; i < sites.size(); i++){
	        	 if(i + 1 == sites.size()){
	        		 out.write(sites.get(currentRoute[i]).name + "\n");
	        	 } else {
	        	 out.write(sites.get(currentRoute[i]).name + "\n");
	        	 }
	         }
	         
	      }finally {
	         
	         if (out != null) {
	            out.close();
	         }
	      }
		
}
	//Returns and array list filled with data from file passed in
	static ArrayList<site> openFile (String s) throws IOException {
		
		ArrayList<site> siteList = new ArrayList<site>();
		//Read file code based off of:
		// http://www.tutorialspoint.com/java/java_files_io.htm
		FileInputStream in = null;
		
		try{
			try {
				
				//Open file passed in as argument
				in = new FileInputStream(s);
				
				//Helper variables to store file in to list of sites
				int c;
				int count = 1;
				String temp = "";
				site newSite = new site();
				
				//Loop through file until end
		         while ((c = in.read()) != -1) {
		        	 char ch = (char) c;
		        	
		        	 if (ch == '\n') {
		        		 temp = temp.trim();
		        		String[] parts = temp.split("\\s+");
		        		newSite.name = parts[0];
		        		newSite.x = Long.parseLong(parts[1]);
		        		newSite.y = Long.parseLong(parts[2]);
		        		temp = "";
		        		siteList.add(newSite);
	            		newSite = new site();
		        	 } else {
		        		 temp = temp + ch;
		        	 }

		         }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	} finally {
		if (in != null) {
            in.close();
         }
	
		};
		return siteList;
	}
	
	//Returns the distance between two sites
	static long calcDist(site a, site b) {
		long distance = Math.round(Math.sqrt(
				Math.pow((a.x - b.x), 2) +
				Math.pow((a.y - b.y), 2)));
		return distance;
		
	}


}


