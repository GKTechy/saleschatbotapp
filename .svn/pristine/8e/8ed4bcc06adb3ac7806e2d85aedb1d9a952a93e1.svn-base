package com.app.saleschatbotapp.chat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.saleschatbotapp.chat.Entity.Buttons;
import com.app.saleschatbotapp.chat.Entity.GeneralData;
import com.app.saleschatbotapp.chat.Entity.Sales;

@Repository
public class SalesChatDaoImpl implements SalesChatDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SalesChatModel getSalesChat() {
		
		Session session = this.sessionFactory.openSession();
		SalesChatModel scmodel= new SalesChatModel();
		List<Sales> saleslist =new ArrayList<>();
		
		try {
			saleslist = session.createQuery("SELECT responseValue from Sales").list();
			//System.out.println("-saleslist---"+saleslist.toString());
			scmodel.setSaleslist(saleslist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return scmodel;
	}

	@Override
	public SalesChatModel getAllSalesBranches() {
		Session session = this.sessionFactory.openSession();
		SalesChatModel scmodel= new SalesChatModel();
		List<Buttons> branchlist =new ArrayList<>();
		
		try {
			branchlist = session.createQuery("SELECT branchId as payload, branchName  as title from Branches")
					.setResultTransformer(Transformers.aliasToBean(Buttons.class)).list();
			//System.out.println("-branchlist---"+branchlist.toString());
			scmodel.setButtonList(branchlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return scmodel;
	}

	@Override
	public SalesChatModel startChat() {
		Session session = this.sessionFactory.openSession();
		SalesChatModel scmodel= new SalesChatModel();
		List<GeneralData> branchlist =new ArrayList<>();
		List<Buttons> buttonList =new ArrayList<>();
		try {
			branchlist = session.createQuery("SELECT accessId as accessId, displayValue  as displayValue,seqNo as seqNo from GeneralData where accessId='L_01_00_00_00_00'")
					.setResultTransformer(Transformers.aliasToBean(GeneralData.class)).list();
		//	System.out.println("-branchlist---"+branchlist.size());
			for(GeneralData g: branchlist) {
				Buttons b = new Buttons();
				b.setTitle(g.getDisplayValue());
				String payload="";
				if(g.getSeqNo().length() ==1) {
					payload="L_01_0"+g.getSeqNo()+"_00_00_00";
				}else {
					payload="L_01_"+g.getSeqNo()+"_00_00_00";
				}
				b.setPayload(payload);
				buttonList.add(b);
			}
			scmodel.setButtonList(buttonList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scmodel;
	}

	@Override
	public SalesChatModel getValues(String payload) {
		
		System.out.println("--payload------"+payload);
		Session session = this.sessionFactory.openSession();
		SalesChatModel scmodel= new SalesChatModel();
		List<GeneralData> branchlist =new ArrayList<>();
		List<Buttons> buttonList =new ArrayList<>();
		try {
			
			branchlist = session.createQuery("SELECT accessId as accessId, displayValue  as displayValue,seqNo as seqNo,displayType as displayType from GeneralData where accessId='"+payload+"'")
					.setResultTransformer(Transformers.aliasToBean(GeneralData.class)).list();
			//System.out.println("-branchlist---"+branchlist.size());
			
			if(branchlist.size() ==1) { // only text -> last level
			//	System.out.println("only text-->"+branchlist.get(0).getValue());
				scmodel.setResponseMsg(branchlist.get(0).getDisplayValue());
			}else { // Buttons list
				
				for(GeneralData g: branchlist) {
					
					Buttons b = new Buttons();
					b.setTitle(g.getDisplayValue());
					String temppayload="";
					String dbpayload=g.getAccessId();
	
					int indexOfSubStr = g.getAccessId().indexOf("00");
					//System.out.println("indexOfSubStr-->"+indexOfSubStr);
					if(g.getSeqNo().length() ==1) {
						temppayload+="0"+g.getSeqNo();
					}else {
						temppayload+=g.getSeqNo();
					}
					dbpayload = dbpayload.substring(0, indexOfSubStr)  + temppayload + dbpayload.substring(indexOfSubStr + 1); // replace the old value(00) to new (1 id value)
					dbpayload = dbpayload.substring(0,(indexOfSubStr+2))+dbpayload.substring((indexOfSubStr+2)+1);   // remove the extra 0 in level
					
					//System.out.println("dbpayload -->"+dbpayload);
					b.setPayload(dbpayload);
					buttonList.add(b);

				}
				scmodel.setButtonList(buttonList);
				scmodel.setResponseMsg("listValues");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scmodel;

	}

	
	
	
	
	
	
	
}
