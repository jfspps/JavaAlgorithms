package com.algorithms.StacksAndQueues.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DogsAndCats {

    private final LinkedList<String> dogs;
    private final LinkedList<String> cats;

    public DogsAndCats() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    // add new animals to the end of the List
    // time complexity is based on getToFirstNull(), hence O(n) where n is the number of cats or dogs, as appropriate, are present
    public void enqueue(String name, String type){
        int firstNull;
        if (type.equalsIgnoreCase("cat")){
            firstNull = getToFirstNull(cats);
            cats.add(firstNull, name);
        } else if (type.equalsIgnoreCase("dog")){
            firstNull = getToFirstNull(dogs);
            dogs.add(firstNull, name);
        } else {
            System.out.println("Expecting either cat or dog as second argument");
        }
    }

    // time complexity is O(n)
    private int getToFirstNull(LinkedList<String> animalList) {
        int counter = 0;

        while (counter < animalList.size()){
            if (animalList.get(counter) == null){
                break;
            }
            counter++;
        }
        return counter;
    }

    // time complexity is constant, O(1)
    public String peek(String type){
        if (type.equalsIgnoreCase("cat")){
            return cats.get(0);
        } else if (type.equalsIgnoreCase("dog")){
            return dogs.get(0);
        } else {
            System.out.println("Expecting either cat or dog as second argument");
            return null;
        }
    }

    // time complexity is constant, O(1)
    public boolean isEmpty(String type){
        if (type.equalsIgnoreCase("cat")){
            return cats.isEmpty();
        } else if (type.equalsIgnoreCase("dog")){
            return dogs.isEmpty();
        } else {
            System.out.println("Expecting either cat or dog as second argument");
            return true;
        }
    }

    // time complexity is based on reshuffle, i.e. O(n)
    public String dequeueDog(){
        if (dogs.get(0) == null){
            System.out.println("No more dogs at the shelter");
            return null;
        }

        String dogsName = dogs.get(0);
        reshuffle(dogs);
        return dogsName;
    }

    // time complexity is based on reshuffle, i.e. O(n)
    public String dequeueCat(){
        if (cats.get(0) == null){
            System.out.println("No more cats at the shelter");
            return null;
        }

        String catsName = cats.get(0);
        reshuffle(cats);
        return catsName;
    }

    // time complexity is based on reshuffle, i.e. O(n)
    public String dequeueAny(){
        // returns an animal from the most populated list
        if (cats.isEmpty() && dogs.isEmpty()){
            System.out.println("No animals at the shelter");
            return null;
        }

        String animalName;
        boolean catAdopted = false;
        if (cats.size() >= dogs.size()){
            animalName = cats.get(0);
            catAdopted = true;
        } else {
            animalName = dogs.get(0);
        }

        if (catAdopted){
            reshuffle(cats);
        } else
            reshuffle(dogs);

        return animalName;
    }

    // time complexity is O(n)
    // shuffles nodes to the beginning (ensures dequeue methods release the rightly placed animal in the queue)
    private void reshuffle(List<String> animalList) {
        int i = 1;
        while (i < animalList.size() && animalList.get(i) != null){
            animalList.set(i - 1, animalList.get(i));
            i++;
        }
        animalList.set(i - 1, null);
    }
}