package com;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class HdfsClient {
	public void readFile(String file) throws IOException {
		Configuration conf = new Configuration();
		String hadoopConfPath = "/opt/hadoop/etc/hadoop/";
		conf.addResource(new Path(hadoopConfPath+"core-site.xml"));
		conf.addResource(new Path(hadoopConfPath+"hdfs-site.xml"));
		conf.addResource(new Path(hadoopConfPath+"mapred-site.xml"));
		 
		FileSystem fileSystem = FileSystem.get(conf);
		// For the join type of queries, output file in the HDFS has 'r' in it. 
		String type="r";
		
		Path path = new Path(file+"/part-"+type+"-00000");
		if (!fileSystem.exists(path)) {
		System.out.println("File " + file + " does not exists");
		return;
		}
		 
		FSDataInputStream in = fileSystem.open(path);
		 
		String filename = file.substring(file.lastIndexOf('/') + 1,
		file.length());
		 //String path="";
		OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("/home/omkya/DAS_Pig/"+filename)));
		 
		byte[] b = new byte[1024];
		int numBytes = 0;
		while ((numBytes = in.read(b)) > 0) {
		out.write(b, 0, numBytes);
		}
		conf.clear(); 
		in.close();
		out.close();
		fileSystem.close();
		}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HDFSClient hc =new HDFSClient();
		hc.readFile("out_hdfsClient.out");
	}

}
