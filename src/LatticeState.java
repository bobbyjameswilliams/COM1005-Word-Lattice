import java.util.ArrayList;


public class LatticeState extends SearchState {
	private WordH word;
	private int localCost; 
	private WordLattice latt;
	
		public LatticeState(WordH w,int lc) { //Constructor for the LatticeState
			word = w;
			localCost = lc;				
		}
	  public boolean goalP(Search searcher) { //Returns if the current state is the goal (True if so)
		    LatticeSearch lsearcher = (LatticeSearch) searcher;
		    int tar=lsearcher.getEndTime(); // get target
		    return (word.getEnd() == tar);
		  }
	  
	  //Returns the successors for the current state, with the local costs calculated using LM
	  public ArrayList<SearchState> getSuccessors(Search searcher) {
		  //Searcher, lattice, language model all instantiated for use 
		  LatticeSearch lsearcher = (LatticeSearch) searcher;
		  WordLattice Lattice = lsearcher.getLattice();
		  LM languageModel = lsearcher.getLanguageModel();
		  ArrayList<SearchState> succs=new ArrayList<SearchState>();
		  ArrayList<WordH> links= Lattice.wordsAtT(word.getEnd());
		  for (WordH l: links) {
			  	int newCost = languageModel.getCost(this.getWord(),l.getWord()) + l.getCost(); //Calculates the cost from current to next state
		        succs.add((SearchState)new LatticeState(l,newCost)); 
		    }
		    return succs; //returns the successors with their new local costs
		  
	  }
	  //Checks if the current state is the same state as another.
	  public boolean sameState(SearchState s2) {
		    LatticeState ls2= (LatticeState) s2;
		    return (word.getWord().compareTo(ls2.getWord())==0);
		  }
	  //Accessors
	  public String getWord() {
		  return word.getWord();
	  }
	  public int getLocalCost() {
		  return localCost;
	  }
	  public String toString () {
	      return ("Word State: "+ word.getWord());
	    }

}

