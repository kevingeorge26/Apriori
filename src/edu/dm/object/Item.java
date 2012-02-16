package edu.dm.object;

public class Item implements Comparable<Item>
{
	String item;
	float count;
	float mis;
	int order;
	
	public Item(String item, float count,float mis)
	{
		this.item = item;
		this.count = count;
		this.mis = mis;
	}

	@Override
	public int compareTo(Item o) 
	{
		if(mis < o.mis)
			return -1;
		else if (mis > o.mis)
			return 1;
		else
			return 0;
	}

	public String getItemValue() {
		return item;
	}

	public float getCount() {
		return count;
	}

	public float getMis() {
		return mis;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Item [item=" + item + ", count=" + count + ", mis=" + mis
				+ ", order=" + order + "]";
	}

	



}
