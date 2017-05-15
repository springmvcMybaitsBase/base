package com.mana.ftp;

import java.io.InputStream;
import java.io.OutputStream;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
/**
 * @author LIUG004
 * @date 2009-12-01
 */
public class FtpClient {
	private FTPClient ftpClient = null;
	/**
	 * 创建FTP连接
	 * @param server
	 * @param user
	 * @param password
	 */
	public void connectServer(String server, String user, String password){
		if(ftpClient == null || !ftpClient.connected()){
			ftpClient = new FTPClient();
			try{
				ftpClient.setRemoteHost(server);
				//ftpClient.setTimeout(3000);
				ftpClient.connect();
				ftpClient.login(user, password);
				ftpClient.setConnectMode(FTPConnectMode.PASV); 
				ftpClient.setType(FTPTransferType.BINARY); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * 更改文件目录
	 * @param path
	 */
	public void changeDir(String path){
		if(path == null || path.equals("")){
			return;
		}
		String temp[] = path.split("/");
		for(int i=0;i<temp.length;i++){
			try{
				if(temp[i] == null || temp[i].equals("")){
					continue;
				}
				ftpClient.chdir(temp[i]);
			}catch(FTPException fe){
				try{
					ftpClient.mkdir(temp[i]);
					ftpClient.chdir(temp[i]);
				}catch(Exception e){
					
				}
			}catch(Exception ee){
				
			}
		}
	}
	/**上传文件
	 * @param in
	 * @param filename
	 */
	public void uploadFile(InputStream in,String filename){
		try{
			ftpClient.put(in,filename);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除文件
	 * @param filename
	 */
	public void deleteFile(String filename){
		try{
			ftpClient.delete(filename);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void downLoad(OutputStream out ,String filename){
		  try{
			  ftpClient.get(out, filename);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	}
	/**
	 *关闭FTP连接
	 */
	public void close(){
		try{
			if(ftpClient != null && ftpClient.connected()){
				ftpClient.quit();
				ftpClient = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
