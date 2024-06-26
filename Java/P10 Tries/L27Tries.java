import java.util.*;

public class L27Tries{

    public static class trienode{
        char data;
        trienode[] children;
        boolean isTerminal;

        trienode(char c){
            data=c;
            children = new trienode[26];
            for(int i=0; i<26; i++){
                children[i]=null;
            }
            isTerminal=false;
        }
    }

    public static void insertword(trienode root, String word){
        if(word.length()==0){
            root.isTerminal=true;
            return;
        }
        int index= word.charAt(0)-'a';
        trienode child;
        if(root.children[index]!=null){
            child= root.children[index];
        }
        else{
            child= new trienode(word.charAt(0));
            root.children[index]= child;
        }
        insertword(child, word.substring(1));
    }

    public static boolean searchword(trienode root, String word){
        if(word.length()==0){
            return root.isTerminal;
        }
        int index= word.charAt(0)-'a';
        trienode child;
        if(root.children[index]!=null){
            child=root.children[index];
        }
        else{
            return false;
        }
        return searchword(child, word.substring(1));
    }

    public static boolean isprefix(trienode root, String word){
        if(word.length()==0){
            return true;
        }
        int index= word.charAt(0)-'a';
        trienode child;
        if(root.children[index]!=null){
            child=root.children[index];
        }
        else{
            return false;
        }
        return isprefix(child, word.substring(1));
    }

    public static void main(String args[]){
        trienode x= new trienode('\0');
        insertword(x, "hello");
        System.out.println(isprefix(x, "he"));
    }

}