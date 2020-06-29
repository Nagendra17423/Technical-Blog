package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {
	
	static public void delete(String path)
	{
		try{
			File f=new  File(path);
			f.delete();
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	 static public void addFile(InputStream is ,String path)
	{
		try{
			byte b[]=new byte[is.available()];
			is.read(b);
			
			FileOutputStream fos=new FileOutputStream(path);
			fos.write(b);
			fos.flush();
			fos.close();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
