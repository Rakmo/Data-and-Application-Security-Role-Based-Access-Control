package com;

import org.apache.pig.ExecType;
import org.apache.pig.PigServer;

public class PigClient {
	
	public PigClient()
	{}
	
	public String executeQuery(String filepath) {
		String error = "error";
		try {
			// Starting the PigServer API in the Map Reduce Mode
			PigServer pigServer = new PigServer(ExecType.MAPREDUCE);

			pigServer.registerScript(filepath);

			//pigServer.shutdown();

		} catch (Exception e) {

			//System.out.println("###########StartMSGs:="+e.getCause()+" EndMSG###");
			if(e.getCause()!=null)
				error = e.getCause().toString();
			e.printStackTrace();
			return error;
		}
		return "Success!";
	}

	public static void main(String args[]) 
	{
		PigClient client = new PigClient();
		System.out.println("Result: ");
		System.out.println(client.executeQuery("/home/omkya/DAS_Pig/temp.pig"));
		
	}
}