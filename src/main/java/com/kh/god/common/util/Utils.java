package com.kh.god.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	
	public static String getPageBar(int totalContents,int cPage,int numPerPage,String requestMapping) {
	
		
		 

        int totalPage = (int)Math.ceil((double)totalContents/numPerPage); 
        
       
        String pageBar = "";
        //페이지바 길이
        int pageBarSize = 5;
      
        int startPage = ((cPage-1)/pageBarSize)*pageBarSize +1 ;
        int endPage = startPage + pageBarSize - 1;

        int pageNo = startPage;
        
        //[이전]section
        if(pageNo == 1) {
           
        }else {
           pageBar += "<li class='page-item '><a class='page-link' href='"+requestMapping+"?cPage="
                    +(pageNo-1)+"&numPerPage="
                    +numPerPage+"'>[이전]</a></li>";
           
        }
        
        //[페이지]section
        while(pageNo <= endPage && pageNo <= totalPage) { 
           if(cPage == pageNo) {
            
              pageBar += " <li class='page-item disabled'><a class='page-link' href='#'>"+pageNo+"</a></li>";
              
           }else {
              pageBar += " <li class='page-item'><a class='page-link' href='"+requestMapping+"?cPage="
                            +pageNo+"&numPerPage="
                            +numPerPage+"'>"+pageNo+"</a></li>";
           }
           pageNo++;
           
        }
        
        //[다음]section
        if(pageNo > totalPage) { 
           
        }else {
           pageBar += " <li class='page-item'><a class='page-link' href='"+requestMapping+"?cPage="
                   +pageNo+"&numPerPage="
                   +numPerPage+"'>[다음]</a></li>";
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
	
	

}
