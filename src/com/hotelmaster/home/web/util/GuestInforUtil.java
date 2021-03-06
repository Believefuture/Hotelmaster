package com.hotelmaster.home.web.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.hotelmaster.po.Guest;

/**
 * Class description goes here.
 * 
 * @author heiosha
 * @Date May 21, 2008
 * @Description parse the json data from guestInfoControll request
 */
public class GuestInforUtil {
	private final static Logger log = Logger.getLogger(GuestInforUtil.class);
	public static Guest dealGuestAddRequest(HttpServletRequest request) throws Exception {
		log.info("add New Guest");
		Guest guest = new Guest();
	    Timestamp createTime = new Timestamp(System.currentTimeMillis());
	    log.info(createTime);
		String json = (String)request.getParameter("json").trim();
		JSONObject jsonObject = JSONObject.fromObject( json ); 
		guest = (Guest) JSONObject.toBean( jsonObject, Guest.class );
		guest.setGtCreateTime(createTime);
		log.info(guest.getGtName());
		log.info(guest.getGtMobile());
		//assertEquals( jsonObject.get( "gtName" ), guest.getGtName());  
		return guest;
	}
	
	public static Guest dealGuestUpdateRequest(HttpServletRequest request) throws Exception {
		log.info("Update Guest information");
		Guest guest = new Guest();
		String json = (String)request.getParameter("json").trim();
		JSONObject jsonObject = JSONObject.fromObject( json );
		guest.setGtId(jsonObject.getString("gtId"));
		guest.setGtAddress(jsonObject.getString("gtAddress"));
		guest.setGtCardCatalog(jsonObject.getString("gtCardCatalog"));
		guest.setGtCardId(jsonObject.getString("gtCardId"));
		guest.setGtCompany(jsonObject.getString("gtCompany"));
		guest.setGtCountry(jsonObject.getString("gtCountry"));
		guest.setGtCreateTime(Timestamp.valueOf(jsonObject.getString("gtCreateTime")));
		guest.setGtEmail(jsonObject.getString("gtEmail"));
		guest.setGtGender(jsonObject.getString("gtGender"));
		guest.setGtMobile(jsonObject.getString("gtMobile"));
		guest.setGtName(jsonObject.getString("gtName"));
		guest.setGtTelphone(jsonObject.getString("gtTelphone"));
		guest.setGtType(jsonObject.getString("gtType"));
		guest.setGtZip(jsonObject.getString("gtZip"));
		//guest.setGtCreateTime(createTime);
		log.info(guest.getGtName());
		log.info(guest.getGtMobile());
		//assertEquals( jsonObject.get( "gtName" ), guest.getGtName());  
		return guest;
	}
	
	public static String dealGuestDelRequest(HttpServletRequest request) throws Exception {
		String gtId = null;
		request.setCharacterEncoding("UTF-8");
		gtId = (String) request.getParameter("gtId").trim();
		log.info(gtId);
		return gtId;
	}
	
	public void updateGuestInforRequest(HttpServletRequest request,String guestID) throws Exception {
		log.info("update The Guest Information");
	}
}
