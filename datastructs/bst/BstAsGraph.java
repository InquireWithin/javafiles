package bst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class BstAsGraph {
    public static BinaryNode makeBST(int[] array){
        
        BinaryNode bst = new BinaryNode(array[0],null,null);
        for(int i =1;i<array.length;i++){
                //List<BinaryNode> binaryList = new ArrayList<>();
                //Set<BinaryNode> nodes = new TreeSet<>();
                if(!bst.search(array[i])){
                bst.binaryInsert(array[i]); }
        }
        return bst;
    }
    public static Graph<Integer> ConvertToGraph(BinaryNode bst){
        Graph<Integer> graph = new AdjacencyGraph<>();
        List<Integer[]> graphValues = searching(bst);
        for(Integer[] i:graphValues){
            graph.add(i[0]);graph.add(i[1]);graph.add(i[2]);
            graph.connectUndirected(i[0], i[1]);
            graph.connectUndirected(i[1], i[2]);
        }
        return graph;
    }
    //ignore
    public static Graph<Integer> binaryAutoFill(BinaryNode bst){
        Graph<Integer> graph = new AdjacencyGraph<Integer>();
        //given
        graph.add(bst.getValue());
        graph.add(bst.getLeft().getValue());
        graph.add(bst.getRight().getValue());
        //not given
        
        String[] stringValues = bst.infixTraversal().split(" ");
        int[] intValues = new int[stringValues.length];
        int layers = 1;int thisLayer =3;
        int tempLength = intValues.length;
        Set<Integer> checkForDupes = new HashSet<>();
        for(int a : intValues){
            checkForDupes.add(a);
        }
        checkForDupes.remove(bst.getValue());
        checkForDupes.remove(bst.getLeft().getValue());
        checkForDupes.remove(bst.getRight().getValue());
        for(int b:checkForDupes){
            graph.add(b);
        }
        
        while((double) tempLength % 2 >= 1.0) {layers+=1;}
        //layers one and two are already decided
        graph.connectUndirected(bst.getValue(),bst.getLeft().getValue());
        graph.connectUndirected(bst.getValue(), bst.getRight().getValue());
        //
        int nullPointersCaught = 0;
        while(thisLayer != layers){
            nullPointersCaught = 0;
            
            try{
                
            }
            catch(NullPointerException npe){
                nullPointersCaught +=1;
                //!Might continue on the while loop, and not the for loop
                if(nullPointersCaught < Math.pow(2,thisLayer-1)){
                continue;}
                else{return graph;}
            }
        } 
        for(int i =0;i<stringValues.length;i++){
            intValues[i] = Integer.parseInt(stringValues[i]);
        }
        
        return null;
    }
    public static List<Integer[]> searching(BinaryNode bst){
        String search = bst.infixTraversal();
        String[] nodes = search.split("BinaryNode value=");
        for(String s: nodes){
            s.split(", left=");
            s.split(", right=");
        }
        Integer[] intarr = new Integer[3];
        List<Integer[]> nodeValues = new ArrayList<>();
        for(int p =0;p<nodes.length;p++){
            intarr = new Integer[3];
        for(int x = 0;x<3;x++){
            intarr[x] = Integer.parseInt(nodes[x]);
            //nodeValues.add(Integer.parseInt(nodes[x]));
        }
        nodeValues.add(intarr);
    }
        /*for(int k =0;k<nodes.length;k++){
            String toAdd = "";
            Integer[] ia = new Integer[3];
            int occurrences = 0;
        for(int i =0;i<nodes[k].length();i++){
            try{
                Integer a = Integer.parseInt(((Character) search.charAt(i)).toString());
                toAdd += a.toString();
                occurrences+=1;
                if((Integer)Integer.parseInt(((Character) search.charAt(i+1)).toString()) instanceof Integer){
                i++;
                }
                Integer b =(Integer)Integer.parseInt(((Character) search.charAt(i)).toString());
                while(b instanceof Integer){
                    toAdd += b;
                    if ((Integer)Integer.parseInt(((Character) search.charAt(i+1)).toString()) instanceof Integer){
                        i++;
                        b = (Integer)Integer.parseInt(((Character) search.charAt(i)).toString());
                    }
                    else{break;}
                }
                Integer[] c;
                nodeValues.add(Integer.parseInt(toAdd.toString()));
            }
            catch (Exception e){continue;}
        }
    }*/
    return nodeValues;
    }
    public static void main(String[] args) {
        int[] a = {4,8,2,67,45,88,29,3,2,75};
        //System.out.println(makeBST(a).toString());
        //System.out.println(makeBST(a).infixTraversal());

        //try using bst tostring
        ConvertToGraph(makeBST(a));
    }
}
