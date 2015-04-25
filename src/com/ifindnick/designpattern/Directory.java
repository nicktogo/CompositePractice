package com.ifindnick.designpattern;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
	
	private String name;
	private Vector directory = new Vector();
	//private Vector<Entry> directory = new Vector<Entry>();
	
	public Directory(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int size = 0;
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			size += entry.getSize(); 
		}
	
		return size;
	}
	
	public Entry add(Entry entry){
		directory.add(entry);
		return this;
	}

	@Override
	protected void printList(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + "/" + this);
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			entry.printList(prefix + "/" + name);
		}
		
	}

}
