import sheffield.*;

public class LatticeSearch extends Search {
	//objects which will be useful to instantiate throughout the search.
  private WordLattice Lattice;
  private LM LanguageModel; 
  //Accessor Methods.
  public WordLattice getLattice(){
    return Lattice;
  }
  public LM getLanguageModel(){
    return LanguageModel;
  }
  public int getEndTime() {
	  return Lattice.getEndTime();
  }
  
  
  //Instantiator
public LatticeSearch(WordLattice latt, LM bg) {
	Lattice = latt;
	LanguageModel = bg;
}
}
