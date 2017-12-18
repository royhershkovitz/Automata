package states;
import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;

public class AnState 
{
	private String _name;
	public static char[] _alefBeit;
	protected LinkedList<AnState>[] _nextStates;//the size is the aleph-beit size
	//constructor
	@SuppressWarnings("unchecked")
	public AnState(String name)
	{
		_name = name;
		_nextStates = new LinkedList[_alefBeit.length];
		for(int i = 0; i < _alefBeit.length; i++)
			_nextStates[i] = new LinkedList<AnState>();
		
	}
	//constructor
	public AnState(String name, LinkedList<AnState>[] nextStates)
	{
		_name = name;
		_nextStates = nextStates;
	}
	
	//The function add the route of the automat 
	public void addRoute(char nextCh, AnState nextSt) {		
		boolean foundChar = false;
		for(int j = 0; j < _alefBeit.length&!foundChar; j++)
			if(_alefBeit[j] == nextCh){
				_nextStates[j].add(nextSt);
				foundChar = true;
			}
	}
	
	//The function delete the route of the automat 
		public boolean delRoute(char nextCh) {		
			boolean foundChar = false;
			for(int j = 0; j < _alefBeit.length&!foundChar; j++)
				if(_alefBeit[j] == nextCh){
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
			if(st.charAt(index) != ' ' & st.charAt(index) != ',')
				reducedAlefBeit = reducedAlefBeit + st.charAt(index);
		return reducedAlefBeit;
	}
	
	public String getName() {		
		return _name;
	}
	
	//The function get a word and return true if the automata include this word
	protected boolean compute(String word) {		
		boolean foundCh = false;
		//System.out.println(_name + ", word: " + word);
		if(word.length() != 0){
			int nextStateIndex = 0;
			//check the input current char
			while(nextStateIndex < _alefBeit.length & !foundCh){
				if(_alefBeit[nextStateIndex] == word.charAt(0))
					foundCh = true;//we validate before that it always will be true during this for loop
				else
					nextStateIndex = nextStateIndex + 1;
			}
			if(foundCh){
				foundCh = false;
				if(_nextStates[nextStateIndex].size() != 0){
					word = word.substring(1);
					Iterator<AnState> iter = _nextStates[nextStateIndex].iterator();
					while(iter.hasNext() & !foundCh){
						//System.out.print(_name + " -> ");
						foundCh = iter.next().compute(word);
					}
				}
			}
		}
		return foundCh;
	}
	
	//A string represation of the class
	@Override	
	public String toString()
	{
		String output = _name+", [";
		for(int i = 0; i < _nextStates.length; i++)
			for(AnState state : _nextStates[i])
				output = output + "  " + _alefBeit[i] +"->" + state.getName();
		return output +"  ]";
	}
	
	//regularExpressionToNfa
	public static AnState regularExpressionToNfa(String regular)
	{
		
		return new AnState("NFA");
	}
	
	//nfaToDfa
	public static AnState nfaToDfa(String regular)
	{
		
		return new AnState("DFA");
	}
	
}
