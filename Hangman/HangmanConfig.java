package hangman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import assignment2.Hangman.Status;
import backtracker.Backtracker;
import backtracker.Configuration;
/**
 * @apiNote "This machine. I hate this machine. Because it does exactly what I tell it to do,
 *  and not what I want it to do."
 * - CS Student at Oxford in the 60's


 */
public class HangmanConfig implements Configuration{
    private Hangman game;
   // private List<Character> cList;
   //the character about to be guessed
    private Character charToGuess;
    //contains every unique character found inside the secret phrase of Hangman game.
    Set<Character> secretList = new HashSet<>();
    
    public HangmanConfig(Hangman game){
        this.game = game;
        //try 'A' first. despite 'e' being the most common.
        charToGuess = 'A';
        /*for(Character ch = 'A';ch <z;ch++){
            clis
        }*/
        secretList = initSecret();
        
    }
    //fill the set w/ the unique chars of the secret phrase
    public Set<Character> initSecret(){
        Set<Character> secretChars = new HashSet<>();
        for(int i =0;i<game.getSecret().length();i++){
            System.out.println("Secret letter: "+game.getSecret().charAt(i));
            secretChars.add(game.getSecret().charAt(i));
        }
        return secretChars;
    }
    @Override
    public Collection<Configuration> getSuccessors() {
        System.out.println("Getting successors for move # "+ game.getGuesses());
        //list of possible guesses
        List<Configuration> list = new ArrayList<>();
        //list of characters that have already been guessed
        List<Character> cList = new ArrayList<>();
        //fill the cList with chars already previously guessed
        for( int i =0;i<game.getGuesses().length();i++){
                cList.add(game.getGuesses().charAt(i));
                System.out.println("Previously guessed: "+ game.getGuesses().charAt(i));
                }
        for(Character ch = 'A';ch<'Z';ch++){ 
            //if duplicate guess, dont try
            if (cList.contains(ch)){continue;}
            else{
                //if the character ch is within the HashSet "secretList", use as possible successor
                //if(secretList.contains(ch)){
                    //make a new game "deep copy" w/ the same progress as the current one and add it to the
                    //configuration list (successors).
                    charToGuess = ch;
                    Hangman deepCopy = this.game;
                    deepCopy.guess(ch);
                    list.add(new HangmanConfig(deepCopy)) ;
                //}
                //if not, discard and continue
                //else{continue;}
                }

        }
        return list;
    }

    @Override
    public boolean isValid() {
        //a set that will contain only the letters contained in the secret phrase
       // Set<Character> inSecretPhrase= secretList;
        //if the losing conditions are already met, do not accept the move
        if(game.getStatus() == Status.LOST){return false;}
        if(game.getWrongGuesses()>=5){return false;}
        //add each unique letter to the guess set
            for(int i =0;i<game.getSecret().length();i++){
            secretList.add(game.getSecret().charAt(i));
            System.out.println("Adding "+ game.getSecret().charAt(i)+ " to the inSecretPhrase");
        }
        //if the character about to be guessed is *not* in the secret phrase
        //treat it as invalid.
        if(!secretList.contains(charToGuess)){
            return false;
        }
        //all invalid possibilities checked, assume valid
        else{return true;}
        }

    

    @Override
    public boolean isGoal() {
        //the goal is when the user has won.
       return game.getStatus() == Status.WON;
    }
    public static void main(String[] args) {
        
        Backtracker bt = new Backtracker(true);
        Configuration sol = bt.solve(new HangmanConfig(new Hangman("Test Answer")));
        System.out.println(sol);
    }

    @Override
    public String toString() {
        String s="";
        s+="Revealed: "+ game.revealed()+"\n";
        s+="Guesses: "+game.getGuesses();
        s+="\n\n";
        return s;
    }
}
