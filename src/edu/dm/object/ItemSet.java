package edu.dm.object;

public class ItemSet 
{
	String itemSet; // comma separated values
	float count;
	
	public ItemSet(String itemSet,float count) 
	{
		this.itemSet  = itemSet;
		this.count = count;
	}
	
	public String getItemSet() {
		return itemSet;
	}
	
	public float getCount() {
		return count;
	}
	
	
	public String getFirstItem()
	{
		return itemSet.split(",")[0];
	}

	@Override
	public String toString() {
		return "ItemSet [itemSet=" + itemSet + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemSet == null) ? 0 : itemSet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemSet other = (ItemSet) obj;

		if (itemSet == null) 
		{
			if (other.itemSet != null)
				return false;
		} 
		else if (!itemSet.equals(other.itemSet))
			return false;
		return true;
	}
	
	
	
	

}
