package com;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PigQueryParser 
{
	// Method returns the file content!!
	public String getContent(String filepath)
	{
		  BufferedReader inputStream = null;
		  try
	        {
	            inputStream = new BufferedReader(new FileReader(filepath));
	            String l;
	            StringBuffer strb=new StringBuffer();
	            while ((l = inputStream.readLine()) != null)
	            {           
	            	strb.append(l+"\n");
	            }
	            return new String(strb);
	        }
	        catch(IOException ie)
	        {
	            // tokens is NULL
	            System.out.println("Exception ");
	            ie.printStackTrace();
	        } 
		  return null;
	}
	
	//Returns the output file name in the PIG Query!!!
	public String getOutputFolderName(String filepath) throws IOException
	{
		BufferedReader inputStream = null;
        String tokens = new String();
        tokens = null;
        try
        {
            inputStream = new BufferedReader(new FileReader(filepath));
            String l;
            String temp = "";
            int location = -1;
            
            //[1] Looking for Store in pig query
            Pattern p =  Pattern.compile("[Ss][Tt][Oo][Rr][Ee]");
            while ((l = inputStream.readLine()) != null)
            {           
                if (true == p.matcher(l).find())
                {
                    	location = l.indexOf("\'");
	                    temp = l.substring(location+1);                   
	                    tokens = temp.substring(0,temp.indexOf("\'"));
	                    inputStream.close();
	                    return tokens;
                }
            }
            
            //[2] Looking for Dump in pig query
            p =  Pattern.compile("[Dd][Uu][Mm][Pp]");
            while ((l = inputStream.readLine()) != null)
            {           
                if (true == p.matcher(l).find())
                {
                    String delims = " ;"; // space and semi-colon are delimiters
                    String[] x = l.split(delims);
                    if (x.length == 2)
                    {
                    	tokens = x[1];
                    	 inputStream.close();
                    	return tokens;
                    }
                    break;
                }
            }
  
        } 
        catch(IOException ie)
        {
            // tokens is NULL
            System.out.println("Exception ");
            ie.printStackTrace();
        }finally{
        inputStream.close();}
        return tokens; // return empty when neither load nor dump is present
   	
	}
	
	// Gives the all the resources in the PIG Query
	public String getDatasetFileName(String filepath)
    {
        BufferedReader inputStream = null;
        String token = null;
        //ArrayList<String> tokens = new ArrayList<String>();
        try
        {
            inputStream = new BufferedReader(new FileReader(filepath));
            String l;
            String temp = "";
            int location = -1;
            Pattern p =  Pattern.compile("[Ll][Oo][Aa][Dd]");
            while ((l = inputStream.readLine()) != null)
            {           
                if (true == p.matcher(l).find())
                {
                    location = l.indexOf("\'");
                    temp = l.substring(location+1);                   
                    token = (temp.substring(0,temp.indexOf("\'")));
                }
            }
            inputStream.close();
        }       
        catch(IOException ie)
        {
            // token is null
            System.out.println("Exception ");
            ie.printStackTrace();
        }
        return token;
    }
}
