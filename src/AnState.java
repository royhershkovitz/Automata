
public class AnState 
{
	private String _name;
	public static char[] _alefBeit;
	protected AnState[] _nextStates;//the size is the aleph-beit size
	//constructor
	public AnState(String name)
	{
		_name = name;
		_nextStates = new AnState[_alefBeit.length];
	}
	//constructor
	public AnState(String name, AnState[] nextStates)
	{
		_name = name;
		_nextStates = nextStates;
	}
	
	//The function add the route of the automat 
	public void addRoute(char nextCh, AnState nextSt) {		
		boolean foundChar = false;
		for(int j = 0; j < _alefBeit.length&!foundChar; j++)
			if(_alefBeit[j] == (int)nextCh){
				_nextStates[j] = nextSt;
				foundChar = true;
			}		
	}
	
	//The function delete the route of the automat 
		public boolean delRoute(char nextCh) {		
			boolean foundChar = false;
			for(int j = 0; j < _alefBeit.length&!foundChar; j++)
				if(_alefBeit[j] == (int)nextCh){
					_nextStates[j] = null;
					foundChar = true;
				}
			return foundChar;
		}
	
	//The function set the alefBeit of the automat 
	public static void setAlefBeit(String alefBeit) {
		String reducedAlefBeit = reduceSt(alefBeit);		
		if(reducedAlefBeit.length() > 0)
			_alefBeit = reducedAlefBeit.toCharArray();			
	}
	
	//Returns String without ' ', and ','
	protected static String reduceSt(String st) {
		String reducedAlefBeit = "";
		for(int index = 0; index < st.length(); index++)
			if(st.charAt(index) != (int)' ' & st.charAt(index) != (int)',')
				reducedAlefBeit = reducedAlefBeit + st.charAt(index);
		return reducedAlefBeit;
	}
	
	public String getName() {		
		return _name;
	}
	
	//The function get a word and return true if the automata include this word
	protected boolean compute(String word) {		
		boolean foundCh = false;
		int nextStateIndex = 0;
		for(; nextStateIndex < _alefBeit.length&!foundCh; nextStateIndex++)
			if(_alefBeit[nextStateIndex] == (int)word.charAt(0))
				foundCh = true;//we validate before that it always will be true during this for loop
		if(_nextStates[nextStateIndex] == null)
			foundCh = false;
		else
			foundCh = _nextStates[nextStateIndex].compute(word.substring(1));
		return foundCh;
	}
	
	//A string represation of the class
	@Override	
	public String toString()
	{
		String output = _name+", [";
		for(int i = 0; i < _nextStates.length; i++)
			output = output + "  " + _alefBeit[i] +"->" + _nextStates[i].getName();
		return output +"  ]";
	}
	
}
