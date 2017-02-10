
import java.io.*;
import java.util.*;
import java.nio.*;

public class Config{
	static class NodeLocation{
		public NodeLocation(int parseInt1, String string, int parseInt) {
			this.identifier=parseInt1;
			this.serverName= string;
			this.portNumber=parseInt;
		}
		public String serverName;
		public int portNumber, identifier;
		}
/*	public class Neighbours{
		public int node;
		public int Neigbours[];
	}
	*/
		
	public static void readConfigFile() throws NumberFormatException, IOException
	{
	
		int totalNoOfNodes=0;
		BufferedReader br = null;
			try {
				String sCurrentLine;
//br = new BufferedReader(new FileReader("/home/010/p/px/pxm140430/aos/project/config.txt"));
				br = new BufferedReader(new FileReader("C:\\Users\\Gitanshi Khullar\\Downloads\\Node\\config.txt"));

//Extracting total nodes
				while ((sCurrentLine = br.readLine()) != null) 
				{
					if((int)sCurrentLine.charAt(0)>=48 && (int)sCurrentLine.charAt(0)<=57)
					{
						String[] splitArray = sCurrentLine.trim().replaceAll("\\s{2,}", " ").split("\\s+");	
						totalNoOfNodes = Integer.parseInt(splitArray[0]);
						//interRequestDelay = Integer.parseInt(splitArray[1]);
						//csExecutionTime = Integer.parseInt(splitArray[2]);
						//totalRequests = Integer.parseInt(splitArray[3]);
						break;
					}	
				}

				System.out.println(totalNoOfNodes);
// System.out.println(interRequestDelay);
// System.out.println(csExecutionTime);
// System.out.println(totalRequests);

//Extracting Location of all nodes.
			 NodeLocation[] nodeLocations = new NodeLocation[totalNoOfNodes];
				for(int i=0;i<totalNoOfNodes;)
				{	sCurrentLine = br.readLine();
				if(!sCurrentLine.equals(null) && !sCurrentLine.equals("") && (int)sCurrentLine.charAt(0)>=48 && (int)sCurrentLine.charAt(0)<=57)
				{	
					sCurrentLine = sCurrentLine.trim();
					String[] splitArray = sCurrentLine.replaceAll("\\s{2,}", " ").split("\\s+");
					nodeLocations[i]=new NodeLocation(Integer.parseInt(splitArray[0]),splitArray[1],Integer.parseInt(splitArray[2])); 
					i++;
				}
				}

//testing if dataStructure nodeLocations is populated correctly or not
				System.out.println("Node Location : ");
				for(NodeLocation n :nodeLocations )
				{	
					System.out.println(n.identifier);
					System.out.println(n.serverName);
					System.out.println(n.portNumber);
					System.out.println();
				}
	/*			for(int i=0;i<totalNoOfNodes;)
				{	sCurrentLine = br.readLine();
				if(!sCurrentLine.equals(null) && !sCurrentLine.equals("") && (int)sCurrentLine.charAt(0)>=48 && (int)sCurrentLine.charAt(0)<=57)
				{	
					sCurrentLine = sCurrentLine.trim();
					String[] splitArray = sCurrentLine.replaceAll("\\s{2,}", " ").split("\\s+");
					nodeLocations[i]=new NodeLocation(Integer.parseInt(splitArray[0]),splitArray[1],Integer.parseInt(splitArray[2])); 
					i++;
				}
				*/
				}
			finally{
				System.out.println("results");
			}
			

}}