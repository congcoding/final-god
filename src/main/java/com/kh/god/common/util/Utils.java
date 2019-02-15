package com.kh.god.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	
	public static String getPerBar(int totalContents,int cPage,int numPerPage,String loc) {
	
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		int pageBarSize = 5;
		int startPage = ((cPage-1)/pageBarSize) * pageBarSize + 1;
		int endPage = startPage + pageBarSize - 1; 
		int pageNo = startPage;
		String pageBar = "<nav><ul class=\'pagination justify-content-center\'>";
		
		
		
		if(loc.contains("storeInfoList.do")) {
			//[이전]section
			if(pageNo == 1) {
				
			}
			else {
				pageBar += "<li class='page-itme'><a class='page-link' href='"+loc+
									 "&cPage="+(pageNo-1)+
									 "&numPerPage="+numPerPage+"'>PREVIOUS</a><li>";
			}
			
			//[페이지]section
			while(pageNo<=endPage && pageNo<=totalPage) {
				if(cPage == pageNo) {
					pageBar += "<li class='page-item disabled'> <a class='page-link'>"+pageNo+"</a></li>";
				}
				else {
					pageBar += "<li class='page-item'><a class='page-link' href='"+loc+
							   "&cPage="+pageNo+
							   "&numPerPage="+numPerPage+"'>"+
							   pageNo+"</a></li>";
				}
				pageNo++;
			}

			//[다음]section
			if(pageNo > totalPage) {
				
			} 
			else {
				pageBar += "<li class='page-item'><a class='page-link' href='"+loc+
						   "&cPage="+pageNo+
						   "&numPerPage="+numPerPage+"'>NEXT</a></li>";
			}
			
			pageBar += "</ul></nav>";
			
			
			
			
		}else {
			//[이전]section
			if(pageNo == 1) {
				
			}
			else {
				pageBar += "<li class='page-itme'><a class='page-link' href='"+loc+
									 "?cPage="+(pageNo-1)+
									 "&numPerPage="+numPerPage+"'>PREVIOUS</a><li>";
			}
			
			//[페이지]section
			while(pageNo<=endPage && pageNo<=totalPage) {
				if(cPage == pageNo) {
					pageBar += "<li class='page-item disabled'> <a class='page-link'>"+pageNo+"</a></li>";
				}
				else {
					pageBar += "<li class='page-item'><a class='page-link' href='"+loc+
							   "?cPage="+pageNo+
							   "&numPerPage="+numPerPage+"'>"+
							   pageNo+"</a></li>";
				}
				pageNo++;
			}

			//[다음]section
			if(pageNo > totalPage) {
				
			} 
			else {
				pageBar += "<li class='page-item'><a class='page-link' href='"+loc+
						   "?cPage="+pageNo+
						   "&numPerPage="+numPerPage+"'>NEXT</a></li>";
			}
			
			pageBar += "</ul></nav>";
			
			
		}
		
		return pageBar;
     
        
	}

	public static String getRenamedFileName(String fname) {
		//확장자 분리
		String ext = fname.substring(fname.lastIndexOf(".")+1);
		//날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		//난수 만들기
		int rndNum = (int)(Math.random()*1000);
		
		return sdf.format(new Date())+"_"+rndNum+"."+ext;
	}

	
	public static String getRenamedEventFileName(String fName,String bs, int eventNo) {
		//확장자 분리
		String ext = fName.substring(fName.lastIndexOf(".")+1);
		if(bs.equals("s")) {
			return eventNo+"_Small."+ext;
		}else {
			return eventNo+"_Big."+ext;
		}
		
	}
	

}
