
public class AnWiningState extends AnState{
	
	public AnWiningState(String name, AnState[] nextStates) {
		super(name, nextStates);
	}
	
	@Override
	protected boolean compute(String word) {
		if(word.length() == 0)
			return true;
		else
			return super.compute(word);
	}
}