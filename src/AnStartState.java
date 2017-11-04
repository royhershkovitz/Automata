
public class AnStartState extends AnState{

	private static boolean _isIntialize = false;
	public AnStartState(String name, AnState[] nextStates) {
		super(name, nextStates);
		if(_isIntialize)
			throw new ExceptionInInitializerError("Can initialize two StarState");
		_isIntialize = true;
	}
	
	//check if the word contain unknown chars or if its too short 	
	public boolean checkWord(String word){
		String reducedAlefBeit = reduceSt(word);
		boolean output = true;
		for(int i = 0; i<reducedAlefBeit.length()&output; i++)
		{
			output = false;
			for(int j = 0; j < _alefBeit.length&!output; j++)
				if(_alefBeit[j] == (int)reducedAlefBeit.charAt(j))
					output = true;
		}
		return output&&super.compute(word);
	}
	
	public void delete(){
		_isIntialize = false;
	}
}
