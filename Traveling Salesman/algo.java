import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class TSP
{
  public static void main(String[] args)
    throws IOException
  {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < args.length; i++) {
      System.out.println("Input:" + i + " is " + args[i]);
    }
    ArrayList<site> sites = openFile(args[0]);
    
    long[][] distances = new long[sites.size()][sites.size()];
    for (int x = 0; x < sites.size(); x++) {
      for (int y = 0; y < sites.size(); y++) {
        distances[x][y] = calcDist((site)sites.get(x), (site)sites.get(y));
      }
    }
    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("Time:...." + totalTime + "....");
    for (int x = 0; x < sites.size(); x++) {
      System.out.println("Site " + ((site)sites.get(0)).name + " to site " + 
        ((site)sites.get(x)).name + " is " + distances[0][x]);
    }
  }
  
  /* Error */
  static ArrayList<site> openFile(String s)
    throws IOException
  {}
  
  static long calcDist(site a, site b)
  {
    long distance = Math.round(Math.sqrt(
      Math.pow(a.x - b.x, 2.0D) + 
      Math.pow(a.y - b.y, 2.0D)));
    return distance;
  }
}