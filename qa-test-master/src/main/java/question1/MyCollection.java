package question1;


/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	int n, size;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
		n = arraySize;
		size = 0;
	}

	public int search(int searchingNum) {
		for(int i = 0; i < numArray.length; i++) {
			if(numArray[i]==searchingNum) 
				return i;	
		}
		return -1;
	}

	public boolean add(int numberToAdd) {
		int i = search(numberToAdd);
		if(i!=-1) 
			return false;
		else if(size==n) 
			doubleCapacity();
		numArray[size++] = numberToAdd;
		return true;
	}

	public void doubleCapacity() {
		n = n *2;
		int[] doubleArray = new int[n];
        System.arraycopy(numArray,0,doubleArray,0,numArray.length); 
       numArray = doubleArray;
    }

	public boolean remove(int numberToRemove) {
		int exists = search(numberToRemove);
		if(exists!=-1) 
			return true;
		for(int i = exists; i < getCount()-1; i++) {
			numArray[i] = numArray[i+1];
		}
		return false;
	}

	public int getCount() {
		return size;
	}

	public int[] rotate(int n) {
		int i, j = 0, temp[] = new int[getCount()];
		for(i = n; i < getCount(); i++)
			temp[j++] = numArray[i];
		for(i = 0; i < n; i++)
			temp[j++] = numArray[i];
		numArray=temp;
		return numArray;
	}
	
	public String toString() {
		if(size==0) {
			return "{}";
		}
		String str = "{";
		for(int i = 0; i < getCount(); i++) {
			str += numArray[i];
			if(i < getCount()-1)
				str += ",";
		}	
		str += "}";
		return str;
	}
	

}
