package states;
import java.util.LinkedList;

public class AnWiningState extends AnState{
	
	public AnWiningState(String name, LinkedList<AnState>[] nextStates) {
		super(name, nextStates);
	}
	
	public AnWiningState(String name) {
		super(name);
	}
	
	@Override
	protected boolean compute(String word) {
		boolean output;
		if(word.length() == 0)
			output = true;
		else
			output = super.compute(word);
		return output;
	}
}