/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redsparksystems.primefacespush;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@ManagedBean(name = "globalCounter")
@SessionScoped
public class GlobalCounterBean implements Serializable {

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public synchronized void increment() {
		count++;
        
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/counter", String.valueOf(count));
	}
}

