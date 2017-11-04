
public class AnLosingState extends AnState{
	
	public AnLosingState(String name) {
		super(name, null);
		_nextStates = new AnState[] {this};
	}	
	
	@Override
	protected boolean compute(String word) {
		return false;
	}
}